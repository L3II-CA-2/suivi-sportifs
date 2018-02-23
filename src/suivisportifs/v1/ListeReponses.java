package suivisportifs.v1;

import java.util.ArrayList;
import java.util.Iterator;

public class ListeReponses {
  private ArrayList<ReponsesSportifQuestionnaire> reponses;
  
  ListeReponses() {
    this.reponses = new ArrayList<ReponsesSportifQuestionnaire>();
  }
  public ReponsesSportifQuestionnaire get(Sportif sportif, Questionnaire questionnaire) {
    Iterator<ReponsesSportifQuestionnaire> i = reponses.iterator();
    ReponsesSportifQuestionnaire retours;
    while (i.hasNext()) {
      retours = i.next();
      if (retours.getQuestionnaire() == questionnaire && retours.getSportif() == sportif) {
        return retours;
      }
    }
    return null;
  }
  
  public ReponsesSportifQuestionnaire add(Sportif sportif, Questionnaire questionnaire) {
    ReponsesSportifQuestionnaire retours = this.get(sportif, questionnaire);
    if (retours == null) {
      retours = new ReponsesSportifQuestionnaire(sportif, questionnaire);
    }
    return retours;
  }
  
  public boolean remove(ReponsesSportifQuestionnaire reponse) {
    return this.reponses.remove(reponse);
  }
  
  public int remove(Questionnaire questionnaire) {
    int retours = 0;
    Iterator<ReponsesSportifQuestionnaire> i = reponses.iterator();
    ReponsesSportifQuestionnaire buffer;
    while (i.hasNext()) {
      buffer = i.next();
      if (buffer.getQuestionnaire() == questionnaire) {
        this.reponses.remove(buffer);
        retours ++;
      }
    }
    return retours;
  }
  
  public int remove(Sportif sportif) {
    int retours = 0;
    Iterator<ReponsesSportifQuestionnaire> i = reponses.iterator();
    ReponsesSportifQuestionnaire buffer;
    while (i.hasNext()) {
      buffer = i.next();
      if (buffer.getSportif() == sportif) {
        this.reponses.remove(buffer);
        retours ++;
      }
    }
    return retours;
  }
}
