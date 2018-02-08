/**
 * 
 */
package v1;

import java.util.Date;
import java.util.regex.*;

/**
 * @author Kevin Kerboit
 *
 */
public class Sportif {
	private String pseudo;
	private String nom;
	private String prenom;
	private Date datedenaissance;
	private String sport;
	
	public Sportif() {
		this.pseudo = null;
		this.nom = null;
		this.prenom = null;
		this.datedenaissance = null;
		this.sport = null;
	}

/*---------Pseudo---------*/
	public String getPseudo() {
		return pseudo;
	}

	public Boolean setPseudo(String pseudo) {
		
		Pattern pattern;
	    Matcher matcher;
	     
	    pattern = Pattern.compile(pseudo);
	    matcher = pattern.matcher("[^\\w]");
	    
	    while(matcher.find()) {
            System.out.println("Erreur ! Le pseudo ne doit pas contenir d'accents ou des caractères spéciaux \n");
            return false;
        }
		
		if(pseudo.length() < 5) {
			System.out.println("Erreur ! Le pseudo doit faire minimum 5 caractères ! \n");
			return false;
		}
		
		
		this.pseudo = pseudo;
		
		return true;
	}

/*---------Nom---------*/	

	public String getNom() {
		return nom;
	}

	public Boolean setNom(String nom) {
		
		Pattern pattern;
	    Matcher matcher;
	     
	    pattern = Pattern.compile(pseudo);
	    matcher = pattern.matcher("");
	    
	    while(matcher.find()) {
            System.out.println("Erreur ! Le Nom ne doit pas contenir de caractères spéciaux \n");
            return false;
        }
		
		if(nom.length() < 2) {
			System.out.println("Erreur ! Le nom doit faire minimum 2 caractères ! \n");
			return false;
		}
		
		this.nom = nom;
		return true;
	}

/*---------Prenom---------*/	
	
	public String getPrenom() {
		return prenom;
	}

	public Boolean setPrenom(String prenom) {
		
		Pattern pattern;
	    Matcher matcher;
	     
	    pattern = Pattern.compile(pseudo);
	    matcher = pattern.matcher("[a-zA-Zéèëêùûüôö]");
	    
	    while(!matcher.find()) {
            System.out.println("Erreur ! Le prenom ne doit pas contenir de caractères spéciaux \n");
            return false;
        }
		
		if(nom.length() < 2) {
			System.out.println("Erreur ! Le nom doit faire minimum 2 caractères ! \n");
			return null;
		}
		
		this.prenom = prenom;
		return true;
	}
	
/*---------Date de naissance---------*/

	public Date getDatedenaissance() {
		return datedenaissance;
	}

	public void setDatedenaissance(Date datedenaissance) {
		this.datedenaissance = datedenaissance;
	}

/*---------Sport---------*/
	
	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}
	
	
	
	
	
}
