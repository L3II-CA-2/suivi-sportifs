/**
 * 
 */

package suivisportifs.v1;

import java.util.ArrayList;
import java.util.Date;

/**
 * Gestion CRUD des Questionnaires.
 * @author Valentin Pearce
 *
 */
public class ListeQuestionnaires {
  
  private ArrayList<Questionnaire> listeQuestionnaires;
  
  public ListeQuestionnaires() {
    this.listeQuestionnaires = new ArrayList<Questionnaire>();
  }
  
  /**
   * Ajoute un questionnaire.
   */
  public void ajouter(Questionnaire questionnaire) {
    this.listeQuestionnaires.add(questionnaire);
  }
  
  /**
   * Retire un Questionnaire de la liste des questionnaires.
   */
  public int retirer(int index) {
    if (index >= 0 && index < this.listeQuestionnaires.size()) {
      @SuppressWarnings("unused")
      Questionnaire questionRetiree = this.listeQuestionnaires.remove(index);
      return 0;
    } else {
      return 1;
    }
  }
  
  /**
   * Permet de modifier l'intitulé d'un Questionnaire.
   * @param index Index du questionnaire à modifier
   * @param intitule Nouvel intitulé du questionnaire
   * @return 0 en cas de réussite, 1 si il est impossible de modifier le questionnaire et 2 si 
   *     le questionnaire n'existe pas
   */
  public int modifierIntituleQuestionnaire(int index, String intitule) {
    if (index >= 0 && index < this.listeQuestionnaires.size()) {
      return this.listeQuestionnaires.get(index).setIntitule(intitule);
    } else {
      return 2;
    }
  }

  /**
   * Permet de modifier la date de début d'un Questionnaire.
   * @param index Index du questionnaire à modifier
   * @param debut Nouvelle date de début du questionnaire
   * @return Le valeur  de retour de setDebut si le Questionnaire existe, 4 sinon.  */
  public int modifierDebutQuestionnaire(int index, Date debut) {
    if (index >= 0 && index < this.listeQuestionnaires.size()) {
      return this.listeQuestionnaires.get(index).setDebut(debut);
    } else {
      return 4;
    }
  }

  /**
   * Permet de modifier la date de fin d'un Questionnaire.
   * @param index Index du questionnaire à modifier
   * @param fin Nouvelle date de fin du questionnaire
   * @return Le valeur  de retour de setFin si le Questionnaire existe, 4 sinon.  */
  public int modifierFinQuestionnaire(int index, Date fin) {
    if (index >= 0 && index < this.listeQuestionnaires.size()) {
      return this.listeQuestionnaires.get(index).setFin(fin);
    } else {
      return 4;
    }
  }
}
