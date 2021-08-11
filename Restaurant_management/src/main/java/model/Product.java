package model;

public class Product {
    private int p_id;
    private String p_name;
    private int p_price;
    private String p_description;
    private String p_image;
    private int cal_id;

    public Product() {
    }

    public Product(String p_name, int p_price, String p_description, String p_image, int cal_id) {
        this.p_name = p_name;
        this.p_price = p_price;
        this.p_description = p_description;
        this.p_image = p_image;
        this.cal_id = cal_id;
    }

    public Product(int p_id, String p_name, int p_price, String p_description, String p_image, int cal_id) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_price = p_price;
        this.p_description = p_description;
        this.p_image = p_image;
        this.cal_id = cal_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getP_price() {
        return p_price;
    }

    public void setP_price(int p_price) {
        this.p_price = p_price;
    }

    public String getP_description() {
        return p_description;
    }

    public void setP_description(String p_description) {
        this.p_description = p_description;
    }

    public String getP_image() {
        return p_image;
    }

    public void setP_image(String p_image) {
        this.p_image = p_image;
    }

    public int getCal_id() {
        return cal_id;
    }

    public void setCal_id(int cal_id) {
        this.cal_id = cal_id;
    }
}
