package com.example.nearby.presenter.GetPlacesDetailsPresenter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Looper;
import android.util.Log;

import com.example.nearby.R;
import com.example.nearby.adapter.MainAdapter;
import com.example.nearby.model.FoursquareImageModel.FoursquareImageResponseModel;
import com.example.nearby.model.FoursquareModel.FoursquareResponseModel;
import com.example.nearby.model.FoursquareModel.VenuesItem;
import com.example.nearby.model.FoursquarePlaceDetailsModel.FoursquarePlaceDetailsResponseModel;
import com.example.nearby.presenter.GetPlacesPresenter.GetPlacesPresenterListener;
import com.example.nearby.repo.FoursquareDetailsRepository.GetPlacesDetailsDataSource;
import com.example.nearby.repo.FoursquareDetailsRepository.GetPlacesDetailsRepository;
import com.example.nearby.repo.FoursquareRepository.GetPlacesDataSource;
import com.example.nearby.repo.FoursquareRepository.GetPlacesRepository;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;

import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GetPlacesDetailsPresenter {
    private FoursquarePlaceDetailsResponseModel foursquarePlaceDetailsResponseModel;
    private GetPlacesDetailsRepository getPlacesDetailsRepository;
    private GetPlacesDetailsPresenterListener getPlacesDetailsPresenterListener;
    private Context context;

    public GetPlacesDetailsPresenter(GetPlacesDetailsPresenterListener getPlacesDetailsPresenterListener,
                                     GetPlacesDetailsRepository getPlacesDetailsRepository) {
        this.getPlacesDetailsPresenterListener = getPlacesDetailsPresenterListener;
        this.getPlacesDetailsRepository = getPlacesDetailsRepository;
        this.context = context;

    }

    public void getPlaces(String venueId) {

        getPlacesDetailsRepository.GetPlacesDetailsDataSource(venueId, new GetPlacesDetailsDataSource.getPlacesDetailsDataSource() {


            @Override
            public void onGetPlacesDetailsDataSourceSuccess(FoursquareImageResponseModel foursquarePlaceDetailsResponseModel) {
                getPlacesDetailsPresenterListener.onGetPlacesDetailsSuccess(foursquarePlaceDetailsResponseModel);

            }

            @Override
            public void onGetPlacesDetailsDataSourceFail(String message) {
                getPlacesDetailsPresenterListener.onGetPlacesDetailsFail(message);
            }
        });
    }





}
