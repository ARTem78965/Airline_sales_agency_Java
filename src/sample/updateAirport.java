package sample;

public class updateAirport {
    private int kod_airport;
    private String nazv;

    public updateAirport(int kod_airport, String nazv) {
        this.kod_airport = kod_airport;
        this.nazv = nazv;
    }

    public int getKod_airport() {
        return kod_airport;
    }

    public void setKod_airport(int kod_airport) {
        this.kod_airport = kod_airport;
    }

    public String getNazv() {
        return nazv;
    }

    public void setNazv(String nazv) {
        this.nazv = nazv;
    }
}

