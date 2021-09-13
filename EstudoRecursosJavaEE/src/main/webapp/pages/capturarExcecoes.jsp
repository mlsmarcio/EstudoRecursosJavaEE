<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>Recursos Avan�ados em Java</title>
</head>
<body>
	<h3>Capturando exce��es com jquery</h3>
	<input type="text" value="Jesus � a esperan�a!" id="txtValor">
	<input type="button" onclick="testarExecao()" value="Testar Exce��o">
</body>

<script type="text/javascript">

	function testarExecao(){
		let valorInformado = $('#txtValor').val();
		//alert(valorInformado);
		
		$.ajax({
			method: "POST",
			url: "capturarExecao",
			data: {valorParam: valorInformado}
		})
			/*
		   	.always(function(response){ // sempre capta oretorno
		   	*/
		   	
	   	.done(function(response){		// resposta ok
	   		alert("Sucesso " + response);	
	   	})
		.fail(function(xhr, status, errorThrown){		// falha
			alert("Error: " + xhr.responseText);	
		});
	}
</script>
</html>