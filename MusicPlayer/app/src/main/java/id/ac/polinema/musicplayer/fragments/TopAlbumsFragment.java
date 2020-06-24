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
import id.ac.polinema.musicplayer.adapters.TopAlbumsAdapter;
import id.ac.polinema.musicplayer.viewmodels.TopAlbumsViewModel;

public class TopAlbumsFragment extends Fragment {

    TopAlbumsViewModel viewModel;
    RecyclerView mRecyclerview;
    TopAlbumsAdapter mTopAlbumsAdapter;

    public TopAlbumsFragment() {
    }

    public static TopAlbumsFragment newInstance() {
        return new TopAlbumsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top_albums, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
