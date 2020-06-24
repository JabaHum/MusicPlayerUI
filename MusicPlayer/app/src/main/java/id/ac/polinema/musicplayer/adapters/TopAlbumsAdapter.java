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
import id.ac.polinema.musicplayer.models.Album;



public class TopAlbumsAdapter extends RecyclerView.Adapter<TopAlbumsAdapter.ViewHolder> {
    private List<Album> mDataset;
    private Context mContext;

    public TopAlbumsAdapter( Context context) {
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Album item = mDataset.get(position);
        ImageLoader.loadImage(mContext, item.getImage(), R.drawable.default_album, holder.albumImageView);
        holder.nameTextView.setText(item.getName());
        holder.playCountTextView.setText(item.getPlaycount());
        holder.artistTextView.setText(item.getArtist().getName());
    }

    @Override
    public int getItemCount() {
        if (mDataset != null) {
            return mDataset.size();
        }
        return 0;
    }

    public void setDataset(List<Album> items) {
        this.mDataset = items;
        notifyDataSetChanged();
    }

    public Album getItemByPosition(int position) {
        return mDataset.get(position);
    }

    public void clearDataset() {
        if (mDataset != null) {
            mDataset.clear();
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView albumImageView;
        TextView artistTextView;
        TextView nameTextView;
        TextView playCountTextView;
        CardView cardView;


        public ViewHolder(View itemView) {
            super(itemView);

            albumImageView = itemView.findViewById(R.id.img_album);
            artistTextView = itemView.findViewById(R.id.txt_album_artist);
            nameTextView = itemView.findViewById(R.id.txt_album_name);
            playCountTextView = itemView.findViewById(R.id.txt_plays);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

    }
}
