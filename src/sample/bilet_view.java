package sample;

public class bilet_view {
            private int col_nomer_vilet;
            private int col_num_reis;
            private String col_air_v;
            private String col_air_n;
            private String col_vremya_vilet;
            private String col_tip_airplace;
            private Float col_price;

    public bilet_view(int col_nomer_vilet, int col_num_reis, String col_air_v, String col_air_n, String col_vremya_vilet, String col_tip_airplace, Float col_price) {
        this.col_nomer_vilet = col_nomer_vilet;
        this.col_num_reis = col_num_reis;
        this.col_air_v = col_air_v;
        this.col_air_n = col_air_n;
        this.col_vremya_vilet = col_vremya_vilet;
        this.col_tip_airplace = col_tip_airplace;
        this.col_price = col_price;
    }

    public int getCol_nomer_vilet() {
        return col_nomer_vilet;
    }

    public void setCol_nomer_vilet(int col_nomer_vilet) {
        this.col_nomer_vilet = col_nomer_vilet;
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

    public String getCol_vremya_vilet() {
        return col_vremya_vilet;
    }

    public void setCol_vremya_vilet(String col_vremya_vilet) {
        this.col_vremya_vilet = col_vremya_vilet;
    }

    public String getCol_tip_airplace() {
        return col_tip_airplace;
    }

    public void setCol_tip_airplace(String col_tip_airplace) {
        this.col_tip_airplace = col_tip_airplace;
    }

    public Float getCol_price() {
        return col_price;
    }

    public void setCol_price(Float col_price) {
        this.col_price = col_price;
    }
}
