package com.cskaoyan.bean.vo;

import com.cskaoyan.bean.Brand;

import java.util.List;

public class BrandQuery {

    private Integer totalPages;

    private List<Brand> brandList;

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public BrandQuery() {
    }

    public BrandQuery(Integer totalPages, List<Brand> brandList) {
        this.totalPages = totalPages;
        this.brandList = brandList;
    }

}
