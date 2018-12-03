package com.example.mariakhaleta.booksstore;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BooksController extends RecyclerView.Adapter<BooksController.ProductViewHolder> {

    private Context mCtx;
    private List<Books> booksList;

    public BooksController(Context mCtx, List<Books> booksList) {
        this.mCtx = mCtx;
        this.booksList = booksList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.product_list, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Books book = booksList.get(position);

        //loading the image
//        Glide.with(mCtx)
//                .load(product.getImage())
//                .into(holder.imageView);

        holder.textViewTitle.setText(book.getTitle());
        holder.textViewPrice.setText(book.getPrice());
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewPrice;
        //ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.tesxtTitle);
            textViewPrice = itemView.findViewById(R.id.textPrice);
            //imageView = itemView.findViewById(R.id.booksImage);
        }
    }
}

