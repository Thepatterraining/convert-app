package org.thepatter.convertutil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.thepatter.convertutil.Service.IConvertService;
import org.thepatter.convertutil.Service.IXmlCheckerService;
import org.thepatter.convertutil.Service.Impl.ConvertService;
import org.thepatter.convertutil.Service.Impl.XmlCheckerService;

import java.io.File;
import java.io.IOException;

public class XmlController {
    @FXML
    private Label infoLabel;

    @FXML
    private TextArea inputNum;

    @FXML
    private TextArea outputNum;


    @FXML
    protected void onXmlStrChecker() {
        IXmlCheckerService service = new XmlCheckerService();
        infoLabel.setText("xml str success!");
        outputNum.setText(service.xmlChecker(inputNum.getText()));
    }

    @FXML
    protected void onXmlFileChecker(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        Button button = (Button) event.getSource();
        Stage stage = (Stage)button.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            System.out.println("Selected file: " + file.getAbsolutePath());
        }
        IXmlCheckerService service = new XmlCheckerService();
        infoLabel.setText("xml file success!");
        outputNum.setText(service.xmlChecker(file));
    }

    @FXML
    protected void onHomeClick(ActionEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(load,500, 500);
        Button button = (Button) event.getSource();
        Stage stage = (Stage)button.getScene().getWindow();
        stage.setScene(scene);
    }
}