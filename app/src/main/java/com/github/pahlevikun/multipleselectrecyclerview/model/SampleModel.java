package com.github.pahlevikun.multipleselectrecyclerview.model;

/**
 * Created by farhan on 3/17/18.
 */

public class SampleModel {
    private int id;
    private String nama;

    public SampleModel() {
    }

    public SampleModel(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
