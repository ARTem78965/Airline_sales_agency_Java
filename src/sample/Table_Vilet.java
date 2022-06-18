package sample;

public class Table_Vilet {
    private int col_id_vilet, col_reis;
    private String col_time_v, col_place, col_comand_akipa;

    public Table_Vilet(int col_id_vilet, int col_reis, String col_time_v, String col_place, String col_comand_akipa) {
        this.col_id_vilet = col_id_vilet;
        this.col_reis = col_reis;
        this.col_time_v = col_time_v;
        this.col_place = col_place;
        this.col_comand_akipa = col_comand_akipa;
    }

    public int getCol_id_vilet() {
        return col_id_vilet;
    }

    public void setCol_id_vilet(int col_id_vilet) {
        this.col_id_vilet = col_id_vilet;
    }

    public int getCol_reis() {
        return col_reis;
    }

    public void setCol_reis(int col_reis) {
        this.col_reis = col_reis;
    }

    public String getCol_time_v() {
        return col_time_v;
    }

    public void setCol_time_v(String col_time_v) {
        this.col_time_v = col_time_v;
    }

    public String getCol_place() {
        return col_place;
    }

    public void setCol_place(String col_place) {
        this.col_place = col_place;
    }

    public String getCol_comand_akipa() {
        return col_comand_akipa;
    }

    public void setCol_comand_akipa(String col_comand_akipa) {
        this.col_comand_akipa = col_comand_akipa;
    }
}
