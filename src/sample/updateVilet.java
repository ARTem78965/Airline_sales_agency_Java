package sample;

public class updateVilet {
    private int kod_vilet;
    private int reis;
    private String vremya_vilet;
    private int airplace;
    private String commandir_akipad;

    public updateVilet(int kod_vilet, int reis, String vremya_vilet, int airplace, String commandir_akipad) {
        this.kod_vilet = kod_vilet;
        this.reis = reis;
        this.vremya_vilet = vremya_vilet;
        this.airplace = airplace;
        this.commandir_akipad = commandir_akipad;
    }

    public int getKod_vilet() {
        return kod_vilet;
    }

    public void setKod_vilet(int kod_vilet) {
        this.kod_vilet = kod_vilet;
    }

    public int getReis() {
        return reis;
    }

    public void setReis(int reis) {
        this.reis = reis;
    }

    public String getVremya_vilet() {
        return vremya_vilet;
    }

    public void setVremya_vilet(String vremya_vilet) {
        this.vremya_vilet = vremya_vilet;
    }

    public int getAirplace() {
        return airplace;
    }

    public void setAirplace(int airplace) {
        this.airplace = airplace;
    }

    public String getCommandir_akipad() {
        return commandir_akipad;
    }

    public void setCommandir_akipad(String commandir_akipad) {
        this.commandir_akipad = commandir_akipad;
    }
}
