/**
 * 
 */

package suivisportifs.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 * Question.
 * @author Pierre Le Bras
 *
 */
public class Question {
  private String intitule;
  private boolean reponseDefault;

  Question(String inttl, boolean rdflt) {
    this.intitule = inttl;
    this.reponseDefault = rdflt;
    
  }
      
  /**
   * accesseur Intitulé Question.
   */
  public String getIntitule() {
      
    return this.intitule;
      
  }
  
  /**
   * modificateur Intitulé Question.
   */
  public void setIntitule(String itl) {
    
    this.intitule = itl;
    
  }
  
  /**
   * modificateur reponseDefault Question.
   */
  public void setReponseDefault(boolean reponseD) {
    this.reponseDefault = reponseD;
  }
  
  /**
   * accesseur reponseDefault Question.
   */
  public boolean getReponseDefault() {
    return this.reponseDefault;
  }

}
