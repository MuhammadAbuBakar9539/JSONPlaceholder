package com.example.jsonplaceholder.recycler_view;

import com.example.jsonplaceholder.model.JsonCommentsModel;
import com.example.jsonplaceholder.model.JsonPostsModel;
import com.example.jsonplaceholder.network.Instances;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Retrofit {
    private OnFinishedListener onFinishedListener;

    public Retrofit(OnFinishedListener onFinishedListener) {
        this.onFinishedListener = onFinishedListener;
    }

    public void retrofitJasonPlaceholderPosts() {
        Call<List<JsonPostsModel>> call = Instances.getClientInstance().getJsonPosts();
        call.enqueue(new Callback<List<JsonPostsModel>>() {
            @Override
            public void onResponse(Call<List<JsonPostsModel>> call, Response<List<JsonPostsModel>> response) {
                if (response.isSuccessful()) {
                    onFinishedListener.success(response.body());
                } else {
                    onFinishedListener.failure(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<JsonPostsModel>> call, Throwable t) {
                onFinishedListener.failure(t.getMessage());
            }
        });
    }

    public void retrofitJasonPlaceholderComments() {
        Call<List<JsonCommentsModel>> call = Instances.getClientInstance().getJsonComments();
        call.enqueue(new Callback<List<JsonCommentsModel>>() {
            @Override
            public void onResponse(Call<List<JsonCommentsModel>> call, Response<List<JsonCommentsModel>> response) {
                if (response.isSuccessful()) {
                    onFinishedListener.success(response.body());
                } else {
                    onFinishedListener.failure(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<JsonCommentsModel>> call, Throwable t) {
                onFinishedListener.failure(t.getMessage());
            }
        });
    }
}
