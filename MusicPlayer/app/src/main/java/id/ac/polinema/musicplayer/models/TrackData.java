package id.ac.polinema.musicplayer.models;

import com.squareup.moshi.Json;

import org.w3c.dom.Attr;

import java.util.List;

public class TrackData {

    @Json(name = "@attr")
    private String attr;
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

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public TrackData withAttr(String attr) {
        this.attr = attr;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public TrackData withDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public TrackData withPlaycount(String playcount) {
        this.playcount = playcount;
        return this;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public TrackData withArtist(Artist artist) {
        this.artist = artist;
        return this;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public TrackData withImage(List<Image> image) {
        this.image = image;
        return this;
    }

    public Streamable getStreamable() {
        return streamable;
    }

    public void setStreamable(Streamable streamable) {
        this.streamable = streamable;
    }

    public TrackData withStreamable(Streamable streamable) {
        this.streamable = streamable;
        return this;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public TrackData withMbid(String mbid) {
        this.mbid = mbid;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrackData withName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TrackData withUrl(String url) {
        this.url = url;
        return this;
    }

}