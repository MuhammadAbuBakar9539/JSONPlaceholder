package com.example.jsonplaceholder.recycler_view;

import java.util.List;

public interface OnFinishedListener {
    <T> void success (List<T> dataList);

    void failure(String errorMessage);
}
