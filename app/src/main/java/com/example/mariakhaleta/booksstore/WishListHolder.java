package com.example.mariakhaleta.booksstore;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class WishListHolder extends RecyclerView.ViewHolder{

    TextView mTextViewTitle;
    TextView mTextViewPrice;
    ImageView mCover;

    public WishListHolder(@NonNull View itemView) {
        super(itemView);
        mTextViewTitle = itemView.findViewById(R.id.wishListTitle);
        mTextViewPrice = itemView.findViewById(R.id.wishListPrice);
        mCover = itemView.findViewById(R.id.wishListCover);
    }
}
