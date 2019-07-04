package com.cskaoyan.bean;

import java.util.List;

public class Province {
    private Integer id;

    private String  name;

    private Byte    type;

    private Integer code;

    private List<City> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<City> getChildren() {
        return children;
    }

    public void setChildren(List<City> children) {
        this.children = children;
    }


}
