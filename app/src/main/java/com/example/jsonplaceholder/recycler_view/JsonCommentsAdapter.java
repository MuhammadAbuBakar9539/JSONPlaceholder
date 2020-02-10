package com.example.jsonplaceholder.recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.model.JsonCommentsModel;

import java.util.List;

public class JsonCommentsAdapter extends RecyclerView.Adapter<JsonCommentsAdapter.myViewHolder> {
    private List<JsonCommentsModel> jsonCommentsModel;

    public JsonCommentsAdapter(List<JsonCommentsModel> jsonCommentsModel) {
        this.jsonCommentsModel = jsonCommentsModel;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.json_placeholder_comments, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.name.setText(jsonCommentsModel.get(position).getName());
        holder.commentBody.setText(jsonCommentsModel.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return jsonCommentsModel.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView name, commentBody;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_name);
            commentBody = itemView.findViewById(R.id.tv_comment_body);
        }
    }
}
