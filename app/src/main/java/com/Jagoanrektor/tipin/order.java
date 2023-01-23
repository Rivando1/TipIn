package com.Jagoanrektor.tipin;

public class order {
    private String key;

    private String nama;
    private String haritanggal;
    private String note;
    private String other;
    private String salary;

    public order(){

    }

    public order(String nama, String haritanggal, String note, String other, String salary) {
        this.nama = nama;
        this.haritanggal = haritanggal;
        this.note = note;
        this.other = other;
        this.salary = salary;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHaritanggal() {
        return haritanggal;
    }

    public void setHaritanggal(String haritanggal) {
        this.haritanggal = haritanggal;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
