package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ADD_Passager {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_vilet;

    @FXML
    private TextField txt_FIO;

    @FXML
    private TextField txt_passport;

    @FXML
    private Button next;

    @FXML
    private TextField txt_naznachenie;

    @FXML
    private ComboBox comboBox;

    @FXML
    void initialize() {
//        места в самолете.
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
                "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
                "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
                "61", "62", "63", "64", "65", "66", "67", "68", "69", "70",
                "71", "72", "73", "74", "75", "76", "77", "78", "79", "80",
                "81", "82", "83", "84", "85", "86", "87", "88", "89", "90",
                "91", "92", "93", "94", "95", "96", "97", "98", "99", "100");
        comboBox.getSelectionModel().select("");



//        Добавление записи в таблицу Пассажир.
        next.setOnAction(event -> {
            DatabaseHandler dbHandler;
            int nomer_mesta;
            String FIO;
            String passport;

            if (!txt_FIO.equals(" ") && !txt_vilet.equals(" ") && !txt_passport.equals(" ") && !txt_naznachenie.equals(" ") && !comboBox.equals(" ")) {
                dbHandler = new DatabaseHandler();
                String vilet = txt_vilet.getText();
                String naznachenie = txt_naznachenie.getText();
                SelectViewBilet svb = new SelectViewBilet(vilet, naznachenie);
                svb.setAirport_vilet(vilet);
                svb.setNazv(naznachenie);
                ResultSet rs = dbHandler.getView_Bilet(svb);
                try {
                    if (rs.next()) {
                        if(svb.getAirport_vilet().equals(vilet) && svb.getNazv().equals(naznachenie)) {
                            JOptionPane.showMessageDialog(null, "Рейс существует!");
                            nomer_mesta = Integer.parseInt(comboBox.getValue().toString());
                            FIO = txt_FIO.getText();
                            passport = txt_passport.getText();
                            //  Cannot add or update a child row: a foreign key constraint fails (`airlines`.`passager`, CONSTRAINT `passager_ibfk_1` FOREIGN KEY (`vilet`) REFERENCES `vilet` (`kod_vilet`))
                            addPassager addpassager = new addPassager(nomer_mesta, FIO, passport);
                            dbHandler.addPassager(addpassager);
                        }else{
                            JOptionPane.showMessageDialog(null, "В данный момент нет рейсов");
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ошибка");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });
    }
}