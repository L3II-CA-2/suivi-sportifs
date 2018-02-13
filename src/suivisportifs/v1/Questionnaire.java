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
  }

  /**
   * @return the intitule
   */
  public String getIntitule() {
    return intitule;
  }

  /**
   * @param intitule the intitule to set
   */
   int setIntitule(String intitule) {
     Date maintenant = new Date();
     if (this.debut.after(maintenant)) {
       this.intitule = intitule;
       return 0;
     }
     return 1;
  }

  /**
   * @return la date debut
   */
  public Date getDebut() {
    return debut;
  }

  /**
   * Permet de modfier la date de début du questionnaire
   * @param debut the debut to set
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
      return 1;
    }
  return 2;
  }

  /**
   * @return the fin
   */
  Date getFin() {
    return fin;
  }

  /**
   * @param fin the fin to set
   */
  public int setFin(Date fin) {
    Date maintenant = new Date();
    if (this.debut.after(maintenant)) {
      if (fin.after(this.debut)) {
        GregorianCalendar validationDate = new GregorianCalendar();
        validationDate.setTime(fin);
        if (validationDate.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY) {
          this.fin = fin;
          return 0;
        }
        return 1;
      }
      return 2;
    }
    return 3;
  }

  /*
   * Permet d'ajouter un instance de question à la liste de questions du questionnaire.
   * @param Question initialisée
   */
  public int ajouterQuestion(Question question) {
    Date maintenant = new Date();
    if (this.debut.after(maintenant)) {
      this.questions.add(question);
      return 0;
    }
    return 1;
  }

  /*
   * Permet de retirer une question.
   * @return 0 ou code erreur
   */
  public int retirerQuestion(int index) {
    Date maintenant = new Date();
    if (this.debut.after(maintenant)) {
      try {
        @SuppressWarnings("unused") // La question est retirée mais n'est pas utile par la suite.
        Question questionSupprimee;
        questionSupprimee = this.questions.remove(index);
        return 0;
      } catch (IndexOutOfBoundsException e) {
        return 1;
      }
    }
    return 2;
  }
}
