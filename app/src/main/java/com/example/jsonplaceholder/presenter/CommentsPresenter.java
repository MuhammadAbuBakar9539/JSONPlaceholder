package com.example.jsonplaceholder.presenter;

import com.example.jsonplaceholder.JsonPlaceholderContract;
import com.example.jsonplaceholder.model.JsonCommentsModel;
import com.example.jsonplaceholder.recycler_view.OnFinishedListener;
import com.example.jsonplaceholder.recycler_view.Retrofit;

import java.util.List;

public class CommentsPresenter implements JsonPlaceholderContract.CommentsPresenter, OnFinishedListener {
    private JsonPlaceholderContract.CommentsView commentsView;
    private Retrofit retrofit = new Retrofit(this);

    public CommentsPresenter(JsonPlaceholderContract.CommentsView commentsView) {
        this.commentsView = commentsView;
    }

    @Override
    public void getComments() {
        retrofit.retrofitJasonPlaceholderComments();
    }

    @Override
    public void onCommentsDestroyCalled() {
        commentsView = null;
    }

    @Override
    public <T> void success(List<T> dataList) {
        commentsView.showComments((List<JsonCommentsModel>) dataList);
    }

    @Override
    public void failure(String errorMessage) {
        commentsView.showError(errorMessage);
    }
}
