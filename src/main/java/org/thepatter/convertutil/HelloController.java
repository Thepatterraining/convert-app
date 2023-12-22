package org.thepatter.convertutil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.thepatter.convertutil.Service.IConvertService;
import org.thepatter.convertutil.Service.Impl.ConvertService;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label infoLabel;

    @FXML
    private TextArea inputNum;

    @FXML
    private TextArea outputNum;


    @FXML
    protected void onHelloButtonClick() {
        IConvertService convertService = new ConvertService();
        infoLabel.setText("convert success!");
        outputNum.setText(convertService.convert(inputNum.getText()));
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