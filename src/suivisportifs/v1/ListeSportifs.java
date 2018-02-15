package suivisportifs.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Programme de test pour la classe Sportif.
 * 
 * @author Kevin Kerboit
 *
 */

public class ListeSportifs {
  ArrayList<Sportif> listeSportifs = new ArrayList<Sportif>();

  /**
   * Fonction d'ajout d'un sportif.
   * 
   */

  public Boolean ajout() {
    
    Boolean creation = false;
    Boolean creePseudo = false;
    Boolean creeNom = false;
    Boolean creePrenom = false;
    Boolean creeDdN = false;
    Boolean creeSport = false;
    
    Sportif sp = new Sportif();
    Scanner scanner = new Scanner(System.in);
    
    
    System.out.println("Programme de creation d'un sportif : \n");
    
    while (!creation) {
      while (!creePseudo) {
        System.out.println("Pseudo : (Min 5 caractère, pas d'accents, pas de caractères spéciaux)");
       
        creePseudo = sp.setPseudo(scanner.nextLine());
      }

      while (!creeNom) {
        System.out.println("Nom : (Min 2 caractère, pas de caractères spéciaux) ");
        creeNom = sp.setNom(scanner.nextLine());

      }

      while (!creePrenom) {
        System.out.println("Prénom : (Min 2 caractère, pas de caractères spéciaux) ");
        creePrenom = sp.setPrenom(scanner.nextLine());
      }

      while (!creeDdN) {
        SimpleDateFormat dateIso = new SimpleDateFormat("yyyy-MM-dd"); // Format de date ISO
        String dateEntree;
        Date dateDeNaissance = new Date();
        System.out.println("Date de naissance : (format AAAA-MM-JJ) ");
        dateEntree = scanner.nextLine();
        try {
          dateDeNaissance = dateIso.parse(dateEntree);
          creeDdN = true;
        } catch (ParseException e) {
          System.out.println("Le format de la date doit respecter le format demandé.");
        }
        
        if (creeDdN == true) {
          sp.setDateDeNaissance(dateDeNaissance);
          System.out.println(sp.getDateDeNaissance().toString());
        }
        
        
      }
      
      while (!creeSport) {
        System.out.print("Sport : (");
        for (Sport spt : Sport.values()) {
          System.out.print(spt.toString() + " - ");
        }
        System.out.print(") \n");
        String sport = scanner.nextLine();
        
        for (Sport spt : Sport.values()) {
          if (spt.toString().equals(sport)) {
            sp.setSport(spt);
            creeSport = true;
          }
        }
        
        if (creeSport == false) {
          System.out.println("Erreur, Sport inconnu !");
        }
        
      }
      
      for (int i = 0; i < listeSportifs.size(); i++) {
        if (sp.getPseudo().equals(listeSportifs.get(i).getPseudo())) {
          System.out.print("Erreur ! ");
          System.out.print("Il existe déja un sportif avec ce pseudo \n");
          creation = false;
        }
      }
      
      if (verifDoublon(sp) == true) {
        creation = true;
        sp.setActif(true);
        listeSportifs.add(sp);
      } else {
        creation = false;
      }
      
      
    }
    
    scanner.close();
    return creation;
  }
  
  /**
   * Fonction de modification du nom d'un Sportif.
   */
  
  public Boolean modifierNom(int index, String nouvNom) {
    Sportif sp = listeSportifs.get(index);
    sp.setNom(nouvNom);
    if (verifDoublon(sp) == true) {
      listeSportifs.get(index).setNom(nouvNom);
      return true;
    } 
    
    return false;
  }

  /**
   * Fonction de modification du prenom d'un Sportif.
   */
  
  public Boolean modifierPrenom(int index, String nouvPrenom) {
    Sportif sp = listeSportifs.get(index);
    sp.setPrenom(nouvPrenom);
    if (verifDoublon(sp) == true) {
      listeSportifs.get(index).setPrenom(nouvPrenom);
      return true;
    } 
    
    return false;
  }
  
  /**
   * Fonction de modification de la date de naissance d'un Sportif.
   */
  
  public Boolean modifierDateDeNaissance(int index, Date nouvddn) {
    Sportif sp = listeSportifs.get(index);
    sp.setDateDeNaissance(nouvddn);
    if (verifDoublon(sp) == true) {
      listeSportifs.get(index).setDateDeNaissance(nouvddn);
      return true;
    } 
    
    return false;
  }
  
  public Boolean modifActif(int index, Boolean actif) {
    listeSportifs.get(index).setActif(actif);
    return true;
  }
  
  private Boolean verifDoublon(Sportif sp) {
    for (int i = 0; i < listeSportifs.size(); i++) {
      if ((sp.getNom().equals(listeSportifs.get(i).getNom())) 
          && (sp.getPrenom().equals(listeSportifs.get(i).getPrenom())) 
          && (sp.getDateDeNaissance().equals(listeSportifs.get(i).getDateDeNaissance()))) {
        
        System.out.print("Erreur ! ");
        System.out.print("Il existe déja un sportif avec ce Nom, Prenom et date de naissance \n");
        return false;
      }
    }
    return true;
  }
  

}
