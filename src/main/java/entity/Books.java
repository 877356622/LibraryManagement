package entity;

public class Books {
    private String b_id;
    private String bk_id;
    private String b_name;
    private String b_desc;
    private String b_author;
    private String b_edit;
    private double b_price;
    private int b_number;

    public int getB_number() {
        return b_number;
    }

    public void setB_number(int b_number) {
        this.b_number = b_number;
    }

    public String getB_id() {
        return b_id;
    }

    public void setB_id(String b_id) {
        this.b_id = b_id;
    }

    public String getBk_id() {
        return bk_id;
    }

    public void setBk_id(String bk_id) {
        this.bk_id = bk_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getB_desc() {
        return b_desc;
    }

    public void setB_desc(String b_desc) {
        this.b_desc = b_desc;
    }

    public String getB_author() {
        return b_author;
    }

    public void setB_author(String b_author) {
        this.b_author = b_author;
    }

    public String getB_edit() {
        return b_edit;
    }

    public void setB_edit(String b_edit) {
        this.b_edit = b_edit;
    }

    public double getB_price() {
        return b_price;
    }

    public void setB_price(double b_price) {
        this.b_price = b_price;
    }
}
