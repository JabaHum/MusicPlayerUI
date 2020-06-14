package id.ac.polinema.musicplayer.models;

import com.squareup.moshi.Json;

import org.w3c.dom.Attr;

import java.util.List;

public class TopTracksData {

    @Json(name = "@attr")
    private String attr;
    @Json(name = "track")
    private List<TrackData> track = null;

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public TopTracksData withAttr(String attr) {
        this.attr = attr;
        return this;
    }

    public List<TrackData> getTrack() {
        return track;
    }

    public void setTrack(List<TrackData> track) {
        this.track = track;
    }

    public TopTracksData withTrack(List<TrackData> track) {
        this.track = track;
        return this;
    }

}
