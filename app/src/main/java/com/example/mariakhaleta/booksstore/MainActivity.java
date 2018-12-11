package com.example.mariakhaleta.booksstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    EditText loginEditText, passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter);
        loginEditText = (EditText)findViewById(R.id.loginEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, Regestration.class);
        startActivity(intent);
    }

    public void test(View view) {
        Intent intent = new Intent(MainActivity.this, MainContentLayout.class);
        startActivity(intent);
    }

    public void OnLogin(View view) {
        String email = loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String type = "login";
        LoginBackGround loginBackGround = new LoginBackGround(this);
        loginBackGround.execute(type, email, password);

        String serverResult = "";
        try {
            serverResult = loginBackGround.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (serverResult) {
            case "login is success": {
                Intent intent = new Intent(this, MainContentLayout.class);
                startActivity(intent);
                break;
            }
            case "login isn't success": {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Неверный логин или пароль.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
            case "": {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Нет доступа к серверу.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
        }
    }
}
