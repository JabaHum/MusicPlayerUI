package id.ac.polinema.musicplayer.models;

import com.squareup.moshi.Json;

import java.util.List;

public class Track {

    @Json(name = "@attr")
    private Attr attr;
    @Json(name = "duration")
    private String duration;
    @Json(name = "playcount")
    private String playcount;
    @Json(name = "artist")
    private Artist artist;
    @Json(name = "image")
    private List<Image> image = null;
    @Json(name = "streamable")
    private Streamable streamable;
    @Json(name = "mbid")
    private String mbid;
    @Json(name = "name")
    private String name;
    @Json(name = "url")
    private String url;

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    public Track withAttr(Attr attr) {
        this.attr = attr;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Track withDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public Track withPlaycount(String playcount) {
        this.playcount = playcount;
        return this;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Track withArtist(Artist artist) {
        this.artist = artist;
        return this;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public Track withImage(List<Image> image) {
        this.image = image;
        return this;
    }

    public Streamable getStreamable() {
        return streamable;
    }

    public void setStreamable(Streamable streamable) {
        this.streamable = streamable;
    }

    public Track withStreamable(Streamable streamable) {
        this.streamable = streamable;
        return this;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public Track withMbid(String mbid) {
        this.mbid = mbid;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Track withName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Track withUrl(String url) {
        this.url = url;
        return this;
    }

}