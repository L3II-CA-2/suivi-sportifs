/**
 * 
 */
package v1;

/**
 * @author Glen Ollivier
 *
 */
public abstract class Reponse {
	int idQuestion;
	int idQuestionnaire;
	int idSportif;
	int resultat;
	Reponse(int idQuestion, int idQuestionnaire, int idSportif, int resultat) {
		super();
		this.idQuestion = idQuestion;
		this.idQuestionnaire = idQuestionnaire;
		this.idSportif = idSportif;
		this.resultat = resultat;
	}
	Reponse() {
		super();
		this.idQuestion = 0;
		this.idQuestionnaire = 0;
		this.idSportif = 0;
		this.resultat = 0;
	}
	/*
	Reponse(Question question, int idSportif) {
		super();
		this.idQuestion = question.getId();
		this.idQuestionnaire = question.getIdQuestionnaire();
		this.idSportif = idSportif;
		this.resultat = question.getResultat();
	}*/
	/**
	 * @return the idQuestion
	 */
	public int getIdQuestion() {
		return idQuestion;
	}
	/**
	 * @param idQuestion the idQuestion to set
	 */
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	/**
	 * @return the idQuestionnaire
	 */
	public int getIdQuestionnaire() {
		return idQuestionnaire;
	}
	/**
	 * @param idQuestionnaire the idQuestionnaire to set
	 */
	public void setIdQuestionnaire(int idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}
	/**
	 * @return the idSportif
	 */
	public int getIdSportif() {
		return idSportif;
	}
	/**
	 * @param idSportif the idSportif to set
	 */
	public void setIdSportif(int idSportif) {
		this.idSportif = idSportif;
	}
	/**
	 * @return the resultat
	 */
	public int getResultat() {
		return resultat;
	}
	/**
	 * @param resultat the resultat to set
	 */
	public void setResultat(int resultat) {
		this.resultat = resultat;
	}
	
}
