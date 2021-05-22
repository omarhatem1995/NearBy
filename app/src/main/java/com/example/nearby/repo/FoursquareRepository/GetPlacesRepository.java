package com.example.nearby.repo.FoursquareRepository;


import com.example.nearby.model.FoursquareModel.FoursquareResponseModel;

public class GetPlacesRepository implements GetPlacesDataSource{
    private static GetPlacesRepository INSTANCE;
    private static GetPlacesDataSource getPlacesDataSource;
    public GetPlacesRepository(GetPlacesDataSource getPlacesDataSource) {
        this.getPlacesDataSource = getPlacesDataSource;
    }

    public static GetPlacesRepository getInstance(GetPlacesDataSource getPlacesDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new GetPlacesRepository(getPlacesDataSource);
        }

        return INSTANCE;
    }
    @Override
    public void GetPlacesDataSource(String ll, GetPlacesDataSource.getPlacesDataSource callback) {
        getPlacesDataSource.GetPlacesDataSource(ll, new getPlacesDataSource() {
            @Override
            public void onGetPlacesDataSourceSuccess(FoursquareResponseModel teacherCoursesResponseModel) {
callback.onGetPlacesDataSourceSuccess(teacherCoursesResponseModel);
            }

            @Override
            public void onGetPlacesDataSourceFail(String message) {
callback.onGetPlacesDataSourceFail(message);
            }
        });
    }
}
