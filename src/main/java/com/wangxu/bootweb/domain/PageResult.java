package com.wangxu.bootweb.domain;

import java.util.List;

public class PageResult<T> {
    private int page;
    private int pageSize;
    private int totalPage;
    private long totalSize;
    private List<T> list;

    public PageResult(int page, int pageSize, int totalPage, long totalSize, List<T> list) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalSize = totalSize;
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
