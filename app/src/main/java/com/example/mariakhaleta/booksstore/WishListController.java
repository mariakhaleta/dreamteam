package com.example.mariakhaleta.booksstore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class WishListController extends RecyclerView.Adapter<WishListHolder> {

    private static final String PRICE_POSTFIX = " грн.";

    private Context mContext;
    private List<Books> mBookList;

    WishListController(List<Books> bookList, Context context) {
        this.mContext = context;
        this.mBookList = bookList;
    }

    @NonNull
    public WishListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.wish, null);
        return new WishListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishListHolder viewHolder, int position) {

        Books book = mBookList.get(position);
        Glide.with(mContext)
                .load(book.getCover())
                .into(viewHolder.mCover);
        viewHolder.mTextViewTitle.setText(book.getTitle());
        viewHolder.mTextViewPrice.setText(String.format("%d%s", book.getPrice(), PRICE_POSTFIX));

    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }
}
