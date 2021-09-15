<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	<title>Upload files</title>
</head>
	<body>
	
		<h3>Upload</h3>
		
		<input type="file" id="txtArquivo" name="txtArquivo" onchange="uploadFile()">
		<img alt="Imagem" src="" id="target" width="200" height="200"> 	
		<div>
			<a href="servletUploadFile?acao=carregar">Carregar Imagem</a>
			
			<table>
				<c:forEach items="${listaImagens}" var="img">
					<tr>
						<td> ${user.id} </td>
						<td> ${user.login} </td>
						<td> <a href="servletUploadFile?acao=download&idImagem=${img.id}">Download ${img.tipo}</a> </td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
	</body>
	
	<script type="text/javascript">
		function uploadFile(){
			var target = document.querySelector("img");
			var file = document.querySelector("input[type=file]").files[0];
			var reader = new FileReader();
	
			reader.onloadend = function () {
				target.src = reader.result;
			
				// ---- UPLOAD COM AJAX ----
				$.ajax({
					method : "POST",
					url : "servletUploadFile",
					data : { fileUpload : reader.result}
				
				}).done(function(response) {
					alert("Sucesso: " + response);
					
				}).fail(function(xhr, status, errorThrown){
					alert("Error: " + xhr.responseText);
				});

				//----
				
			};
	
			if (file) {
				reader.readAsDataURL(file);
				
			}else{
				target.src = ""			
			}	
		}
	</script>
</html>