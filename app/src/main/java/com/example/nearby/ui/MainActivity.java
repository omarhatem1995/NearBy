package com.example.nearby.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.nearby.R;
import com.example.nearby.model.FoursquareModel.FoursquareResponseModel;
import com.example.nearby.model.FoursquareModel.VenuesItem;
import com.example.nearby.presenter.GetPlacesPresenter.GetPlacesPresenter;
import com.example.nearby.presenter.GetPlacesPresenter.GetPlacesPresenterListener;
import com.example.nearby.repo.FoursquareRepository.GetPlacesRemoteDataSource;
import com.example.nearby.repo.FoursquareRepository.GetPlacesRepository;
import com.example.nearby.utils.Constants;
import com.example.nearby.utils.GlobalSharedPreference;
import com.example.nearby.utils.SpinnerDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GetPlacesPresenterListener {

    private SpinnerDialog spinnerDialog;
    private GetPlacesPresenter getPlacesPresenter;

    private List<VenuesItem> venuesItems;

    private TextView appMode;
    private RecyclerView recyclerView;
    private ConstraintLayout constraintLayoutNoPlaces, constraintLayoutError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerDialog = new SpinnerDialog(this);

        appMode = findViewById(R.id.app_mode);
        recyclerView = findViewById(R.id.venues_recyclerview);
        constraintLayoutNoPlaces = findViewById(R.id.no_places_constraint);
        constraintLayoutError = findViewById(R.id.error_constraint);

        venuesItems = new ArrayList<>();

        getPlacesPresenter = new GetPlacesPresenter(this,
                GetPlacesRepository.getInstance(GetPlacesRemoteDataSource.getInstance()), this);

        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();
        } else {
            checkLastMode();
        }
        appMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchAppMode(appMode.getText().toString());
            }

        });

    }

    private void switchAppMode(String appModeString) {
        Log.d("isClicked" , "is called" + appModeString + "," + getString(R.string.singleupdate));
        if (appModeString.equals(getString(R.string.realtime))) {
            GlobalSharedPreference.getInstance().setSavedString(this,
                    Constants.APPMODE, getString(R.string.singleupdate));
            appMode.setText(R.string.singleupdate);
            getPlacesPresenter.getLastKnownLocationRealTime();
        } else if (appModeString.equals(getString(R.string.singleupdate))) {
            Log.d("isClicked" , "is entered " + appModeString);

            GlobalSharedPreference.getInstance().setSavedString(this,
                    Constants.APPMODE, getString(R.string.realtime));
            appMode.setText(R.string.realtime);
            getPlacesPresenter.getLastKnownLocationSingleUpdate();
        }

    }


    private void checkLastMode() {
        if (GlobalSharedPreference.getInstance().getSavedString(this, Constants.APPMODE).equals(getString(R.string.singleupdate))) {
            getPlacesPresenter.getLastKnownLocationSingleUpdate();
            switchAppMode(appMode.getText().toString());
        } else {
            getPlacesPresenter.getLastKnownLocationRealTime();
            switchAppMode(appMode.getText().toString());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();
        } else {
            checkLastMode();
        }
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.enable_gps))
                .setCancelable(false)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        recyclerView.setVisibility(View.GONE);
                        constraintLayoutNoPlaces.setVisibility(View.VISIBLE);
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onGetPlacesSuccess(FoursquareResponseModel foursquareResponseModel) {

        if (foursquareResponseModel.getResponse().getVenues().size() != 0) {
            for (int i = 0; i < foursquareResponseModel.getResponse()
                    .getVenues().size(); i++) {
                VenuesItem venuesItem = new VenuesItem();
                venuesItem.setName(foursquareResponseModel.getResponse()
                        .getVenues().get(i).getName());
                venuesItem.setId(foursquareResponseModel.getResponse().getVenues().get(i).getId());
                venuesItem.setCategories(foursquareResponseModel.getResponse().getVenues().get(i).getCategories());
                venuesItem.setReferralId(foursquareResponseModel.getResponse().getVenues().get(i).getReferralId());
                venuesItem.setLocation(foursquareResponseModel.getResponse().getVenues().get(i).getLocation());
                venuesItems.add(venuesItem);

            }
            getPlacesPresenter.setUpVenuesList(venuesItems);
        } else {
            recyclerView.setVisibility(View.GONE);
            constraintLayoutNoPlaces.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onGetPlacesFail(String message) {
        recyclerView.setVisibility(View.GONE);
        constraintLayoutError.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgress() {
        spinnerDialog.show();
    }

    @Override
    public void hideProgress() {
        if (spinnerDialog.isShowing() && spinnerDialog != null) {
            spinnerDialog.dismiss();
        }
    }
}