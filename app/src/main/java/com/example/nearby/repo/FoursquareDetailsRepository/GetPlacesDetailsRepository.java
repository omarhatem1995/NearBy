package com.example.nearby.repo.FoursquareDetailsRepository;


import com.example.nearby.model.FoursquarePlaceDetailsModel.FoursquarePlaceDetailsResponseModel;

public class GetPlacesDetailsRepository implements GetPlacesDetailsDataSource {
    private static GetPlacesDetailsRepository INSTANCE;
    private static GetPlacesDetailsDataSource getPlacesDetailsDataSource;

    public GetPlacesDetailsRepository(GetPlacesDetailsDataSource getPlacesDetailsDataSource) {
        this.getPlacesDetailsDataSource = getPlacesDetailsDataSource;
    }

    public static GetPlacesDetailsRepository getInstance(GetPlacesDetailsDataSource getPlacesDetailsDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new GetPlacesDetailsRepository(getPlacesDetailsDataSource);
        }

        return INSTANCE;
    }

    @Override
    public void GetPlacesDetailsDataSource(String venueId, GetPlacesDetailsDataSource.getPlacesDetailsDataSource callback) {
        getPlacesDetailsDataSource.GetPlacesDetailsDataSource(venueId, new getPlacesDetailsDataSource() {
            @Override
            public void onGetPlacesDetailsDataSourceSuccess(FoursquarePlaceDetailsResponseModel foursquarePlaceDetailsResponseModel) {
                callback.onGetPlacesDetailsDataSourceSuccess(foursquarePlaceDetailsResponseModel);
            }

            @Override
            public void onGetPlacesDetailsDataSourceFail(String message) {
                callback.onGetPlacesDetailsDataSourceFail(message);
            }
        });
    }
}
