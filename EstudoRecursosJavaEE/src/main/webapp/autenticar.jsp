<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style> 
h4 {
  width: 200px;
  height: 40px;
  position: relative;
  animation: myfirst 3s 2;
  animation-direction: alternate-reverse;
}

@keyframes myfirst {
  0%   {color: red; left: 100px; top: 0px;}
  25%  {color: brown; left: 200px; top: 0px;}

}
</style>
</head>
<body>
	<h3>Autenticar Usuário</h3>
	<h4>${msg}</h4>
	<!--   <form action="<= request.getContextPath() %>/ServletAutenticacao" method="post"> -->
	<form action="ServletAutenticacao" method="post">
		<input type="hidden" name="url" id="url" value="<%= request.getParameter("url") %>">
		<table>
		<tr>
			<td> <label for="usuario">Usuário:</label> </td>
			<td> <input type="text" id="usuario" name="usuario"></td>			
		</tr>
		<tr>
			<td> <label for="senha">Senha:</label> </td>
			<td> <input type="password" id="senha" name="senha"> </td>			
		</tr>
		<tr>
			<td>
				<input type="submit" id="logar" name = "logar" value="Logar">
			</td>
		</tr>		
		</table>
	</form>
</body>
</html>