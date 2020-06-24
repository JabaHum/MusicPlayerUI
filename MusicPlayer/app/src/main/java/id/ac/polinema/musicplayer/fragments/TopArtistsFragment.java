package id.ac.polinema.musicplayer.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.ac.polinema.musicplayer.R;
import id.ac.polinema.musicplayer.adapters.TopArtistsAdapter;
import id.ac.polinema.musicplayer.interfaces.OnArtistItemClickListener;
import id.ac.polinema.musicplayer.models.ArtistMainData;
import id.ac.polinema.musicplayer.models.ArtistMainModel;
import id.ac.polinema.musicplayer.models.Resource;
import id.ac.polinema.musicplayer.viewmodels.TopArtistsViewModel;


public class TopArtistsFragment extends Fragment implements OnArtistItemClickListener {

    private static final String TAG = "TopArtistsFragment";

    private TopArtistsViewModel viewModel;
    private ProgressBar mainprogressBar;
    private RecyclerView mRecyclerview;
    private TopArtistsAdapter mTopArtistsAdapter;
    private View emptyLayout;


    public TopArtistsFragment() {
    }

    public static TopArtistsFragment newInstance() {
        return new TopArtistsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_artists, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainprogressBar = view.findViewById(R.id.prgrs_main);
        mRecyclerview = view.findViewById(R.id.rclr_artists);
        emptyLayout = view.findViewById(R.id.empty_layout);
        initRecyclerView();
        fetchArtistData();
    }

    private void initRecyclerView() {
        mTopArtistsAdapter = new TopArtistsAdapter(getContext(), this);
        mRecyclerview.setHasFixedSize(false);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        mRecyclerview.setAdapter(mTopArtistsAdapter);
    }

    private void fetchArtistData() {
        viewModel = new ViewModelProvider(this).get(TopArtistsViewModel.class);
        viewModel.init();
        viewModel.getTopArtistsRepository().removeObservers(getViewLifecycleOwner());
        viewModel.getTopArtistsRepository().observe(getViewLifecycleOwner(), new Observer<Resource<ArtistMainModel>>() {
            @Override
            public void onChanged(Resource<ArtistMainModel> artistMainModelResource) {
                if (artistMainModelResource != null) {
                    switch (artistMainModelResource.status) {
                        case ERROR:
                            mainprogressBar.setVisibility(View.GONE);
                            break;
                        case LOADING:
                            mainprogressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            if (artistMainModelResource.data != null) {
                                if (artistMainModelResource.data.getArtists().getArtist().size()==0){
                                    emptyLayout.setVisibility(View.VISIBLE);
                                }
                                mTopArtistsAdapter.setDataset(artistMainModelResource.data.getArtists().getArtist());
                                mainprogressBar.setVisibility(View.GONE);
                                emptyLayout.setVisibility(View.GONE);

                            }
                            break;
                    }
                }
            }
        });
    }


    private void openUrl(String url) {
        if (!TextUtils.isEmpty(url)) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }



    @Override
    public void onClick(ArtistMainData artistMainData) {
        openUrl(artistMainData.getUrl());
    }
}
