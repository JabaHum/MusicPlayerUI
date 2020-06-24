package id.ac.polinema.musicplayer.network;

import id.ac.polinema.musicplayer.models.ArtistMainModel;
import id.ac.polinema.musicplayer.models.MainModel;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/2.0/")
    Single<MainModel> getTopTracks(@Query("method") String toptracks,
                                   @Query("api_key") String api_key,
                                   @Query("format") String format);

    @GET("/2.0/")
    Single<ArtistMainModel> getTopArtists(@Query("method") String topArtist,
                                          @Query("api_key") String api_key,
                                          @Query("format") String format);

   /* @GET("?method=user.gettopalbums&format=json")
    Single<TopAlbumsResponse> getTopArtists(@Query("user") String user, @Query("limit") int limit, @Query("api_key") String apiKey);

*/

}
