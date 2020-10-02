package View;

import Control.Processing;
import Model.ESL;
import Model.ExportCSV;
import Model.SDAT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author Vator AG
 * @version 1.0
 * @since 2020-September-30
 */

public class ExportController implements Initializable {

    private Map<String, ESL> eslMap;
    private Map<String, SDAT> sdatMap;

    @FXML private ImageView logo;

    @FXML
    private void onBackPressed(ActionEvent event) throws IOException {

        Parent saveUIParent = FXMLLoader.load(getClass().getResource("FXML/MeterReadingUI.fxml"));
        Scene saveUIscene = new Scene(saveUIParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(saveUIscene);
        window.show();

    }
    @FXML
    private void onbutton(ActionEvent event) throws IOException {

        Parent saveUIParent = FXMLLoader.load(getClass().getResource("FXML/EndUI.fxml"));
        Scene saveUIscene = new Scene(saveUIParent);

        Stage endwindow = new Stage();

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        DirectoryChooser directoryChooser = new DirectoryChooser();

        File selectDirectory = directoryChooser.showDialog(window);

        if (selectDirectory != null) {

            ExportCSV exportCSV = new ExportCSV(eslMap, sdatMap);
            exportCSV.writeCSV(selectDirectory);

            endwindow.initModality(Modality.WINDOW_MODAL);
            endwindow.initOwner(window);
            endwindow.setScene(saveUIscene);
            endwindow.show();
        }

    }

    public Image getImage() throws FileNotFoundException {
        Image image = new Image(new FileInputStream("files/images/logo.PNG"));
        return image;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        eslMap = Processing.PROCESSING.getEslMap();
        sdatMap = Processing.PROCESSING.getSdatMap();

        try {
            logo.setImage(getImage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}