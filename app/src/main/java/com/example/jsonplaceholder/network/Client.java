package com.example.jsonplaceholder.network;

import com.example.jsonplaceholder.model.JsonCommentsModel;
import com.example.jsonplaceholder.model.JsonPostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Client {
    @GET("posts")
    Call<List<JsonPostsModel>> getJsonPosts();

    @GET("posts/1/comments")
    Call<List<JsonCommentsModel>> getJsonComments();
}
