/**
 * 
 */
package v1;

import java.util.Date;

/**
 * @author Kevin Kerboit
 *
 */
public class Sportif {
	private String pseudo;
	private String nom;
	private String prenom;
	private Date datedenaissance;
	private Sport sport;
	
	public Sportif(String pseudo, String nom, String prenom, Date datedenaissance, Sport sport) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.datedenaissance = datedenaissance;
		this.sport = sport;
		
		//Vérification que le pseudo fasse plus de 5 caractères
		if(pseudo.length() < 5) {
			return;
		}
		
		//Vérification que Nom et prénom fassent plus de 2 caractères chacun 
		if(nom.length() < 2 && prenom.length() < 2) {
			return;
		}
		
		
		
		
	}
	
	
	
}
