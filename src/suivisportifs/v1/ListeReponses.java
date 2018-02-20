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
  public void add(Sportif sportif, Questionnaire questionnaire) {
    
  }
}
