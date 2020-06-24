package id.ac.polinema.musicplayer.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import id.ac.polinema.musicplayer.common.Config;
import id.ac.polinema.musicplayer.models.Artist;
import id.ac.polinema.musicplayer.models.ArtistMainModel;
import id.ac.polinema.musicplayer.models.Resource;
import id.ac.polinema.musicplayer.network.APIClient;
import id.ac.polinema.musicplayer.network.APIInterface;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class TopArtistsRepository {
    private static TopArtistsRepository topArtistsRepository;
    private APIInterface apIinterface;

    private MediatorLiveData<Resource<ArtistMainModel>> data = new MediatorLiveData<>();

    public TopArtistsRepository() {
        apIinterface = APIClient.getClient().create(APIInterface.class);
    }

    public static TopArtistsRepository getInstance() {
        if (topArtistsRepository == null) {
            topArtistsRepository = new TopArtistsRepository();
        }
        return topArtistsRepository;
    }

    public MediatorLiveData<Resource<ArtistMainModel>> getTopArtist() {

        data.setValue(Resource.loading((ArtistMainModel) null));

        final LiveData<Resource<ArtistMainModel>> source = LiveDataReactiveStreams.fromPublisher(
                apIinterface.getTopArtists(Config.topartist, Config.api_key, Config.format)
                        .toFlowable()
                        .onErrorReturn(new Function<Throwable, ArtistMainModel>() {
                            @Override
                            public ArtistMainModel apply(Throwable throwable) throws Exception {
                                return new ArtistMainModel();
                            }
                        })
                        .map(new Function<ArtistMainModel, Resource<ArtistMainModel>>() {
                            @Override
                            public Resource<ArtistMainModel> apply(ArtistMainModel mainModel) throws Exception {
                                if (mainModel == null ) {
                                    return Resource.error("Error Couldn't Fetch Data", null);
                                }
                                return Resource.success(mainModel);
                            }
                        }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
        );

        data.addSource(source, new Observer<Resource<ArtistMainModel>>() {
            @Override
            public void onChanged(Resource<ArtistMainModel> mainModelResource) {
                data.setValue(mainModelResource);
                data.removeSource(source);
            }
        });

        return data;
    }
}
