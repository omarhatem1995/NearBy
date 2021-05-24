package com.example.nearby.presenter.GetPlacesPresenter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Looper;
import android.util.Log;

import com.example.nearby.R;
import com.example.nearby.adapter.MainAdapter;
import com.example.nearby.model.FoursquareModel.FoursquareResponseModel;
import com.example.nearby.model.FoursquareModel.VenuesItem;
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

public class GetPlacesPresenter {
    private FoursquareResponseModel foursquareResponseModel;
    private GetPlacesRepository getPlacesRepository;
    private GetPlacesPresenterListener getPlacesPresenterListener;
    private Context context;

    private LocationRequest locationRequest;
    private LocationCallback locationCallback;
    private FusedLocationProviderClient fusedLocationClient;

    private static final long SMALLEST_DISPLACEMENT = 500;

    int firstTime = 0;

    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;

    public GetPlacesPresenter(GetPlacesPresenterListener getPlacesPresenterListener,
                              GetPlacesRepository getPlacesRepository, Context context) {
        this.getPlacesPresenterListener = getPlacesPresenterListener;
        this.getPlacesRepository = getPlacesRepository;
        this.context = context;
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context);

    }

    public void getPlaces(String ll) {

        getPlacesPresenterListener.showProgress();
        getPlacesRepository.GetPlacesDataSource(ll, new GetPlacesDataSource.getPlacesDataSource() {


            @Override
            public void onGetPlacesDataSourceSuccess(FoursquareResponseModel teacherCoursesResponseModel) {
                getPlacesPresenterListener.hideProgress();
                Log.d("getLog", teacherCoursesResponseModel.getResponse().getVenues().get(0).getId() + " is ");
                getPlacesPresenterListener.onGetPlacesSuccess(teacherCoursesResponseModel);

            }

            @Override
            public void onGetPlacesDataSourceFail(String message) {
                getPlacesPresenterListener.hideProgress();
                getPlacesPresenterListener.onGetPlacesFail(message);
            }
        });
    }


    /*
     * Function that is used for realTime Updates
     * */
    public void getLastKnownLocationRealTime() {
        Log.d("RealTime" ,  " is called");
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(0);
        locationRequest.setFastestInterval(0);
        locationRequest.setSmallestDisplacement(SMALLEST_DISPLACEMENT);
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    if (location != null) {
                        double wayLatitude = location.getLatitude();
                        double wayLongitude = location.getLongitude();

                        Log.d("lastKnown ", "locationResult" + wayLatitude + " , " + wayLongitude);
                    }
                }
            }
        };
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            String latLong = location.getLatitude() + "," + location.getLongitude();
                            getPlaces(latLong);

                        } else {

                        }
                    }
                });
    }

    /*
     * Function that is used for SingleUpdate
     * */
    public void getLastKnownLocationSingleUpdate() {
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    if (location != null) {
                        double wayLatitude = location.getLatitude();
                        double wayLongitude = location.getLongitude();

                        Log.d("lastKnown ", "locationResult" + wayLatitude + " , " + wayLongitude);
                    }
                }
            }
        };
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            String latLong = location.getLatitude() + "," + location.getLongitude();
                            getPlaces(latLong);

                        } else {

                        }
                    }
                });
    }

    private void setAdapter(List<VenuesItem> venuesItems) {
        mainAdapter = new MainAdapter(context,
                venuesItems);
        recyclerView.setAdapter(mainAdapter);
    }

    public void setUpVenuesList(List<VenuesItem> venuesItems) {
        recyclerView = ((Activity) context).findViewById(R.id.venues_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL
                , false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);
        setAdapter(venuesItems);
    }

}
