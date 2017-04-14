package com.ce.sdu.mysdu.model;

/**
 * Created by rauan on 07.04.2017.
 */

public class DataModel {

    String name;
    String version;
    int id_;
    int image;

    public DataModel(String name, String version, int id_) {
        this.name = name;
        this.version = version;
        this.id_ = id_;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public int getId() {
        return id_;
    }
}
