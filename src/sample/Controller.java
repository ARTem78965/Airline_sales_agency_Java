package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.axis.encoding.Base64;

import javax.swing.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login;

    @FXML
    private Button autsSingInButton;

    @FXML
    private PasswordField password;

    @FXML
    private ComboBox comboBox;

    @FXML
    private Button loginSingUpButton;

    // Шифрование пароля Encode.
    public static String encodeString(String passTXT)
            throws UnsupportedEncodingException {
        byte[] bytes = passTXT.getBytes("UTF-8");
        String encodeString = Base64.encode(bytes);
        return encodeString;
    }

    @FXML
    void initialize() {
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("Администратор", "Кассир", "Пассажир");
        comboBox.getSelectionModel().select("Пассажир");

        //  Кнопка РЕГИСТРАЦИЯ.
        loginSingUpButton.setOnAction(event -> {
            loginSingUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("fxml/Registr.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        //  Кнопка ВХОД.
        autsSingInButton.setOnAction(event -> {
            String loginTXT = login.getText().trim();
            String passTXT = null;
            try {
                passTXT = encodeString(password.getText().trim());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String role = comboBox.getValue().toString();
            if (!loginTXT.equals("") && !passTXT.equals("") && !role.equals("")) {
                loginUser(loginTXT, passTXT, role);
            } else {
                System.out.println("Нет данных в полях!");
            }
        });
    }

    //  Проверка на существование пользователя и переход на другую форму по привилегиям.
    private void loginUser(String loginTXT, String passTXT, String role) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        addUser user = new addUser();
        user.setLog(loginTXT);
        user.setPass(passTXT);
        user.setRole(role);
        ResultSet rs = dbHandler.getUser(user);
        try {
            if (rs.next()) {
                if (user.getLog().equals(loginTXT) && user.getPass().equals(passTXT) && user.getRole().equals("Администратор")) {
                    autsSingInButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("fxml/Admin.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                } else if (user.getLog().equals(loginTXT) && user.getPass().equals(passTXT) && user.getRole().equals("Кассир")) {
                    autsSingInButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("fxml/PayMasster.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                } else {
                    autsSingInButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("fxml/Pass.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
            }else{
                JOptionPane.showMessageDialog(null,"Неверный логин или пароль?");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
