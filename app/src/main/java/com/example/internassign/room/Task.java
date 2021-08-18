package com.example.internassign.room;

import android.net.LinkAddress;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "taii")
public class Task implements Serializable {


    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "agency")
    private String agency;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "wikipedia")
    private String wikipedia;

    @ColumnInfo(name = "launches")
    private String launches;

    @ColumnInfo(name = "status")
    private String status;

    @PrimaryKey(autoGenerate = true )
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getLaunches() {
        return launches;
    }

    public void setLaunches(String launches) {
        this.launches = launches;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
