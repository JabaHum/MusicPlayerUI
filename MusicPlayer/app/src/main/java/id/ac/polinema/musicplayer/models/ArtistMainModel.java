package id.ac.polinema.musicplayer.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtistMainModel {

    @SerializedName("artists")
    @Expose
    private Artists artists;

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

}