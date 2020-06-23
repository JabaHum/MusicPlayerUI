package id.ac.polinema.musicplayer.models;

import com.squareup.moshi.Json;

public class Streamable {

    @Json(name = "fulltrack")
    private String fulltrack;
    @Json(name = "#text")
    private String text;


    public String getFulltrack() {
        return fulltrack;
    }

    public void setFulltrack(String fulltrack) {
        this.fulltrack = fulltrack;
    }

    public Streamable withFulltrack(String fulltrack) {
        this.fulltrack = fulltrack;
        return this;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Streamable withText(String text) {
        this.text = text;
        return this;
    }


}