package suivisportifs.v1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IHMAjouterQuestionnaire extends JFrame implements ActionListener {
  
  private ArrayList<Question> questions = new ArrayList();
  private int nbQuestion = 0;
  
  private JPanel ligne1 = new JPanel();
  private JPanel ligne2 = new JPanel();
  private JPanel ligne3 = new JPanel();
  private JPanel ligne4 = new JPanel();
  private JPanel ligne5 = new JPanel();
  
  
  private JButton boutonRetour = new JButton("Retour");
  private JButton boutonValider = new JButton("Valider");
  
  private JLabel labelnbQuestion = new JLabel("0");
  private JLabel labelIntitule = new JLabel("Intituler");
  private JLabel labelDateDebutJ = new JLabel("date de debut Jour JJ");
  private JLabel labelDateDebutM = new JLabel("date de debut Mois MM");
  private JLabel labelDateDebutA = new JLabel("date de debut Année AA");
  private JLabel labelDateFinJ = new JLabel("date de fin Jour JJ");
  private JLabel labelDateFinM = new JLabel("date de fin Mois MM");
  private JLabel labelDateFinA = new JLabel("date de fin Année AA");
  private JLabel labelQuestion = new JLabel("intituler question");
  private JLabel labelReponseParDefault = new JLabel("Réponse par default");
  
  private JTextField champIntitule = new JTextField("Indiquer l'intitule");
  private JTextField champQuestion = new JTextField("Indiquer la question");
  private JCheckBox checkReponse = new JCheckBox("reponse : check = oui");
  private JButton Question = new JButton("Ajouter la question");
  private JComboBox menuDeroulentDJ = new JComboBox(); 
  private JComboBox menuDeroulentDM = new JComboBox(); 
  private JComboBox menuDeroulentDA = new JComboBox();
  
  private JComboBox menuDeroulentFinJ = new JComboBox(); 
  private JComboBox menuDeroulentFinM = new JComboBox(); 
  private JComboBox menuDeroulentFinA = new JComboBox();
  
  
  public IHMAjouterQuestionnaire() {
    
    this.setTitle("Ajout d'un questionnaire");
    this.setSize(800, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new GridLayout(5, 1));
    
    ligne1.add(labelIntitule);
    ligne1.add(champIntitule);
    
   
    
    
    for(int i = 1; i<=31; i++ ) {
      menuDeroulentDJ.addItem(i);
      menuDeroulentFinJ.addItem(i);
    }
    
    for(int i = 1; i<=12; i++) {
      menuDeroulentDM.addItem(i);
      menuDeroulentFinM.addItem(i);
    }
    
    for(int i = 2017; i<2020; i++) {
      menuDeroulentDA.addItem(i);
      menuDeroulentFinA.addItem(i);
    }
    
    
    
    
    
    ligne2.add(labelDateFinJ);
    ligne2.add(menuDeroulentFinJ);
    ligne2.add(labelDateFinM);
    ligne2.add(menuDeroulentFinM);
    ligne2.add(labelDateFinA);
    ligne2.add(menuDeroulentFinA);
    
    ligne3.add(labelDateDebutJ);
    ligne3.add(menuDeroulentDJ);
    ligne3.add(labelDateDebutM);
    ligne3.add(menuDeroulentDM);
    ligne3.add(labelDateDebutA);
    ligne3.add(menuDeroulentDA);
    
    
    
    ligne4.add(labelQuestion);
    ligne4.add(champQuestion);
    ligne4.add(labelReponseParDefault);
    ligne4.add(checkReponse);
    ligne4.add(Question);
    ligne4.add(labelnbQuestion);
    
    
    
    boutonRetour.addActionListener(this);
    boutonValider.addActionListener(this);
    Question.addActionListener(this);
    ligne5.add(boutonRetour);
    ligne5.add(boutonValider);
    
    
    this.getContentPane().add(ligne1);
    this.getContentPane().add(ligne2);
    this.getContentPane().add(ligne3);
    this.getContentPane().add(ligne4);
    this.getContentPane().add(ligne5);

    this.setVisible(true);
    
  }
  
  
 
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
 if(e.getSource() == Question) {
   this.nbQuestion ++;
   String intituleQuestion = champQuestion.getText();
   boolean rep = checkReponse.isSelected();
   Question question = new Question(intituleQuestion, rep);
   questions.add(question);
      labelnbQuestion.setText(""+nbQuestion);
      
      System.out.println(questions.toString());
      }
 
 
 if(e.getSource() == boutonValider) {
   String intitule = champIntitule.getText();
   int dateDJ =   (Integer) menuDeroulentDJ.getSelectedItem();
   int dateDM =  (Integer) menuDeroulentDM.getSelectedItem();
   int dateDA =  (Integer) menuDeroulentDA.getSelectedItem();
   @SuppressWarnings("deprecation")
   Date dateD = new Date((dateDA-1900),(dateDM-1),dateDJ);
   int dateFJ =   (Integer) menuDeroulentFinJ.getSelectedItem();
   int dateFM =  (Integer) menuDeroulentFinM.getSelectedItem();
   int dateFA =  (Integer) menuDeroulentFinA.getSelectedItem();
   @SuppressWarnings("deprecation")
   Date dateF = new Date((dateFA-1900),(dateFM-1),dateFJ);
   
   /*Questionnaire questionnaire = new Questionnaire(nbQuestion, intitule, null, null);
   questionnaire.setFin(dateF);
   questionnaire.setDebut(dateD);
   for (int i = 0 ; i< questions.size() ; i++) {
     //System.out.println(questions.get(i));
     questionnaire.ajouterQuestion(questions.get(i));
   }*/
   //System.out.println(questionnaire.toString());
   
 }
 
 if(e.getSource() == boutonRetour) {
   this.setVisible(false); 
   Fenetre Sportif= new Fenetre();
   Sportif.setVisible(true);
   }
  } 
}
