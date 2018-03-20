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
    
      int nbQuestion = 3;
      String nomFichier;
      String nomFichierprec;
    
      STGroup g = new STGroupDir("src/suivisportifs/v1/WEB/template/", '^','^');
      ST index = g.getInstanceOf("accueil");
      
      
      index.add("quest_name", "Questionnaire d'initiation");
      index.add("date_debut", "26/02/18");
      index.add("date_fin", "04/03/18");
      String result = index.render();
      System.out.println(result);
      
      File accueilHTML = new File("html/accueil.php");
      FileUtils.writeStringToFile(accueilHTML, result);
      
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
        quest.add("quest_name", "Questionnaire d'initiation");
        quest.add("question", "Vous allez bien ? ");
        quest.add("prec", nomFichierprec);
        result = quest.render();
        System.out.println(result);
        
        File questionnaire = new File("html/questionnaire"+i+".php");
        FileUtils.writeStringToFile(questionnaire, result);
      }
  }
}
