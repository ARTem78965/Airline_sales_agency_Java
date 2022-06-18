package sample;

import java.sql.*;

public class DatabaseHandler {
    public static Connection getDbCon()
            throws ClassNotFoundException, SQLException {
        String connectionString = ("jdbc:mysql://localhost:3306/airlines");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection dbCon = DriverManager.getConnection(connectionString, "root", "A331166a");

        return dbCon;
    }

    //             Проверка пользователя из таблицы USERS для Авторизация.
    public ResultSet getUser(addUser user) {
        ResultSet rs = null;
        String select = "SELECT * FROM users WHERE log =? AND pass =? AND rol =?";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(select);
            prSt.setString(1, user.getLog());
            prSt.setString(2, user.getPass());
            prSt.setString(3, user.getRole());
            rs = prSt.executeQuery();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return rs;
    }

    //             Проверка VIEW_VILET.
    public ResultSet getView_Bilet(SelectViewBilet svb){
        ResultSet rs = null;
        String select_view = "SELECT * FROM bilet_view WHERE airport_vilet = ? AND nazv = ?";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(select_view);
            prSt.setString(1,svb.getAirport_vilet());
            prSt.setString(2,svb.getNazv());
            rs = prSt.executeQuery();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }


    //             Добавление записи в таблицу USERS.
    public void singUpUser(addUser adduser) {
        String insert = "INSERT INTO users (fam, nam, otch, pho, rol, log, pass)" + " VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(insert);
            prSt.setString(1, adduser.getFam());
            prSt.setString(2, adduser.getNam());
            prSt.setString(3, adduser.getOtch());
            prSt.setString(4, adduser.getPho());
            prSt.setString(5, adduser.getRole());
            prSt.setString(6, adduser.getLog());
            prSt.setString(7, adduser.getPass());

            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //            Добавление записи в даблицу AIRPORT.
    public void addAirport(addAirport addairport) {
        String insert = "INSERT INTO airport (nazv)" + " VALUES(?)";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(insert);
            prSt.setString(1, addairport.getNazv());
            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //            Добавление записи в даблицу REIS.
    public void addReis(addReis addreis) {
        String insert = "INSERT INTO reis (nomer_reis, airport_vilet, airport_naznach, prodolz, stoimost)" + " VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(insert);
            prSt.setInt(1, addreis.getNomer_reis());
            prSt.setString(2, addreis.getAirport_vilet());
            prSt.setInt(3, addreis.getAirport_naznach());
            prSt.setInt(4, addreis.getProdolz());
            prSt.setFloat(5, addreis.getStoimost());

            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //    Добавление записи в даблицу AIRPLACE.
    public void addAiplace(addAirplace addairplace) {
        String insert = "INSERT INTO airplace (tip_airplace, kol_mest, dal_pol)" + " VALUES(?,?,?)";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(insert);
            prSt.setString(1, addairplace.getTip_airplace());
            prSt.setInt(2, addairplace.getKol_mest());
            prSt.setInt(3, addairplace.getDal_pol());

            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //    Добавление записи в даблицу VILET.
    public void addVilet(addVilet addvilet) {
        String insert = "INSERT INTO vilet (reis, vremya_vilet, airplace, commandir_akipad)" + " VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(insert);
            prSt.setInt(1, addvilet.getReis());
            prSt.setString(2, addvilet.getVremya_vilet());
            prSt.setInt(3, addvilet.getAirplace());
            prSt.setString(4, addvilet.getCommandir_akipad());

            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //    Добавление записи в даблицу PASSAGER.
    public void addPassager(addPassager addpassager) {
        String insert = "INSERT INTO passager (vilet, nomer_mesta, FIO, passport)" + " VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(insert);
            prSt.setInt(1, addpassager.getVilet());
            prSt.setInt(2, addpassager.getNomer_mesta());
            prSt.setString(3, addpassager.getFIO());
            prSt.setString(4, addpassager.getPassport());

            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    //    Изменение записи в таблице USERS.
    public void updateUser(updateUsers upusers) {
        String update = "UPDATE users SET fam = ?, nam = ?, otch = ?, pho = ?, log = ?, pass = ?  WHERE kod_users = ?";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(update);
            prSt.setString(1, upusers.getFam());
            prSt.setString(2, upusers.getNam());
            prSt.setString(3, upusers.getOtch());
            prSt.setString(4, upusers.getPho());
            prSt.setString(5, upusers.getLog());
            prSt.setString(6, upusers.getPass());
            prSt.setInt(7, upusers.getKod_users());
            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //    Изменение записи в таблице AIRPORT.
    public void updateAirport(updateAirport upairport) {
        String update = "UPDATE airport SET nazv = ? WHERE kod_airport = ?";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(update);
            prSt.setString(1,upairport.getNazv());
            prSt.setInt(2, upairport.getKod_airport());
            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //    Изменение записи в таблице REIS.
    public void updateReis(updateReis upreis) {
        String update = "UPDATE reis SET nomer_reis = ?, airport_vilet = ?, airport_naznach = ?, prodolz = ?, stoimost = ? WHERE kod_reis = ?";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(update);
            prSt.setInt(1, upreis.getNomer_reis());
            prSt.setString(2, upreis.getAirport_vilet());
            prSt.setInt(3, upreis.getAirport_naznach());
            prSt.setInt(4, upreis.getProdolz());
            prSt.setFloat(5, upreis.getStoimost());
            prSt.setInt(6, upreis.getKod_reis());
            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //    Изменение записи в таблице AIRPLACE.
    public void updateAirplace(updateAiplace upaiplace) {
        String update = "UPDATE airplace SET tip_airplace = ?, kol_mest = ?, dal_pol = ? WHERE kod_airplace = ?";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(update);
            prSt.setString(1, upaiplace.getTip_airplace());
            prSt.setInt(2, upaiplace.getKol_mest());
            prSt.setInt(3, upaiplace.getDal_pol());
            prSt.setInt(4, upaiplace.getKod_airplace());
            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //    Изменение записи в таблице VILET.
    public void updateVilet(updateVilet upvilet) {
        String update = "UPDATE vilet SET reis = ?, vremya_vilet = ?, airplace = ?, commandir_akipad = ? WHERE kod_vilet = ?";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(update);
            prSt.setInt(1, upvilet.getReis());
            prSt.setString(2, upvilet.getVremya_vilet());
            prSt.setInt(3, upvilet.getAirplace());
            prSt.setString(4, upvilet.getCommandir_akipad());
            prSt.setInt(5, upvilet.getKod_vilet());
            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //    Изменение записи в таблице PASSAGER.
    public void updatePassager(updatePassager uppassager) {
        String update = "UPDATE passager SET nomer_mesta = ?, FIO = ?, passport = ? WHERE kod_pass = ?";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(update);
            prSt.setInt(1, uppassager.getNomer_mesta());
            prSt.setString(2, uppassager.getFIO());
            prSt.setString(3, uppassager.getPassport());
            prSt.setInt(4, uppassager.getKod_passager());
            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    //    Удаление записи в таблице USERS.
    public void deleteUsers(delUsers dlusers) {
        String update = "DELETE FROM users WHERE kod_users = ?";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(update);
            prSt.setInt(1, dlusers.getKod_users());

            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //    Удаление записи в таблице AIRPORT.
    public void deleteAiport(deleteAirport delairport) {
        String update = "DELETE FROM airport WHERE kod_airport = ?";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(update);
            prSt.setInt(1, delairport.getKod_airport());

            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //    Удаление записи в таблице REIS.
    public void deleteReis(deleteReis delreis) {
        String update = "DELETE FROM reis WHERE kod_reis = ?";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(update);
            prSt.setInt(1, delreis.getKod_reis());

            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //    Удаление записи в таблице AIRPLACE.
    public void deleteAirplace(deleteAirplace delairplace) {
        String update = "DELETE FROM airplace WHERE kod_airplace = ?";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(update);
            prSt.setInt(1, delairplace.getKod_airplace());

            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //    Удаление записи в таблице VILET.
    public void deleteVilet(deleteVilet delvilet) {
        String update = "DELETE FROM vilet WHERE kod_vilet = ?";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(update);
            prSt.setInt(1, delvilet.getKod_vilet());

            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //    Удаление записи в таблице PASSAGER.
    public void deletePassager(deletePassager delpassager) {
        String update = "DELETE FROM passager WHERE kod_pass = ?";
        try {
            PreparedStatement prSt = getDbCon().prepareStatement(update);
            prSt.setInt(1, delpassager.getKod_passager());

            prSt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}


