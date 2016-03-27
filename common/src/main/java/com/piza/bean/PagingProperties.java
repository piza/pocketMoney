package com.piza.bean;

public class PagingProperties {

    private int page=0;

    private int perPage=10;

    private int total;

    private Boolean needPaging = true;

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getPerPage() {
        return perPage;
    }
    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    public int getStart(){
        if(page<=1){
            return 0;
        }
        else{
            return (page-1)*perPage;
        }
    }

    public String build(){
        return " limit "+this.getStart()+","+this.getPerPage();
    }
    @Override
    public String toString() {
        return "PagingProperties [page=" + page + ", perPage=" + perPage
                + ", total=" + total + "]";
    }

    public Boolean getNeedPaging() {
        return needPaging;
    }

    public void setNeedPaging(Boolean needPaging) {
        this.needPaging = needPaging;
    }
}

