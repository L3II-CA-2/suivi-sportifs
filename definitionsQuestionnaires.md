# Questionnaires

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




public class ListeQuestionnaires {
  
  private ArrayList<Questionnaire> listeQuestionnaires;

# ListeQuestionnaires

  public int retirer(int index) {
Vérifie si le questionnaire à l'index existe
Si il existe, le retire. Fin de fonction retourne 0
Si il n'existe pas, fin de fonction retourne 1

  public int modifierIntituleQuestionnaire(int index, String intitule) {
Vérifie si le questionnaire à l'index existe
Si il existe, retourne le résultat modifierIntitule la classe questionnaire
Si il n'existe pas, fin de fonction retourne 2

  public int modifierDebutQuestionnaire( int index, Date debut) {
Vérifie si le questionnaire à l'index existe
Si il existe, retourne le résultat setDebut de la classe questionnaire
Si il n'existe pas, fin de fonction retourne 4

  public int modifierFinQuestionnaire( int index, Date debut) {
Vérifie si le questionnaire à l'index existe
Si il existe, retourne le résultat setFin de la classe questionnaire
Si il n'existe pas, fin de fonction retourne 4


# Plans de tests


  public Boolean setPseudo(String pseudo) {
 

 | | pseudo | sp.pseudo | retour |
 |etat initial | - | null | - |
 | | pséudo | null | false |
 | | ps\*udo | null | false |
 | | p | null | false |
 | | ps | ps | true |
 | | monpseudo | monpseudo | true |
 | | m0nps3ud0 | m0nps3ud0 | true |


  public Boolean setNom(String nom) {
 

 | | nom | sp.nom | retour |
 |etat initial | - | null | - |
 | | Pearce | Pearce | true |
 | | P3arce | Pearce | false |
 | | p | Pearce | false |
 | | ps | ps | true |
