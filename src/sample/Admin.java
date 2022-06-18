package sample;

import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class Admin implements Initializable {

    @FXML
    private TableView<Table_User> user_table;

    @FXML
    private TableColumn<Table_User, Integer> col_id;

    @FXML
    private TableColumn<Table_User, String> col_fam;

    @FXML
    private TableColumn<Table_User, String> col_nam;

    @FXML
    private TableColumn<Table_User, String> col_otch;

    @FXML
    private TableColumn<Table_User, String> col_phone;

    @FXML
    private TableColumn<Table_User, String> col_role;

    @FXML
    private TableColumn<Table_User, String> col_log;

    @FXML
    private TableColumn<Table_User, String> col_pass;

    @FXML
    private TextField txt_password;

    @FXML
    private Button users;

    @FXML
    private TextField txt_fam;

    @FXML
    private TextField txt_nam;

    @FXML
    private TextField txt_otch;

    @FXML
    private TextField txt_pho;

    @FXML
    private TextField txt_rol;

    @FXML
    private TextField txt_log;

    @FXML
    private Button add_user;

    @FXML
    private Button delete_user;

    @FXML
    private Button update_user;

    @FXML
    private TextField txt_kod_users;

    @FXML
    private TableView<Table_Airplace> airplace_table;

    @FXML
    private TableColumn<Table_Airplace, Integer> col_id_airplace;

    @FXML
    private TableColumn<Table_Airplace, String> col_tip_airplace;

    @FXML
    private TableColumn<Table_Airplace, String> col_kol_mest;

    @FXML
    private TableColumn<Table_Airplace, String> col_polet;

    @FXML
    private Button park_air;

    @FXML
    private TextField txt_tip_airplace;

    @FXML
    private TextField txt_kol_mest;

    @FXML
    private TextField txt_danl_pol;

    @FXML
    private Button add_aiprlace;

    @FXML
    private Button delete_aiprlace;

    @FXML
    private Button update_aiprlace;

    @FXML
    private TextField txt_nomer_aiplace;

    @FXML
    private TableView<Table_Airports> airport_table;

    @FXML
    private TableColumn<Table_Airports, Integer> col_id_airports;

    @FXML
    private TableColumn<Table_Airports, String> col_naz_airports;

    @FXML
    private Button airport;

    @FXML
    private Button delete_airport;

    @FXML
    private TextField txt_nazv_airplace;

    @FXML
    private Button add_airport;

    @FXML
    private Button update_airport;

    @FXML
    private TextField txt_nomer_airport;

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
    private Button reis;

    @FXML
    private TextField txt_nomer_reis;

    @FXML
    private TextField txt_airport_vilet;

    @FXML
    private TextField txt_airport_nazn;

    @FXML
    private TextField txt_prodolz;

    @FXML
    private TextField txt_cena;

    @FXML
    private Button add_reis;

    @FXML
    private Button delete_reis;

    @FXML
    private Button update_reis;

    @FXML
    private TextField txt_num_reis;

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
    private Button vilet;

    @FXML
    private TextField txt_reis;

    @FXML
    private TextField txt_vremya_vilet;

    @FXML
    private TextField txt_airplace;

    @FXML
    private TextField txt_command_akipad;

    @FXML
    private Button add_vilet;

    @FXML
    private Button delete_vilet;

    @FXML
    private Button update_vilet;

    @FXML
    private TextField txt_nomer_vileta;

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
    private Button passager;

    @FXML
    private TextField txt_vilet;

    @FXML
    private TextField txt_nomer_mesta;

    @FXML
    private TextField txt_FIO;

    @FXML
    private TextField txt_passport;

    @FXML
    private Button add_passager;

    @FXML
    private Button delete_passager;

    @FXML
    private Button update_passager;

    @FXML
    private TextField txt_nomer_passager;

    Connection con;
    ResultSet rs;

    ObservableList<Table_User> list = FXCollections.observableArrayList();
    ObservableList<Table_Airplace> list1 = FXCollections.observableArrayList();
    ObservableList<Table_Airports> list2 = FXCollections.observableArrayList();
    ObservableList<Table_Reis> list3 = FXCollections.observableArrayList();
    ObservableList<Table_Vilet> list4 = FXCollections.observableArrayList();
    ObservableList<Table_Passager> list5 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//      Вывод таблицы Пользователи.
        users.setOnAction(event -> {
            try {
                list.clear();
                user_table.setVisible(true);
                con = DatabaseHandler.getDbCon();
                rs = con.createStatement().executeQuery("SELECT * FROM users");
                while (rs.next()) {
                    list.add(new Table_User(
                            rs.getInt("kod_users"),
                            rs.getString("fam"),
                            rs.getString("nam"),
                            rs.getString("otch"),
                            rs.getString("pho"),
                            rs.getString("rol"),
                            rs.getString("log"),
                            rs.getString("pass")));
                }
                col_id.setCellValueFactory(new PropertyValueFactory<Table_User, Integer>("col_id"));
                col_fam.setCellValueFactory(new PropertyValueFactory<Table_User, String>("col_fam"));
                col_nam.setCellValueFactory(new PropertyValueFactory<Table_User, String>("col_nam"));
                col_otch.setCellValueFactory(new PropertyValueFactory<Table_User, String>("col_otch"));
                col_phone.setCellValueFactory(new PropertyValueFactory<Table_User, String>("col_pho"));
                col_role.setCellValueFactory(new PropertyValueFactory<Table_User, String>("col_role"));
                col_log.setCellValueFactory(new PropertyValueFactory<Table_User, String>("col_log"));
                col_pass.setCellValueFactory(new PropertyValueFactory<Table_User, String>("col_pass"));
                user_table.setItems(list);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });             //+
//        Добавление записи в таблицу Пользователи.
        add_user.setOnAction(event -> {
            DatabaseHandler dbHandler;
            String fam;
            String nam;
            String otches;
            String pho;
            String role;
            String log;
            String passwd;

            //      Проверка на заполнение полей.
            if (!txt_fam.equals(" ") && !txt_nam.equals(" ") && !txt_pho.equals(" ") && !txt_rol.equals(" ") && !txt_log.equals(" ") && !txt_password.equals(" ")) {
                dbHandler = new DatabaseHandler();
                fam = txt_fam.getText().trim();
                nam = txt_nam.getText().trim();
                otches = txt_otch.getText().trim();
                pho = txt_pho.getText().trim();
                role = txt_rol.getText().trim();
                log = txt_log.getText().trim();
                passwd = txt_password.getText().trim();


//            Проверка на валидность номера телефона.
                String regex = "^(?:8|\\\\+7)[7-9][0-9]{9}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(pho);
                if (matcher.matches()) {
//                    JOptionPane.showMessageDialog(null, "Номер телефона прошел валидацию");
//            Шифровка пароля.
                    MessageDigest des = null;
                    try {
                        des = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                    byte[] bytes = des.digest(passwd.getBytes());
                    StringBuilder builder = new StringBuilder();
                    for (byte b : bytes) {
                        builder.append(String.format("%02X ", b));
                    }
                    passwd = builder.toString();
                    addUser user = new addUser(fam, nam, otches, pho, role, log, passwd);
                    dbHandler.singUpUser(user);
                } else {
                    JOptionPane.showMessageDialog(null, "Номер телефона не корректный!");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });          //+
//        Изменение записи в таблице Пользователь.
        update_user.setOnAction(event -> {
            DatabaseHandler dbHandler;
            int kod_users;
            String fam;
            String nam;
            String otches;
            String pho;
            String log;
            String pass;

            //      Проверка на заполнение полей.
            if (!txt_kod_users.equals(" ") && !txt_fam.equals(" ") && !txt_nam.equals(" ") && !txt_pho.equals(" ") && !txt_log.equals(" ") && !txt_password.equals(" ")) {
                dbHandler = new DatabaseHandler();
                kod_users = Integer.parseInt(txt_kod_users.getText().trim());
                fam = txt_fam.getText().trim();
                nam = txt_nam.getText().trim();
                otches = txt_otch.getText().trim();
                pho = txt_pho.getText().trim();
                log = txt_log.getText().trim();
                pass = txt_password.getText().trim();
                //            Проверка на валидность номера телефона.
                String regex = "^(?:8|\\\\+7)[7-9][0-9]{9}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(pho);
                if (matcher.matches()) {
//            Шифровка пароля.
                    MessageDigest des = null;
                    try {
                        des = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                    byte[] bytes = des.digest(pass.getBytes());
                    StringBuilder builder = new StringBuilder();
                    for (byte b : bytes) {
                        builder.append(String.format("%02X ", b));
                    }
                    pass = builder.toString();
                    updateUsers upusers = new updateUsers(kod_users, fam, nam, otches, pho, log, pass);
                    dbHandler.updateUser(upusers);
                } else {
                    JOptionPane.showMessageDialog(null, "Номер телефона не корректный!");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });       //+
//        Удаление записи в таблице Пользователь.
        delete_user.setOnAction(event -> {
            DatabaseHandler dbHandler;
            int kod_users;
            if (!txt_kod_users.equals(" ")) {
                dbHandler = new DatabaseHandler();
                kod_users = Integer.parseInt(txt_kod_users.getText().trim());

                delUsers dlusers = new delUsers(kod_users);
                dbHandler.deleteUsers(dlusers);
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });       //+

//      Вывод таблицы Парк самолетов.
        park_air.setOnAction(event -> {
            list1.clear();
            airplace_table.setVisible(true);
            try {
                con = DatabaseHandler.getDbCon();
                rs = con.createStatement().executeQuery("SELECT * FROM airplace");
                while (rs.next()) {
                    list1.add(new Table_Airplace(
                            rs.getInt("kod_airplace"),
                            rs.getString("tip_airplace"),
                            rs.getString("kol_mest"),
                            rs.getString("dal_pol")
                    ));
                }
                col_id_airplace.setCellValueFactory(new PropertyValueFactory<Table_Airplace, Integer>("col_id_airplace"));
                col_tip_airplace.setCellValueFactory(new PropertyValueFactory<Table_Airplace, String>("col_tip_airplace"));
                col_kol_mest.setCellValueFactory(new PropertyValueFactory<Table_Airplace, String>("col_kol_mest"));
                col_polet.setCellValueFactory(new PropertyValueFactory<Table_Airplace, String>("col_polet"));
                airplace_table.setItems(list1);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });          //+
//        Добавление записи в таблицу Парк самолетов.
        add_aiprlace.setOnAction(event -> {
            DatabaseHandler dbHandler;
            String tip_airplace;
            int kol_mest;
            int dal_pol;

            if (!txt_tip_airplace.equals(" ") && !txt_kol_mest.equals(" ") && !txt_danl_pol.equals(" ")) {
                dbHandler = new DatabaseHandler();
                tip_airplace = txt_tip_airplace.getText().trim();
                kol_mest = Integer.parseInt(txt_kol_mest.getText().trim());
                dal_pol = Integer.parseInt(txt_danl_pol.getText().trim());

                addAirplace addairplace = new addAirplace(tip_airplace, kol_mest, dal_pol);
                dbHandler.addAiplace(addairplace);
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });      //+
//        Изменение записи в таблице Парк самолетов.
        update_aiprlace.setOnAction(event -> {
            DatabaseHandler dbHandler;
            int kod_airplace;
            String tip_airplace;
            int kol_mest;
            int dal_pol;
            if (!txt_nomer_aiplace.equals(" ") && !txt_tip_airplace.equals(" ") && !txt_tip_airplace.equals(" ") && !txt_kol_mest.equals(" ") && !txt_danl_pol.equals(" ")) {
                dbHandler = new DatabaseHandler();
                kod_airplace = Integer.parseInt(txt_nomer_aiplace.getText().trim());
                tip_airplace = txt_tip_airplace.getText().trim();
                kol_mest = Integer.parseInt(txt_kol_mest.getText().trim());
                dal_pol = Integer.parseInt(txt_danl_pol.getText().trim());
                updateAiplace upaiplace = new updateAiplace(kod_airplace, tip_airplace, kol_mest, dal_pol);
                dbHandler.updateAirplace(upaiplace);
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });   //+
//        Удаление записи в таблице Парк самолетов.
        delete_aiprlace.setOnAction(event -> {
            DatabaseHandler dbHandler;
            int kod_airplace;
            if (!txt_nomer_aiplace.equals(" ")) {
                dbHandler = new DatabaseHandler();
                kod_airplace = Integer.parseInt(txt_nomer_aiplace.getText().trim());
                deleteAirplace delairplace = new deleteAirplace(kod_airplace);
                dbHandler.deleteAirplace(delairplace);
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });   //+

//      Выод таблицы Аэропорта
        airport.setOnAction(event -> {
            list2.clear();
            try {
                airport_table.setVisible(true);
                con = DatabaseHandler.getDbCon();
                rs = con.createStatement().executeQuery("SELECT * FROM airport");
                while (rs.next()) {
                    list2.add(new Table_Airports(
                            rs.getInt("kod_airport"),
                            rs.getString("nazv")
                    ));
                }
                col_id_airports.setCellValueFactory(new PropertyValueFactory<Table_Airports, Integer>("col_id_airports"));
                col_naz_airports.setCellValueFactory(new PropertyValueFactory<Table_Airports, String>("col_naz_airports"));
                airport_table.setItems(list2);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });           //+
//        Добавление записи в таблицу Аэропорт.
        add_airport.setOnAction(event -> {
            DatabaseHandler dbHandler;
            String nazv;

            if (!txt_nazv_airplace.equals(" ")) {
                dbHandler = new DatabaseHandler();
                nazv = txt_nazv_airplace.getText();
                addAirport addaiport = new addAirport(nazv);
                dbHandler.addAirport(addaiport);
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });       //+
//        Изменение записи в таблицу Аэропорт.
        update_airport.setOnAction(event -> {
            DatabaseHandler dbHandler;
            int kod_airport;
            String nazv;
            if (!txt_nomer_airport.equals(" ") && !txt_nazv_airplace.equals(" ")) {
                dbHandler = new DatabaseHandler();
                kod_airport = Integer.parseInt(txt_nomer_airport.getText().trim());
                nazv = txt_nazv_airplace.getText();
                updateAirport upairport = new updateAirport(kod_airport, nazv);
                dbHandler.updateAirport(upairport);
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });    //+
//        Удаление записи в таблицу Аэропорт.
        delete_airport.setOnAction(event -> {
            DatabaseHandler dbHandler;
            int kod_airport;
            if (!txt_nomer_airport.equals(" ")) {
                dbHandler = new DatabaseHandler();
                kod_airport = Integer.parseInt(txt_nomer_airport.getText().trim());
                deleteAirport delairport = new deleteAirport(kod_airport);
                dbHandler.deleteAiport(delairport);
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });    //+

//      Вывод представление Рейс
        reis.setOnAction(event -> {
            list3.clear();
            try {
                reis_table.setVisible(true);
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
        });             //+
//      Добавление записи в таблицу Рейс.
        add_reis.setOnAction(event -> {
            DatabaseHandler dbHandler;
            int nomer_reis;
            String airport_vilet;
            int airport_naznach;
            int prodolz;
            float stoimost;

            if (!txt_nomer_reis.equals(" ") && !txt_airport_vilet.equals(" ") && !txt_airport_nazn.equals(" ") && !txt_prodolz.equals(" ") && !txt_cena.equals("")) {
                dbHandler = new DatabaseHandler();
                nomer_reis = Integer.parseInt(txt_nomer_reis.getText().trim());
                airport_vilet = txt_airport_vilet.getText();
                airport_naznach = Integer.parseInt(txt_airport_nazn.getText().trim());
                prodolz = Integer.parseInt(txt_prodolz.getText().trim());
                stoimost = Float.parseFloat(txt_cena.getText().trim());
                addReis addreis = new addReis(nomer_reis, airport_vilet, airport_naznach, prodolz, stoimost);
                dbHandler.addReis(addreis);
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });         //+ Работает но под (?)
//      Изменение записи в таблицу Рейс.
        update_reis.setOnAction(event -> {
            DatabaseHandler dbHandler;
            int kod_reis;
            int nomer_reis;
            String airport_vilet;
            int airport_naznach;
            int prodolz;
            float stoimost;
            if (!txt_num_reis.equals(" ") && !txt_nomer_reis.equals(" ") && !txt_airport_vilet.equals(" ") && !txt_airport_nazn.equals(" ") && !txt_prodolz.equals(" ") && !txt_cena.equals(" ")) {
                dbHandler = new DatabaseHandler();
                kod_reis = Integer.parseInt(txt_num_reis.getText().trim());
                nomer_reis = Integer.parseInt(txt_nomer_reis.getText().trim());
                airport_vilet = txt_airport_vilet.getText().trim();
                airport_naznach = Integer.parseInt(txt_airport_nazn.getText().trim());
                prodolz = Integer.parseInt(txt_prodolz.getText().trim());
                stoimost = Integer.parseInt(txt_cena.getText().trim());
                updateReis upreis = new updateReis(kod_reis, nomer_reis, airport_vilet, airport_naznach, prodolz, stoimost);
                dbHandler.updateReis(upreis);
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });      //+
//      Удаление записи в таблицу Рейс
        delete_reis.setOnAction(event -> {
            DatabaseHandler dbHandler;
            int kod_reis;
            if (!txt_num_reis.equals(" ")) {
                dbHandler = new DatabaseHandler();
                kod_reis = Integer.parseInt(txt_num_reis.getText().trim());
                deleteReis delreis = new deleteReis(kod_reis);
                dbHandler.deleteReis(delreis);
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });      //+

//      Вывод представления Вылет
        vilet.setOnAction(event -> {
            list4.clear();
            try {
                vilet_table.setVisible(true);
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
        });            //+
//      Добавление записи в таблицу Вылет.
        add_vilet.setOnAction(event -> {
            DatabaseHandler dbHandler;
            int reis;
            String vremya_vilet;
            int airplace;
            String commandir_akipad;

            if (!txt_reis.equals(" ") && !txt_vremya_vilet.equals(" ") && !txt_airplace.equals(" ") && !txt_command_akipad.equals(" ")) {
                dbHandler = new DatabaseHandler();
                reis = Integer.parseInt(txt_reis.getText().trim());
                vremya_vilet = txt_vremya_vilet.getText();
                airplace = Integer.parseInt(txt_airplace.getText().trim());
                commandir_akipad = txt_command_akipad.getText();
                addVilet addvilet = new addVilet(reis, vremya_vilet, airplace, commandir_akipad);
                dbHandler.addVilet(addvilet);
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });        //+
//      Изменение записи в таблицу Вылет.
        update_vilet.setOnAction(event -> {
            DatabaseHandler dbHandler;
            int kod_vilet;
            int reis;
            String vremya_vilet;
            int airplace;
            String commandir_akipad;
            if (!txt_nomer_vileta.equals(" ") && !txt_reis.equals(" ") && !txt_vremya_vilet.equals(" ") && !txt_airplace.equals(" ") && !txt_command_akipad.equals(" ")) {
                dbHandler = new DatabaseHandler();
                kod_vilet = Integer.parseInt(txt_nomer_vileta.getText().trim());
                reis = Integer.parseInt(txt_reis.getText().trim());
                vremya_vilet = txt_vremya_vilet.getText();
                airplace = Integer.parseInt(txt_airplace.getText().trim());
                commandir_akipad = txt_command_akipad.getText();
                updateVilet upvilet = new updateVilet(kod_vilet, reis, vremya_vilet, airplace, commandir_akipad);
                dbHandler.updateVilet(upvilet);
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });     //+
//      Удаление записи в таблицу Вылет.
        delete_vilet.setOnAction(event -> {
            DatabaseHandler dbHandler;
            int kod_vilet;
            if (!txt_nomer_vileta.equals(" ")) {
                dbHandler = new DatabaseHandler();
                kod_vilet = Integer.parseInt(txt_nomer_vileta.getText().trim());
                deleteVilet delvilet = new deleteVilet(kod_vilet);
                dbHandler.deleteVilet(delvilet);
            } else {
                JOptionPane.showMessageDialog(null, "Не заполнены все поля!");
            }
        });     //+

//      Вывод представление Пассажир
        passager.setOnAction(event -> {
            list5.clear();
            try {
                passager_table.setVisible(true);
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
        });         //+
//      Добавление записи в таблицу Пассажир.
        add_passager.setOnAction(event -> {
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
        });     //+
//      Изменение записи в таблице Пассажир.
        update_passager.setOnAction(event -> {
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
        });  //+
//      Удаление записи в таблицу Пассажир.
        delete_passager.setOnAction(event -> {
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
        });  //+
    }
}