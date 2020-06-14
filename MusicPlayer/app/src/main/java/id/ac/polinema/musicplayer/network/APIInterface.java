package id.ac.polinema.musicplayer.network;

import id.ac.polinema.musicplayer.models.MainModel;
import id.ac.polinema.musicplayer.models.TopTracksData;
import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/2.0/")
    Single<MainModel> getTopTracks(@Query("method") String toptracks,
                                   @Query("api_key") String api_key,
                                   @Query("format") String format);


    // @GET("?method=artist.search&format=json&api_key=" + API_KEY)
}
