package controller;

import java.io.IOException;
import javafx.event.ActionEvent;

/**
 * controller de la page Visualize.fxml
 */
public class VisualizeController extends NavigationControls {
    
    /**
     * emmene vers la page Batracien.fxml
     * @param e signal d'appui du bouton
     * @throws IOException
     */
    public void goToBatracien(ActionEvent e) throws IOException {

        switchScene(e, "../vue/VisualizeBatracien.fxml");

    }

    /**
     * emmene vers la page Loutre.fxml
     * @param e signal d'appui du bouton
     * @throws IOException
     */
    public void goToLoutre(ActionEvent e) throws IOException {

        switchScene(e, "../vue/VisualizeLoutre.fxml");

    }

    /**
     * emmene vers la page Hippocampe.fxml
     * @param e signal d'appui du bouton
     * @throws IOException
     */
    public void goToHippocampe(ActionEvent e) throws IOException {

        switchScene(e, "../vue/VisualizeHippocampe.fxml");

    }

    /**
     * emmene vers la page GCI.fxml
     * @param e signal d'appui du bouton
     * @throws IOException
     */
    public void goToGCI(ActionEvent e) throws IOException {

        switchScene(e, "../vue/VisualizeGCI.fxml");

    }

    /**
     * emmene vers la page Chouette.fxml
     * @param e signal d'appui du bouton
     * @throws IOException
     */
    public void goToChouette(ActionEvent e) throws IOException {

        switchScene(e, "../vue/VisualizeChouette.fxml");

    }
}
