package entity;

import java.sql.Date;

public class Borrows {
    private String br_id;
    private String b_id;
    private String u_id;
    private Date br_date;
    private Date re_date;

    public String getBr_id() {
        return br_id;
    }

    public void setBr_id(String br_id) {
        this.br_id = br_id;
    }

    public String getB_id() {
        return b_id;
    }

    public void setB_id(String b_id) {
        this.b_id = b_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public Date getBr_date() {
        return br_date;
    }

    public void setBr_date(Date br_date) {
        this.br_date = br_date;
    }

    public Date getRe_date() {
        return re_date;
    }

    public void setRe_date(Date re_date) {
        this.re_date = re_date;
    }
}
