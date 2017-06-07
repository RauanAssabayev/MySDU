package com.ce.sdu.mysdu.model;

/**
 * Created by rauan on 06.06.2017.
 */

public class MessagesModel {
    String name;
    String version;
    String id_;
    int image;
    public MessagesModel(String name, String version, String id_) {
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

    public String getId() {
        return id_;
    }
}