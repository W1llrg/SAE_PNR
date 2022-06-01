package vue;

import controler.*;
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

    /** listener de cette classe */
    private ConnectionPageListener listener;

    /**
     * methode PNRView (constructor)
     * in this methode we have all the configuration for the interface and the initialization
     * @param l le listener pour cette classe
     */
    public ConnectionPage(ConnectionPageListener l) {

        this.listener = l;
        this.setBackground(Color.green);

        this.setLayout(new GridLayout(6,1));

        connexion = new JButton();
        connexion.setText("Connexion");
        connexion.addActionListener(l);

        connexionTitre = new JLabel();
        connexionTitre.setText("CONNEXION");
       
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


    public void setText(String text) {
        this.connexion.setText(text);
    }

    public void connectUser(){
        String user = this.textFieldUser.getText();
        char[] tabPassword = this.textFieldMdp.getPassword();
        String password = String.valueOf(tabPassword);

        ConnectionDatabase c = new ConnectionDatabase(user, password);
    }
}
