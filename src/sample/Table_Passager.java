package sample;

public class Table_Passager {
    private int col_id_pass;
    private int col_vilet;
    private String col_num_mesta;
    private String col_FIO;
    private String col_passport;

    public Table_Passager(int col_id_pass, int col_vilet, String col_num_mesta, String col_FIO, String col_passport) {
        this.col_id_pass = col_id_pass;
        this.col_vilet = col_vilet;
        this.col_passport = col_passport;
        this.col_num_mesta = col_num_mesta;
        this.col_FIO = col_FIO;
    }


    public int getCol_id_pass() {
        return col_id_pass;
    }

    public void setCol_id_pass(int col_id_pass) {
        this.col_id_pass = col_id_pass;
    }

    public int getCol_vilet() {
        return col_vilet;
    }

    public void setCol_vilet(int col_vilet) {
        this.col_vilet = col_vilet;
    }

    public String getCol_num_mesta() {
        return col_num_mesta;
    }

    public void setCol_num_mesta(String col_num_mesta) {
        this.col_num_mesta = col_num_mesta;
    }

    public String getCol_FIO() {
        return col_FIO;
    }

    public void setCol_FIO(String col_FIO) {
        this.col_FIO = col_FIO;
    }

    public String getCol_passport() {
        return col_passport;
    }

    public void setCol_passport(String col_passport) {
        this.col_passport = col_passport;
    }
}
