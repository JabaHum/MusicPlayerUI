package id.ac.polinema.musicplayer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.polinema.musicplayer.R;
import id.ac.polinema.musicplayer.models.Track;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ItemViewHolder> {

    private Context context;
    private List<Track> dataList;

    public SongsAdapter(Context context,List<Track> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public void setDataList(List<Track> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.song_item, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Track data = dataList.get(position);

        holder.txtSong.setText(data.getName());
        holder.txtArtistName.setText(data.getArtist().getName());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView ivThumbnail;
        TextView txtArtistName, txtSong;

        public ItemViewHolder(@NonNull View itemView) {

            super(itemView);

            ivThumbnail = itemView.findViewById(R.id.song_poster);
            txtArtistName = itemView.findViewById(R.id.song_artist);
            txtSong = itemView.findViewById(R.id.song_name);

        }
    }
}
