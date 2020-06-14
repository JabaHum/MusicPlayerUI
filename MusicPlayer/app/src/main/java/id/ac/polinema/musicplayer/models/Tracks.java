package id.ac.polinema.musicplayer.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tracks {

    @SerializedName("track")
    @Expose
    private List<TrackData> track = null;
    @SerializedName("@attr")
    @Expose
    private Attr attr;

    public List<TrackData> getTrack() {
        return track;
    }

    public void setTrack(List<TrackData> track) {
        this.track = track;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

}