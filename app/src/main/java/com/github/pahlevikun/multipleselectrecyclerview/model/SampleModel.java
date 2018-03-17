package com.github.pahlevikun.multipleselectrecyclerview.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by farhan on 3/17/18.
 */

public class SampleModel implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nama);
    }

    protected SampleModel(Parcel in) {
        this.id = in.readInt();
        this.nama = in.readString();
    }

    public static final Parcelable.Creator<SampleModel> CREATOR = new Parcelable.Creator<SampleModel>() {
        @Override
        public SampleModel createFromParcel(Parcel source) {
            return new SampleModel(source);
        }

        @Override
        public SampleModel[] newArray(int size) {
            return new SampleModel[size];
        }
    };
}
