package com.cskaoyan.bean.vo;

public class QueryCommentList<T> {

    private T data;

    private int count;

    private int currentPage;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public QueryCommentList() {

    }

    public QueryCommentList(T data, int count, int currentPage) {
        this.data = data;
        this.count = count;
        this.currentPage = currentPage;
    }

}
