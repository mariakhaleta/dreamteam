package com.example.mariakhaleta.booksstore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainContentLayout extends AppCompatActivity {
    private Context mCurrentActivity;

    private Button button;
    //private static final String SERVER_IP_ADDRESS = "http://10.12.40.125/SERVER_IP_ADDRESS/booksList.php/";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_content);

        mCurrentActivity = this;


    }
    public void test3(View view) {
        Intent intent = new Intent(mCurrentActivity, BooksListView.class);
        startActivity(intent);
    }
    public void test4(View view) {
        Intent intent = new Intent(mCurrentActivity, UserOwnCabinet.class);
        startActivity(intent);
    }

    public void store1(View view) {
        Intent intent = new Intent(mCurrentActivity, StoreListView.class);
        startActivity(intent);
    }

    public void wishlisttest(View view) {
        Intent intent = new Intent(mCurrentActivity, WishListView.class);
        startActivity(intent);
    }
}
