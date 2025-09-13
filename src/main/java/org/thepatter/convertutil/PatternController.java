package org.thepatter.convertutil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.thepatter.convertutil.Service.IConvertService;
import org.thepatter.convertutil.Service.Impl.ConvertService;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternController {
    @FXML
    private Label infoLabel;

    @FXML
    private TextArea inputNum;

    @FXML
    private TextArea outputNum;

    @FXML
    private TextArea regex;


    @FXML
    protected void onHelloButtonClick() {
        String text = inputNum.getText();
        String reg  = regex.getText();

        if (text == null || reg == null || reg.isBlank()) {
            showAlert("请输入合法文本与正则！");
            return;
        }
        try {
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(text);

            int count = 0;
            StringBuilder hits = new StringBuilder();

            while (matcher.find()) {
                count++;
                String hit = matcher.group();
                int start = matcher.start();
                int end   = matcher.end();
                hits.append(String.format("%2d. %-20s  [%d,%d)%n",
                        count, hit, start, end));
            }

            infoLabel.setText(String.valueOf(count));
            if (count == 0) {
                infoLabel.setText("（无匹配）");
            }
            outputNum.setText(hits.toString());
        } catch (Exception e) {
            showAlert("正则表达式非法：" + e.getMessage());
        }

    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING, msg);
        alert.setHeaderText(null);
        alert.showAndWait();
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