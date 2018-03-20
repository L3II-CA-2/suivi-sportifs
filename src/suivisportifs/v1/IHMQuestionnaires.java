package suivisportifs.v1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IHMQuestionnaires extends JFrame implements ActionListener{
  private JPanel ligne1 = new JPanel();
  private JPanel ligne2 = new JPanel();
  private JPanel ligne3 = new JPanel();
  private JPanel ligne4 = new JPanel();
  
  private JButton boutonAjouterQuestionnaire = new JButton("Ajouter Questionnaire");
  private JButton boutonSuprimerQuestionnaire = new JButton("Suprimer Questionnaire");
  private JButton boutonRetour = new JButton("Retour");
  
  public IHMQuestionnaires() {
    this.setTitle("Questionnaire");
    this.setSize(800, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new GridLayout(5, 1));
    
    boutonAjouterQuestionnaire.addActionListener(this);
    ligne1.add(boutonAjouterQuestionnaire);
    
    boutonSuprimerQuestionnaire.addActionListener(this);
    ligne2.add(boutonSuprimerQuestionnaire);
    
    boutonRetour.addActionListener(this);
    ligne3.add(boutonRetour);
    
  
   
    
    
    this.getContentPane().add(ligne1);
    this.getContentPane().add(ligne2);
    this.getContentPane().add(ligne3);


    this.setVisible(true);
  }
  


  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if(e.getSource() == boutonRetour) {
      this.setVisible(false); 
      Fenetre Sportif= new Fenetre();
      Sportif.setVisible(true);
      }
    if(e.getSource() == boutonAjouterQuestionnaire) {
      this.setVisible(false); 
      IHMAjouterQuestionnaire questionnaire= new IHMAjouterQuestionnaire();
      questionnaire.setVisible(true);
      }
  }
}