package model;

public class Category {
    private int cal_id;
    private String cal_name;

    public Category() {
    }

    public Category(int cal_id, String cal_name) {
        this.cal_id = cal_id;
        this.cal_name = cal_name;
    }

    public Category(String cal_name) {
        this.cal_name = cal_name;
    }

    public int getCal_id() {
        return cal_id;
    }

    public void setCal_id(int cal_id) {
        this.cal_id = cal_id;
    }

    public String getCal_name() {
        return cal_name;
    }

    public void setCal_name(String cal_name) {
        this.cal_name = cal_name;
    }
}
