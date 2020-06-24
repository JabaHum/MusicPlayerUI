package id.ac.polinema.musicplayer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ac.polinema.musicplayer.R;
import id.ac.polinema.musicplayer.common.ImageLoader;
import id.ac.polinema.musicplayer.interfaces.OnArtistItemClickListener;
import id.ac.polinema.musicplayer.models.ArtistMainData;


public class TopArtistsAdapter extends RecyclerView.Adapter<TopArtistsAdapter.ViewHolder> {
    private List<ArtistMainData> mDataset = new ArrayList<>();
    private Context mContext;
    private OnArtistItemClickListener listener;

    public TopArtistsAdapter(Context context, OnArtistItemClickListener listener) {
        this.mContext = context;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ((ViewHolder) holder).bind(mDataset.get(position));

    }

    @Override
    public int getItemCount() {
        if (mDataset != null) {
            return mDataset.size();
        }
        return 0;
    }

    public void setDataset(List<ArtistMainData> items) {
        this.mDataset = items;
        notifyDataSetChanged();
    }

    public ArtistMainData getItemByPosition(int position) {
        return mDataset.get(position);
    }

    public void clearDataset() {
        if (mDataset != null) {
            mDataset.clear();
            notifyDataSetChanged();
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView artistImageView;
        TextView artistTextView;
        TextView numberOfPlaysTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            artistImageView = itemView.findViewById(R.id.img_artist);
            artistTextView = itemView.findViewById(R.id.txt_artist_name);
            numberOfPlaysTextView = itemView.findViewById(R.id.txt_plays);
        }


        public void bind(final ArtistMainData artistMainData) {
            ImageLoader.loadImage(mContext, artistMainData.getImage(), R.drawable.default_artist, artistImageView);
            artistTextView.setText(artistMainData.getName());
            numberOfPlaysTextView.setText(artistMainData.getPlaycount());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(artistMainData);
                }
            });
        }


    }

}
