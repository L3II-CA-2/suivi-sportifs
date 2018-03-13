package suivisportifs.v1;

import java.util.Date;
import java.util.Iterator;

public class GestionSportifs {  
  public static ListeQuestionnaires listeQuestionnaires = new ListeQuestionnaires();
  public static ListeSportifs listeSportifs = new ListeSportifs();
  public static ListeReponses listeReponses = new ListeReponses();
  
  public static void main(String[] args) {

  }
  public static Boolean addSportif(String pseudo, String nom, String prenom, Sport sport, Date ddn) {
    return listeSportifs.ajoutDansLaListe(pseudo, nom, prenom, sport, ddn);
  }
  
  public static Sportif getSportif(String pseudo) {
    Iterator<Sportif> i = listeSportifs.getListeSportifs().iterator();
    Sportif retours;
    while (i.hasNext()) {
      retours = i.next();
      if (retours.getPseudo() == pseudo) {
        return retours;
      }
    }
    return null;
  }
  
  public static int getIndexSportif(String pseudo) {
    int i = 0;
    Sportif sportif = listeSportifs.getListeSportifs().get(i);
    while (sportif != null) {
      if (sportif.getPseudo() == pseudo) {
        return i;
      }
      i++;
      sportif = listeSportifs.getListeSportifs().get(i);
    }
    return -1;
  }
  
  public static Sportif getSportif(int index) {
    return listeSportifs.getListeSportifs().get(index);
  }
  
  public static Boolean setNomSportif(int index, String nom) {
    return listeSportifs.modifierNomSportif(index, nom);
  }
  
  public static Boolean setNomSportif(String pseudo, String nom) {
    int index = getIndexSportif(pseudo);
    if(index == -1) { return false; }
    return listeSportifs.modifierNomSportif(index, nom);
  }
  
  public static Boolean setPrenomSportif(int index, String prenom) {
    return listeSportifs.modifierPrenomSportif(index, prenom);
  }
  
  public static Boolean setPrenomSportif(String pseudo, String prenom) {
    int index = getIndexSportif(pseudo);
    if(index == -1) { return false; }
    return listeSportifs.modifierPrenomSportif(index, prenom);
  }
  
  public static Boolean setDateNaissanceSportif(int index, Date nouvddn) {
    return listeSportifs.modifierDateDeNaissanceSportif(index, nouvddn);
  }
  
  public static Boolean setDateNaissanceSportif(String pseudo, Date nouvddn) {
    int index = getIndexSportif(pseudo);
    if(index == -1) { return false; }
    return listeSportifs.modifierDateDeNaissanceSportif(index, nouvddn);
  }
  
  public static Boolean setActifSportif(int index, Boolean actif) {
    return listeSportifs.modifActifSportif(index, actif);
  }
  
  public static Boolean setActifSportif(String pseudo, Boolean actif) {
    int index = getIndexSportif(pseudo);
    if(index == -1) { return false; }
    return listeSportifs.modifActifSportif(index, actif);
  }
  
  public static int addQuestionnaire(String intitule, Date debut, Date fin) {
    listeQuestionnaires.ajouter(new Questionnaire(intitule, debut, fin));
    return listeQuestionnaires.getListSize() - 1;
  }
  
  public static Questionnaire getQuestionnaire(int index) {
    return listeQuestionnaires.getQuestionnaire(index);
  }
  
  public static int addQuestion(int index, String intitule, boolean reponseDefaut) {
    return getQuestionnaire(index).ajouterQuestion(new Question(intitule, reponseDefaut));
  }
  
  public static int removeQuestion(int indexQuestionnaire, int indexQuestion) {
    return getQuestionnaire(indexQuestionnaire).retirerQuestion(indexQuestion);
  }
  
  public static int setIntituleQuestionnaire(int index, String intitule) {
    return listeQuestionnaires.modifierIntituleQuestionnaire(index, intitule);
  }
  
  public static int setDebutQuestionnaire(int index, Date debut) {
    return listeQuestionnaires.modifierDebutQuestionnaire(index, debut);
  }
  
  public static int setFinQuestionnaire(int index, Date fin) {
    return listeQuestionnaires.modifierFinQuestionnaire(index, fin);
  }
  
  public static ReponsesSportifQuestionnaire addReponses(Sportif sportif, Questionnaire questionnaire) {
    return listeReponses.add(sportif, questionnaire);
  }
  
  public static ReponsesSportifQuestionnaire getReponses(Sportif sportif, Questionnaire questionnaire) {
    return listeReponses.get(sportif, questionnaire);
  }
  
  public static Boolean removeReponses(ReponsesSportifQuestionnaire reponse) {
    return listeReponses.remove(reponse);
  }
  
  public static Boolean removeSportif(int index) {
    Boolean retours = false;
    Sportif sportif = listeSportifs.getListeSportifs().get(index);
    if(sportif != null) {
      listeReponses.remove(sportif);
      listeSportifs.getListeSportifs().remove(index);
      retours = true;
    }
    return retours;
  }
  
  public static Boolean removeSportif(String pseudo) {
    Boolean retours = false;
    int index = getIndexSportif(pseudo);
    if(index != -1) { 
      retours = removeSportif(index);
    }
    return retours;
  }
  
  public static int removeQuestionnaire(int index) {
    Questionnaire questionnaire = listeQuestionnaires.getQuestionnaire(index);
    listeReponses.remove(questionnaire);
    return listeQuestionnaires.retirer(index);
  }
}
