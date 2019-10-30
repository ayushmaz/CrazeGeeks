package android.example.crazegeeks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.MyViewHolder> {
    private ArrayList<Media> media;

    MediaAdapter(ArrayList<Media> media){
        this.media = media;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView heading;
        public TextView content;
        public MyViewHolder(View v) {
            super(v);
            heading = v.findViewById(R.id.heading);
            content = v.findViewById(R.id.content);
        }
    }
    @NonNull
    @Override
    public MediaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.fragment_media_page, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MediaAdapter.MyViewHolder holder, int position) {
        final Media myMedia = media.get(position);
        holder.heading.setText(myMedia.getHeading());
        holder.content.setText(myMedia.getContent());

    }

    @Override
    public int getItemCount() {
        return media.size();
    }
}
