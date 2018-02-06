/**
 * 
 */
package v1;


/**
 * @author Pierre Le Bras
 * Superclasse Question
 */
public abstract class Question {
	int identifiant;
	String intitule;
	
	Question(int id,String itl){
		this.identifiant = id;
		this.intitule = itl;
	}
	
}
