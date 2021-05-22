package com.example.nearby.network;

import android.content.Context;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RetrofitCallBack<T> implements Callback<T> {
    @SuppressWarnings("unused")
    private static final String TAG = "RetrofitCallback";
    private Context mContext;
    String mServiceName;

    public RetrofitCallBack() {
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.code()==401){

        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }
}
