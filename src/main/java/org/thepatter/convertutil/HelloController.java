package org.thepatter.convertutil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.thepatter.convertutil.Service.IConvertService;
import org.thepatter.convertutil.Service.Impl.ConvertService;

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
}