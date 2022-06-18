package sample;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;

public class PayMast implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Table_Reis> reis_table;

    @FXML
    private TableColumn<Table_Reis, Integer> col_id_reis;

    @FXML
    private TableColumn<Table_Reis, Integer> col_num_reis;

    @FXML
    private TableColumn<Table_Reis, String> col_air_v;

    @FXML
    private TableColumn<Table_Reis, String> col_air_n;

    @FXML
    private TableColumn<Table_Reis, Integer> col_prodolz;

    @FXML
    private TableColumn<Table_Reis, Integer> col_price;

    @FXML
    private Button update_passager;

    @FXML
    private Button delete_passager;

    @FXML
    private Button add_passager;

    @FXML
    private TableView<Table_Passager> passager_table;

    @FXML
    private TableColumn<Table_Passager, Integer> col_id_pass;

    @FXML
    private TableColumn<Table_Passager, Integer> col_vilet;

    @FXML
    private TableColumn<Table_Passager, String> col_num_mesta;

    @FXML
    private TableColumn<Table_Passager, String> col_FIO;

    @FXML
    private TableColumn<Table_Passager, String> col_passport;

    @FXML
    private TableView<Table_Vilet> vilet_table;

    @FXML
    private TableColumn<Table_Vilet, Integer> col_id_vilet;

    @FXML
    private TableColumn<Table_Vilet, Integer> col_reis;

    @FXML
    private TableColumn<Table_Vilet, String> col_time_v;

    @FXML
    private TableColumn<Table_Vilet, String> col_place;

    @FXML
    private TableColumn<Table_Vilet, String> col_comand_akipa;

    @FXML
    private TextField txt_vilet;

    @FXML
    private TextField txt_nomer_mesta;

    @FXML
    private TextField txt_FIO;

    @FXML
    private TextField txt_passport;

    @FXML
    private TextField txt_nomer_passager;

    Connection con;
    ResultSet rs;
    ObservableList<Table_Reis> list3 = FXCollections.observableArrayList();
    ObservableList<Table_Vilet> list4 = FXCollections.observableArrayList();
    ObservableList<Table_Passager> list5 = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //      Вывод представление Рейс
        try {
            con = DatabaseHandler.getDbCon();
            rs = con.createStatement().executeQuery("SELECT * FROM reis_view");
            while (rs.next()) {
                list3.add(new Table_Reis(
                        rs.getInt("kod_reis"),
                        rs.getInt("nomer_reis"),
                        rs.getString("airport_vilet"),
                        rs.getString("nazv"),
                        rs.getInt("prodolz"),
                        rs.getInt("stoimost")));
            }
            col_id_reis.setCellValueFactory(new PropertyValueFactory<Table_Reis, Integer>("col_id_reis"));
            col_num_reis.setCellValueFactory(new PropertyValueFactory<Table_Reis, Integer>("col_num_reis"));
            col_air_v.setCellValueFactory(new PropertyValueFactory<Table_Reis, String>("col_air_v"));
            col_air_n.setCellValueFactory(new PropertyValueFactory<Table_Reis, String>("col_air_n"));
            col_prodolz.setCellValueFactory(new PropertyValueFactory<Table_Reis, Integer>("col_prodolz"));
            col_price.setCellValueFactory(new PropertyValueFactory<Table_Reis, Integer>("col_price"));
            reis_table.setItems(list3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //        Вывод таблицы Вылет.
        try {
            con = DatabaseHandler.getDbCon();
            rs = con.createStatement().executeQuery("SELECT * FROM vilet_view");
            while (rs.next()) {
                list4.add(new Table_Vilet(
                        rs.getInt("kod_vilet"),
                        rs.getInt("nomer_reis"),
                        rs.getString("vremya_vilet"),
                        rs.getString("tip_airplace"),
                        rs.getString("commandir_akipad")));
            }
            col_id_vilet.setCellValueFactory(new PropertyValueFactory<Table_Vilet, Integer>("col_id_vilet"));
            col_reis.setCellValueFactory(new PropertyValueFactory<Table_Vilet, Integer>("col_reis"));
            col_time_v.setCellValueFactory(new PropertyValueFactory<Table_Vilet, String>("col_time_v"));
            col_place.setCellValueFactory(new PropertyValueFactory<Table_Vilet, String>("col_place"));
            col_comand_akipa.setCellValueFactory(new PropertyValueFactory<Table_Vilet, String>("col_comand_akipa"));
            vilet_table.setItems(list4);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //      Вывод представление Пассажир
        try {
            con = DatabaseHandler.getDbCon();
            rs = con.createStatement().executeQuery("SELECT * FROM passager_view");
            while (rs.next()) {
                list5.add(new Table_Passager(
                        rs.getInt("kod_pass"),
                        rs.getInt("kod_vilet"),
                        rs.getString("nomer_mesta"),
                        rs.getString("fio"),
                        rs.getString("passport")
                ));
            }
            col_id_pass.setCellValueFactory(new PropertyValueFactory<Table_Passager, Integer>("col_id_pass"));
            col_vilet.setCellValueFactory(new PropertyValueFactory<Table_Passager, Integer>("col_vilet"));
            col_num_mesta.setCellValueFactory(new PropertyValueFactory<Table_Passager, String>("col_num_mesta"));
            col_FIO.setCellValueFactory(new PropertyValueFactory<Table_Passager, String>("col_FIO"));
            col_passport.setCellValueFactory(new PropertyValueFactory<Table_Passager, String>("col_passport"));
            passager_table.setItems(list5);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        Добавление пассажира.
        add_passager.setOnAction(event -> {
            passager_table.setVisible(true);
            list5.clear();
            DatabaseHandler dbHandler;
            int vilet;
            int nomer_mesta;
            String FIO;
            String passport;

            if (!txt_vilet.equals(" ") && !txt_nomer_mesta.equals(" ") && !txt_FIO.equals(" ") && !txt_passport.equals(" ")) {
                dbHandler = new DatabaseHandler();
                vilet = Integer.parseInt(txt_vilet.getText().trim());
                nomer_mesta = Integer.parseInt(txt_nomer_mesta.getText().trim());
                FIO = txt_FIO.getText();
                passport = txt_passport.getText();
                addPassager addpassager = new addPassager(vilet, nomer_mesta, FIO, passport);
                dbHandler.addPassager(addpassager);
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });
//        Обновление пассажира.
        update_passager.setOnAction(event -> {
            list5.clear();
            passager_table.setVisible(true);
            DatabaseHandler dbHandler;
            int kod_passager;
            int vilet;
            int nomer_mesta;
            String FIO;
            String passport;
            if (!txt_nomer_passager.equals(" ") && !txt_nomer_mesta.equals(" ") && !txt_FIO.equals(" ") && !txt_passport.equals(" ")) {
                dbHandler = new DatabaseHandler();
                kod_passager = Integer.parseInt(txt_nomer_passager.getText().trim());
                vilet = Integer.parseInt(txt_vilet.getText().trim());
                nomer_mesta = Integer.parseInt(txt_nomer_mesta.getText().trim());
                FIO = txt_FIO.getText();
                passport = txt_passport.getText();
                updatePassager uppassager = new updatePassager(kod_passager, vilet, nomer_mesta, FIO, passport);
                dbHandler.updatePassager(uppassager);
            }
        });
//        Удаление таблицы.
        delete_passager.setOnAction(event ->{
            list5.clear();
            passager_table.setVisible(true);
            DatabaseHandler dbHandler;
            int kod_passager;
            if (!txt_nomer_passager.equals(" ")) {
                dbHandler = new DatabaseHandler();
                kod_passager = Integer.parseInt(txt_nomer_passager.getText().trim());
                deletePassager delpassager = new deletePassager(kod_passager);
                dbHandler.deletePassager(delpassager);
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });
        passager_table.setVisible(true);                            // Обновление записи таблицы?
    }
}
