package sample;

public class Table_Airplace {
    private int col_id_airplace;
    private  String col_tip_airplace, col_kol_mest, col_polet;

    public Table_Airplace(int col_id_airplace, String col_tip_airplace, String col_kol_mest, String col_polet) {
        this.col_id_airplace = col_id_airplace;
        this.col_tip_airplace = col_tip_airplace;
        this.col_kol_mest = col_kol_mest;
        this.col_polet = col_polet;
    }

    public int getCol_id_airplace() {
        return col_id_airplace;
    }

    public void setCol_id_airplace(int col_id_airplace) {
        this.col_id_airplace = col_id_airplace;
    }

    public String getCol_tip_airplace() {
        return col_tip_airplace;
    }

    public void setCol_tip_airplace(String col_tip_airplace) {
        this.col_tip_airplace = col_tip_airplace;
    }

    public String getCol_kol_mest() {
        return col_kol_mest;
    }

    public void setCol_kol_mest(String col_kol_mest) {
        this.col_kol_mest = col_kol_mest;
    }

    public String getCol_polet() {
        return col_polet;
    }

    public void setCol_polet(String col_polet) {
        this.col_polet = col_polet;
    }
}
