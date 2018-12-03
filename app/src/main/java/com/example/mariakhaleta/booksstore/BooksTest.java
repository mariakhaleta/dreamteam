package com.example.mariakhaleta.booksstore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BooksTest extends AppCompatActivity {

    private static final String SERVER_IP_ADDRESS = "http://192.168.1.6/booksList.php/";


    List<Books> booksList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        BottomNavigationView bottomNavigationView = (BottomNavigationView)
//                findViewById(R.id.bottom_navigation);

//        bottomNavigationView.setOnNavigationItemSelectedListener(
//                new BottomNavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                        switch (item.getItemId()) {
//
//                            //getting the recyclerview from xml
//
//                        }
//                        return true;
//                    }
//                });
        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the booksList
        booksList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadBooks();
    }

    private void loadBooks() {

        /*
         * Creating a String Request
         * The request type is GET defined by first parameter
         * The URL is defined in the second parameter
         * Then we have a Response Listener and a Error Listener
         * In response listener we will get the JSON response as a String
         * */
        StringRequest stringRequest = new StringRequest(Request.Method.GET, SERVER_IP_ADDRESS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject books = array.getJSONObject(i);

                                //adding the product to product list
                                booksList.add(new Books(
                                        books.getInt("bookID"),
                                        books.getString("title"),
                                        books.getString("author"),
                                        books.getString("langOfPub"),
                                        books.getString("dateOfPub"),
                                        books.getString("description"),
                                        books.getString("audiobook"),
                                        books.getString("textpreview"),
                                        books.getString("binding"),
                                        books.getString("publisher"),
                                        books.getString("genre"),
                                        books.getString("vendorCode"),
                                        books.getString("cover"),
                                        books.getString("price")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            BooksController adapter = new BooksController(BooksTest.this, booksList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
