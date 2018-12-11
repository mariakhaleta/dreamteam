package com.example.mariakhaleta.booksstore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BookInfoActivity extends AppCompatActivity {
    private static final String SERVER_IP_ADDRESS = "http://192.168.1.6/booksList.php/";
    private static final Integer DEFAULT_BOOK_ID = 0;

    private Context mContext;
    private Integer mIntentBookID;

    private TextView mTextViewTitle;
    private TextView mTextViewPrice;
    private TextView mAuthorInfo;
    private TextView mGenreInfo;
    private TextView mDescriptionInfo;
    private ImageView mCover;
    private TextView mAuthorInfoPodrob;
    private TextView mGenreInfoPodrob;
    private TextView mPublisherInfo;
    private TextView mDateOfPubInfo;
    private TextView mLangOfPubInfo;
    private TextView mBindingInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_information);
        mContext = this;

        mIntentBookID = getIntent().getIntExtra(BooksController.EXTRA_BOOK_ID, DEFAULT_BOOK_ID);

        mTextViewTitle = findViewById(R.id.titleInfo);
        mAuthorInfo = findViewById(R.id.authorInfo);
        mAuthorInfoPodrob = findViewById(R.id.authorInfoPodrob);
        mTextViewPrice = findViewById(R.id.priceInfo);
        mGenreInfo = findViewById(R.id.genreInfo);
        mDescriptionInfo = findViewById(R.id.descriptionInfo);
        mCover = findViewById(R.id.coverInfo);
        mGenreInfoPodrob = findViewById(R.id.genreInfoPodrob);
        mPublisherInfo = findViewById(R.id.publisherInfo);
        mDateOfPubInfo = findViewById(R.id.dateOfPubInfo);
        mLangOfPubInfo = findViewById(R.id.langOfPubInfo);
        mBindingInfo = findViewById(R.id.bindingInfo);
        loadProducts();
    }

    private void loadProducts() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, SERVER_IP_ADDRESS,
                response -> {
                    try {
                        showMessage("Connection to server established");
                        JSONArray array = new JSONArray(response);

                        for (int i = 0; i < array.length(); i++) {
                            JSONObject books = array.getJSONObject(i);

                            if(books.getInt("BookID") == mIntentBookID) {

                                mTextViewTitle.setText(books.getString("Title"));
                                mAuthorInfo.setText(books.getString("Author"));
                                Glide.with(mContext)
                                        .load(books.getString("Cover"))
                                        .into(mCover);
                                mTextViewPrice.setText(books.getString("Price"));
                                mAuthorInfoPodrob.setText(books.getString("Author"));
                                mGenreInfo.setText(books.getString("Genre"));
                                mDescriptionInfo.setText(books.getString("Description"));
                                mGenreInfoPodrob.setText(books.getString("Genre"));
                                mPublisherInfo.setText(books.getString("Publisher"));
                                mDateOfPubInfo.setText(books.getString("DateOfPub"));
                                mLangOfPubInfo.setText(books.getString("LangOfPub"));
                                mBindingInfo.setText(books.getString("Binding"));
                                break;
                            }
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

    public void Back(View view) {
        Intent intent = new Intent(mContext, BooksListView.class);
        mContext.startActivity(intent);
    }
}
