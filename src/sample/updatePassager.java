package sample;

public class updatePassager {
    private int kod_passager;
    private int vilet;
    private int nomer_mesta;
    private String FIO;
    private String passport;

    public updatePassager(int kod_passager, int vilet, int nomer_mesta, String FIO, String passport) {
        this.kod_passager = kod_passager;
        this.vilet = vilet;
        this.nomer_mesta = nomer_mesta;
        this.FIO = FIO;
        this.passport = passport;
    }

    public int getKod_passager() {
        return kod_passager;
    }

    public void setKod_passager(int kod_passager) {
        this.kod_passager = kod_passager;
    }

    public int getVilet() {
        return vilet;
    }

    public void setVilet(int vilet) {
        this.vilet = vilet;
    }

    public int getNomer_mesta() {
        return nomer_mesta;
    }

    public void setNomer_mesta(int nomer_mesta) {
        this.nomer_mesta = nomer_mesta;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
