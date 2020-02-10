package com.example.jsonplaceholder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholder.model.JsonCommentsModel;
import com.example.jsonplaceholder.presenter.CommentsPresenter;
import com.example.jsonplaceholder.recycler_view.JsonCommentsAdapter;

import java.util.List;

public class CommentsFragment extends Fragment implements JsonPlaceholderContract.CommentsView {
    private JsonPlaceholderContract.CommentsPresenter presenter;
    private RecyclerView recyclerView;
    private LinearLayout progressBar; //ProgressBar is inside the LinearLayout to avoid constraint warning and to place center of the screen
    private LinearLayout error_body;
    private TextView error_message;
    private Button retry;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.json_placeholder_recycler_view, container, false);
        recyclerView = view.findViewById(R.id.rv_json_placeholder);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new CommentsPresenter(this);
        progressBar = view.findViewById(R.id.progress);
        error_body = view.findViewById(R.id.lil_error_box);
        error_message = view.findViewById(R.id.tv_error_message);
        retry = view.findViewById(R.id.btn_retry);

        presenter.getComments();
    }

    @Override
    public void showComments(List<JsonCommentsModel> jsonCommentsModels) {
        JsonCommentsAdapter commentsAdapter = new JsonCommentsAdapter(jsonCommentsModels);
        progressBar.setVisibility(View.GONE);
        recyclerView.setAdapter(commentsAdapter);
    }

    @Override
    public void showError(String errorMessage) {
        progressBar.setVisibility(View.GONE);
        error_body.setVisibility(View.VISIBLE);
        error_message.setText(errorMessage);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error_body.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
                presenter.getComments();
            }
        });
    }

    @Override
    public void onDestroy() {
        presenter.onCommentsDestroyCalled();
        super.onDestroy();
    }
}
