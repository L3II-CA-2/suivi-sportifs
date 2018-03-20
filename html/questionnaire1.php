<?php
	session_start();
	if(!isset($_SESSION['login'])){
		header("Location:index.php");
	}

	if(isset($_POST['submit'])){
		$_SESSION['data'][1]=$_POST['reponse'];
		header("Location:questionnaire2.php");
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
      <article>
        <div class="formContainer" >
          <form method="POST" target="">
            <h2>Questionnaire d'initiation</h2>
            <h3>Vous allez bien ? </h3>

						<table>
							<tr>
								<td><input type="radio" name="reponse" id="reponse" value="oui" checked></td><td><h4>Oui</h4></td>
							</tr>
							<tr>
								<td><input type="radio" name="reponse" id="reponse" value="non"></td><td><h4>Non</h4></td>
							</tr>
						</table>

 						<br />

						<button type="button" id="prec" onclick="location.href='accueil.php';">Précedent</button>
						<input type="submit" id="submit" name="submit" value="Suivant" />
          </form>
        </div>
      </article>
    </div>
	</body>
</html>