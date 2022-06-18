package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Pass implements Initializable {

    @FXML
    private AnchorPane add_passenger;

    @FXML
    private TableView<personalPassager> views_table;

    @FXML
    private TableColumn<personalPassager, String> txt_vilet;

    @FXML
    private TableColumn<personalPassager, String> txt_datetime_otprav;

    @FXML
    private TableColumn<personalPassager, String> txt_nazn;

    @FXML
    private TableColumn<personalPassager, String> txt_datetime_nazn;

    @FXML
    private Button add_passager;

    @FXML
    private TableView<bilet_view> reis_table;

    @FXML
    private TableColumn<bilet_view, Integer> col_nomer_vilet;

    @FXML
    private TableColumn<bilet_view, Integer> col_num_reis;

    @FXML
    private TableColumn<bilet_view, String> col_air_v;

    @FXML
    private TableColumn<bilet_view, String> col_air_n;

    @FXML
    private TableColumn<bilet_view, String> col_vremya_vilet;

    @FXML
    private TableColumn<bilet_view, String> col_tip_airplace;

    @FXML
    private TableColumn<bilet_view, Float> col_price;

    @FXML
    private TextField txt_otprav;

    @FXML
    private TextField txt_prib;

    @FXML
    private Button search;

    Connection con;
    ResultSet rs;
    ObservableList<personalPassager> list = FXCollections.observableArrayList();
    ObservableList<bilet_view> list3 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Вывод таблицы ЛИЧНОГО ПАССАЖИРА.
          txt_vilet.setCellValueFactory(new PropertyValueFactory<personalPassager, String>("vilet"));
          txt_datetime_otprav.setCellValueFactory(new PropertyValueFactory<personalPassager, String>("datetime_vilet"));
          txt_nazn.setCellValueFactory(new PropertyValueFactory<personalPassager, String>("naznach"));
          txt_datetime_nazn.setCellValueFactory(new PropertyValueFactory<personalPassager, String>("datetime_naznach"));
          views_table.setItems(list);

//        Вывод таблицы РЕЙС.
        try {
            con = DatabaseHandler.getDbCon();
            rs = con.createStatement().executeQuery("SELECT * FROM bilet_view");
            while (rs.next()) {
                list3.add(new bilet_view(
                    rs.getInt("kod_vilet"),
                    rs.getInt("nomer_reis"),
                    rs.getString("airport_vilet"),
                    rs.getString("nazv"),
                    rs.getString("vremya_vilet"),
                    rs.getString("tip_airplace"),
                    rs.getFloat("stoimost")));

            }
            col_nomer_vilet.setCellValueFactory(new PropertyValueFactory<bilet_view, Integer>("col_nomer_vilet"));
            col_num_reis.setCellValueFactory(new PropertyValueFactory<bilet_view, Integer>("col_num_reis"));
            col_air_v.setCellValueFactory(new PropertyValueFactory<bilet_view, String>("col_air_v"));
            col_air_n.setCellValueFactory(new PropertyValueFactory<bilet_view, String>("col_air_n"));
            col_vremya_vilet.setCellValueFactory(new PropertyValueFactory<bilet_view, String>("col_vremya_vilet"));
            col_tip_airplace.setCellValueFactory(new PropertyValueFactory<bilet_view, String>("col_tip_airplace"));
            col_price.setCellValueFactory(new PropertyValueFactory<bilet_view, Float>("col_price"));
            reis_table.setItems(list3);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Поиск записи в таблице REIS.
        search.setOnAction(event -> {
            String otprav = txt_otprav.getText();
            String naznach = txt_nazn.getText();
            if(!otprav.equals("")&&!naznach.equals("")){
                Bilet(otprav, naznach);
//                Bilet_View(otprav, naznach);
                try {
                    Statement st = null;
                    String sql = "SELECT * FROM airlines.bilet_view WHERE airport_vilet = " + otprav + " AND nazv = " + naznach + "";
                    st.getConnection().createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Есть рейс!");
                        list3.clear();
                        reis_table.setVisible(true);
                        list3.add(new bilet_view(
                                rs.getInt("kod_vilet"),
                                rs.getInt("nomer_reis"),
                                rs.getString("airport_vilet"),
                                rs.getString("nazv"),
                                rs.getString("vremya_vilet"),
                                rs.getString("tip_airplace"),
                                rs.getFloat("stoimost")));
                    }
                    col_nomer_vilet.setCellValueFactory(new PropertyValueFactory<bilet_view, Integer>("col_nomer_vilet"));
                    col_num_reis.setCellValueFactory(new PropertyValueFactory<bilet_view, Integer>("col_num_reis"));
                    col_air_v.setCellValueFactory(new PropertyValueFactory<bilet_view, String>("col_air_v"));
                    col_air_n.setCellValueFactory(new PropertyValueFactory<bilet_view, String>("col_air_n"));
                    col_vremya_vilet.setCellValueFactory(new PropertyValueFactory<bilet_view, String>("col_vremya_vilet"));
                    col_tip_airplace.setCellValueFactory(new PropertyValueFactory<bilet_view, String>("col_tip_airplace"));
                    col_price.setCellValueFactory(new PropertyValueFactory<bilet_view, Float>("col_price"));
                    reis_table.setItems(list3);
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Нет данных в полях!");
            }
        });

//        Добавление записи в таблицу Пассажир (оформление билета).
        add_passager.setOnAction(event ->{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("fxml/addPassager.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
//        Удаление записи из таблицы Пассажир (удаление билета).

    }
    private void Bilet(String otprav, String naznach) {
        int i = 0;
        DatabaseHandler dbHandler = new DatabaseHandler();
        SelectViewBilet svb = new SelectViewBilet(otprav, naznach);
        svb.setAirport_vilet(otprav);
        svb.setNazv(naznach);
        ResultSet rs = dbHandler.getView_Bilet(svb);
    }

    private void Bilet_View(String otprav, String naznach) {
        try {
            DatabaseHandler dbHandler = new DatabaseHandler();
            SelectViewBilet svb = new SelectViewBilet(otprav, naznach);
            svb.setAirport_vilet(otprav);
            svb.setNazv(naznach);
            ResultSet rs = dbHandler.getView_Bilet(svb);
                    while (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Есть рейс!");
                        list3.clear();
                        reis_table.setVisible(true);
                        list3.add(new bilet_view(
                                rs.getInt("kod_vilet"),
                                rs.getInt("nomer_reis"),
                                rs.getString("airport_vilet"),
                                rs.getString("nazv"),
                                rs.getString("vremya_vilet"),
                                rs.getString("tip_airplace"),
                                rs.getFloat("stoimost")));
                    }
                    col_nomer_vilet.setCellValueFactory(new PropertyValueFactory<bilet_view, Integer>("col_nomer_vilet"));
                    col_num_reis.setCellValueFactory(new PropertyValueFactory<bilet_view, Integer>("col_num_reis"));
                    col_air_v.setCellValueFactory(new PropertyValueFactory<bilet_view, String>("col_air_v"));
                    col_air_n.setCellValueFactory(new PropertyValueFactory<bilet_view, String>("col_air_n"));
                    col_vremya_vilet.setCellValueFactory(new PropertyValueFactory<bilet_view, String>("col_vremya_vilet"));
                    col_tip_airplace.setCellValueFactory(new PropertyValueFactory<bilet_view, String>("col_tip_airplace"));
                    col_price.setCellValueFactory(new PropertyValueFactory<bilet_view, Float>("col_price"));
                    reis_table.setItems(list3);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}