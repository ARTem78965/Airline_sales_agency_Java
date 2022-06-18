package sample;

public class addUser {
    private String Fam;
    private String Nam;
    private String Otch;
    private String Pho;
    private String Role;
    private String Log;
    private String Pass;

    public addUser(String fam, String nam, String otch, String pho, String role, String log, String pass) {
        Fam = fam;
        Nam = nam;
        Otch = otch;
        Pho = pho;
        Role = role;
        Log = log;
        Pass = pass;
    }

    public addUser() {

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

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
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

    public String setPass(String pass) {
        Pass = pass;
        return pass;
    }
}
