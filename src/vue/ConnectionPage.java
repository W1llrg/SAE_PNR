package vue;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Color;

public class ConnectionPage extends JPanel {
    private JLabel connexionTitre;
    private JLabel nom;
    private JLabel mdp;

    private JTextField textFieldUser;
    private JPasswordField textFieldMdp;

    private JButton connexion;

    /**
     * methode PNRView (constructor)
     * in this methode we have all the configuration for the interface and the initialization
     */
    public ConnectionPage() {

        // JPanel panel = new JPanel();
        // panel = (JPanel)this.getContentPane();

        this.setBackground(Color.green);

        this.setLayout(new GridLayout(6,1));

        connexion = new JButton();
        connexion.setText("Connexion");

        connexionTitre = new JLabel();
        connexionTitre.setText("                 CONNEXION");
       
        nom = new JLabel();
        nom.setText("Nom d'utilisateur");

        mdp = new JLabel();
        mdp.setText("Mot de passe");

        textFieldUser = new JTextField();
        textFieldMdp = new JPasswordField(); 
    

        //put the button in a JPanel
        this.add(this.connexionTitre);
        this.add(this.nom);
        this.add(this.textFieldUser);
        this.add(this.mdp);
        this.add(this.textFieldMdp);
        this.add(this.connexion);

        //Creation of the listener
        //Listener listener = new ChronoListener(this.timer, this.time);
        
        // I add an action listener to every button 
        //start.addActionListener(listener);
    }
}
