package vue;

import controler.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Color;
import java.sql.*;

public class CreateAccount extends JPanel {    
    private JLabel nouveauCompteTitre;

    private JButton user;
    private JButton admin;
    private JButton create;

    private JTextField id;
    private JTextField password;
    private JTextField mail;

    public CreateAccount(){

        this.setBackground(Color.green);

        this.setLayout(new GridLayout(4,2));

        this.nouveauCompteTitre = new JLabel();
        this.nouveauCompteTitre.setText("Nouveau compte");

        this.user = new JButton();
        this.user.setText("Utilisateur");
        this.admin = new JButton();
        this.admin.setText("Administrateur");
        this.create = new JButton();
        this.create.setText("Cree");

        this.id = new JTextField();
        this.id.setText("Identifiant");
        this.password = new JPasswordField(); 
        this.password.setText("Mot de passe");
        this.mail = new JTextField(); 
        this.mail.setText("E-Mail");

        this.add(this.nouveauCompteTitre);
        this.add(new JLabel());
        this.add(this.id);
        this.add(this.password);
        this.add(this.mail);
        this.add(new JLabel());
        this.add(this.create);
        this.add(new JLabel());
    }

    public void changement() {

        this.setLayout(new GridLayout(3,1));

        this.user.setVisible(false);
        this.id.setVisible(false);
        this.password.setVisible(false);
        this.mail.setVisible(false);

        this.admin.setVisible(true);
        this.create.setVisible(true);

        this.add(this.nouveauCompteTitre);
        this.add(this.user);
        this.add(this.admin);

    }

    public void creationCompte(){
        try{
            String user = "CREATE USER '" + this.id.getText() + "'@'localhost' IDENTIFIED BY '" + this.password.getText() + "';";
            Statement stAddUser = getConnection().createStatement();
            ResultSet rsAddUser = stAddUser.executeQuery(user);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}   
