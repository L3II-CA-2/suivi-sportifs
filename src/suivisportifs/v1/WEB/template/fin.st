fin(quest_id) ::= <<

<?php
	session_start();
	if(!isset($_SESSION['login'])){
		header("Location:index.php");
	}

	try{
		$bdd = new PDO('mysql:host=obiwan2.univ-brest.fr;dbname=zfl3-zpearceva;charset=utf8', 'zpearceva', 'ffa9kyky');

		$reponse = $bdd->query('SELECT count(*) FROM t_reponse_rps');
		$donnees = $reponse->fetch();

		foreach ($_SESSION['data'] as $key => $value) {
			if($value == "oui"){
				$rep="1";
			}
			else{
				$rep="0";
			}
			$today = getdate();
			$date = $today['year'].$today['mon'].$today['mday'];
			$rpsid=$donnees+$key;
			$bdd->exec('INSERT INTO t_reponse_rps VALUES ('.$value.')');
			$bdd->exec('INSERT INTO t_reponse_sportif_questionnaire_rsq VALUES ('.$_SESSION['idlogin'].',^quest_id^, '.$rpsid.', '.$date.')');
		}
  }
	catch (Exception $e){
  	die('Erreur : ' . $e->getMessage());
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
					 <h3>Vos réponse ont bien été enregistrer ! </h3>
           <?php
           echo("<h4>Login : ".$_SESSION['login']."</h4>");
            foreach ($_SESSION['data'] as $key => $value) {
              echo("<h4>Question ".$key." : ".$value."</h4>");
            }
           ?>
         </article>
       </div>
     </div>
   </div>
 </body>
</html>
>>
