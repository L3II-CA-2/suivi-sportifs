package suivisportifs.v1;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class Fenetre extends JFrame implements ActionListener{
  
  private JPanel pan = new JPanel();
  private JButton boutonSportifs = new JButton("Sportifs");
  private JButton boutonQuestionnaire = new JButton("Questionnaire");
  private JButton boutonSuivit = new JButton("Suivit");
  private JButton boutonCreerWeb = new JButton("Creer page web");
  private JComboBox menuDeroulentQuestionnaire = new JComboBox();
  
  public Fenetre () {
    this.setTitle("Menu");
    this.setSize(800, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    
    for(int i = 0; i<GestionSportifs.listeQuestionnaires.getListSize(); i++ ) {
      menuDeroulentQuestionnaire.addItem(GestionSportifs.getQuestionnaire(i));
    }
    
    
    
    boutonSuivit.addActionListener(this);
    pan.add(boutonSuivit);
    
    boutonSportifs.addActionListener(this);
    pan.add(boutonSportifs);
    
    pan.add(menuDeroulentQuestionnaire);
    boutonQuestionnaire.addActionListener(this);
    pan.add(boutonQuestionnaire);
    
    boutonCreerWeb.addActionListener(this);
    pan.add(boutonCreerWeb);
    
    this.setContentPane(pan);
    this.setVisible(true);
  }

 



  
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if(e.getSource() == boutonSportifs) {
    this.setVisible(false); 
    IHMSportifs Sportif= new IHMSportifs();
    Sportif.setVisible(true);
    }
    
    if(e.getSource() == boutonQuestionnaire) {
      this.setVisible(false); 
      IHMQuestionnaires Questionnaire= new IHMQuestionnaires();
      Questionnaire.setVisible(true);
      }
    
    if(e.getSource() == boutonCreerWeb) {
      Questionnaire questionnaire = (Questionnaire) menuDeroulentQuestionnaire.getSelectedItem();
      try {
        GestionSportifs.genererWeb(questionnaire);
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      
      }
    
  }


    
  
  
  
  
  
}
