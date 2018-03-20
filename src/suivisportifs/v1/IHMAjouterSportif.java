package suivisportifs.v1;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import java.awt.GridLayout;
public class IHMAjouterSportif extends JFrame implements ActionListener {

  private JPanel ligne1 = new JPanel();
  private JPanel ligne2 = new JPanel();
  private JPanel ligne3 = new JPanel();
  private JPanel ligne4 = new JPanel();
  private JPanel ligne5 = new JPanel();
  private JPanel ligne6 = new JPanel();
  
  private JButton boutonRetour = new JButton("Retour");
  private JButton boutonValider = new JButton("Valider");
  
  private JLabel labelPseudo = new JLabel("Pseudo");
  private JLabel labelNom = new JLabel("NOM");
  private JLabel labelPrenom = new JLabel("Prenom");
  private JLabel labelDate = new JLabel("Date de naissance");
  private JLabel labelDateJ = new JLabel("jour JJ :");
  private JLabel labelDateM = new JLabel("mois MM :");
  private JLabel labelDateA = new JLabel("année AA : ");
  private JLabel labelSport = new JLabel("Sport");

  private JTextField champPseudo = new JTextField("Indiquer Votre Pseudo");
  private JTextField champNom = new JTextField("Indiquer Votre nom");
  private JTextField champPrenom = new JTextField("Indiquer Votre Prenom");
  private JComboBox menuDeroulentDJ = new JComboBox(); 
  private JComboBox menuDeroulentDM = new JComboBox(); 
  private JComboBox menuDeroulentDA = new JComboBox(); 
  private JComboBox menuDeroulent = new JComboBox(); 
  
  
  public IHMAjouterSportif () {
    this.setTitle("Sportifs");
    this.setSize(800, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new GridLayout(6, 1));
    
    ligne1.add(labelNom);
    ligne1.add(champNom);
    
    ligne2.add(labelPrenom);
    ligne2.add(champPrenom);
    
    ligne3.add(labelDate);
    
    for(int i = 1; i<=31; i++ ) {
      menuDeroulentDJ.addItem(i);
    }
    
    for(int i = 1; i<=12; i++) {
      menuDeroulentDM.addItem(i);
    }
    
    for(int i = 1930; i<2010; i++) {
      menuDeroulentDA.addItem(i);
    }
    ligne3.add(labelDateJ);
    ligne3.add(menuDeroulentDJ);
    ligne3.add(labelDateM);
    ligne3.add(menuDeroulentDM);
    ligne3.add(labelDateA);
    ligne3.add(menuDeroulentDA);
    
    ligne4.add(labelSport);
    for(Sport spt : Sport.values()) {
      menuDeroulent.addItem(spt.toString());
    }
    
    ligne4.add(menuDeroulent);
    
    ligne5.add(labelPseudo);
    ligne5.add(champPseudo);
    
    boutonRetour.addActionListener(this);
    boutonValider.addActionListener(this);
    ligne6.add(boutonRetour);
    ligne6.add(boutonValider);
    
    
    this.getContentPane().add(ligne1);
    this.getContentPane().add(ligne2);
    this.getContentPane().add(ligne3);
    this.getContentPane().add(ligne4);
    this.getContentPane().add(ligne5);
    this.getContentPane().add(ligne6);
    this.setVisible(true);
  }


 
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if(e.getSource() == boutonValider) {
      
      String Pseudo = champPseudo.getText();
      String nom = champNom.getText();
      String Prenom = champNom.getText();
      Sport sport = Sport.valueOf(menuDeroulent.getSelectedItem().toString());
      int dateJ =   (Integer) menuDeroulentDJ.getSelectedItem();
      int dateM =  (Integer) menuDeroulentDM.getSelectedItem();
      int dateA =  (Integer) menuDeroulentDA.getSelectedItem();
      System.out.println(sport.toString());
      @SuppressWarnings("deprecation")
      Date date = new Date((dateA-1900),(dateM-1),dateJ);
      System.out.println(date.toString());
      this.setVisible(false); 
      Fenetre Sportif= new Fenetre();
      Sportif.setVisible(true);
      }
    if(e.getSource() == boutonRetour) {
      this.setVisible(false); 
      Fenetre Sportif= new Fenetre();
      Sportif.setVisible(true);
      }
    
    
  }
}
