package com.example.mariakhaleta.booksstore;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    TextView mTextViewTitle;
    TextView mTextViewPrice;
   // ImageView mCover;

    ProductViewHolder(View itemView) {
        super(itemView);
        mTextViewTitle = itemView.findViewById(R.id.textTitle);
        mTextViewPrice = itemView.findViewById(R.id.textPrice);
       // mCover = itemView.findViewById(R.id.cover);
    }
}
