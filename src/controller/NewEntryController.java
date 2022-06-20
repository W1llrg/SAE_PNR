package controller;

import java.io.IOException;
import javafx.event.ActionEvent;

public class NewEntryController extends NavigationControls {
    
    /**
     * emmene vers la page Batracien.fxml
     * @param e signal d'appui du bouton
     * @throws IOException
     */
    public void goToBatracien(ActionEvent e) throws IOException {

        switchScene(e, "../vue/Batracien.fxml");

    }

    /**
     * emmene vers la page Loutre.fxml
     * @param e signal d'appui du bouton
     * @throws IOException
     */
    public void goToLoutre(ActionEvent e) throws IOException {

        switchScene(e, "../vue/Loutre.fxml");

    }

    /**
     * emmene vers la page Hippocampe.fxml
     * @param e signal d'appui du bouton
     * @throws IOException
     */
    public void goToHippocampe(ActionEvent e) throws IOException {

        switchScene(e, "../vue/HippocampeLieu.fxml");

    }

    /**
     * emmene vers la page GCI.fxml
     * @param e signal d'appui du bouton
     * @throws IOException
     */
    public void goToGCI(ActionEvent e) throws IOException {

        switchScene(e, "../vue/GCI.fxml");

    }

    /**
     * emmene vers la page Chouette.fxml
     * @param e signal d'appui du bouton
     * @throws IOException
     */
    public void goToChouette(ActionEvent e) throws IOException {

        switchScene(e, "../vue/Chouette.fxml");

    }
}
