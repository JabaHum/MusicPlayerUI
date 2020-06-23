package id.ac.polinema.musicplayer.activities;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;

import id.ac.polinema.musicplayer.R;
import id.ac.polinema.musicplayer.models.Track;

public class SelectedSong extends AppCompatActivity {

    private static final String TAG = "SelectedSong";

    TextView txtSongTitle, txtSongArtist;

    MediaPlayer mMediaPlayer;
    AudioManager mAudioManger;

    public SelectedSong() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_song_item);

        txtSongTitle = findViewById(R.id.txt_song_title);
        txtSongArtist = findViewById(R.id.txt_song_artist);

        String jsonMyObject = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            jsonMyObject = extras.getString("Data");
        }
        Track track = new Gson().fromJson(jsonMyObject, Track.class);

        txtSongTitle.setText(track.getName());
        txtSongArtist.setText(track.getArtist().getName());
        if(Player.mPlayer == null){
            new Player();
        }
        Player.mPlayer.playStream(track.getUrl());
    }
}
