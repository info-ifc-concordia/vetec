<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/includes/headers.jsp" />
<div class="container-fluid conteudo">
	<c:import url="/includes/navigation.jsp" />
	<div class="container-fluid row">
		<!-- Barra de Pesquisa-->
	        <!-- Tabs -->
	        <div class="col-md-12 col-sm-12">
				<ul class="nav nav-tabs">
					<li class = "active"><a href="#tab1" data-toggle="tab" >Informações Gerais</a></li>
					<li><a href="#tab2" data-toggle="tab">Anamnese Geral</a></li>
					<li><a href="#tab3" data-toggle="tab">Anamnese Especial</a></li>
					<li><a href="#tab4" data-toggle="tab" id = "exame">Exame Físico</a></li>
					<li><a href="#tab5" data-toggle="tab" id = "complementares">Exames Complementares</a></li>
					<li><a href="#tab6" data-toggle="tab" id = "resultado">Resultados</a></li>
					<li class="dropdown"><a href="#" data-toggle="dropdown" aria-expanded="false" class="dropdown-toggle" id="teste1">Retorno<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu" aria-labelledby="teste1">
							<li role="presentation">
							    <a role="menuitem" href="#">JavaScript</a>
							    <a role="menuitem" href="#">Python</a>
							    <a role="menuitem" href="#">Java</a>
							    <a role="menuitem" href="#">Delphi</a>
							</li>
						</ul>
					</li>
				</ul>
				<!-- Tabs content -->
				<div class="tab-content">
						<div class="tab-pane fade active in" id="tab1">
							<c:import url="/includes/prontuarioIncludes/infoGerais.jsp"/>
						</div>
						<div class="tab-pane fade" id="tab2">
							<c:import url="/includes/prontuarioIncludes/anamneseGeral.jsp"/>
						</div>
						<div class="tab-pane fade" id="tab3">
							<c:import url="/includes/prontuarioIncludes/anamneseEspecial.jsp"/>
						</div>
						<div class="tab-pane fade" id="tab4">
							<c:import url="/includes/prontuarioIncludes/exameFisico.jsp"/>
						</div>
						<div class="tab-pane fade" id="tab5">
							<c:import url="/includes/prontuarioIncludes/examesComplementares.jsp"/>
						</div>
						<div class="tab-pane fade" id="tab6">
							<c:import url="/includes/prontuarioIncludes/resultados.jsp"/>
						</div>
						<div class="tab-pane fade" id="tab8">
							<c:import url="/includes/prontuarioIncludes/retorno.jsp"/>
						</div>
						<div class="tab-pane fade" id="infoGerais">
							<c:import url="/includes/prontuarioIncludes/infoGeraisShow.jsp"/>
						</div>
						<div class="tab-pane fade" id="anamneseGeral">
							<c:import url="/includes/prontuarioIncludes/anamneseGeralShow.jsp"/>
						</div>
						<div class="tab-pane fade" id="anamneseEspecial">
							<c:import url="/includes/prontuarioIncludes/anamneseEspecialShow.jsp"/>
						</div>
						<div class="tab-pane fade" id="exameFisico">
							<c:import url="/includes/prontuarioIncludes/ExameFisicoShow.jsp"/>
						</div>
						<div class="tab-pane fade" id="resultados">
							<c:import url="/includes/prontuarioIncludes/resultadosShow.jsp"/>
						</div>

				</div>
		</div>
	</div>

</div>

<c:import url="/includes/footer.jsp" />