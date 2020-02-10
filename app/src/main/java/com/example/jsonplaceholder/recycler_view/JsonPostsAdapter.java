package com.example.jsonplaceholder.recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.model.JsonPostsModel;

import java.util.List;

public class JsonPostsAdapter extends RecyclerView.Adapter<JsonPostsAdapter.myViewHolder> {
    private List<JsonPostsModel> jsonPostsModel;

    public JsonPostsAdapter(List<JsonPostsModel> jsonPostsModel) {
        this.jsonPostsModel = jsonPostsModel;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.json_placeholder_posts, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.title.setText(jsonPostsModel.get(position).getTitle());
        holder.body.setText(jsonPostsModel.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return jsonPostsModel.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        private TextView title, body;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_title);
            body = itemView.findViewById(R.id.tv_body);
        }
    }
}
