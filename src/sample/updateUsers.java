package sample;

public class updateUsers {
    private int Kod_users;
    private String Fam;
    private String Nam;
    private String Otch;
    private String Pho;
    private String Log;
    private String Pass;

    public updateUsers(int kod_users, String fam, String nam, String otch, String pho, String log, String pass) {
        Kod_users = kod_users;
        Fam = fam;
        Nam = nam;
        Otch = otch;
        Pho = pho;
        Log = log;
        Pass = pass;
    }

    public int getKod_users() {
        return Kod_users;
    }

    public void setKod_users(int kod_users) {
        Kod_users = kod_users;
    }

    public String getFam() {
        return Fam;
    }

    public void setFam(String fam) {
        Fam = fam;
    }

    public String getNam() {
        return Nam;
    }

    public void setNam(String nam) {
        Nam = nam;
    }

    public String getOtch() {
        return Otch;
    }

    public void setOtch(String otch) {
        Otch = otch;
    }

    public String getPho() {
        return Pho;
    }

    public void setPho(String pho) {
        Pho = pho;
    }

    public String getLog() {
        return Log;
    }

    public void setLog(String log) {
        Log = log;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
