package id.ac.polinema.musicplayer.activities;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.widget.Toast;

import java.io.IOException;

import timber.log.Timber;

public class Player {
    private static final String TAG = "Player";
    private MediaPlayer mMediaplayer = new MediaPlayer();
    public static Player mPlayer;
    private String url = "";
    private Context mContext;

    Player(Context mContext) {
        this.mPlayer = this;
        this.mContext = mContext;
    }

    public void playStream(String Url) {
        if (mMediaplayer != null) {
            try {
                mMediaplayer.stop();
            } catch (Exception e) {
                Timber.tag(TAG).e("playStream: %s", e.toString());
            }
            mMediaplayer = null;
        }

        mMediaplayer = new MediaPlayer();
        mMediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mMediaplayer.setDataSource(Url);
            mMediaplayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mMediaplayer.start();
                }
            });
            mMediaplayer.prepareAsync();
        } catch (IOException e) {
            Timber.tag(TAG).d("playStream: %s", e.toString());

        }
    }


    public void pausePlayer() {
        try {
            mMediaplayer.pause();
            Toast.makeText(mContext, "Paused", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Timber.tag(TAG).e("pausePlayer: %s", e.toString());
        }
    }

    public void playPlayer() {
        try {
            mMediaplayer.start();
            Toast.makeText(mContext, "Play", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Timber.tag(TAG).e("pausePlayer: %s", e.toString());
        }
    }


    public void togglePlayer() {
        try {
            if (mMediaplayer.isPlaying()) {
                pausePlayer();
            } else {
                playPlayer();
            }
        } catch (Exception e) {
            Timber.tag(TAG).e("togglePlayer: %s", e.toString());
        }
    }
}
