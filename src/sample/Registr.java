package sample;

import org.apache.axis.encoding.Base64;

import java.io.*;
import java.net.*;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;

public class Registr {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login;

    @FXML
    private Button RegSingInButton;

    @FXML
    private PasswordField password;

    @FXML
    private TextField name;

    @FXML
    private TextField famil;

    @FXML
    private TextField otch;

    @FXML
    private TextField phone;

    @FXML
    private RadioButton admin;

    @FXML
    private ToggleGroup role;

    @FXML
    private RadioButton pass;

    @FXML
    private RadioButton paymast;

//    Шифровка пароля Encode
    public static String encodeString(String passwd)
            throws UnsupportedEncodingException {
        byte[] bytes = passwd.getBytes("UTF-8");
        String encodeString = Base64.encode(bytes);
        return encodeString;
    }

    @FXML
    void initialize() {


        RegSingInButton.setOnAction(event -> {
            try {
                singUpNewUser();
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException | BadPaddingException | IllegalBlockSizeException e) {
                e.printStackTrace();
            }

        });
    }

    //    Добавление записи в таблицу ПОЛЬЗОВАТЕЛИ.
    private void singUpNewUser() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        DatabaseHandler dbHandler;
        String fam;
        String nam;
        String otches;
        String pho;
        String role;
        String log;
        String passwd;


//      Проверка на заполнение полей.
        if (!famil.equals(" ") && !name.equals(" ") && !otch.equals(" ") && !phone.equals(" ") && !login.equals(" ") && !password.equals(" ")) {
            dbHandler = new DatabaseHandler();
            fam = famil.getText().trim();
            nam = name.getText().trim();
            otches = otch.getText().trim();
            pho = phone.getText().trim();
            role = "";
            log = login.getText().trim();
            passwd = encodeString(password.getText().trim());

//            Проверка на валидность номера телефона.
            String regex = "^(?:8|\\\\+7)[7-9][0-9]{9}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(pho);

/*            Proverka pr = new Proverka();                                                                               //  Что то нужно сделать!?
            pr.initialize();*/
            if (matcher.matches()) {
//            Выбор ролей проверка.
                if (admin.isSelected()) {
                    role = "Администратор";
                } else if (paymast.isSelected()) {
                    role = "Кассир";
                } else if (pass.isSelected()) {
                    role = "Пассажир";
                }
                addUser adduser = new addUser(fam, nam, otches, pho, role, log, passwd);
                dbHandler.singUpUser(adduser);
            } else {
                JOptionPane.showMessageDialog(null, "Номер телефона не корректный!");
                return;
            }
//            Возвращает на форму Автоизация.
            RegSingInButton.getScene().getWindow().hide();
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
            JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
        }
    }
}
