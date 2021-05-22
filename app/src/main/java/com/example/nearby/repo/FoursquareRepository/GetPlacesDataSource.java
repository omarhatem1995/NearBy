package com.example.nearby.repo.FoursquareRepository;


import com.example.nearby.model.FoursquareModel.FoursquareResponseModel;

public interface GetPlacesDataSource {
    interface getPlacesDataSource {
        void onGetPlacesDataSourceSuccess(FoursquareResponseModel teacherCoursesResponseModel);

        void onGetPlacesDataSourceFail(String message);
    }

    void GetPlacesDataSource(String ll , getPlacesDataSource callback);
}
