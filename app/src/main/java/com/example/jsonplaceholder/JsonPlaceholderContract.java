package com.example.jsonplaceholder;

import com.example.jsonplaceholder.model.JsonCommentsModel;
import com.example.jsonplaceholder.model.JsonPostsModel;

import java.util.List;

public interface JsonPlaceholderContract {
    interface PostsView {

        void showPosts(List<JsonPostsModel> jsonPostsModel);

        void showError(String errorMessage);

    }

    interface CommentsView {

        void showComments(List<JsonCommentsModel> jsonCommentsModels);

        void showError(String errorMessage);
    }

    interface PostsPresenter {

        void getPosts();

        void onPostsDestroyCalled();

    }

    interface CommentsPresenter {

        void getComments();

        void onCommentsDestroyCalled();
    }
}
