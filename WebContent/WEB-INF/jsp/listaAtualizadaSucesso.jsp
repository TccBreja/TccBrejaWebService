<link href="estaticos/css/cadastrarCervejas.css" rel="stylesheet">

<jsp:include page="common/cabecalhoMenu.jsp"></jsp:include>
<jsp:include page="common/cabecalhoCervejas.jsp"></jsp:include>

<style>
	.textbody{
		font-size: 24px;
	}
</style>

<div class="container pb10 fundoHome" style="padding-top: 20px;">
	<img src="estaticos/imagens/hommer.ico" />
	<div class="title">
		<strong>Lista de cervejas do <%=request.getAttribute("nomeEstabelecimento") %> atualizada com sucesso!</strong>
	</div>
	
	<div id="info" class="textbody" style="padding-left: 200px;padding-right: 200px;text-align: center;">
		Parab�ns, a lista de cerveja do seu estabelecimento foi atualizada.
		Caso deseja atualizar as informa��es ou foto do <%=request.getAttribute("nomeEstabelecimento") %> selecione a op��o "Atualizar Estabelecimento" no menu superior.
	</div>	
		
</div>