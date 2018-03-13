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
      STGroup g = new STGroupDir("src/suivisportifs/v1/WEB/template", '$','$');
      ST index = g.getInstanceOf("accueil");
      
      index.add("quest_name", "Questionnaire d'initiation");
      index.add("date_debut", "26/02/18");
      index.add("date_fin", "04/03/18");
      String result = index.render();
      System.out.println(result);
      
      File newHtmlFile = new File("src/suivisportifs/v1/WEB/accueil.html");
      FileUtils.writeStringToFile(newHtmlFile, result);
  }
}
