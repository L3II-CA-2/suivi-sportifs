package suivisportifs.v1;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupDir;

public class generationWeb {
  @SuppressWarnings("deprecation")
  public static void main(String[] args) throws IOException {
    
      Questionnaire quests = GestionSportifs.getQuestionnaire(0);
    
      int nbQuestion = quests.getTailleQuestionnaire();
      String nomFichier;
      String nomFichierprec;
    
      STGroup g = new STGroupDir("src/suivisportifs/v1/WEB/template/", '^','^');
      ST index = g.getInstanceOf("accueil");
      
      
      String dateDebut = quests.getDebut().getDay()+"/"+quests.getDebut().getMonth()+"/"+quests.getDebut().getYear();
      String dateFin = quests.getFin().getDay()+"/"+quests.getFin().getMonth()+"/"+quests.getFin().getYear();
      
      index.add("quest_name", quests.getIntitule());
      index.add("date_debut", dateDebut);
      index.add("date_fin", dateFin);
      
      String result = index.render();
      System.out.println(result);
      
      File accueilHTML = new File("html/accueil.php");
      FileUtils.writeStringToFile(accueilHTML, result, "UTF-8");
      
      for(int i = 1; i < nbQuestion; i++) {
        ST quest = g.getInstanceOf("questionnaire");
        
        if(i==nbQuestion-1) {
          nomFichier = "fin";
        }
        else {
          nomFichier = "questionnaire"+(i+1);  
        }
        
        if(i==1) {
          nomFichierprec = "accueil";
        }
        else {
          nomFichierprec = "questionnaire"+(i-1);
        }
        
        quest.add("nomFichier", nomFichier);
        quest.add("num", i);
        quest.add("quest_name", quests.getIntitule());
        quest.add("question", quests.getQuestion(i));
        quest.add("prec", nomFichierprec);
        result = quest.render();
        System.out.println(result);
        
        File questionnaire = new File("html/questionnaire"+i+".php");
        FileUtils.writeStringToFile(questionnaire, result, "UTF-8");
      }
  }
}
