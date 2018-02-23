

	public int setDebut(Date debut) :

Vérifie si debut est avant la date actuelle:
Si c'est avant : fin de la fonction avec retour 3
sinon vérifie si la date de début du questionnaire est déjà passée
Si elle est passée : fin de la fonction avec retour 2
Sinon vérifie si la nouvelle date est un Lundi (jour de début de semaine)
Si ce n'est pas un lundi : fin de la fonction avec retour 1
Sinon : changement de la date et fin de la fonction avec retour 0
	 
	public int setFin(Date fin) :

Vérifie si la date de début du questionnaire est déjà passée
Si elle est passée : fin de la fonction avec retour 3
Vérifie si fin est avant la date de début du questionnaire :
Si c'est avant : fin de la fonction avec retour 2
Sinon vérifie si la nouvelle date est un Dimanche (jour de fin de semaine)
Si ce n'est pas un Dimanche : fin de la fonction avec retour 1
Sinon : changement de la date et fin de la fonction avec retour 0

	public int ajouterQuestion(Question question)

Vérifie si la date de début du questionnaire est déjà passée
Si elle est passée : fin de la fonction avec retour 1
Sinon : ajout de la question à la fin du questionnaire et fin de la fonction avec retour 0

	public int retirerQuestion(int index) {

Vérifie si la date de début du questionnaire est déjà passée
Si elle est passée : fin de la fonction avec retour 2
Sinon vérifie si la question à l'index existe 
si elle n'existe pas : fin de la fonction avec retour 1
si elle existe : retrait de la question et fin de la fonction avec retour 0

	public int setIntitule(String intitule)

Vérifie si la date de début du questionnaire est passée
Si elle est passée : fin de la fonction avec retour 1
Sinon changement de l'intitulé et fin de la fonction avec retour 0

  public int echangerQuestions(int positionA, int positionB) {
Vérifie si la date de début du questionnaire est déjà passée
Si elle est passée : fin de la fonction avec retour 2
Sinon vérifie si les question aux position A et B existenet 
si elles n'existent pas : fin de la fonction avec retour 1
si elle existe : échange de position des questions et fin de la fonction avec retour 0

  public int monterQuestion(int index) {
	execution de echangerQuestions avec positionA = index et positionB = index -1
	retourne le résultat d'echangerQuestions

  public int descendreQuestion(int index) {
	execution de echangerQuestions avec positionA = index et positionB = index +1
	retourne le résultat d'echangerQuestions

  public int modifierIntituleQuestion(int index, String intitule) {
Vérifie si la date de début du questionnaire est passée
Si elle est passée : fin de la fonction avec retour 2
Sinon vérifie si la question existe dans l'index
Si elle n'existe pas : fin de la fonction avec retour 1
Sinon changement de l'intitulé de la question et fin de la fonction avec retour 0

  public int modifierReponseDefautQuestion(int index, Boolean reponseDefaut) {
Vérifie si la date de début du questionnaire est passée
Si elle est passée : fin de la fonction avec retour 2
Sinon vérifie si la question existe dans l'index
Si elle n'existe pas : fin de la fonction avec retour 1
Sinon changement de la réponse par défaut de la question et fin de la fonction avec retour 0
