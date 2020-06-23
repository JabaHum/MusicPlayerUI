package id.ac.polinema.musicplayer.models;

import com.squareup.moshi.Json;

import java.util.List;

public class TopTracksData {

    @Json(name = "@attr")
    private Attr attr;
    @Json(name = "track")
    private List<Track> track = null;


    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    public TopTracksData withAttr(Attr attr) {
        this.attr = attr;
        return this;
    }

    public List<Track> getTrack() {
        return track;
    }

    public void setTrack(List<Track> track) {
        this.track = track;
    }

    public TopTracksData withTrack(List<Track> track) {
        this.track = track;
        return this;
    }


}
