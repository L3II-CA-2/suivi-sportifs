<?php

    session_start();
    if (isset($_POST['submit'])){
      $_SESSION['login']=$_POST['pseudo'];
      header("Location:accueil.php");
	  }

?>
 <!DOCTYPE html>
 <html lang="fr">
 		<head>
 		<meta charset="utf-8"/>
 		<link href="https://fonts.googleapis.com/css?family=Inconsolata|Lobster" rel="stylesheet"/>
 		<link href="css/alzai.css" type="text/css" rel="stylesheet" media="screen,projection"/>
 		<link rel='stylesheet' href='css/solarizedLight.css' type='text/css'>
 		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

 		<title>Application de Suivi de Sportifs</title>
 	</head>

 	<body class="font2">
 		<div class='container'>

 			<div id="contentContainer" >
 				<div id='pageTitle'>
 					<h1 class="font1">Application de Suivi de Sportifs</h1>
 				</div>
 					<article>
 						<div class="formContainer" >
 							<form method="post" action="./index.php">
 								<div class="formPart">
 									<input type="text" id="pseudo" name="pseudo" placeholder="Pseudo : "/>
 								<br />
 								<br />
 									<input type="submit" id="submit" name="submit"  value="Connexion" />
 								</div>
 							</form>
 					</div>
 					</article>
 				</div>
 			</div>
 		</div>
 	</body>
 </html>
