package com.example.nearby.repo.FoursquareRepository;


import com.example.nearby.model.FoursquareModel.FoursquareResponseModel;
import com.example.nearby.network.RetrofitCallBack;
import com.example.nearby.network.WebServices;

import retrofit2.Call;
import retrofit2.Response;

public class GetPlacesRemoteDataSource implements GetPlacesDataSource{
    private  static GetPlacesRemoteDataSource INSTANCE ;
    private static String CLIENT_ID = "UDZUZLJSBZWFVP4GIGJZLZDWTFK0GX1SY0ZWB0ALU4G25AAL";
    private static  String CLIENT_SECRET = "C3ND52KGO1LTOLN5BSFJWNGC4K4NSGE5USEWLYL5C20B2W5E";
    private static String VERSION = "20210401";
    private static int RADIUS = 1000;
    public static GetPlacesRemoteDataSource getInstance(){
        if (INSTANCE == null){
            INSTANCE = new GetPlacesRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void GetPlacesDataSource(String ll, getPlacesDataSource callback) {
        WebServices.getApis().getPlaces(CLIENT_ID,CLIENT_SECRET, ll , VERSION, RADIUS).enqueue(new RetrofitCallBack<FoursquareResponseModel>() {
            @Override
            public void onResponse(Call<FoursquareResponseModel> call, Response<FoursquareResponseModel> response) {
                super.onResponse(call, response);
                if(response.body()!=null){
                    callback.onGetPlacesDataSourceSuccess(response.body());
                }else {
                    callback.onGetPlacesDataSourceFail(null);
                }
            }

            @Override
            public void onFailure(Call<FoursquareResponseModel> call, Throwable t) {
                super.onFailure(call, t);
                callback.onGetPlacesDataSourceFail(t.getMessage());
            }
        });
    }
}
