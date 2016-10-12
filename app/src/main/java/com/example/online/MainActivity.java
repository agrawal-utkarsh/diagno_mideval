package com.example.online;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class MainActivity extends Activity {

    EditText e;
    String text;
    Button b1,b2;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.bas1);
        b2=(Button)findViewById(R.id.bas2);
        textView=(TextView)findViewById(R.id.textView);
        ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null && networkInfo.isConnected())
        {
            textView.setVisibility(View.INVISIBLE);
        }
        else
        {
            b1.setEnabled(false);
            b2.setEnabled(false);
        }

        e=(EditText)findViewById(R.id.uiop);

    }










    public void onLogin(View view)
    {
            text=e.getText().toString();

        new BTask().execute(text);


        }

    class BTask extends AsyncTask<String, Void, String> {
        String json_url;

        @Override
        protected void onPreExecute() {
            json_url = "http://lapla.net23.net/login.php";
        }


        @Override
        protected String doInBackground(String... args) {
            String check;
            check = args[0];
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("login_name", "UTF-8") + "=" + URLEncoder.encode(check, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }


        @Override
        protected void onProgressUpdate(Void... values) {

            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

















    public void addApp(View view)
    {
        startActivity(new Intent(this,Addinfo.class));
    }

    public void addHistory(View view)
    {
        startActivity(new Intent(this,Addinfo_history.class));
    }


    public void viewRegistration(View view)

    {
        try{
        Intent intent = new Intent(this, jason.class);
            text=e.getText().toString();

            intent.putExtra("json_born",text);
        startActivity(intent);
        Toast.makeText(MainActivity.this,"YOYYOYOYO",Toast.LENGTH_LONG).show();
    }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public void viewAppointment(View view)

    {
        try{
            Intent intent = new Intent(this, jason_appointment.class);
            text=e.getText().toString();

            intent.putExtra("json_born",text);
            startActivity(intent);
            Toast.makeText(MainActivity.this,"YOYYOYOYO",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }


    public void viewFullHistory(View view)

    {
        try{
            Intent intent = new Intent(this, jason_fullHistory.class);
            text=e.getText().toString();

            intent.putExtra("json_born",text);
            startActivity(intent);
            Toast.makeText(MainActivity.this,"YOYYOYOYO",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }


}
