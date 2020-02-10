package com.example.jsonplaceholder.network;

import com.example.jsonplaceholder.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Instances {
    public static Retrofit retrofit;
    private static Client client;

    public static Retrofit getRetrofitInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public static Client getClientInstance(){
        if(client == null){
            client = getRetrofitInstance().create(Client.class);
        }
        return client;
    }
}

