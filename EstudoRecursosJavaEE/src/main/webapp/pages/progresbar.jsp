<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		
	  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	  
	  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>		
		
		<title>Progresbar</title>

		<style type="text/css">
			#myProgress {
				width: 100%;
				background-color: #ddd; 
			}
			
			#myBar{
				width: 1%;
				height: 30px;
				background-color: #4CAF50;
			}
			
			/* Barra de Progresso com jquery*/
			.ui-progressbar{
				position: relative;
			}
			.progress-label{
				position: relative;
				left: 50%;
				top: 4px;
				font-weight: bold;
				text-shadow: 1px 1px 0 #fff;
			}
		</style>
	</head>
	
	<body>
		<h1>Exemplo com javascript</h1>
		<div id="myProgress">
			<div id="myBar"></div>
		</div>
		<button onclick="exibirBarra()"> Executar </button>
		<br/>
		
		<h1>Exemplo com Jquery</h1>
		<div id="progressbar">
			<div class="progress-label">
				Carregando...
			</div>
		</div>
	</body>
	
    <script type="text/javascript">
	function exibirBarra(){
		alert('iniciando a função');
		var elem = document.getElementById("myBar");
		var width = 1;
		var id = setInterval(frame, 10); 

		function frame(){
			if (width >= 100){
				clearInterval(id);
			}else{
				width++;
				elem.style.width = width + "%";
			}
		}
	}

	/* Barra com Jquery */
	$(function(){
		let progressbar = $('#progressbar'), progresslabel = $('.progress-label');

		progressbar.progressbar ({
			value : false,
			change : function(){
				progresslabel.text (progressbar.progressbar('value') + "%" );
			},
			complete : function() {
				progresslabel.text('Completo!');
			}
		});

		function progress() {
			let val = progressbar.progressbar("value") || 0;

			progressbar.progressbar("value", val + 2);
			if (val < 99) {
				setTimeout(progress, 80)
			}
		}

		setTimeout(progress, 2000)  // ao abrir a tela
	});
</script>
</html>