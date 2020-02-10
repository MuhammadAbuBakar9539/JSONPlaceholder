package com.example.jsonplaceholder.presenter;

import com.example.jsonplaceholder.JsonPlaceholderContract;
import com.example.jsonplaceholder.model.JsonPostsModel;
import com.example.jsonplaceholder.recycler_view.OnFinishedListener;
import com.example.jsonplaceholder.recycler_view.Retrofit;

import java.util.List;

public class PostsPresenter implements JsonPlaceholderContract.PostsPresenter, OnFinishedListener {
    private JsonPlaceholderContract.PostsView postsView;
    private Retrofit retrofit = new Retrofit(this);

    public PostsPresenter(JsonPlaceholderContract.PostsView postsView) {
        this.postsView = postsView;
    }

    @Override
    public void getPosts() {
        retrofit.retrofitJasonPlaceholderPosts();
    }

    @Override
    public void onPostsDestroyCalled() {
        postsView = null;
    }

    @Override
    public <T> void success(List<T> dataList) {
        postsView.showPosts((List<JsonPostsModel>) dataList);
    }

    @Override
    public void failure(String errorMessage) {
        postsView.showError(errorMessage);
    }
}
