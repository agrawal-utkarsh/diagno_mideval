package com.example.online;

import android.app.Activity;
import android.app.AlertDialog;
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
import java.io.EOFException;
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

    EditText ety;
    String text;
    char[] charArray;
    String tan;

    Button b1;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.logo);

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
        }

        ety=(EditText)findViewById(R.id.uiop);


        final TextView registerLink = (TextView) findViewById(R.id.tvRegisterHere);
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
  //                  Toast.makeText(MainActivity.this, "onclick listener", Toast.LENGTH_LONG).show();

                    Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                    MainActivity.this.startActivity(registerIntent);
                }
                catch (Exception e)
                {
//                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();

                }
            }
        });







    }


    class BTask extends AsyncTask<String, Void, String>
    {
        String json_url;
        Context ctx;
        AlertDialog ae;

        BTask(Context ctx) {
            this.ctx = ctx;
        }

        @Override
        protected void onPreExecute() {
            ae = new AlertDialog.Builder(ctx).create();
            ae.setTitle("Login Information....");
            json_url = "http://lapla.net23.net/login.php";
        }


        @Override
        protected String doInBackground(String... args)
        {
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
        protected void onPostExecute(String result) {
            {
                ae.setMessage(result);
                ae.show();
                charArray = result.toCharArray();

            }

        }
    }


    public void onLogin(View view)
    {
        text=ety.getText().toString();    //abhi doctor hard hai

        if(text.equals("900") || text.equals("901") ||text.equals("902") || text.equals("903") || text.equals("904") || text.equals("905") )
        {
            try{
                Intent intent = new Intent(this, patient.class);
                intent.putExtra("json_born", text);
                tan="yes";
                intent.putExtra("doc",tan);
                startActivity(intent);
                // Toast.makeText(MainActivity.this, "900YO900Y0", Toast.LENGTH_LONG).show();

            } catch (Exception e)
            {
                //   Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();

            }
        }


        else

        {
            try
            {

                new BTask(this).execute(text);

                if (charArray[6]=='s') //login is successful
                {
                    Intent intent = new Intent(this, patient.class);
                    intent.putExtra("json_born", text);
                    tan="no";
                    intent.putExtra("doc",tan);
                    startActivity(intent);

                }
            }
            catch (Exception e)
            {
                //Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }

        }
    }

}

