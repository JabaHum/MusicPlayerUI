package id.ac.polinema.musicplayer.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artists {

    @SerializedName("artist")
    @Expose
    private List<ArtistMainData> artist = null;
    @SerializedName("@attr")
    @Expose
    private Attr attr;

    public List<ArtistMainData> getArtist() {
        return artist;
    }

    public void setArtist(List<ArtistMainData> artist) {
        this.artist = artist;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

}