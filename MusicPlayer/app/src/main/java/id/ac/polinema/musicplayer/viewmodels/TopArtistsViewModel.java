package id.ac.polinema.musicplayer.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.ac.polinema.musicplayer.models.ArtistMainModel;
import id.ac.polinema.musicplayer.models.Resource;
import id.ac.polinema.musicplayer.repositories.TopArtistsRepository;

public class TopArtistsViewModel extends ViewModel {
    private MutableLiveData<Resource<ArtistMainModel>> mutableLiveData;
    private TopArtistsRepository topArtistsRepository;

    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        topArtistsRepository = TopArtistsRepository.getInstance();
        mutableLiveData = topArtistsRepository.getTopArtist();

    }

    public LiveData<Resource<ArtistMainModel>> getTopArtistsRepository() {
        return mutableLiveData;
    }
}
