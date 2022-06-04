package vue;

import controler.*;
import javax.swing.*;
import java.awt.*;


public class HomePage extends JPanel {

    private JButton newEntry;
    private JButton visual;
    private JButton settings;
    private JButton createAccount;

    public HomePage(){
        initComponents();
    }

    private void initComponents(){
        Icon icon = new ImageIcon("../Icons/newEntry.PNG");

        JPanel panel = new JPanel();
        panel = (JPanel)this.getContentPane();

        panel.setBackground(Color.green);

        newEntry = new JButton(icon);
        visual = new JButton();
        settings = new JButton();
        createAccount = new JButton();

        panel.setLayout(new GridLayout(1,4));
        panel.add(newEntry);
        panel.add(visual);
        panel.add(settings);
        panel.add(createAccount);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                ViewWindowManager view = new ViewWindowManager();
                HomePage.setVisible(true);
                HomePage.pack();
            }
        });

    }
    
}