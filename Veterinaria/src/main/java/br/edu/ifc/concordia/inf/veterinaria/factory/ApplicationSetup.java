package br.edu.ifc.concordia.inf.veterinaria.factory;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.ServletContext;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;

import br.com.caelum.vraptor.boilerplate.HibernateDAO;
//import br.com.caelum.vraptor.boilerplate.HibernateDAO;
import br.com.caelum.vraptor.boilerplate.factory.SessionFactoryProducer;
import br.com.caelum.vraptor.boilerplate.factory.SessionManager;
import br.com.caelum.vraptor.boilerplate.util.CryptManager;
import br.edu.ifc.concordia.inf.veterinaria.model.User;
import br.edu.ifc.concordia.inf.veterinaria.permision.UserRoles;
import br.edu.ifc.concordia.inf.veterinaria.properties.SystemConfigs;
//import br.com.caelum.vraptor.boilerplate.factory.SessionManager;
@ApplicationScoped
@Startup
public class ApplicationSetup {
	private static final Logger LOG = Logger.getLogger(ApplicationSetup.class);

	protected ApplicationSetup() {
	}

	public void initializeAtStartup(@Observes ServletContext context) {

	}

	@Inject
	public ApplicationSetup(SessionFactoryProducer factoryProducer) {
		factoryProducer.initialize("hibernate.cfg.xml");
		CryptManager.updateKey(SystemConfigs.getConfig("crypt.key"));
		CryptManager.updateSalt("@2o!A", "70Px$");
		SessionFactoryProducer factoryproducer = new SessionFactoryProducer();
		SessionManager mngr = new SessionManager(factoryProducer.getInstance());
		HibernateDAO dao = new HibernateDAO(mngr);
		
		Criteria criteria = dao.newCriteria(User.class);
		criteria.add(Restrictions.eq("username", "admin"));
		User user = (User) criteria.uniqueResult();
		if (user == null){
			user = new User();
			user.setAcesso(UserRoles.ADMIN.getAccessLevel());
			user.setCep("00000-000");
			user.setNome("admin");
			user.setEmail("admin@admin");
			user.setEndereco("default");
			user.setCrmv("default");
			user.setPassword(CryptManager.passwordHash("admin"));
			user.setUsername("admin");
			user.setTelefone("00 0 00000000");
			user.setEstudo("default");
			user.setEndereco("default");
			user.setCpf("000.000.000-00");
			user.setEspecialidade("default");
			dao.persist(user);
			
			
		}
		
		LOG.info("Overwriting SSL context to ignore invalid certificates...");
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
			SSLContext.setDefault(ctx);
		} catch (GeneralSecurityException ex) {
			System.out.println("N�o consegui sobrescrever o SSLContext.");
			ex.printStackTrace();
		}

		LOG.info("Application setup completed.");
		mngr.closeSession();
	}
	public static class DefaultTrustManager implements X509TrustManager {

		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}
}
