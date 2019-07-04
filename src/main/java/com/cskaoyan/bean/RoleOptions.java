package com.cskaoyan.bean;

public class RoleOptions {
    int value;
    String label;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "RoleOptions{" +
                "value=" + value +
                ", label='" + label + '\'' +
                '}';
    }
}
