package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import javax.swing.*;

public class Proverka {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField password;

    @FXML
    private Button next;

    @FXML
    void initialize() {
        next.setOnAction(event -> {
            String pass = password.getText();
            if (pass == "Admin" || pass == "PayMast") {
                JOptionPane.showMessageDialog(null, "Провека прошла успашна!");

//                Возвращает на форму Автоизация.
                next.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("fxml/sample.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                JOptionPane.showMessageDialog(null, "Неверный пароль!" + "\n" + "Обратитесь к администратору");
            }
        });
    }
}

