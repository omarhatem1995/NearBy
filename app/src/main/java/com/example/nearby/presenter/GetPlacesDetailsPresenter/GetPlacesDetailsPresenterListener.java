package com.example.nearby.presenter.GetPlacesDetailsPresenter;


import com.example.nearby.model.FoursquareImageModel.FoursquareImageResponseModel;
import com.example.nearby.model.FoursquareModel.FoursquareResponseModel;
import com.example.nearby.model.FoursquarePlaceDetailsModel.FoursquarePlaceDetailsResponseModel;

public interface GetPlacesDetailsPresenterListener {
    void onGetPlacesDetailsSuccess(FoursquareImageResponseModel foursquarePlaceDetailsResponseModel);
    void onGetPlacesDetailsFail(String message);

    void showProgress();
    void hideProgress();
}
