package sample;

public class addVilet {
    private int reis;
    private String vremya_vilet;
    private int airplace;
    private String commandir_akipad;

    public addVilet(int reis, String vremya_vilet, int airplace, String commandir_akipad) {
        this.reis = reis;
        this.vremya_vilet = vremya_vilet;
        this.airplace = airplace;
        this.commandir_akipad = commandir_akipad;
    }

    public addVilet() {

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
