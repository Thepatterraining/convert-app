package org.thepatter.convertutil;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.thepatter.convertutil.Service.IConvertService;
import org.thepatter.convertutil.Service.Impl.ConvertService;

public class MainController {
    @FXML
    private Label infoLabel;

    @FXML
    private TextArea inputNum;

    @FXML
    private TextArea outputNum;


    @FXML
    protected void onConvertClick() {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        setScene();
    }

    @FXML
    protected void onXmlClick() {
        IConvertService convertService = new ConvertService();
        infoLabel.setText("convert success!");
        outputNum.setText(convertService.convert(inputNum.getText()));
    }
}