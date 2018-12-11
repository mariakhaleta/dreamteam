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

public class BooksListView extends AppCompatActivity {

    private static final String SERVER_IP_ADDRESS = "http://192.168.1.6/booksList.php/";
    private static final Integer GRID_ELEMENTS_COUNT = 2;

    private Context mContext;
    private List<Books> mProductList;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, GRID_ELEMENTS_COUNT));

        mProductList = new ArrayList<>();

        loadProducts();
    }

//    public void TestToBookInfo(View view) {
//        Intent intent = new Intent(mContext, BookInfoActivity.class);
//        //showMessage(String.valueOf(mRecyclerView.getChildAdapterPosition(view)));
//        startActivity(intent);
//    }

    private void loadProducts() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, SERVER_IP_ADDRESS,
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

                        mRecyclerView.setAdapter(new BooksController(mProductList, mContext));
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
