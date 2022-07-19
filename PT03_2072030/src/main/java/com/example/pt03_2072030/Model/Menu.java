package com.example.pt03_2072030.Model;

public class Menu {
    private String nama;
    private float harga;
    private float discount;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Menu(String nama, float harga, float discount) {
        this.nama = nama;
        this.harga = harga;
        this.discount = discount;
    }

    @Override
    public String toString() {
        if (discount != 0) {
            return nama + " " + (harga - (harga * (discount/100))) + " (original price : " +  harga + ") Discount : " + discount + "%";
        } else if (harga != 0) {
            return nama + " " + harga;
        } else {
            return nama + "";
        }
    }
}
