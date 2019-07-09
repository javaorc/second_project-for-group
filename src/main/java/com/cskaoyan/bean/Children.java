package com.cskaoyan.bean;

import java.util.List;

public class Children {
    String id;
    String label;
    List<SonPermission> children;

    @Override
    public String toString() {
        return "Children{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
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

    public List<SonPermission> getChildren() {
        return children;
    }

    public void setChildren(List<SonPermission> children) {
        this.children = children;
    }
}
