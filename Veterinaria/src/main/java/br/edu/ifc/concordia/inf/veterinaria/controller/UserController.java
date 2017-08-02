package br.edu.ifc.concordia.inf.veterinaria.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.boilerplate.NoCache;
import br.com.caelum.vraptor.boilerplate.factory.SessionFactoryProducer;
import br.com.caelum.vraptor.boilerplate.util.GeneralUtils;
import br.edu.ifc.concordia.inf.veterinaria.IndexController;
import br.edu.ifc.concordia.inf.veterinaria.abstractions.AbstractController;
import br.edu.ifc.concordia.inf.veterinaria.business.UserBS;
import br.edu.ifc.concordia.inf.veterinaria.model.Proprietario;
import br.edu.ifc.concordia.inf.veterinaria.model.User;
import br.edu.ifc.concordia.inf.veterinaria.permision.Permition;
import br.edu.ifc.concordia.inf.veterinaria.permision.UserRoles;

@Controller

public class UserController extends AbstractController {
	@Inject private UserBS bs;
	SessionFactoryProducer factoryproducer = new SessionFactoryProducer();
	
	@Get(value="/createacount")
	@NoCache
	public void createacount(){
		
	}
	
	@Get(value="/login")
	@NoCache
	public void login(int state, String errorMsg) {
		if(this.userSession.isLogged() == true) {
			this.result.redirectTo(IndexController.class).index();
		}
		else if (!GeneralUtils.isEmpty(errorMsg)&& state == 1){
			this.result.include("errorMsg",errorMsg);
		}else if (!GeneralUtils.isEmpty(errorMsg)&& state == 2){
			this.result.include("gotout",errorMsg);
		}else {
			
		}
	}
	
	
	@Post(value="/createacount")
	@NoCache
	public void cadastrar(String nome, String especialidade, String estudo, String telefone, String endereco, String crmv, String cep, String cpf, String password, String username){
		this.bs.cadastrar(factoryproducer, nome, especialidade, estudo, telefone, endereco, crmv, cep, cpf, password, username);
		this.result.redirectTo(this).login(0,null);
	}
	
	@Post(value = "/cadastrarProprietario")
	@NoCache
	public void cadastrarProprietario(String nome, String cpf, String cep, String telefone, String profissao, String endereco, String referencias) {
		this.bs.cadastrarProprietario(factoryproducer, nome, cpf, cep, telefone, profissao, endereco, referencias);
	}
	
	@Post(value="/login")
	@NoCache
	public void doLogin(String username, String password){
		if(username == null || password == null){
			this.result.redirectTo(this).login(1,"Campos incompletos");
		}else{
		User user = this.bs.login(factoryproducer, username, password);
		if (user == null){
			this.result.redirectTo(this).login(1,"Nome de usuário ou senha incorretos!");
		}else{
			this.userSession.login(user);
			this.result.redirectTo(IndexController.class).index();
		}
		}
	}
	@Get(value="/logout")
	@NoCache
	public void sair(){
		if (this.userSession.isLogged() == true){
			this.userSession.logout();
			this.result.redirectTo(this).login(2,"Você Está Desconectado");
		}else{
			
		}
	}
	
	@Get(value="/cadastrarProprietario")
	@NoCache
	public void cadastrarProprietario() {
		if(this.userSession.isLogged() == true) {
			
		}else {
			this.result.redirectTo(this).login(0,null);
		}
	}
	
	@Post(value="/cadastrarproprietario")
	@NoCache
	public void cadastrar(String nome, String cep, String profissao, String cpf, String telefone, String endereco, String referencias) {
		this.bs.cadastrarProprietario(factoryproducer,  nome,  cpf,  cep,  telefone,  profissao,  endereco,  referencias);
		this.result.redirectTo(this).cadastrarProprietario();
	}
	
	@Get(value="/buscar")
	@NoCache
	public void buscar() {
		
	}
	
	@Post("/search")
	@NoCache
	public void buscar(String proprietario) {
		List<Proprietario> proprietario1 =  this.bs.busca(factoryproducer, proprietario);
		if(proprietario1 == null) {
			this.result.include("notfound","Proprietario não encontrado");
		}else {
			this.result.include("found",proprietario1);
			//this.result.include("found1",proprietario1);
		}
		
	}
	
	@Get("/loggedUser")
	@Permition(UserRoles.ADMIN)
	public void getLoggeduser(){
		
		
	}
}
