/**
 * 
 */

package suivisportifs.v1;

/**
 * Question.
 * @author Pierre Le Bras
 *
 */
public class Question {
  private String intitule;
  private boolean reponseDefaut;

  Question(String intitule, boolean reponseDefaut) {
    this.intitule = intitule;
    this.reponseDefaut = reponseDefaut;
    
  }
      
  /**
   * accesseur Intitulé Question.
   */
  public String getIntitule() {
      
    return this.intitule;
      
  }
  
  /**
   * Modificateur Intitulé Question.
   */
  public void setIntitule(String intitule) {
    
    this.intitule = intitule;
    
  }
  
  /**
   * Modificateur reponseDefault Question.
   */
  public void setReponseDefaut(boolean reponseDefaut) {
    this.reponseDefaut = reponseDefaut;
  }
  
  /**
   * Accesseur reponseDefault Question.
   */
  public boolean getReponseDefaut() {
    return this.reponseDefaut;
  }

}
