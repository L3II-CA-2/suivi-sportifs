/**
 * 
 */

package suivisportifs.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


/**
 * Classe gérant la création et l'édition des questionnaires.
 * @author Valentin Pearce
 * 
 */
public class Questionnaire {
  private int id;
  private static int idMaximum = 0;
  private String intitule;
  private Date debut;
  private Date fin;
  private ArrayList<Question> questions;
  
  private Questionnaire(int id, String intitule, Date debut, Date fin) {
    this.id = id;
    this.intitule = intitule;
    this.debut = debut;
    this.fin = fin;
  }
  
  /**
   * Accesseur de l'identifiant du questionnaire.
   * @return l'identifiant du questionnaire
   */
  int getId() {
    return id;
  }

  /**
   * Modificateur de l'identifiant du questionnaire.
   * @param id the id to set
   */
  private void setId(int id) {
    this.id = id;
  }

  /**
   * Accesseur du plus grand identifiant de questionnaire.
   * Permet une incrémentation automatique des identifiants de questionnaires.
   * @return Le plus grand identifiant de questionnaire
   */
  private static int getIdMaximum() {
    return idMaximum;
  }

  
  /**
   * Modificateur du plus grand identifiant de questionnaire.
   * Incrémente de 1 la valeur.
   */
  private static void incrementerIdMaximum() {
    Questionnaire.idMaximum += 1;
  }

  /**
   * @return the intitule
   */
  String getIntitule() {
    return intitule;
  }

  /**
   * @param intitule the intitule to set
   */
  private void setIntitule(String intitule) {
    this.intitule = intitule;
  }

  /**
   * @return the debut
   */
  Date getDebut() {
    return debut;
  }

  /**
   * @param debut the debut to set
   */
  private void setDebut(Date debut) {
    this.debut = debut;
  }

  /**
   * @return the fin
   */
  Date getFin() {
    return fin;
  }

  /**
   * @param fin the fin to set
   */
  private void setFin(Date fin) {
    this.fin = fin;
  }

  public void ajouterQuestion(Question question){
    this.questions.add(question);
  }
  
  public static Questionnaire creer() {
    incrementerIdMaximum();
    
    
    boolean dateCorrecte = false;
    SimpleDateFormat dateIso = new SimpleDateFormat("YYYY-MM-DD");
    String dateEntree;
    Date debut = new Date();
    Date fin = new Date();
    Date today = new Date();
    GregorianCalendar verificationDate = new GregorianCalendar();
    
    System.out.println("Veuillez entrer l'intitulé du questionnaire :");
    Scanner entreeClavier = new Scanner(System.in);
    final String intitule = entreeClavier.nextLine();
    while (!dateCorrecte) {
      System.out.println("Veuillez entrer la date de début du questionnaire.");
      System.out.println("Elle doit être au format AAAA-MM-JJ :");
      dateEntree = entreeClavier.nextLine();
      try {
        debut = dateIso.parse(dateEntree);
        verificationDate.setTime(debut);
        if (verificationDate.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.MONDAY) {
          if (debut.after(today)) {
            dateCorrecte = true;
          } else {
            System.out.println("La date de début doit être après la date du jour.");
          }
        } else {
          System.out.println("La date de début doit être un Lundi.");
        }
      } catch (ParseException e) {
        System.out.println("Le format de la date doit respecter le format demandé.");
      }
    }
    dateCorrecte = false;
    while (!dateCorrecte) {
      System.out.println("Veuillez entrer la date de fin du questionnaire au format AAAA-MM-JJ :");
      dateEntree = entreeClavier.nextLine();
      try {
        fin = dateIso.parse(dateEntree);
        verificationDate.setTime(fin);
        if (verificationDate.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY) {
          if (fin.after(today)) {
            if (fin.after(debut)) {
              dateCorrecte = true;
            } else {
              System.out.println("La date de fin doit être après la date de début.");
            }
          } else {
            System.out.println("La date de fin doit être après la date du jour.");
          }
        } else {
          System.out.println("La date de fin doit être un Dimanche.");
        }
      } catch (ParseException e) {
        System.out.println("Le format de la date doit respecter le format demandé.");
      }
    }
    entreeClavier.close();
    int id = getIdMaximum();
    return new Questionnaire(id, intitule, debut, fin);
  }
}
