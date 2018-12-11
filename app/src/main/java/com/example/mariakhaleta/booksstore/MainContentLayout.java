package com.example.mariakhaleta.booksstore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainContentLayout extends AppCompatActivity {
    private Context mCurrentActivity;

    private Button button;
    //private static final String SERVER_IP_ADDRESS = "http://10.12.40.125/SERVER_IP_ADDRESS/booksList.php/";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);

        mCurrentActivity = this;

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                       // mCurrentActivity.startActivities(new Intent(MainContentLayout.this, yourActivity.this));
                        switch (item.getItemId()) {
                            case R.id.action_favorites:
                                //startActivity(new Intent(mCurrentActivity, YourActivity.this));
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Первое окно", Toast.LENGTH_SHORT);
                                toast.show();
                                button.findViewById(R.id.button);
                                break;
                            case R.id.action_music:
                                Toast toast1 = Toast.makeText(getApplicationContext(),
                                        "Второе окно", Toast.LENGTH_SHORT);
                                toast1.show();
                                break;
                            case R.id.action_schedules:
                                Toast toast2 = Toast.makeText(getApplicationContext(),
                                        "Третье окно", Toast.LENGTH_SHORT);
                                toast2.show();
                                break;
                        }
                        return true;
                    }
                });

    }
    public void test3(View view) {
        Intent intent = new Intent(mCurrentActivity, BooksListView.class);
        startActivity(intent);
    }


}
