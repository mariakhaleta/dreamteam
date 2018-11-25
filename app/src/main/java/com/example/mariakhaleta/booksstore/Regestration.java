package com.example.mariakhaleta.booksstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class Regestration extends AppCompatActivity {

    EditText userName, userLastName, userPhone, userEmail, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regestration);
        userName = (EditText)findViewById(R.id.regName);
        userLastName = (EditText)findViewById(R.id.regLastName);
        userPhone = (EditText)findViewById(R.id.regPhone);
        userEmail = (EditText)findViewById(R.id.regEmail);
        userPassword = (EditText)findViewById(R.id.regPassword);
    }

    public void onRegestration(View view) {
        String strName = userName.getText().toString();
        String strLastName = userLastName.getText().toString();
        String strPhone = userPhone.getText().toString();
        String strEmail = userEmail.getText().toString();
        String strPassword = userPassword.getText().toString();

        String type = "regestration";
        LoginBackGround loginBackGround = new LoginBackGround(this);
        loginBackGround.execute(type, strName, strLastName, strPhone, strEmail, strPassword);

        String serverResult = "";
        try {
            serverResult = loginBackGround.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (serverResult) {
            case "Regestration successful": {
                Intent intent = new Intent(this, MainContentLayout.class);
                startActivity(intent);
                break;
            }
            case "regestration isn't success": {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Проверьте интернет соединение.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
            case "": {
                //TODO: Server unavailable(Toast)
                break;
            }
        }
    }
}
