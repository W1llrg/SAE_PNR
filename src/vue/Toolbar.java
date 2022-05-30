package vue;

import controler.*;
import javax.swing.*;
import java.awt.*;


public class Toolbar extends JPanel {
    
    private JButton newEntry;
    private JButton viewEntry;
    private JButton settings;
    private JButton account;

    public Toolbar() {

        this.setLayout(new GridLayout(4, 1));

    }

}
