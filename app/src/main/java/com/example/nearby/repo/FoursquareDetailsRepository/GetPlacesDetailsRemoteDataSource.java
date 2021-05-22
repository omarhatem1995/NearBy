package com.example.nearby.repo.FoursquareDetailsRepository;

import com.example.nearby.model.FoursquarePlaceDetailsModel.FoursquarePlaceDetailsResponseModel;
import com.example.nearby.network.RetrofitCallBack;
import com.example.nearby.network.WebServices;

import retrofit2.Call;
import retrofit2.Response;

public class GetPlacesDetailsRemoteDataSource implements GetPlacesDetailsDataSource{
    private  static GetPlacesDetailsRemoteDataSource INSTANCE ;
    private static String CLIENT_ID = "UDZUZLJSBZWFVP4GIGJZLZDWTFK0GX1SY0ZWB0ALU4G25AAL";
    private static  String CLIENT_SECRET = "C3ND52KGO1LTOLN5BSFJWNGC4K4NSGE5USEWLYL5C20B2W5E";
    private static String VERSION = "20210401";

    public static GetPlacesDetailsRemoteDataSource getInstance(){
        if (INSTANCE == null){
            INSTANCE = new GetPlacesDetailsRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void GetPlacesDetailsDataSource(String venueId, GetPlacesDetailsDataSource.getPlacesDetailsDataSource callback) {
        WebServices.getApis().getPlacesDetails(venueId,CLIENT_ID,CLIENT_SECRET, VERSION).enqueue(new RetrofitCallBack<FoursquarePlaceDetailsResponseModel>() {
            @Override
            public void onResponse(Call<FoursquarePlaceDetailsResponseModel> call, Response<FoursquarePlaceDetailsResponseModel> response) {
                super.onResponse(call, response);
                if(response.body()!=null){
                    callback.onGetPlacesDetailsDataSourceSuccess(response.body());
                }else {
                    callback.onGetPlacesDetailsDataSourceFail(null);
                }
            }

            @Override
            public void onFailure(Call<FoursquarePlaceDetailsResponseModel> call, Throwable t) {
                super.onFailure(call, t);
                callback.onGetPlacesDetailsDataSourceFail(t.getMessage());
            }
        });
    }
}
