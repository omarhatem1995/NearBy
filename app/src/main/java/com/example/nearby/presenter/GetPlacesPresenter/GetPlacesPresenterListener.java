package com.example.nearby.presenter.GetPlacesPresenter;


import com.example.nearby.model.FoursquareModel.FoursquareResponseModel;

public interface GetPlacesPresenterListener {
    void onGetPlacesSuccess(FoursquareResponseModel foursquareResponseModel);
    void onGetPlacesFail(String message);

    void showProgress();
    void hideProgress();
}
