<?php
	session_start();
	if(!isset($_SESSION['login'])){
		header("Location:index.php");
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
