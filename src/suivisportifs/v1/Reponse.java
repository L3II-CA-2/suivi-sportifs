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
  
  /**
   * Echange les elements r1 et e2 dan sla liste de Booleans.
   * @param r1 l'indice du 1er element
   * @param r2 l'indice du deuxieme element
   */
  public void swap(int r1, int r2) {
    if (r1 >= reponses.size()) {
      r1 = reponses.size() - 1;
    }
    if (r1 < 0) {
      r1 = 0;
    }
    if (r2 >= reponses.size()) {
      r2 = reponses.size() - 1;
    }
    if (r2 < 0) {
      r2 = 0;
    }
    if (r1 == r2) {
      return;
    }
    Boolean tmp;
    tmp = reponses.get(r1);
    reponses.set(r1, reponses.get(r2));
    reponses.set(r2, tmp);
    return;
  }

  /**
   * Remonte le Boolean à l'indice r dans la liste des reponses.
   * @param r l'indice de l'element a monter
   */
  public void up(int r) {
    this.swap(r, r - 1);
    return;
  }

  /**
   * Descend le Boolean à l'indice r dans la liste des reponses.
   * @param r l'indice de l'element a descendre
   */
  public void down(int r) {
    this.swap(r, r + 1);
    return;
  }
}