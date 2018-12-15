package com.example.mariakhaleta.booksstore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class StoreController extends RecyclerView.Adapter<StoreViewHolder>  {

    private Context mContext;
    private List<Store> mStoreList;

    StoreController(List<Store> storeList, Context context) {
        this.mContext = context;
        this.mStoreList = storeList;
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.stores_list, null);
        return new StoreViewHolder(view);
    }

    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {
        Store store = mStoreList.get(position);
        holder.mAdress.setText(store.getTitle());
        holder.mContacts.setText(store.getContacts());
        holder.mTimeWork.setText(store.getOpenHour());

    }

    @Override
    public int getItemCount() {
        return mStoreList.size();
    }
}
