package com.example.nearby.presenter.GetPlacesDetailsPresenter;


import com.example.nearby.model.FoursquareModel.FoursquareResponseModel;
import com.example.nearby.model.FoursquarePlaceDetailsModel.FoursquarePlaceDetailsResponseModel;

public interface GetPlacesDetailsPresenterListener {
    void onGetPlacesDetailsSuccess(FoursquarePlaceDetailsResponseModel foursquarePlaceDetailsResponseModel);
    void onGetPlacesDetailsFail(String message);

    void showProgress();
    void hideProgress();
}
