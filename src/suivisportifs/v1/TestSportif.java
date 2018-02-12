package suivisportifs.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Programme de test pour la classe Sportif.
 * 
 * @author Kevin Kerboit
 *
 */

public class TestSportif {

  /**
   * Fonction main du programme de test.
   * 
   */

  public static void main(String[] args) {
    // TODO Stub de la méthode généré automatiquement
    
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
          sp.setDatedenaissance(dateDeNaissance);
          System.out.println(sp.getDatedenaissance().toString());
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

    }
    
    scanner.close();

    

  }

}
