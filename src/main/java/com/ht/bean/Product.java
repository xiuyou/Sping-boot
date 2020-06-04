package com.ht.bean;

/**
 * Created by Administrator on 2020/4/26.
 */
public class Product {
    private int id;
    private String pname;
    private float price1;
    private float price2;
    private int pcount;
    private int psale;
    private int pcomment;
    private String pimg;
    private String pdetail;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", price1=" + price1 +
                ", price2=" + price2 +
                ", pcount=" + pcount +
                ", psale=" + psale +
                ", pcomment=" + pcomment +
                ", pimg='" + pimg + '\'' +
                ", pdetial='" + pdetail + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public float getPrice1() {
        return price1;
    }

    public void setPrice1(float price1) {
        this.price1 = price1;
    }

    public float getPrice2() {
        return price2;
    }

    public void setPrice2(float price2) {
        this.price2 = price2;
    }

    public int getPcount() {
        return pcount;
    }

    public void setPcount(int pcount) {
        this.pcount = pcount;
    }

    public int getPsale() {
        return psale;
    }

    public void setPsale(int psale) {
        this.psale = psale;
    }

    public int getPcomment() {
        return pcomment;
    }

    public void setPcomment(int pcomment) {
        this.pcomment = pcomment;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public String getPdetail() {
        return pdetail;
    }

    public void setPdetail(String pdetail) {
        this.pdetail = pdetail;
    }
}
