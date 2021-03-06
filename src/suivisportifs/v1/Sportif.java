package suivisportifs.v1;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe Sportif : Cette classe permet de definir un sportif.
 * 
 * @author Kevin Kerboit
 *
 */

public class Sportif {
  private String pseudo;
  private String nom;
  private String prenom;
  private Date dateDeNaissance;
  private Sport sport;
  private Boolean actif;
  

  
  /**
   * Constructeur.
   */
  
  public Sportif() {
    this.pseudo = "";
    this.nom = "";
    this.prenom = "";
    this.dateDeNaissance = null;
    this.sport = Sport.Null;
  }

  /**
   * Fonction d'accès à la variable Pseudo.
   * 
   */
  
  public String getPseudo() {
    return pseudo;
  }

  /** 
   * Fonction pour modifier la variable pseudo.
   *
   */
  
  public Boolean setPseudo(String pseudo) {
    
    Pattern pattern;
    Matcher matcher;
    Boolean res = true;
      
    pattern = Pattern.compile("[^\\w]");
    matcher = pattern.matcher(pseudo);
      
    if (matcher.find()) {
      res = false;
    }
    
    if (res == false) {
      System.out.println("Erreur ! Le pseudo contient d'accents/caractères spéciaux \n");
      return false;
    }

      
    if (pseudo.length() < 5) {
      System.out.println("Erreur ! Le pseudo doit faire minimum 5 caractères ! \n");
      return false;
    }
    
    
    this.pseudo = pseudo;
    
    return true;
  }

  /**
   * Fonction d'accès à la variable nom.
   */

  public String getNom() {
    return nom;
  }
  
  /**
   * Fonction de modification de la variable nom.
   */

  public Boolean setNom(String nom) {
    
    Pattern pattern;
    Matcher matcher;
      
    Boolean res = true;
       
    pattern = Pattern.compile("[^a-zA-Zéèêëöôäâàïîùûü]");
    matcher = pattern.matcher(nom);
      
    if (matcher.find()) {
      res = false;
    }
    
    if (res == false) {
      System.out.println("Erreur ! Le nom ne doit pas contenir de caractères spéciaux \n");
      return false;
    }
      
    if (nom.length() < 2) {
      System.out.println("Erreur ! Le nom doit faire minimum 2 caractères ! \n");
      return false;
    }
    
    this.nom = nom;

    return true;
  }

  /**
   * Fonction d'accès à la variable Prenom.
   */
  
  public String getPrenom() {
    return prenom;
  }
  
  /**
   * Modification de la variable Prenom.
   */

  public Boolean setPrenom(String prenom) {
    
    Pattern pattern;
    Matcher matcher;
      
    Boolean res = true;
       
    pattern = Pattern.compile("[^a-zA-Zéèêëöôäâàïîùûü]");
    matcher = pattern.matcher(prenom);
      
    if (matcher.find()) {
      res = false;
    }
    
    if (res == false) {
      System.out.println("Erreur ! Le prenom ne doit pas contenir de caractères spéciaux \n");
      return false;
    }
      
    if (prenom.length() < 2) {
      System.out.println("Erreur ! Le prenom doit faire minimum 2 caractères ! \n");
      return null;
    }
    
    this.prenom = prenom;

    return true;
  }
  
  /**
   * Fonction d'accès de la variable Date de Naissance.
   * @return
   */

  public Date getDateDeNaissance() {
    return dateDeNaissance;
  }

  /**
   * Fonction de modification de la variable Date de Naissance.
   *
   */
  
  public void setDateDeNaissance(Date datedenaissance) {
    this.dateDeNaissance = datedenaissance;
  }
  
  /**
   * Fonction d'accès à la variable sport.
   * 
   */
  
  public Sport getSport() {
    return sport;
  }
  
  /**
   * Fonction de modification de sport.
   * 
   */
  public void setSport(Sport sport) {
    this.sport = sport;
  }

  public Boolean getActif() {
    return actif;
  }

  public void setActif(Boolean actif) {
    this.actif = actif;
  }
  
  
  
}
