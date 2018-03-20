package suivisportifs.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Iterator;

/**
 * Classe qui regroupe toutes les objets du modèle de données.
 * @author Glen Ollivier
 *
 */

    
public class GestionSportifs {  
  public static ListeQuestionnaires listeQuestionnaires = new ListeQuestionnaires();
  public static ListeSportifs listeSportifs = new ListeSportifs();
  public static ListeReponses listeReponses = new ListeReponses();
  
  public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {/*
    addSportif("boblegob", "bob", "legob", Sport.Tennis, new Date());
    addSportif("arnold", "jean", "Madec", Sport.Football, new Date());
    addSportif("Kemar", "Marc", "Lagadec", Sport.Football, new Date());
    System.out.println(getSportif(1).getPrenom());
    setPrenomSportif(1, "Alfred");
    System.out.println(getSportif(1).getPrenom());
    int index = addQuestionnaire("test", new Date(), new Date());
    addQuestion(index, "ça va ?", true);
    addQuestion(index, "sur ?", true);
    System.out.println(addReponses(getSportif("Kemar"), getQuestionnaire(index)));

    System.out.println(listeQuestionnaires.getListSize());
    System.out.println(listeSportifs.getListeSportifs().size());
    System.out.println(getReponses(getSportif("Kemar"), getQuestionnaire(index)));
    */
    
    Fenetre Sportif= new Fenetre();
    Sportif.setVisible(true);
    
    
    
    String url = "jdbc:mariadb://obiwan2.univ-brest.fr/zfl3-zpearceva";
    Class.forName ("com.mysql.jdbc.Driver").newInstance ();
    Connection conn = DriverManager.getConnection (url, "zpearceva ", "ffa9kyky");
    Statement stm = conn.createStatement();
    String tousQuestionnaires= new String("SELECT qtr_id, qtr_intitue, qtr_date_debut qtr_date_fin FROM t_questionnaire_qtr;");
    ResultSet result = null;
    // boolean returningRows = stm.execute(fullCommand); // renvoie un booleen qui dit si ça a renvoyé qqchose
    result = stm.executeQuery(tousQuestionnaires);
    while(result.next()) {
      listeQuestionnaires.ajouter(new Questionnaire(result.getInt(0), result.getString(1), result.getDate(2), result.getDate(3)));
    }
    String toutesQuestions = new String("SELECT qst_id, qst_intitule, qst_reponse_defaut, qtr_id from t_question_qst ORDER BY qst_id;");
    result = stm.executeQuery(toutesQuestions);
    while(result.next()) {
      listeQuestionnaires.getQuestionnaire(result.getInt(3)).ajouterQuestion(new Question(result.getString(1), result.getBoolean(2)));
    }
    String tousSportifs = new String("SELECT spf_pseudo, spf_nom, spf_prenom, Date_naissance, spf_actif, spr_id from t_sportifs_spf ORDER BY qst_id;");
    result = stm.executeQuery(tousSportifs);
    while(result.next()) {
      listeSportifs.ajoutDansLaListe(result.getString(0), result.getString(1), result.getString(2), Sport.Null, result.getDate(3));
    }
  }
  /**
   * 
   * @param pseudo
   * @param nom
   * @param prenom
   * @param sport
   * @param ddn
   * @return
   */
  public static Boolean addSportif(String pseudo, String nom, String prenom, Sport sport, Date ddn) {
    return listeSportifs.ajoutDansLaListe(pseudo, nom, prenom, sport, ddn);
  }
  
  public static Sportif getSportif(String pseudo) {
    Iterator<Sportif> i = listeSportifs.getListeSportifs().iterator();
    Sportif retours;
    while (i.hasNext()) {
      retours = i.next();
      if (retours.getPseudo() == pseudo) {
        return retours;
      }
    }
    return null;
  }
  
  public static int getIndexSportif(String pseudo) {
    int i = 0;
    Sportif sportif = listeSportifs.getListeSportifs().get(i);
    while (sportif != null) {
      if (sportif.getPseudo() == pseudo) {
        return i;
      }
      i++;
      sportif = listeSportifs.getListeSportifs().get(i);
    }
    return -1;
  }
  
  public static Sportif getSportif(int index) {
    return listeSportifs.getListeSportifs().get(index);
  }
  
  public static Boolean setNomSportif(int index, String nom) {
    return listeSportifs.modifierNomSportif(index, nom);
  }
  
  public static Boolean setNomSportif(String pseudo, String nom) {
    int index = getIndexSportif(pseudo);
    if(index == -1) { return false; }
    return listeSportifs.modifierNomSportif(index, nom);
  }
  
  public static Boolean setPrenomSportif(int index, String prenom) {
    return listeSportifs.modifierPrenomSportif(index, prenom);
  }
  
  public static Boolean setPrenomSportif(String pseudo, String prenom) {
    int index = getIndexSportif(pseudo);
    if(index == -1) { return false; }
    return listeSportifs.modifierPrenomSportif(index, prenom);
  }
  
  public static Boolean setDateNaissanceSportif(int index, Date nouvddn) {
    return listeSportifs.modifierDateDeNaissanceSportif(index, nouvddn);
  }
  
  public static Boolean setDateNaissanceSportif(String pseudo, Date nouvddn) {
    int index = getIndexSportif(pseudo);
    if(index == -1) { return false; }
    return listeSportifs.modifierDateDeNaissanceSportif(index, nouvddn);
  }
  
  public static Boolean setActifSportif(int index, Boolean actif) {
    return listeSportifs.modifActifSportif(index, actif);
  }
  
  public static Boolean setActifSportif(String pseudo, Boolean actif) {
    int index = getIndexSportif(pseudo);
    if(index == -1) { return false; }
    return listeSportifs.modifActifSportif(index, actif);
  }
  
  public static int addQuestionnaire(String intitule, Date debut, Date fin) {
    listeQuestionnaires.ajouter(new Questionnaire(listeQuestionnaires.getListSize(), intitule, debut, fin));
    return listeQuestionnaires.getListSize() - 1;
  }
  
  public static Questionnaire getQuestionnaire(int index) {
    return listeQuestionnaires.getQuestionnaire(index);
  }
  
  public static int addQuestion(int index, String intitule, boolean reponseDefaut) {
    return getQuestionnaire(index).ajouterQuestion(new Question(intitule, reponseDefaut));
  }
  
  public static int removeQuestion(int indexQuestionnaire, int indexQuestion) {
    return getQuestionnaire(indexQuestionnaire).retirerQuestion(indexQuestion);
  }
  
  public static int setIntituleQuestionnaire(int index, String intitule) {
    return listeQuestionnaires.modifierIntituleQuestionnaire(index, intitule);
  }
  
  public static int setDebutQuestionnaire(int index, Date debut) {
    return listeQuestionnaires.modifierDebutQuestionnaire(index, debut);
  }
  
  public static int setFinQuestionnaire(int index, Date fin) {
    return listeQuestionnaires.modifierFinQuestionnaire(index, fin);
  }
  
  public static ReponsesSportifQuestionnaire addReponses(Sportif sportif, Questionnaire questionnaire) {
    return listeReponses.add(sportif, questionnaire);
  }
  
  public static ReponsesSportifQuestionnaire getReponses(Sportif sportif, Questionnaire questionnaire) {
    return listeReponses.get(sportif, questionnaire);
  }
  
  public static Boolean removeReponses(ReponsesSportifQuestionnaire reponse) {
    return listeReponses.remove(reponse);
  }
  
  public static Boolean removeSportif(int index) {
    Boolean retours = false;
    Sportif sportif = listeSportifs.getListeSportifs().get(index);
    if(sportif != null) {
      listeReponses.remove(sportif);
      listeSportifs.getListeSportifs().remove(index);
      retours = true;
    }
    return retours;
  }
  
  public static Boolean removeSportif(String pseudo) {
    Boolean retours = false;
    int index = getIndexSportif(pseudo);
    if(index != -1) { 
      retours = removeSportif(index);
    }
    return retours;
  }
  
  public static int removeQuestionnaire(int index) {
    Questionnaire questionnaire = listeQuestionnaires.getQuestionnaire(index);
    listeReponses.remove(questionnaire);
    return listeQuestionnaires.retirer(index);
  }
}
