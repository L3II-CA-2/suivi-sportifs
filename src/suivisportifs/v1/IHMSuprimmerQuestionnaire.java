package suivisportifs.v1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IHMSuprimmerQuestionnaire extends JFrame implements ActionListener  {
  private JPanel ligne1 = new JPanel();
  private JPanel ligne2 = new JPanel();

  private JButton boutonRetour = new JButton("Retour");
  private JButton boutonValider = new JButton("Valider");
  private JComboBox menuDeroulentQuestionnaire = new JComboBox();
  
  public IHMSuprimmerQuestionnaire() {
    this.setTitle("Supresion d'un questionnaire");
    this.setSize(800, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new GridLayout(5, 1));
    
    for(int i = 0; i<GestionSportifs.listeQuestionnaires.getListSize(); i++ ) {
      menuDeroulentQuestionnaire.addItem(GestionSportifs.getQuestionnaire(i));
    }
    
    ligne1.add(menuDeroulentQuestionnaire);
    
    boutonRetour.addActionListener(this);
    boutonValider.addActionListener(this);
    ligne2.add(boutonRetour);
    ligne2.add(boutonValider);
    
    
    this.getContentPane().add(ligne1);
    this.getContentPane().add(ligne2);
  }
  
  
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if(e.getSource() == boutonRetour) {
      this.setVisible(false); 
      Fenetre Sportif= new Fenetre();
      Sportif.setVisible(true);
      }
    
    if(e.getSource() == boutonValider) {
      Questionnaire questionnaire = (Questionnaire) menuDeroulentQuestionnaire.getSelectedItem();
      for(int i = 0; i<GestionSportifs.listeQuestionnaires.getListSize(); i++) {
        if(questionnaire == GestionSportifs.listeQuestionnaires.getQuestionnaire(i)) {
          GestionSportifs.removeQuestionnaire(i);
          
          Statement stm = null;
          try {
            stm = GestionSportifs.conn.createStatement();
          } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }        
           String tousQuestionnaires= new String("DELETE FROM t_questionnaire_qtr WHERE qtr_id="+(GestionSportifs.getQuestionnaire(i).getId()-1)+ ";");
           ResultSet result = null;
           // boolean returningRows = stm.execute(fullCommand); // renvoie un booleen qui dit si ça a renvoyé qqchose
           try {
            result = stm.executeQuery(tousQuestionnaires);
          } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
          
          break;
        }
      }
      Fenetre Sportif= new Fenetre();
      Sportif.setVisible(true);
      
    }
  }

}
