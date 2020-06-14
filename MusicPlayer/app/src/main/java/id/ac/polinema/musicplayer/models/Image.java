package id.ac.polinema.musicplayer.models;

import com.squareup.moshi.Json;

public class Image {

    @Json(name = "size")
    private String size;
    @Json(name = "#text")
    private String text;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Image withSize(String size) {
        this.size = size;
        return this;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Image withText(String text) {
        this.text = text;
        return this;
    }

}