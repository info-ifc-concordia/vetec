<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Footer-->
<div class="footer" >
  <div class="row">
     <div class = "col-md-9">
         <address class = "text-center">
            <p>Instituto Federal de Educação, Ciência e Tecnologia Catarinense - Câmpus Concórdia
            <br class = "white-space">
            Rodovia SC 283 - km 08 - CEP 89703-720 - Concórdia - SC - Fone (49) 3441-4800</p>
            </address>
     </div>
	  <div class="col-md-3">
	  		<img id="logo" src="<c:url value="/imagens/logo.png"/>"></img>
	  </div>
  </div>
</div>
	<script src="<c:url value="/js/jquery-3.2.1.min.js" />"></script>
	<script src="<c:url value="/js/tether.min.js" />"></script>
	<script src="<c:url value="/bootstrap/js/bootstrap.js"/>"></script>
	<script src="<c:url value="/aui/aui/aui-min.js" />"></script>
	<script src="<c:url value="/js/jquery.toaster.js"/>"></script>
	<script src="<c:url value="/js/jquery.mask.min.js" />"></script>
	<script src="<c:url value="/js/index.js" />"></script>
<<<<<<< HEAD
	<script src="<c:url value="/js/printThis.js" />"></script>
	<script>
		$(document).ready(function() {
			$(".botao-printar").click(function() {
				$(".row").thisPrint();
			});	
		});
	</script>
=======
	<script src="<c:url value="/js/style.js" />"></script>
	<script src="<c:url value="/js/toastr.js" />"></script>
<!--

//-->

>>>>>>> ca2ebe173b56baffc029a8f30ed2673a0e69f410
</body>
</html>