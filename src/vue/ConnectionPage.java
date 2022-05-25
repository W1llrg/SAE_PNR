package vue;

import javax.swing.*;

public class ConnectionPage extends JPanel {
    private JLabel connexionTitre;
    private JLabel nom;
    private JLabel mdp;

    private JTextField textFieldUser;
    private JTextField textFieldMdp;

    private JButton connexion;

    /**
     * methode PNRView (constructor)
     * in this methode we have all the configuration for the interface and the initialization
     */
    public ConnectionPage() {

        JPanel panel = new JPanel();
        panel = (JPanel)this.getContentPane();

        panel.setBackground(Color.green);

        panel.setLayout(new GridLayout(6,1));

        connexion = new JButton();
        connexion.setText("Connexion");

        connexionTitre = new JLabel();
        connexionTitre.setText("                 CONNEXION");
       
        nom = new JLabel();
        nom.setText("Nom d'utilisateur");

        mdp = new JLabel();
        mdp.setText("Mot de passe");

        textFieldUser = new JTextField();
        textFieldMdp = new JTextField(); 
    

        //put the button in a JPanel
        panel.add(this.connexionTitre);
        panel.add(this.nom);
        panel.add(this.textFieldUser);
        panel.add(this.mdp);
        panel.add(this.textFieldMdp);
        panel.add(this.connexion);

        //Creation of the listener
        //Listener listener = new ChronoListener(this.timer, this.time);
        
        // I add an action listener to every button 
        //start.addActionListener(listener);
    }
}
