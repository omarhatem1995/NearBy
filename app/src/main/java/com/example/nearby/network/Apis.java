package com.example.nearby.network;


import com.example.nearby.model.FoursquareImageModel.FoursquareImageResponseModel;
import com.example.nearby.model.FoursquareModel.FoursquareResponseModel;
import com.example.nearby.model.FoursquarePlaceDetailsModel.FoursquarePlaceDetailsResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface Apis {

    static String CLIENTID = "UDZUZLJSBZWFVP4GIGJZLZDWTFK0GX1SY0ZWB0ALU4G25AAL";
    static String CLIENT_SECRET = "C3ND52KGO1LTOLN5BSFJWNGC4K4NSGE5USEWLYL5C20B2W5E";
    static String VERSION = "20210801";
    static String COMONPARAMS = "&Client_id = $CLIENT";

    @GET("v2/venues/search")
    Call<FoursquareResponseModel> getPlaces(@Query("client_id") String clientID,
                                            @Query("client_secret") String clientSecret,
                                            @Query("near") String ll,
                                            @Query("v") String version,
                                            @Query("radius") int radius);

    @GET("v2/venues/{VENUE_ID}/photos")
    Call<FoursquareImageResponseModel> getPlacesDetails(@Path("VENUE_ID") String venueID,
                                                        @Query("client_id") String clientID,
                                                        @Query("client_secret") String clientSecret,
                                                        @Query("v") String version);

}