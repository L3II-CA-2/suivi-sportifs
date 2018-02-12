/**
 * 
 */

package suivisportifs.v1;

import java.util.ArrayList;
import java.util.Date;

/**
 * Classe qui décrit une liste de réponses correspondant à
 * un questionnaire, et contenant la date de réponse.
 * @author Glen Ollivier
 *
 */

public class Reponse {
  private ArrayList<Boolean> reponses;
  private Date date;
  private int size;

  /**
   * Constructeur qui prend une Date en entrée.
   */
  public Reponse(int size, Date date) {
    super();
    this.date = date;
    this.size = size;
  }

  /**
   * Constructeur qui set la Date à la date du jour.
   */
  public Reponse(int size) {
    super();
    this.date = new Date();
    this.size = size;
  }

  /**
   * Accesseur de la liste de reponses.
   * @return the reponses
   */
  public ArrayList<Boolean> getReponses() {
    return reponses;
  }

  /**
   * Modificateur de la liste de reponses.
   * @param reponses the reponses to set
   */
  public void setReponses(ArrayList<Boolean> reponses) {
    this.reponses = reponses;
  }

  /**
   * Accesseur de la date.
   * @return the date
   */
  public Date getDate() {
    return date;
  }

  /**
   * Modificateur de la date.
   * @param date the date to set
   */
  public void setDate(Date date) {
    this.date = date;
  }
  
  /**
   * Ajoute une réponse à la fin de la liste de réponses.
   * @param reponse la reponse a ajouter
   * @return 1 s'il n'y a pas assez de place, 0 sinon
   */
  public int add(Boolean reponse) {
    if (this.size > reponses.size()) {
      this.reponses.add(reponse);
      return 0;
    } else {
      return 1;
    }
  }
}