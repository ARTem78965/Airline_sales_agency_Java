package sample;

public class updateAiplace {
    private  int kod_airplace;
    private String tip_airplace;
    private int kol_mest;
    private int dal_pol;

    public updateAiplace(int kod_airplace, String tip_airplace, int kol_mest, int dal_pol) {
        this.kod_airplace = kod_airplace;
        this.tip_airplace = tip_airplace;
        this.kol_mest = kol_mest;
        this.dal_pol = dal_pol;
    }

    public int getKod_airplace() {
        return kod_airplace;
    }

    public void setKod_airplace(int kod_airplace) {
        this.kod_airplace = kod_airplace;
    }

    public String getTip_airplace() {
        return tip_airplace;
    }

    public void setTip_airplace(String tip_airplace) {
        this.tip_airplace = tip_airplace;
    }

    public int getKol_mest() {
        return kol_mest;
    }

    public void setKol_mest(int kol_mest) {
        this.kol_mest = kol_mest;
    }

    public int getDal_pol() {
        return dal_pol;
    }

    public void setDal_pol(int dal_pol) {
        this.dal_pol = dal_pol;
    }
}
