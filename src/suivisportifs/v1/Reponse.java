/**
 * 
 */

package suivisportifs.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
   * Constructeur qui prend une Date et une List de Boolean en entrée.
   */
  public Reponse(Date date, List<Boolean> reponses) {
    super();
    this.date = date;
    this.size = reponses.size();
    Iterator<Boolean> i = reponses.iterator();
    while (i.hasNext()) {
      this.add(i.next());
    }
  }

  /**
   * Constructeur qui set la Date à la date du jour et qui prend une List de Boolean en entrée.
   */
  public Reponse(List<Boolean> reponses) {
    super();
    this.date = new Date();
    this.size = reponses.size();
    Iterator<Boolean> i = reponses.iterator();
    while (i.hasNext()) {
      this.add(i.next());
    }
  }

  /**
   * Accesseur de la liste de reponses.
   * @return the reponses
   */
  public ArrayList<Boolean> getReponses() {
    return reponses;
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
      this.reponses.add(new Boolean(reponse.booleanValue()));
      return 0;
    } else {
      return 1;
    }
  }
}