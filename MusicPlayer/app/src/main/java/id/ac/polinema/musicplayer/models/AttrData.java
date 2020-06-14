package id.ac.polinema.musicplayer.models;


import com.squareup.moshi.Json;

public class AttrData {

    @Json(name = "page")
    private String page;
    @Json(name = "perPage")
    private String perPage;
    @Json(name = "user")
    private String user;
    @Json(name = "total")
    private String total;
    @Json(name = "totalPages")
    private String totalPages;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public AttrData withPage(String page) {
        this.page = page;
        return this;
    }

    public String getPerPage() {
        return perPage;
    }

    public void setPerPage(String perPage) {
        this.perPage = perPage;
    }

    public AttrData withPerPage(String perPage) {
        this.perPage = perPage;
        return this;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public AttrData withUser(String user) {
        this.user = user;
        return this;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public AttrData withTotal(String total) {
        this.total = total;
        return this;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public AttrData withTotalPages(String totalPages) {
        this.totalPages = totalPages;
        return this;
    }

}