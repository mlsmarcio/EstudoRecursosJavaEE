<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>Insert title here</title>
</head>
<body>

<h1>Página pai load Jquery</h1>

<input type="button" value="Carregar página" onclick="carregar();">

<div id="mostrarPaginaFilha">

</div>
 
</body>

<script type="text/javascript">
	function carregar(){
		$("#mostrarPaginaFilha").load('paginaFilha.jsp');
	}
</script>
</html>