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
  int identifiant;
  static int id_max = 0;
  String intitule;
  private  List<String> reponsePossible  = new ArrayList<String>();
  
  
  Question(int id) {
    this.identifiant = id;
    
  }
  
  /**
   * Methode permettant de créer une question.
   */
  
  public static Question creerQuestionOuiNon() {
    
    Question qcreer = new Question(id_max + 1);
    id_max++;
    Scanner reader = new Scanner(System.in);  // Reading from System.in
    System.out.println("Entrer un intituler de question :");
    qcreer.setIntitule(reader.next());
    qcreer.setreponsePossible("OUI");
    qcreer.setreponsePossible("NON");
    return qcreer;
  }
  
  /**
   * Methode permettant de changer l'intitulé d'une question.
   */
  
  public void changerIntitule() {
    Scanner reader = new Scanner(System.in);  // Reading from System.in
    System.out.println("Entrer un intituler de question :");
    this.setIntitule(reader.next());
  }
  
  /*public static Question creerQuestionChoixMultiple(){
    Question Qcreer = new Question(id_max+1);
    id_max++;
    
    return Qcreer;
  }
  
  public void changerReponse(String rps,){
    Scanner reader = new Scanner(System.in);  // Reading from System.in
    System.out.println("Entrer une intituler de question :");
    this.intitule  = reader.next();
  }
  
  */
  
  /**
   * accesseur reponsePossible.
   */
  
  public List<String> getreponsePossible() {
    
    return this.reponsePossible;
    
  }
  
  /**
   * modificateur reponsePossible.
   */
  
  public void setreponsePossible(String rps) {
    
    this.reponsePossible.add(rps);
    
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
   * accesseur Identifiant Question.
   */
  
  public int getIdentifiant() {
    
    return this.identifiant;
    
  }
  
  
  

}
