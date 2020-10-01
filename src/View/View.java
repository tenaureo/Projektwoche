package View;

import Control.Processing;
import Datahandler.DataHandler;
import Model.SDAT;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Model.ESL;

import java.awt.*;
import java.util.Map;

/**
 * @author Vator
 * @version 1.0
 * @since 2020-September-30
 */

public class View extends Application {
    private Map<String, SDAT> sdatMap;
    private Map<String, ESL> eslMap;

    private DataHandler dataHandler;
    private Processing processing;
    private CardLayout cardLayout;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Energieagentur Bünzli Stromzähler");

        Parent root = FXMLLoader.load(getClass().getResource("FXML/StartUI.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

}
