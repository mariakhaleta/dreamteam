package com.example.mariakhaleta.booksstore;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WishListView extends AppCompatActivity {

    private Context mContext;
    private List<Books> mProductList;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wish_list);
        mContext = this;

        mRecyclerView = findViewById(R.id.recyclerWishList);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        mProductList = new ArrayList<>();

        loadProducts();
    }

//    public void TestToBookInfo(View view) {
//        Intent intent = new Intent(mContext, BookInfoActivity.class);
//        //showMessage(String.valueOf(mRecyclerView.getChildAdapterPosition(view)));
//        startActivity(intent);
//    }

    private void loadProducts() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, BDConstant.BOOKS_LIST,
                response -> {
                    try {
                        showMessage("Connection to server established");
                        JSONArray array = new JSONArray(response);

                        for (int i = 0; i < array.length(); i++) {
                            JSONObject books = array.getJSONObject(i);

                            mProductList.add(new Books(
                                    books.getInt("BookID") ,
                                    books.getString("Title"),
                                    books.getInt("Price"),
                                    books.getString("Cover")
                            ));
                        }

                        mRecyclerView.setAdapter(new WishListController(mProductList, mContext));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    showMessage("Server not respond");
                });

        Volley.newRequestQueue(mContext).add(stringRequest);
    }

    private void showMessage(String message) {
        Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
