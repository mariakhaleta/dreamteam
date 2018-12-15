package com.example.mariakhaleta.booksstore;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;


public class BooksController extends RecyclerView.Adapter<ProductViewHolder> {

    private static final String PRICE_POSTFIX = " грн.";
    public static final String EXTRA_BOOK_ID = "EXTRA_BOOK_ID";

    private Context mContext;
    private List<Books> mBookList;

    BooksController(List<Books> bookList, Context context) {
        this.mContext = context;
        this.mBookList = bookList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.product_list, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Books book = mBookList.get(position);
        Glide.with(mContext)
                .load(book.getCover())
                .into(holder.mCover);
        holder.mTextViewTitle.setText(book.getTitle());
        holder.mTextViewPrice.setText(String.format("%d%s", book.getPrice(), PRICE_POSTFIX));

        holder.mTextViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BookInfoActivity.class);
                intent.putExtra(EXTRA_BOOK_ID, book.getBookID());
                mContext.startActivity(intent);
            }
        });
        holder.mCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BookInfoActivity.class);
                intent.putExtra(EXTRA_BOOK_ID, book.getBookID());
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mBookList.size();
    }
}