package suivisportifs.v1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe qui contient tous les objets ReponseSportifQuestionnaire et qui permet de les gerer.
 * @author Glen Ollivier
 */

public class ListeReponses {
  private ArrayList<ReponsesSportifQuestionnaire> reponses;
  
  /**
   * Constructeur qui initialise un objet ListeReponse vide.
   */
  ListeReponses() {
    this.reponses = new ArrayList<ReponsesSportifQuestionnaire>();
  }
  
  /**
   * Renvoie le ReponseSportifQuestionnaire qui correspond au Sportif
   * et au Questionnaire donnés en paramètres.
   * @param sportif le Sportif correspondant
   * @param questionnaire le Questionnaire correspondant
   * @return Le ReponseSportifQuestionnaire qui correspond aux deux paramètres d'entrée.
   *         Renvoie null s'il n'existe pas.
   */
  public ReponsesSportifQuestionnaire get(Sportif sportif, Questionnaire questionnaire) {
    int i;
    ReponsesSportifQuestionnaire retours = null;
    ReponsesSportifQuestionnaire buffer;

    System.out.println(reponses.size());
    for(i = 0; i<reponses.size(); i++) {
      buffer = reponses.get(i);
      if (buffer.getQuestionnaire().equals(questionnaire) && buffer.getSportif().equals(sportif)) {
        retours = buffer;
      }
    }
    return retours;
  }

  /**
   * Ajoute un nouvel objet ReponsesSportifQuestionnaire à l'ArrayList.
   * @param sportif le Sportif à lier
   * @param questionnaire le Questionnaire à lier
   * @return Le ReponseSportifQuestionnaire qui a été créé.
   *         S'il en existe déja un correspondant, il est renvoyé et aucun objet n'est créé.
   */
  public ReponsesSportifQuestionnaire add(Sportif sportif, Questionnaire questionnaire) {
    ReponsesSportifQuestionnaire retours = this.get(sportif, questionnaire);
    if (retours == null) {
      retours = new ReponsesSportifQuestionnaire(sportif, questionnaire);
      reponses.add(retours);
    }
    return retours;
  }
  
  /**
   * Enlève l'objet ReponsesSportifQuestionnaire passé en paramètre de l'ArrayList.
   * @param reponse le ReponsesSportifQuestionnaire à enlever
   * @return renvoie true si l'objet a été trouvé et enlevé, false sinon.
   */
  public boolean remove(ReponsesSportifQuestionnaire reponse) {
    return this.reponses.remove(reponse);
  }
  
  /**
   * Enlève les objets ReponsesSportifQuestionnaire de l'ArrayList qui correspondent
   * au Questionnaire passé en paramètre.
   * @param questionnaire le Questionnaire qu'il faut enlever
   * @return renvoie le nombre d'objets enlevés.
   */
  public int remove(Questionnaire questionnaire) {
    int retours = 0;
    Iterator<ReponsesSportifQuestionnaire> i = reponses.iterator();
    ReponsesSportifQuestionnaire buffer;
    while (i.hasNext()) {
      buffer = i.next();
      if (buffer.getQuestionnaire() == questionnaire) {
        this.reponses.remove(buffer);
        retours++;
      }
    }
    return retours;
  }

  /**
   * Enlève les objets ReponsesSportifQuestionnaire de l'ArrayList qui correspondent
   * au Sportif passé en paramètre.
   * @param sportif le Sportif qu'il faut enlever
   * @return renvoie le nombre d'objets enlevés.
   */
  public int remove(Sportif sportif) {
    int retours = 0;
    Iterator<ReponsesSportifQuestionnaire> i = reponses.iterator();
    ReponsesSportifQuestionnaire buffer;
    while (i.hasNext()) {
      buffer = i.next();
      if (buffer.getSportif() == sportif) {
        this.reponses.remove(buffer);
        retours++;
      }
    }
    return retours;
  }
}
