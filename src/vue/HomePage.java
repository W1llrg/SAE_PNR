package vue;

import javax.swing.*;

public class HomePage extends JPanel {

    private JButton newEntry;
    private JButton visual;
    private JButton settings;
    private JButton createAccount;

    public HomePage(){
        initComponents();
    }

    private void initComponents(){
        Icon i = new Icon();
        
        newEntry = new JButton();
        visual = new JButton();
        settings = new JButton();
        createAccount = new JButton();
    }
    
}