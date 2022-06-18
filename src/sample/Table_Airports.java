package sample;

public class Table_Airports {
    private int col_id_airports;
    private String col_naz_airports;

    public Table_Airports(int col_id_airports, String col_naz_airports) {
        this.col_id_airports = col_id_airports;
        this.col_naz_airports = col_naz_airports;
    }

    public int getCol_id_airports() {
        return col_id_airports;
    }

    public void setCol_id_airports(int col_id_airports) {
        this.col_id_airports = col_id_airports;
    }

    public String getCol_naz_airports() {
        return col_naz_airports;
    }

    public void setCol_naz_airports(String col_naz_airports) {
        this.col_naz_airports = col_naz_airports;
    }
}
