package id.ac.polinema.musicplayer.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import id.ac.polinema.musicplayer.common.Config;
import id.ac.polinema.musicplayer.models.MainModel;
import id.ac.polinema.musicplayer.models.Resource;
import id.ac.polinema.musicplayer.network.APIClient;
import id.ac.polinema.musicplayer.network.APIInterface;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class TopTracksRepository {
    private static TopTracksRepository topTracksRepository;
    private APIInterface apIinterface;

    private MediatorLiveData<Resource<MainModel>> data = new MediatorLiveData<>();

    public TopTracksRepository() {
        apIinterface = APIClient.getClient().create(APIInterface.class);
    }

    public static TopTracksRepository getInstance() {
        if (topTracksRepository == null) {
            topTracksRepository = new TopTracksRepository();
        }
        return topTracksRepository;
    }

    public MediatorLiveData<Resource<MainModel>> getTopTracks() {

        data.setValue(Resource.loading((MainModel) null));

        final LiveData<Resource<MainModel>> source = LiveDataReactiveStreams.fromPublisher(
                apIinterface.getTopTracks(Config.toptracks, Config.api_key, Config.format)
                        .toFlowable()
                        .onErrorReturn(new Function<Throwable, MainModel>() {
                            @Override
                            public MainModel apply(Throwable throwable) throws Exception {
                                return new MainModel();
                            }
                        })
                        .map(new Function<MainModel, Resource<MainModel>>() {
                            @Override
                            public Resource<MainModel> apply(MainModel mainModel) throws Exception {
                                if (mainModel == null ) {
                                    return Resource.error("Error Couldn't Fetch Data", null);
                                }
                                return Resource.success(mainModel);
                            }
                        }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
        );

        data.addSource(source, new Observer<Resource<MainModel>>() {
            @Override
            public void onChanged(Resource<MainModel> mainModelResource) {
                data.setValue(mainModelResource);
                data.removeSource(source);
            }
        });

        return data;
    }
}
