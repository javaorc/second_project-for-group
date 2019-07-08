package com.cskaoyan.bean;

public class SonPermission {
String id;
String label;

    @Override
    public String toString() {
        return "SonPermission{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
