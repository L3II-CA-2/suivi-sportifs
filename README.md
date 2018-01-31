Guide de mise en forme : [lien](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)

# 1 - Sportif 

Un sportif est crée par l'administrateur de l'application.
Il est caractérisé par son nom, prénom, pseudo, sa date de naissance et son activité sportive. 
Un seul sport par sportif 
Pseudo unique ! 

Si on veut ajouter un sportif avec le même nom, prénom, pseudo et date de naissance : afficher un message d'erreur "Un utilisateur procède déjà ces information !"  (sans gestion de la casse) 
* Si l'administrateur à fait une erreur, il clique sur annuler, la requête est ignorée! 
* Si il existe deux sportifs avec des infos identiques : il clique sur "ajouter" et le sportif est ajouté a la base 


Pour ajouter un sportif : L'administrateur doit aller dans la liste des sportifs, il peut cliquer sur le bouton "ajouter" sous la liste 
Le formulaire d'ajout s'affiche 
L'utilisateur rentre les infos du sportifs 

Pseudo : il peut contenir des majuscules, minuscules, chiffres.
* Il doit commencer par une lettre 
* Il doit faire minimum 5 caractères 
* Pas d'accents 
* Pas de caractères spéciaux 
			
Nom :  il peut contenir des Majuscules, minuscules. 
Prénom :  il peut contenir des Majuscules, minuscules
2 lettres minimums 
Les accents sont autorisés mais pas les caractères spéciaux 

Date de naissance : Soit un menu déroulant pour (jours - mois - années ) soit champ de date (calendrier)

Sport : menu déroulant 

Une fois toutes les infos du sportif rentrées l'utilisateur clique sur "ajouter". 
Si l'ajout se passe bien l'utilisateur est redirigé sur la liste des sportifs 
Sinon (une popup ou message d'erreur) s'affiche 

Pour modifier un sportif : L'administrateur doit aller dans la liste des sportifs, il peut cliquer sur le bouton "modifier" à coter du sportif 
Le formulaire de modification s'affiche 
Le pseudo ne peut pas être modifié 
Une fois la modification terminée l'administrateur clique sur "Modifier". 
Si la modification se passe bien l'utilisateur est redirigé sur la liste des sportifs 
Sinon (une popup ou message d'erreur) s'affiche 

Le sportif reçoit un lien vers le questionnaire 
Le sportif à le droits de ne pas répondre au questionnaire 
Il peut aussi demander à l'administrateur de remplir le questionnaire à sa place (même sur plusieurs semaine)

Suppression d'un sportif 
Donner le choix à l'administrateur : 
* Soit "désactiver" le sportif ! c-à-d ne plus ne lui envoyer les liens vers les questionnaires 
* Soit le supprimer et supprimer aussi ces réponses aux questionnaires 
	
L'administrateur doit aller dans la liste des sportifs, il peut cliquer sur le bouton "supprimer" à côté du sportif 
Une popup s'affiche :
Donner le choix à l'administrateur : 
* Soit "désactiver" le sportif ! c-à-d ne plus ne lui envoyer les liens vers les questionnaires 
* Soit le supprimer et supprimer aussi ces réponses aux questionnaires 
Deux boutons : "Annuler" et "Supprimer" (boutons supprimer ne peux pas être cliquer si un choix n'est pas fait) 
Si la modification se passe bien l'utilisateur est rediriger sur la liste des sportifs 
Sinon (une popup ou message d'erreur) s'affiche 




# 2 - Questionnaire 

## 2.1 -  Création de questionnaires
Les questionnaires ont tous des attributs obligatoires :
* Titre : une chaine de caractères +
* Date de début : un lundi à partir de celui de la semaine suivante la semaine actuelle
* Date de fin : un dimanche antécédent au lundi de début du questionnaire
Une fois ces informations définies, ont peut ajouter des questions :
* Question Oui/Non
		* Il faut remplir un champ "question" + Valeur par défaut 
	
	
* Question choix multiple
	* Par défaut il y a 3 réponses vides complétables
	* Chaque question peut être supprimée en cliquant sur un bouton (X)
	* Un bouton (+) permet d'ajouter des réponses possibles jusqu'à un maximum de 5

L'administrateur peut valider la création du questionnaire si il contient au moins une question.
Si la date de début du questionnaire précède sa création, il est automatiquement envoyé aux sportifs.
## 2.2 - Modification de questionnaires
Si le questionnaire n'a pas encore été envoyé aux sportifs (date de début ultérieure à l'instant T), l'administrateur peut modifier un questionnaire entièrement.
Il obtient la même interface que celle de création de nouveau questionnaire mais avec les données du questionnaire pré-chargées.
Si le questionnaire a déjà été envoyé, l'administrateur ne peut modifier que la date de fin, toujours vers une date non atteinte.

Arrêter 


# 3 - Réponses 
## 3.1 - Service Web (sportifs)
Les sportifs reçoivent un lien généré par l’application java, le lien mène a une page web (sauf questionnaire déjà valider, questionnaire arrêter ou questionnaire finit, message d'erreur), ou ils sont alors invités a se connecter (les sportifs possèdent un pseudo ( pseudo non reconnut , message d'erreur)), une fois connecté le questionnaire correspondant au lien s'affiche . Il faut répondre a toutes les questions et seulement ensuite est-il possible de valider (sinon un message d'erreur s'affiche). La validation permet de rentrer toutes les réponses du sportif dans une base de donnée.
## 3.2 - Java (administrateur)
En cas de besoin, l'administrateur peut aussi répondre au questionnaire à la place d'un sportif via l’application java , il clique sur le bouton répondre dans le menu principal de l’application, une liste de tous les sportifs s'affiche , il choisit le sportif puis le questionnaire auquel il souhaite répondre ou dont il veut modifier une réponse , le questionnaire s'affiche avec, si existantes, les réponses de l'athlète , il peut alors répondre aux questions ou modifier les réponses puis valider ce qui ajoute ou met à jour les réponse dans la base de donnée comme si le sportif avait répondu lui-même. 


# 4 - Suivi
L'administrateur , afin de suivre les sportifs , pourra cliquer sur le bouton suivre dans le menus principal , il aura alors la liste des questionnaires. Après avoir cliqué sur un questionnaire, il pourra choisir a l'aide de deux boutons si il souhaite tout voir ou si il souhaite voir un seul sportif. Si l'administrateur a choisit de tout voir, les données sont directement affichées sous forme de graphes barres (histogrammes)  . Sinon un champ permet de renseigner le pseudo afin de n'avoir que les infos d'un sportif.


note : 

Attention état des entités questionnaire et sportif 

