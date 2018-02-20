/**
 *
 */

package suivisportifs.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe gérant la création et l'édition des questionnaires.
 * @author Valentin Pearce
 *
 */
public class Questionnaire {

  private String intitule;
  private Date debut;
  private Date fin;
  private ArrayList<Question> questions;

  private Questionnaire(String intitule, Date debut, Date fin) {
    this.intitule = intitule;
    this.debut = debut;
    this.fin = fin;
    this.qestions = new ArrayList<Question>();
  }

  public String getIntitule() {
    return intitule;
  }

  /**
   * Modificateur de l'intitulé.
   * @param intitule the intitule to set
   * @return 0 en cas de réussite, 1 si le questionnaire à déja été envoyé aux sportifs
   */
  public int setIntitule(String intitule) {
    Date maintenant = new Date();
    if (this.debut.after(maintenant)) {
      this.intitule = intitule;
      return 0;
    }
    return 1;
  }

  public Date getDebut() {
    return debut;
  }

  /**
   * Permet de modfier la date de début du questionnaire.
   * @param debut the debut to set
   * @return 0 en cas de réussite, 1 si le questionnaire à déja été envoyé aux sportifs, 
   *     2 Si la date de début n'est pas un Lundi
   */
  public int setDebut(Date debut) {
    Date maintenant = new Date();
    if (this.debut.after(maintenant)) {
      GregorianCalendar validationDate = new GregorianCalendar();
      validationDate.setTime(debut);
      if (validationDate.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.MONDAY) {
        this.debut = debut;
        return 0;
      }
      return 2;
    }
    return 1;
  }

  public Date getFin() {
    return fin;
  }

  /**
   * Modificateur de la date de fin.
   * @param fin the fin to set
   * @return 0 en cas de réussite, 1 si le questionnaire est déja terminé, 
   *     2 Si la nouvelle date de fin n'est pas un Dimanche,
   *     3 Si la nouvelle date de fin est avant la date de début
   */
  public int setFin(Date fin) {
    Date maintenant = new Date();
    if (this.fin.after(maintenant)) {
      if (fin.after(this.debut)) {
        GregorianCalendar validationDate = new GregorianCalendar();
        validationDate.setTime(fin);
        if (validationDate.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY) {
          this.fin = fin;
          return 0;
        }
        return 2;
      }
      return 3;
    }
    return 1;
  }

  /**
   * Permet d'ajouter un instance de question à la liste de questions du questionnaire.
   * @param question Instance de Question initialisée
   */
  public int ajouterQuestion(Question question) {
    Date maintenant = new Date();
    if (this.debut.after(maintenant)) {
      this.questions.add(question);
      return 0;
    }
    return 1;
  }

  /**
   * Permet de retirer une question.
   * @return 0 ou code erreur
   */
  public int retirerQuestion(int index) {
    Date maintenant = new Date();
    if (this.debut.after(maintenant)) {
      if (this.questions.size() > index + 1) {
        @SuppressWarnings("unused") // La question est retirée mais n'est pas utile par la suite.
        Question questionSupprimee;
        questionSupprimee = this.questions.remove(index);
        return 0;
      } else {
        return 1;
      }
    }
    return 2;
  }
  
  /**
   * Permet d'échanger la position de deux questions.
   * 0 en cas de réussite, 1 si l'index est en dehors des bornes,
   *     2 si le questionnaire a déja été envoyé aux sportifs
   */
  public int echangerQuestions(int positionA, int positionB) {
    Date maintenant = new Date();
    if (this.debut.after(maintenant)) {
      if (positionA < 0 || positionB < 0 
          || positionA >= this.questions.size()
          || positionB >= this.questions.size()) {
        return 1;
      } else  {
        Question bufferA = this.questions.get(positionA);
        Question bufferB = this.questions.get(positionB);
        this.questions.set(positionA, bufferB);
        this.questions.set(positionB, bufferA);
        return 0;
      }
    } else {
      return 2;
    }
  }
  
  /**
   * Permet de monter d'un cran une question dans le questionnaire.
   * @return 0 en cas de réussite, 1 en cas d'échec
   */
  public int monterQuestion(int index) {
    return echangerQuestions(index, index - 1);
  }
  
  /**
   * Permet de descendre d'un cran une question dans le questionnaire.
   * @return 0 en cas de réussite, 1 en cas d'échec
   */
  public int descendreQuestion(int index) {
    return echangerQuestions(index, index + 1);
  }
  
  
  /**
   * Permet de modifier l'intitulé d'une question.
   * 0 en cas de réussite, 1 si l'index est en dehors des bornes,
   *     2 si le questionnaire a déja été envoyé aux sportifs
   */
  public int modifierIntituleQuestion(int index, String intitule) {
    if (index >= 0 && index < this.questions.size()) {
      this.questions.get(index).setIntitule(intitule);
      return 0;
    } else {
      return 1;
    }
  }
  
  /**
   * Permet de modifier la reponse par defaut à une question.
   * 0 en cas de réussite, 1 si l'index est en dehors des bornes,
   *     2 si le questionnaire a déja été envoyé aux sportifs
   */
  public int modifierReponseDefautQuestion(int index, Boolean reponseDefaut) {
    if (index >= 0 && index < this.questions.size()) {
      this.questions.get(index).setReponseDefaut(reponseDefaut);
      return 0;
    } else {
      return 1;
    }
  }
  
  /**
   * Renvoie l'intitulé d'une question.
   * @param index Index de la question
   * @return Intitulé de la question ou null en cas de question inexistante
   */
  public String getIntituleQuestion(int index) {
    if (index >= 0 && index < this.questions.size()) {
      return this.questions.get(index).getIntitule();
    } else {
      return null;
    }
  }
  
  /**
   * Renvoie la réponse par défaut à une question.
   * @param index Index de la question
   * @return Objet booeleen contenat la valeur de la réponse par défaut ou null
   */
  public Boolean getReponseDefautQuestion(int index) {
    if (index >= 0 && index < this.questions.size()) {
      return new Boolean(this.questions.get(index).getReponseDefaut());
    } else {
      return null;
    }
  }
  
}
