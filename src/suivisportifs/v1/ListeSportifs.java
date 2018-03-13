package suivisportifs.v1;

import java.util.ArrayList;
import java.util.Date;


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

  public Boolean ajoutDansLaListe(String pseudo, String nom, String prenom, Sport sport, Date ddn) {
    
    Boolean creation = false;
    Sportif sp = new Sportif();
    
    if (sp.setPseudo(pseudo) == false) {
      return false;
    }
    
    if (sp.setNom(nom) == false) {
      return false;
    }
    
    if (sp.setPrenom(prenom) == false) {
      return false;
    }
    
    sp.setSport(sport);
    sp.setDateDeNaissance(ddn);
      
    for (int i = 0; i < listeSportifs.size(); i++) {
      if (sp.getPseudo().equals(listeSportifs.get(i).getPseudo())) {
        System.out.print("Erreur ! ");
        System.out.print("Il existe déja un sportif avec ce pseudo \n");
        creation = false;
      }
    }
      
    if (verifDoublonSportif(sp) == true) {
      creation = true;
      sp.setActif(true);
      listeSportifs.add(sp);
    } else {
      creation = false;
    }
    
    return creation;
  }
  
  /**
   * Fonction de modification du nom d'un Sportif.
   */
  
  public Boolean modifierNomSportif(int index, String nouvNom) {
    Sportif sp = new Sportif();
    
    sp.setPrenom(listeSportifs.get(index).getPrenom());
    sp.setDateDeNaissance(listeSportifs.get(index).getDateDeNaissance());
    sp.setSport(listeSportifs.get(index).getSport());
    sp.setPseudo(listeSportifs.get(index).getPseudo());
    
    if (sp.setNom(nouvNom) == false) {
      return false;
    }
    
    if (verifDoublonSportif(sp) == true) {
      listeSportifs.get(index).setNom(nouvNom);
      return true;
    } 
    
    return false;
  } 

  /**
   * Fonction de modification du prenom d'un Sportif.
   */
  
  public Boolean modifierPrenomSportif(int index, String nouvPrenom) {
    Sportif sp = new Sportif();
    sp.setNom(listeSportifs.get(index).getNom());
    sp.setDateDeNaissance(listeSportifs.get(index).getDateDeNaissance());
    sp.setPseudo(listeSportifs.get(index).getPseudo());
    sp.setSport(listeSportifs.get(index).getSport());
    
    if (sp.setPrenom(nouvPrenom) == false) {
      return false;
    }
    if (verifDoublonSportif(sp) == true) {
      listeSportifs.get(index).setPrenom(nouvPrenom);
      return true;
    } 
    
    return false;
  }
  
  /**
   * Fonction de modification de la date de naissance d'un Sportif.
   */
  
  public Boolean modifierDateDeNaissanceSportif(int index, Date nouvddn) {
    Sportif sp = new Sportif();
    sp.setNom(listeSportifs.get(index).getNom());
    sp.setPrenom(listeSportifs.get(index).getPrenom());
    sp.setPseudo(listeSportifs.get(index).getPseudo());
    sp.setSport(listeSportifs.get(index).getSport());
    sp.setDateDeNaissance(nouvddn);
    if (verifDoublonSportif(sp) == true) {
      listeSportifs.get(index).setDateDeNaissance(nouvddn);
      return true;
    } 
    return false;
  }
  
  public Boolean modifActifSportif(int index, Boolean actif) {
    listeSportifs.get(index).setActif(actif);
    return true;
  }
  
  private Boolean verifDoublonSportif(Sportif sp) {
    for (int i = 0; i < listeSportifs.size(); i++) {
      if ((sp.getNom().equals(listeSportifs.get(i).getNom())) 
          && (sp.getPrenom().equals(listeSportifs.get(i).getPrenom())) 
          && (sp.getDateDeNaissance().toString().equals(
              listeSportifs.get(i).getDateDeNaissance().toString()))) {
        
        System.out.print("Erreur ! ");
        System.out.print("Il existe déja un sportif avec ce Nom, Prenom et date de naissance \n");
        return false;
      }
    }
    return true;
  }

  public ArrayList<Sportif> getListeSportifs() {
    return listeSportifs;
  }

  public void setListeSportifs(ArrayList<Sportif> listeSportifs) {
    this.listeSportifs = listeSportifs;
  }

}
