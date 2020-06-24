package id.ac.polinema.musicplayer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ac.polinema.musicplayer.R;
import id.ac.polinema.musicplayer.common.DurationConverter;
import id.ac.polinema.musicplayer.common.ImageLoader;
import id.ac.polinema.musicplayer.models.Track;



public class TopTracksAdapter extends RecyclerView.Adapter<TopTracksAdapter.ViewHolder> {
    private List<Track> mDataset = new ArrayList<>();
    private Context mContext;

    public TopTracksAdapter( Context context) {
        this.mContext = context;
    }

    @Override
    public TopTracksAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.track_item, parent, false);
        return new TopTracksAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Track item = mDataset.get(position);
        ImageLoader.loadImage(mContext, item.getImage(), R.drawable.default_track, holder.trackImageView);
        holder.nameTextView.setText(item.getName());
        holder.artistTextView.setText(item.getArtist().getName());
        holder.playCountTextView.setText(item.getPlaycount());
        holder.durationTextView.setText(DurationConverter.getDurationInMinutesText(Long.parseLong(item.getDuration())));
    }

    @Override
    public int getItemCount() {
        if (mDataset != null) {
            return mDataset.size();
        }
        return 0;
    }

    public void setDataset(List<Track> items) {
        this.mDataset = items;
        notifyDataSetChanged();
    }

    public Track getItemAt(int position) {
        return mDataset.get(position);
    }

    public void clearDataset() {
        if (mDataset != null) {
            mDataset.clear();
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView trackImageView;
        TextView nameTextView;
        TextView playCountTextView;
        TextView artistTextView;
        TextView durationTextView;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);


            trackImageView = itemView.findViewById(R.id.img_track);
            nameTextView = itemView.findViewById(R.id.txt_track_name);
            playCountTextView = itemView.findViewById(R.id.txt_plays);
            artistTextView = itemView.findViewById(R.id.txt_track_artist);
            durationTextView = itemView.findViewById(R.id.txt_duration);
            cardView= itemView.findViewById(R.id.cv_track_item);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }

    }
}
