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

    private GetPlacesDetailsPresenter getPlacesDetailsPresenter;

    public MainAdapter(Context context, List<VenuesItem> venuesItems) {
        this.context = context;
        this.venuesItemList = venuesItems;
        getPlacesDetailsPresenter = new GetPlacesDetailsPresenter(this,
                GetPlacesDetailsRepository.getInstance(GetPlacesDetailsRemoteDataSource.getInstance()));
        getPlacesDetailsPresenter.getPlaces("51d7f8408bbdd659aa6a057a");

    }

    @NonNull
    @Override
    public MainAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_main_adapter, parent, false);
        MainAdapterViewHolder viewHolder = new MainAdapterViewHolder(v);

        return viewHolder;
    }
    ImageView s;
    @Override
    public void onBindViewHolder(@NonNull MainAdapterViewHolder holder, int position) {
        String placeName = venuesItemList.get(position).getName();
        if(venuesItemList.get(position).getLocation()!=null) {
            String placeAddress = venuesItemList.get(position).getLocation().getAddress();
            holder.itemAddress.setText(placeAddress);
            targetPos = position;
        }
        s = holder.itemImage;

        Log.d("venuID is ",venuesItemList.get(position).getName() + " is value");
        Log.d("venuID is ",venuesItemList.get(position).getReferralId() + " is value");
        Log.d("venuID is ",venuesItemList.get(position).getCategories() + " is value");
        Log.d("venuID is ",venuesItemList.get(position).getLocation() + " is value");
        Log.d("venuID is ",venuesItemList.get(position).getVenuePage() + " is value");
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
    String url ;
    @Override
    public void onGetPlacesDetailsSuccess(FoursquarePlaceDetailsResponseModel foursquarePlaceDetailsResponseModel) {
//        Glide.with(context).load().into(holder.itemImage);
        if(foursquarePlaceDetailsResponseModel.getResponse().getVenue().getBestPhoto()!=null) {
//            Log.d("targetId",  + " is there");
/*            url = foursquarePlaceDetailsResponseModel.getResponse()
                    .getVenue().getBestPhoto().getPrefix() + "" + foursquarePlaceDetailsResponseModel.getResponse()
                    .getVenue().getBestPhoto().getWidth() + "x" + foursquarePlaceDetailsResponseModel.getResponse()
                    .getVenue().getBestPhoto().getHeight() + "" + foursquarePlaceDetailsResponseModel.getResponse()
                    .getVenue().getBestPhoto().getSuffix();
            Glide.with(context).load(url).into(s);*/

        }        else {
            Log.d("targetId", " is null");
        }
    }

    @Override
    public void onGetPlacesDetailsFail(String message) {
        Toast.makeText(context, " FAIl", Toast.LENGTH_SHORT).show();
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
