package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;

public class DELETE_Passager {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button next;

    @FXML
    private TextField txt_kod_pass;

    @FXML
    void initialize() {
    if(!txt_kod_pass.equals(" ")){

    }else{
        JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
    }

    }
}
