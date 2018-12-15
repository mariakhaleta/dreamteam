package com.example.mariakhaleta.booksstore;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class StoreViewHolder extends RecyclerView.ViewHolder {

    TextView mContacts;
    TextView mTimeWork;
    TextView mAdress;

    StoreViewHolder(View itemView) {
        super(itemView);
        mContacts = itemView.findViewById(R.id.contacts);
        mTimeWork = itemView.findViewById(R.id.timeWork);
        mAdress = itemView.findViewById(R.id.adress);
    }
}
