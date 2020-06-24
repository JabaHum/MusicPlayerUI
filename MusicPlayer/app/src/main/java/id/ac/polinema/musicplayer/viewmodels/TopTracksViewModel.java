package id.ac.polinema.musicplayer.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.ac.polinema.musicplayer.models.MainModel;
import id.ac.polinema.musicplayer.models.Resource;
import id.ac.polinema.musicplayer.repositories.TopTracksRepository;

public class TopTracksViewModel extends ViewModel {

    private MutableLiveData<Resource<MainModel>> mutableLiveData;
    private TopTracksRepository topTracksRepository;

    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        topTracksRepository = TopTracksRepository.getInstance();
        mutableLiveData = topTracksRepository.getTopTracks();

    }

    public LiveData<Resource<MainModel>> getTopTracksRepository() {
        return mutableLiveData;
    }

}
