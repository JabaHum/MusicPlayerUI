package id.ac.polinema.musicplayer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import id.ac.polinema.musicplayer.R;
import id.ac.polinema.musicplayer.models.Track;
import timber.log.Timber;

public class SelectedSong extends AppCompatActivity {

    private static final String TAG = "SelectedSong";

    TextView txtSongTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_song_item);

        txtSongTitle = findViewById(R.id.txt_song_title);


        Intent i = getIntent();
        String data = i.getStringExtra("Data");
        JSONObject jsonObject = null;

        try {
            if (data != null) {
                 jsonObject = new JSONObject(data);

                Timber.tag(TAG).d("%s", data);

                Gson gson = new Gson();
                Track track = gson.fromJson(String.valueOf(jsonObject), Track.class);

                txtSongTitle.setText(track.getName());
            }
        } catch (JSONException e) {
            Log.e(TAG, "onCreate: "+e.toString() );
        }



    }
}
