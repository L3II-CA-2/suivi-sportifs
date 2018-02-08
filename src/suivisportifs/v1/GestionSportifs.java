package suivisportifs.v1;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionSportifs {
  ArrayList<Sportif> sportifs;
  ArrayList<Questionnaire> questionnaires;
  ArrayList<Reponse> reponses;
  
  GestionSportifs() {
    sportifs = new ArrayList<Sportif>();
    questionnaires = new ArrayList<Questionnaire>();
    reponses = new ArrayList<Reponse>();
  }
  
  void addSportif(Sportif sportif) {
    this.sportifs.add(sportif);
  }
  
  void addNewSportif() {
    Sportif sportif = new Sportif();
    this.addSportif(sportif);
  }
  
  void addQuestionnaire(Questionnaire questionnaire) {
    this.questionnaires.add(questionnaire);
  }
  
  void addNewQuestionnaire() {
    Questionnaire questionnaire = new Questionnaire();
    this.addQuestionnaire(questionnaire);
  }
  
  void addReponse(Reponse reponse) {
    this.reponses.add(reponse);
  }
  
  void addNewReponse() {
    Reponse reponse = new Reponse();
    this.addReponse(reponse);
  }
  
  Sportif getSportif(String pseudoSportif) {
    Iterator<Sportif> i = sportifs.iterator();
    Sportif sportif;
    boolean testPseudo = false;
    while (i.hasNext()) {
      sportif = i.next();
      if (sportif.getPseudo() == pseudoSportif) {
        testPseudo = true;
        break;
      }
    }
    if (!testPseudo) {
      sportif = null;
    }
    return sportif;
  }
  
  public static void main(String[] args) {
    
  }

}
