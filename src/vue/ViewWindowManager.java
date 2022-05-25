package vue;

import java.sql.Connection;
import javax.swing.*;
import java.awt.CardLayout;

public class ViewWindowManager extends JFrame {
    
    /** panel pour la fenetre */
    private JPanel panel;

    /** accesseur de la classe ConnectionPage  */
    private ConnectionPage connectionPage; 

    /** accesseur de la classe CreateAccount  */
    private CreateAccount createAccount; 

    /** accesseur de la classe HomePage  */
    private HomePage homePage;
    
    /** accesseur de la classe NewEntry  */
    private NewEntry newEntry;
    
    /** accesseur de la classe Settings  */
    private Settings settings; 

    /** accesseur de la classe Visualization  */
    private Visualization visualization; 


    public ViewWindowManager() {

        // parametres de fenetre
        setTitle("PNR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setDefaultLookAndFeelDecorated(true);

        // creation du panel
        this.panel = (JPanel)this.getContentPane();
        this.panel.setLayout(new CardLayout());

    }


    /**
     * Point d'entree du programme
     * @param args tab of String 
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                ViewWindowManager view = new ViewWindowManager();
                view.setVisible(true);
                view.pack();

            }
        });

    }
}
