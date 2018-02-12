package suivisportifs.v1;

import java.util.Date;
import java.util.regex.*;

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
  private Date datedenaissance;
  private String sport;
  
  /**
   * Constructeur.
   */
  
  public Sportif() {
    this.pseudo = null;
    this.nom = null;
    this.prenom = null;
    this.datedenaissance = null;
    this.sport = null;
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
    
    System.out.println("Le pseudo est mis ! \n");
    
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
    System.out.println("Le nom est mis ! \n");
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
      
    if (nom.length() < 2) {
      System.out.println("Erreur ! Le nom doit faire minimum 2 caractères ! \n");
      return null;
    }
    
    this.prenom = prenom;
    System.out.println("Le prenom est mis ! \n");
    return true;
  }
  
  /**
   * Fonction d'accès de la variable Date de Naissance.
   * @return
   */

  public Date getDatedenaissance() {
    return datedenaissance;
  }

  /**
   * Fonction de modification de la variable Date de Naissance.
   *
   */
  
  public void setDatedenaissance(Date datedenaissance) {
    this.datedenaissance = datedenaissance;
  }

  /**
   * Fonction d'accès de la variable Sport.
   * @return
   */
  
  public String getSport() {
    return sport;
  }

  /**
   * Fonction de modification de la variable Sport.
   * 
   */
  
  public void setSport(String sport) {
    this.sport = sport;
  }
  
  
  
  
  
}
