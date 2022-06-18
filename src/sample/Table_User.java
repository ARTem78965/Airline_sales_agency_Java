package sample;

public class Table_User {
    private int col_id;
    private String col_fam, col_nam, col_otch, col_pho, col_role, col_log, col_pass;

    public Table_User(int col_id, String col_fam, String col_nam, String col_otch, String col_pho, String col_role, String col_log, String col_pass) {
        this.col_id = col_id;
        this.col_fam = col_fam;
        this.col_nam = col_nam;
        this.col_otch = col_otch;
        this.col_pho = col_pho;
        this.col_role = col_role;
        this.col_log = col_log;
        this.col_pass = col_pass;
    }

    public int getCol_id() {
        return col_id;
    }

    public void setCol_id(int col_id) {
        this.col_id = col_id;
    }

    public String getCol_fam() {
        return col_fam;
    }

    public void setCol_fam(String col_fam) {
        this.col_fam = col_fam;
    }

    public String getCol_nam() {
        return col_nam;
    }

    public void setCol_nam(String col_nam) {
        this.col_nam = col_nam;
    }

    public String getCol_otch() {
        return col_otch;
    }

    public void setCol_otch(String col_otch) {
        this.col_otch = col_otch;
    }

    public String getCol_pho() {
        return col_pho;
    }

    public void setCol_pho(String col_pho) {
        this.col_pho = col_pho;
    }

    public String getCol_role() {
        return col_role;
    }

    public void setCol_role(String col_role) {
        this.col_role = col_role;
    }

    public String getCol_log() {
        return col_log;
    }

    public void setCol_log(String col_log) {
        this.col_log = col_log;
    }

    public String getCol_pass() {
        return col_pass;
    }

    public void setCol_pass(String col_pass) {
        this.col_pass = col_pass;
    }
}
