package id.ac.polinema.musicplayer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.polinema.musicplayer.R;
import id.ac.polinema.musicplayer.common.ImageLoader;
import id.ac.polinema.musicplayer.models.ArtistMainData;


public class TopArtistsAdapter extends RecyclerView.Adapter<TopArtistsAdapter.ViewHolder> {
    private List<ArtistMainData> mDataset;
    private View.OnClickListener mOnClickListener;
    private Context mContext;

    public TopArtistsAdapter(List<ArtistMainData> items, Context context, View.OnClickListener onItemClickListener) {
        this.mDataset = items;
        this.mOnClickListener = onItemClickListener;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ArtistMainData item = mDataset.get(position);
        ImageLoader.loadImage(mContext, item.getUrl(), R.drawable.default_artist, holder.artistImageView);
        holder.artistTextView.setText(item.getName());
        holder.numberOfPlaysTextView.setText(item.getPlaycount());
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
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            artistImageView = itemView.findViewById(R.id.img_artist);
            artistTextView = itemView.findViewById(R.id.txt_artist_name);
            numberOfPlaysTextView = itemView.findViewById(R.id.txt_plays);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnClickListener != null) {
                        mOnClickListener.onClick(view);
                    }
                }
            });
        }


    }

}
