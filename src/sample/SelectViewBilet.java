package sample;

public class SelectViewBilet {
    String airport_vilet;
    String nazv;

    public SelectViewBilet(String airport_vilet, String nazv) {
        this.airport_vilet = airport_vilet;
        this.nazv = nazv;
    }
    public String getAirport_vilet() {
        return airport_vilet;
    }

    public void setAirport_vilet(String airport_vilet) {
        this.airport_vilet = airport_vilet;
    }

    public String getNazv() {
        return nazv;
    }

    public void setNazv(String nazv) {
        this.nazv = nazv;
    }
}

