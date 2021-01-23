package com.example.listepatisserie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Patisserie implements Parcelable {
    int id;
    float prix;
    Drawable img;
    String name;
    String detail;

    @Override
    public String toString() {
        return "Patisserie{" +
                "id=" + id +
                ", prix=" + prix +
                ", img=" + img +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    public Patisserie(int id, float prix, Drawable img, String name, String detail) {
        this.id = id;
        this.prix = prix;
        this.img = img;
        this.name = name;
        this.detail = detail;
    }

    public Patisserie(Parcel source) {
        this.id = source.readInt();
        this.name = source.readString();
        this.detail = source.readString();
        this.prix = source.readFloat();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(detail);
        dest.writeFloat(prix);
    }

    public static final Parcelable.Creator<Patisserie> CREATOR = new Parcelable.Creator<Patisserie>() {

        @Override
        public Patisserie createFromParcel(Parcel source) {
            return new Patisserie(source);
        }

        @Override
        public Patisserie[] newArray(int size) {
            return new Patisserie[size];
        }
    };
}
