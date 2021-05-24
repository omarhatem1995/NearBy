package com.example.nearby.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.nearby.R;
import com.example.nearby.model.FoursquareImageModel.FoursquareImageResponseModel;
import com.example.nearby.model.FoursquareModel.VenuesItem;
import com.example.nearby.model.FoursquarePlaceDetailsModel.FoursquarePlaceDetailsResponseModel;
import com.example.nearby.presenter.GetPlacesDetailsPresenter.GetPlacesDetailsPresenter;
import com.example.nearby.presenter.GetPlacesDetailsPresenter.GetPlacesDetailsPresenterListener;
import com.example.nearby.repo.FoursquareDetailsRepository.GetPlacesDetailsRemoteDataSource;
import com.example.nearby.repo.FoursquareDetailsRepository.GetPlacesDetailsRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainAdapterViewHolder> implements
        GetPlacesDetailsPresenterListener {

    private final Context context;
    private List<VenuesItem> venuesItemList;
    private int targetPos = 0;
    private ImageView s;
    private String url ;

    private GetPlacesDetailsPresenter getPlacesDetailsPresenter;

    public MainAdapter(Context context, List<VenuesItem> venuesItems) {
        this.context = context;
        this.venuesItemList = venuesItems;
        getPlacesDetailsPresenter = new GetPlacesDetailsPresenter(this,
                GetPlacesDetailsRepository.getInstance(GetPlacesDetailsRemoteDataSource.getInstance()));

        getPlacesDetailsPresenter.getPlaces(venuesItemList.get(0).
                getId());
        Log.d("targetId", " loool " + venuesItemList.get(0).
                getId());
    }

    @NonNull
    @Override
    public MainAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_main_adapter, parent, false);
        MainAdapterViewHolder viewHolder = new MainAdapterViewHolder(v);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull MainAdapterViewHolder holder, int position) {
        String placeName = venuesItemList.get(position).getName();
        if(venuesItemList.get(position).getLocation()!=null) {
            String placeAddress = venuesItemList.get(position).getLocation().getAddress();
            holder.itemAddress.setText(placeAddress);
            targetPos = position;
//            getPlacesDetailsPresenter.getPlaces(venuesItemList.get(position).
//                    getId());
        }
        s = holder.itemImage;
        holder.itemName.setText(placeName);
    }

    @Override
    public int getItemCount() {
        if (venuesItemList != null) {
            return venuesItemList.size();
        } else {
            return 0;
        }
    }
    @Override
    public void onGetPlacesDetailsSuccess(FoursquareImageResponseModel foursquarePlaceDetailsResponseModel) {
        if(foursquarePlaceDetailsResponseModel.getResponse().getPhotos().getItems()!=null
        && !foursquarePlaceDetailsResponseModel.getResponse().getPhotos().getItems().isEmpty()) {
            url = foursquarePlaceDetailsResponseModel.getResponse()
                    .getPhotos().getItems().get(0).getPrefix() + "" + foursquarePlaceDetailsResponseModel.getResponse()
                    .getPhotos().getItems().get(0).getWidth() + "x" + foursquarePlaceDetailsResponseModel.getResponse()
                    .getPhotos().getItems().get(0).getHeight() + "" + foursquarePlaceDetailsResponseModel.getResponse()
                    .getPhotos().getItems().get(0).getSuffix();
//            Glide.with(context).load(url).into(s);
            Log.d("targetId", " is " + url + " target post" + targetPos);

        }        else {
            Log.d("targetId", " is null");
        }
    }

    @Override
    public void onGetPlacesDetailsFail(String message) {
        Log.d("targetId", " is null");
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }


    public static class MainAdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView itemName , itemAddress;
        private ImageView itemImage;
        public MainAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = (TextView) itemView.findViewById(R.id.place_name);
            itemAddress = (TextView) itemView.findViewById(R.id.place_address);
            itemImage =  itemView.findViewById(R.id.item_image);
        }
    }
}
