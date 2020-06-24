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
import id.ac.polinema.musicplayer.adapters.TopTracksAdapter;
import id.ac.polinema.musicplayer.interfaces.OnTrackItemClickListener;
import id.ac.polinema.musicplayer.models.MainModel;
import id.ac.polinema.musicplayer.models.Resource;
import id.ac.polinema.musicplayer.models.Track;
import id.ac.polinema.musicplayer.viewmodels.TopTracksViewModel;

public class TopTracksFragment extends Fragment implements OnTrackItemClickListener {

    private TopTracksViewModel viewModel;
    private ProgressBar mainprogressBar;
    private RecyclerView mRecyclerview;
    private TopTracksAdapter mTracksAdapater;
    View emptyLayout;

    public TopTracksFragment() {
    }

    public static TopTracksFragment newInstance() {
        return new TopTracksFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top_tracks, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainprogressBar = view.findViewById(R.id.prgrs_main);
        mRecyclerview = view.findViewById(R.id.rclr_tracks);
        emptyLayout = view.findViewById(R.id.empty_layout);
        initRecyclerView();
        fetchTracksData();
    }

    private void initRecyclerView() {
        mTracksAdapater = new TopTracksAdapter(getContext(), this);
        mRecyclerview.setHasFixedSize(false);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        mRecyclerview.setAdapter(mTracksAdapater);
    }


    private void fetchTracksData() {
        viewModel = new ViewModelProvider(this).get(TopTracksViewModel.class);
        viewModel.init();
        viewModel.getTopTracksRepository().removeObservers(getViewLifecycleOwner());
        viewModel.getTopTracksRepository().observe(getViewLifecycleOwner(), new Observer<Resource<MainModel>>() {
            @Override
            public void onChanged(Resource<MainModel> mainModelResource) {
                if (mainModelResource != null) {
                    switch (mainModelResource.status) {
                        case ERROR:
                            mainprogressBar.setVisibility(View.GONE);
                            break;
                        case LOADING:
                            mainprogressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            if (mainModelResource.data != null) {
                                if (mainModelResource.data.getTracks().getTrack().size() == 0) {
                                    emptyLayout.setVisibility(View.VISIBLE);
                                }
                                mTracksAdapater.setDataset(mainModelResource.data.getTracks().getTrack());
                                mainprogressBar.setVisibility(View.GONE);
                                emptyLayout.setVisibility(View.GONE);

                            }
                            break;
                    }
                }
            }
        });
    }


    void openUrl(String url) {
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
    public void onClick(Track track) {
        openUrl(track.getUrl());
    }
}
