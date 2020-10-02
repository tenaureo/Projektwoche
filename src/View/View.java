package View;

import Control.Processing;
import Datahandler.DataHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Vator AG
 * @version 1.0
 * @since 2020-September-30
 */

public class View extends Application {

    private DataHandler dataHandler = DataHandler.DATA_HANDLER;

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Energieagentur Bünzli Stromzähler");

        Parent root = FXMLLoader.load(getClass().getResource("FXML/StartUI.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        dataHandler.readFiles();
    }
}