package com.example.nearby.repo.FoursquareDetailsRepository;


import com.example.nearby.model.FoursquareModel.FoursquareResponseModel;
import com.example.nearby.model.FoursquarePlaceDetailsModel.FoursquarePlaceDetailsResponseModel;

public interface GetPlacesDetailsDataSource {
    interface getPlacesDetailsDataSource {
        void onGetPlacesDetailsDataSourceSuccess(FoursquarePlaceDetailsResponseModel foursquarePlaceDetailsResponseModel);

        void onGetPlacesDetailsDataSourceFail(String message);
    }

    void GetPlacesDetailsDataSource(String venueId , getPlacesDetailsDataSource callback);
}
