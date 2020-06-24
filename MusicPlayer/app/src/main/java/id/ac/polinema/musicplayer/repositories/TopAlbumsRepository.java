package id.ac.polinema.musicplayer.repositories;

import androidx.lifecycle.MediatorLiveData;

import id.ac.polinema.musicplayer.models.MainModel;
import id.ac.polinema.musicplayer.models.Resource;
import id.ac.polinema.musicplayer.network.APIInterface;

public class TopAlbumsRepository {
    private static TopAlbumsRepository topAlbumsRepository;
    private APIInterface apIinterface;

    private MediatorLiveData<Resource<MainModel>> data = new MediatorLiveData<>();
}
