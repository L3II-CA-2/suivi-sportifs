/**
 * 
 */

package suivisportifs.v1;

/**
 * Classe qui décrit une réponse à une question provenant
 * d'un questionnaire, et appartenant à un sportif.
 * @author Glen Ollivier
 *
 */

public class Reponse {
  private int id;
  static int idMax = 0;
  private int idQuestion;
  private int idQuestionnaire;
  private String pseudoSportif;
  private int valeur;
  
  /**
   * Constructeur pour l'instanciation d'un objet Reponse à partir d'un identifiant de question,
   * de questionnaire, d'un pseudo sportif et d'une valeur de reponse.
   */
  
  Reponse(int idQuestion, int idQuestionnaire, String pseudoSportif, int valeur) {
    super();
    this.id = ++idMax;
    this.idQuestion = idQuestion;
    this.idQuestionnaire = idQuestionnaire;
    this.pseudoSportif = pseudoSportif;
    this.valeur = valeur;
  }
  
  /**
   * Constructeur pour l'instanciation d'un objet Reponse vide.
   */
  
  Reponse() {
    super();
    this.id = ++idMax;
    this.idQuestion = 0;
    this.idQuestionnaire = 0;
    this.pseudoSportif = null;
    this.valeur = 0;
  }
  
  /**
   * Constructeur pour l'instanciation d'un objet Reponse à partir
   * d'une question et d'un pseudo de sportif.
   */
  
  Reponse(Question question, String pseudoSportif) {
    super();
    this.id = ++idMax;
    this.idQuestion = question.getId();
    this.idQuestionnaire = question.getIdQuestionnaire();
    this.pseudoSportif = pseudoSportif;
    this.valeur = question.getValeur();
  }
  
  /**
   * Accesseur de l'identifiant de la question référencée par la réponse.
   * @return the idQuestion
   */
  
  public int getIdQuestion() {
    return idQuestion;
  }
  
  /**
   * Modificateur de l'identifiant de la question référencée par la réponse.
   * @param idQuestion the idQuestion to set
   */
  
  public void setIdQuestion(int idQuestion) {
    this.idQuestion = idQuestion;
  }
  /**
   * Accesseur de l'identifiant du questionnaire référencé par la réponse.
   * @return the idQuestionnaire
   */
  
  public int getIdQuestionnaire() {
    return idQuestionnaire;
  }
  
  /**
   * Modificateur de l'identifiant du questionnaire référencé par la réponse.
   * @param idQuestionnaire the idQuestionnaire to set
   */
  
  public void setIdQuestionnaire(int idQuestionnaire) {
    this.idQuestionnaire = idQuestionnaire;
  }
  
  /**
   * Accesseur du pseudo du sportif référencé par la réponse.
   * @return the pseudoSportif
   */
  
  public String getpseudoSportif() {
    return pseudoSportif;
  }
  
  /**
   * Modificateur du pseudo du sportif référencé par la réponse.
   * @param pseudoSportif the pseudoSportif to set
   */
  
  public void setpseudoSportif(String pseudoSportif) {
    this.pseudoSportif = pseudoSportif;
  }
  
  /**
   * Accesseur de la valeur de la réponse.
   * @return the valeur
   */
  
  public int getvaleur() {
    return valeur;
  }
  
  /**
   * Modificateur de la valeur de la réponse.
   * @param valeur the valeur to set
   */
  
  public void setvaleur(int valeur) {
    this.valeur = valeur;
  }
  
  /**
   * Accesseur de l'identifiant de la réponse.
   * @return l'identifiant de la reponse
   */
  
  public int getid() {
    return id;
  }
}
