package id.ac.polinema.musicplayer.models;

import com.squareup.moshi.Json;

public class Artist {

    @Json(name = "url")
    private String url;
    @Json(name = "name")
    private String name;
    @Json(name = "mbid")
    private String mbid;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Artist withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist withName(String name) {
        this.name = name;
        return this;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public Artist withMbid(String mbid) {
        this.mbid = mbid;
        return this;
    }

}