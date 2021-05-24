package com.example.nearby.network;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.nearby.utils.MainApplication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RetrofitCallBack<T> implements Callback<T> {
    @SuppressWarnings("unused")
    private static final String TAG = "RetrofitCallback";
    private Context mContext;
    String mServiceName;

    public RetrofitCallBack() {
        Log.d("MainPASD", MainApplication.getAppContext() + " ");
        mContext = MainApplication.getAppContext();
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.code()==401){

        }else if(response.code()==429){
            Toast.makeText(MainApplication.getAppContext(), "Sorry You have exceeded the qouta of Foursquare service" +
                    "Images", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }
}
