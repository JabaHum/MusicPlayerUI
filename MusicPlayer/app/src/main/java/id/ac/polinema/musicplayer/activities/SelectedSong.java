package id.ac.polinema.musicplayer.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import id.ac.polinema.musicplayer.R;
import id.ac.polinema.musicplayer.models.Track;

public class SelectedSong extends AppCompatActivity {

    private static final String TAG = "SelectedSong";

    TextView txtSongTitle, txtSongArtist;
    public static ImageView btnPlayPause;
    ImageView btnForward;
    ImageView btnRewind;

    public SelectedSong() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_song_item);

        //TextViews
        txtSongTitle = findViewById(R.id.txt_song_title);
        txtSongArtist = findViewById(R.id.txt_song_artist);

        //Buttons
        btnPlayPause = findViewById(R.id.btn_play);
        btnForward = findViewById(R.id.btn_forward);
        btnRewind = findViewById(R.id.btn_rewindd);

        String data = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            data = extras.getString("Data");
        }
        Track track = new Gson().fromJson(data, Track.class);

        txtSongTitle.setText(track.getName());
        txtSongArtist.setText(track.getArtist().getName());
        if(Player.mPlayer == null){
            new Player(this);
        }
        Player.mPlayer.playStream(track.getUrl());


        btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player.mPlayer.togglePlayer();

            }
        });
    }

    public static void flipPlayPause(boolean isPlaying) {
        if (isPlaying){
            btnPlayPause.setImageResource(android.R.drawable.ic_media_pause);
        }else {
            btnPlayPause.setImageResource(R.drawable.play_button);
        }
    }
}
