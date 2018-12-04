package com.example.alisher.medicineshop.entities;

public class Medicine {
    private int medicineID;
    private String name;
    private String description;
    private int quantity;
    private String medicineCode;
    private String img;
    private String use_in_case;
    private String contradication;
    private String price;

    public Medicine() {
    }

    public Medicine(int medicineID, String name, String description, int quantity, String medicineCode, String img, String use_in_case, String contradication, String price) {
        this.medicineID = medicineID;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.medicineCode = medicineCode;
        this.img = img;
        this.use_in_case = use_in_case;
        this.contradication = contradication;
        this.price = price;
    }

    public int getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(int medicineID) {
        this.medicineID = medicineID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUse_in_case() {
        return use_in_case;
    }

    public void setUse_in_case(String use_in_case) {
        this.use_in_case = use_in_case;
    }

    public String getContradication() {
        return contradication;
    }

    public void setContradication(String contradication) {
        this.contradication = contradication;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineID=" + medicineID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", medicineCode='" + medicineCode + '\'' +
                ", img='" + img + '\'' +
                ", use_in_case='" + use_in_case + '\'' +
                ", contradication='" + contradication + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
