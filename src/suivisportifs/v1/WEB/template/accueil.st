accueil(quest_name, date_debut, date_fin) ::= <<
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
          <form method="POST" target="" >
            <h2>$quest_name$</h2>
            <h3>Semaine du $date_debut$ au $date_fin$</h3>

            <input type="submit" id="commencer" name="commencer" value="Commencer" />
          </form>
        </div>
      </article>
    </div>
	</body>
</html>
>>
