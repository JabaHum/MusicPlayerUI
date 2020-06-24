package id.ac.polinema.musicplayer.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import id.ac.polinema.musicplayer.R;
import id.ac.polinema.musicplayer.adapters.TopArtistsAdapter;
import id.ac.polinema.musicplayer.viewmodels.TopArtistsViewModel;

public class TopArtistsFragment extends Fragment {

    TopArtistsViewModel viewModel;
    RecyclerView mRecyclerview;
    TopArtistsAdapter mSongsAdapter;
    SwipeRefreshLayout mSwipeRefreshLayout;

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
    }
}
