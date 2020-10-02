package View;

import Control.Processing;
import Model.ESL;
import Model.SDAT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author Vator AG
 * @version 1.0
 * @since 2020-September-30
 */

public class ConsumptionController implements Initializable {

    @FXML private ImageView logo;
    @FXML private DatePicker anfang;
    @FXML private DatePicker ende;
    @FXML private CategoryAxis x;
    @FXML private  NumberAxis y;
    @FXML private LineChart<?, ?> chart;

    @FXML
    private void onExport(ActionEvent event) throws IOException {

        Parent saveUIParent = FXMLLoader.load(getClass().getResource("FXML/ExportUI.fxml"));
        Scene saveUIscene = new Scene(saveUIParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(saveUIscene);
        window.show();

    }

    @FXML
    private void onMeterReading(ActionEvent event) throws IOException {

        Parent meterReadingUIParent = FXMLLoader.load(getClass().getResource("FXML/MeterReadingUI.fxml"));
        Scene meterReadingUIscene = new Scene(meterReadingUIParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(meterReadingUIscene);
        window.show();
    }

    public Image getImage() throws FileNotFoundException {
        return new Image(new FileInputStream("files/images/logo.PNG"));
    }

    public LocalDate LOCAL_DATE (String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Map<String, SDAT> sdatMap = Processing.PROCESSING.getSdatMap();

        try {
            anfang.setValue(LOCAL_DATE("2019-03-11"));
            ende.setValue(LOCAL_DATE("2019-09-24"));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        XYChart.Series series = new XYChart.Series();
        series.setName("Verbrauch");

        for (SDAT sdat : sdatMap.values()) {
            series.getData().add(new XYChart.Data(sdat.getTimeID().toString(), sdat.getTotalValue()));
        }

        x.setLabel("Zeit");
        y.setLabel("Verbrauch");

        chart.getData().addAll(series);
        chart.setTitle("Verbrauchsdiagramm");

        try {
            logo.setImage(getImage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}