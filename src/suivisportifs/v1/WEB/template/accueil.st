accueil(quest_name, date_debut, date_fin) ::= <<

<?php
	session_start();
	if(!isset($_SESSION['login'])){
		header("Location:index.php");
	}

	if(isset($_POST['submit'])){
		header("Location:question0.php");
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
          <form method="POST" target="accueil.php" >
            <h2>^quest_name^</h2>
            <h3>Semaine du ^date_debut^ au ^date_fin^</h3>

          <input type="submit" id="submit" name="submit" value="Commencer" />
          </form>
        </div>
      </article>
    </div>
	</body>
</html>
>>
