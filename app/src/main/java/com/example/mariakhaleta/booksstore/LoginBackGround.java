package com.example.mariakhaleta.booksstore;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class LoginBackGround extends AsyncTask<String, Void, String> {
    Context context;
    String result;

    public LoginBackGround(Context ctx) {

        context = ctx;
        result = "";
    }

    @Override
    protected String doInBackground(String... params) {

        String type = params[0];
        String url_login = BDConstant.SERVER_LOGIN_PAGE;
        String url_regestration = BDConstant.SERVER_REGESTRATION_PAGE;

        if (type.equals("login"))
            try {
                String login = params[1];
                String password = params[2];
                URL url = new URL(url_login);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_login", "UTF-8") + "=" + URLEncoder.encode(login, "UTF-8") + "&"
                        + URLEncoder.encode("user_password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {

                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        else if (type.equals("regestration"))
            try {
                String name = params[1];
                String lastName = params[2];
                String phoneNumber = params[3];
                String email = params[4];
                String password = params[5];
                URL url = new URL(url_regestration);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("user_login", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("user_lastname", "UTF-8") + "=" + URLEncoder.encode(lastName, "UTF-8") + "&" +
                        URLEncoder.encode("user_number", "UTF-8") + "=" + URLEncoder.encode(phoneNumber, "UTF-8") + "&" +
                        URLEncoder.encode("user_password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {

                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onPostExecute(String avoid) {
        super.onPostExecute(result);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
