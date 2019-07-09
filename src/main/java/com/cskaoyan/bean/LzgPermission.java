package com.cskaoyan.bean;

import java.util.List;

public class LzgPermission {
    String id;
    String label;
    int type;
    List<Children> children;

    @Override
    public String toString() {
        return "LzgPermission{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", type=" + type +
                ", children=" + children +
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }
}
