package suivisportifs.v1;

import java.util.ArrayList;

/**
 * Classe qui contient toutes les réponses d'un sportif
 * à un questionnaire particulier.
 * @author Glen Ollivier
 *
 */

public class ListeReponse {
  private ArrayList<Reponse> reponses;
  private Sportif sportif;
  private Questionnaire questionnaire;
  
  /**
   * Constructeur qui prend un sportif et un questionnaire en entrée.
   * @param sportif le sportif
   * @param questionnaire le questionnaire
   */
  public ListeReponse(Sportif sportif, Questionnaire questionnaire) {
    super();
    this.sportif = sportif;
    this.questionnaire = questionnaire;
  }
  
  /**
   * Constructeur sans parametres.
   */
  public ListeReponse() {
    super();
    this.sportif = null;
    this.questionnaire = null;
  }
  
  /**
   * Accesseur du sportif.
   * @return le sportif
   */
  public Sportif getSportif() {
    return sportif;
  }
  
  /**
   * Modificateur du sportif.
   * @param sportif le sportif a lier
   */
  public void setSportif(Sportif sportif) {
    this.sportif = sportif;
  }
  
  /**
   * Accesseur du questionnaire.
   * @return le questionnaire
   */
  public Questionnaire getQuestionnaire() {
    return questionnaire;
  }
  
  /**
   * Modificateur du questionnaire.
   * @param questionnaire le questionnaire a lier
   */
  public void setQuestionnaire(Questionnaire questionnaire) {
    this.questionnaire = questionnaire;
  }

  /**
   * Ajoute une réponse à la fin de la liste de réponses.
   * @param reponse la reponse a ajouter
   */
  public void addReponse(Reponse reponse) {
    this.reponses.add(reponse);
  }
}
