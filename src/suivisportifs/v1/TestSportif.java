package suivisportifs.v1;



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
    
    Sportif sp1 = new Sportif();
    
    if (sp1.setPseudo("SebLoeb1") == false) {
      return;
    }
    
    if (sp1.setNom("Loeb") == false) {
      return;
    }
    
    if (sp1.setPrenom("Sebastien&") == false) {
      return;
    }
    
    sp1.setSport("Rallye");

    

  }

}
