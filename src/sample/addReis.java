package sample;

public class addReis {
    private int nomer_reis;
    private String airport_vilet;
    private int airport_naznach;
    private int prodolz;
    private float stoimost;

    public addReis(int nomer_reis, String airport_vilet, int airport_naznach, int prodolz, float stoimost) {
        this.nomer_reis = nomer_reis;
        this.airport_vilet = airport_vilet;
        this.airport_naznach = airport_naznach;
        this.prodolz = prodolz;
        this.stoimost = stoimost;
    }

    public addReis() {

    }

    public int getNomer_reis() {
        return nomer_reis;
    }

    public void setNomer_reis(int nomer_reis) {
        this.nomer_reis = nomer_reis;
    }

    public String getAirport_vilet() {
        return airport_vilet;
    }

    public void setAirport_vilet(String airport_vilet) {
        this.airport_vilet = airport_vilet;
    }

    public int getAirport_naznach() {
        return airport_naznach;
    }

    public void setAirport_naznach(int airport_naznach) {
        this.airport_naznach = airport_naznach;
    }

    public int getProdolz() {
        return prodolz;
    }

    public void setProdolz(int prodolz) {
        this.prodolz = prodolz;
    }

    public float getStoimost() {
        return stoimost;
    }

    public void setStoimost(float stoimost) {
        this.stoimost = stoimost;
    }
}
