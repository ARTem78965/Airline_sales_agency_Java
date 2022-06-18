package sample;

public class personalPassager {
    String vilet;
    String date_time_vilet;
    String naznach;
    String date_time_naznach;

    public personalPassager(String vilet, String date_time_vilet, String naznach, String date_time_naznach) {
        this.vilet = vilet;
        this.date_time_vilet = date_time_vilet;
        this.naznach = naznach;
        this.date_time_naznach = date_time_naznach;
    }

    public String getVilet() {
        return vilet;
    }

    public void setVilet(String vilet) {
        this.vilet = vilet;
    }

    public String getDate_time_vilet() {
        return date_time_vilet;
    }

    public void setDate_time_vilet(String date_time_vilet) {
        this.date_time_vilet = date_time_vilet;
    }

    public String getNaznach() {
        return naznach;
    }

    public void setNaznach(String naznach) {
        this.naznach = naznach;
    }

    public String getDate_time_naznach() {
        return date_time_naznach;
    }

    public void setDate_time_naznach(String date_time_naznach) {
        this.date_time_naznach = date_time_naznach;
    }
}
