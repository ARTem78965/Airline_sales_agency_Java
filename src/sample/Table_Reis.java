package sample;

public class Table_Reis {
    private int col_id_reis;
    private int col_num_reis;
    private String col_air_v;
    private String col_air_n;
    private int col_prodolz;
    private int col_price;

    public Table_Reis(int col_id_reis, int col_num_reis, String col_air_v, String col_air_n, int col_prodolz, int col_price) {
        this.col_id_reis = col_id_reis;
        this.col_num_reis = col_num_reis;
        this.col_air_v = col_air_v;
        this.col_air_n = col_air_n;
        this.col_prodolz = col_prodolz;
        this.col_price = col_price;
    }

    public int getCol_id_reis() {
        return col_id_reis;
    }

    public void setCol_id_reis(int col_id_reis) {
        this.col_id_reis = col_id_reis;
    }

    public int getCol_num_reis() {
        return col_num_reis;
    }

    public void setCol_num_reis(int col_num_reis) {
        this.col_num_reis = col_num_reis;
    }

    public String getCol_air_v() {
        return col_air_v;
    }

    public void setCol_air_v(String col_air_v) {
        this.col_air_v = col_air_v;
    }

    public String getCol_air_n() {
        return col_air_n;
    }

    public void setCol_air_n(String col_air_n) {
        this.col_air_n = col_air_n;
    }

    public int getCol_prodolz() {
        return col_prodolz;
    }

    public void setCol_prodolz(int col_prodolz) {
        this.col_prodolz = col_prodolz;
    }

    public int getCol_price() {
        return col_price;
    }

    public void setCol_price(int col_price) {
        this.col_price = col_price;
    }
}