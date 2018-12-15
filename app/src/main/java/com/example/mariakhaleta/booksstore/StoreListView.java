package com.example.mariakhaleta.booksstore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StoreListView extends AppCompatActivity {

    private static final Integer GRID_ELEMENTS_COUNT = 2;

    private Context mContext;
    private List<Store> mStoreList;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stores);
        mContext = this;

        mRecyclerView = findViewById(R.id.storeRecyclerView);
        mRecyclerView.setHasFixedSize(true);//run app
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        mStoreList = new ArrayList<>();

        loadProducts();
    }

//    public void TestToBookInfo(View view) {
//        Intent intent = new Intent(mContext, BookInfoActivity.class);
//        //showMessage(String.valueOf(mRecyclerView.getChildAdapterPosition(view)));
//        startActivity(intent);
//    }

    private void loadProducts() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, BDConstant.STORE_LIST,
                response -> {
                    try {
                        showMessage("Connection to server established");
                        JSONArray array = new JSONArray(response);

                        for (int i = 0; i < array.length(); i++) {
                            JSONObject stores = array.getJSONObject(i);

                            mStoreList.add(new Store(
                                    stores.getString("Title"),
                                    stores.getString("OpenHour"),
                                    stores.getString("Contacts")
                            ));
                        }

                        mRecyclerView.setAdapter(new StoreController(mStoreList, mContext));
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

    public void Home(View view) {
        Intent intent = new Intent(mContext, BooksListView.class);
        startActivity(intent);
    }

    public void Shop(View view) {
        Intent intent = new Intent(mContext, StoreListView.class);
        startActivity(intent);
    }

    public void Person(View view) {
        Intent intent = new Intent(mContext, UserOwnCabinet.class);
        startActivity(intent);
    }
}
