package suivisportifs.v1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class IHMSportifs extends JFrame implements ActionListener{

  private JPanel ligne1 = new JPanel();
  private JPanel ligne2 = new JPanel();
  private JPanel ligne3 = new JPanel();
  private JPanel ligne4 = new JPanel();
  
  private JButton boutonAjouterSportif = new JButton("Ajouter Sportif");
  private JButton boutonSuprimerSportif = new JButton("Suprimer Sportif");
  private JButton boutonRetour = new JButton("Retour");
  
  
  public IHMSportifs () {
    this.setTitle("Sportifs");
    this.setSize(800, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new GridLayout(5, 1));
    
    boutonAjouterSportif.addActionListener(this);
    ligne1.add(boutonAjouterSportif);
    
    boutonSuprimerSportif.addActionListener(this);
    ligne2.add(boutonSuprimerSportif);
    
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
    
    if(e.getSource() == boutonAjouterSportif) {
      this.setVisible(false); 
      IHMAjouterSportif Sportif= new IHMAjouterSportif();
      Sportif.setVisible(true);
      }
  }

 

}
