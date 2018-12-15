package com.example.mariakhaleta.booksstore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserOwnCabinet extends AppCompatActivity {

    private Context mContext;

    private TextView mName;
    private TextView mBirthday;
    private TextView mNumber;
    private TextView mEmail;
    private TextView mLastName;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.own_cabinet);
        mContext = this;

        mName = findViewById(R.id.name);
        mBirthday = findViewById(R.id.birthday);
        mNumber = findViewById(R.id.number);
        mEmail = findViewById(R.id.email);
        mLastName = findViewById(R.id.lastName);


        loadProducts();
    }

    private void loadProducts() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, BDConstant.USER_ENTER,
                response -> {
                    try {
                        showMessage("Connection to server established");
                        JSONArray array = new JSONArray(response);

                        for (int i = 0; i < array.length(); i++) {
                            JSONObject user = array.getJSONObject(i);

                                mName.setText(user.getString("Name"));
                                mLastName.setText(user.getString("LastName"));
                                mBirthday.setText(user.getString("Birthday"));
                                mNumber.setText(user.getString("PhoneNumber"));
                                mEmail.setText(user.getString("Email"));
                                break;
                        }

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
