package vue;

import javax.swing.*;

import controler.SettingsListener;

public class Settings extends JPanel {
    
    private JLabel container;
    private JButton newSpecies;
    private JButton newCaracteristic;
    private JTextField id;
    private JTextField password;
    private JButton changePassWord;
    private JButton save;

    /** listener pour cette classe */
    private SettingsListener listener;

    public Settings(SettingsListener l) {

        // verification de la validite du listener
        if (l == null) throw new IllegalArgumentException("ERREUR FATALE: Settings: listener inconnu");
        else this.listener = l;

    }
}
