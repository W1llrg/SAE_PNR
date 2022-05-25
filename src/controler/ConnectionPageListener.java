package controler;

import vue.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Programme pour avoir les actions de l'interface de la page de connection
 * @author Poulain Theo B1
 */
public class ConnectionPageListener implements ActionListener{

    // private JTextField textFieldUser;
    // private JPasswordField textFieldMdp;
    // private JButton connexion;

    private ViewWindowManager view;

    /**
     * methode constructeur pour ConnectionPageListener
     * @param textFieldUser Champ de texte pour le nom de l'utilisateur 
     * @param textFieldMdp Champ de texte pour le mot de passe
     * @param connexion bouton de connexion final 
     */
    public ConnectionPageListener(ViewWindowManager view) {
        // this.textFieldUser = textFieldUser;
        // this.textFieldMdp = textFieldMdp;
        // this.connexion = connexion;

        this.view = view;
    }


    /**
     * Methode pour avoir une action sur le bouton et agir en consequence 
     * @param paramActionEvent une ActionEvent qui va etre cliquer sur un bouton de l'interface
     */
    public void actionPerformed(ActionEvent paramActionEvent) {
                
        Object o = paramActionEvent.getSource();
        System.out.println("oui");
        if(o instanceof JButton){
            JButton button = (JButton) paramActionEvent.getSource();
            view.getConnectionPage().setText("test");
        }

    }
    
}
