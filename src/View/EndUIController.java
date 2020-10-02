package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Vator AG
 * @version 1.0
 * @since 2020-September-30
 */
public class EndUIController implements Initializable {

    @FXML private ImageView logo;

    public Image getImage() throws FileNotFoundException {
        return new Image(new FileInputStream("images/logo2.PNG"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            logo.setImage(getImage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void start(ActionEvent event) throws IOException {
        Parent saveUIParent = FXMLLoader.load(getClass().getResource("FXML/StartUI.fxml"));
        Scene saveUIscene = new Scene(saveUIParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage primaryStage = (Stage) window.getOwner();

        window.close();
        primaryStage.setScene(saveUIscene);
        primaryStage.show();
    }

    @FXML
    public void end(ActionEvent event) {

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage primaryStage = (Stage) window.getOwner();

        window.close();
        primaryStage.close();

    }
}
