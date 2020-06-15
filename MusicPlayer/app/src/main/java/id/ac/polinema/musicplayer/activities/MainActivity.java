package id.ac.polinema.musicplayer.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import id.ac.polinema.musicplayer.R;
import id.ac.polinema.musicplayer.adapters.SongsAdapter;
import id.ac.polinema.musicplayer.models.MainModel;
import id.ac.polinema.musicplayer.models.Resource;
import id.ac.polinema.musicplayer.models.Track;
import id.ac.polinema.musicplayer.viewmodels.TopTracksViewModel;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TopTracksViewModel viewModel;
    RecyclerView mRecyclerview;
    SongsAdapter mSongsAdapter;
    SwipeRefreshLayout mSwipeRefreshLayout;
    List<Track> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        mRecyclerview = findViewById(R.id.radio_recycler_view);
        mSwipeRefreshLayout = findViewById(R.id.refresh);
        data = new ArrayList<>();
        
        
        mSongsAdapter = new SongsAdapter(MainActivity.this,data);
        mRecyclerview.setHasFixedSize(false);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false));
        mRecyclerview.setAdapter(mSongsAdapter);
        
        fetchData();

    }

    private void fetchData() {
        viewModel = new ViewModelProvider(MainActivity.this).get(TopTracksViewModel.class);
        viewModel.init();
        viewModel.getTopTracksRepository().observe(this, new Observer<Resource<MainModel>>() {
            @Override
            public void onChanged(Resource<MainModel> mainModelResource) {
                if (mainModelResource !=null){
                    switch (mainModelResource.status){
                        case ERROR:
                            mSwipeRefreshLayout.setRefreshing(false);
                            break;
                        case LOADING:
                            mSwipeRefreshLayout.setRefreshing(true);
                            break;
                        case SUCCESS:
                            if (mainModelResource.data !=null){
                                Timber.tag(TAG).d("mainModelResource%s", mainModelResource.data);
                                mSwipeRefreshLayout.setRefreshing(false);
                            }
                            break;
                    }
                }
            }
        });
    }
}
