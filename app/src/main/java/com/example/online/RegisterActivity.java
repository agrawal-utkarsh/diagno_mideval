package com.example.online;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class RegisterActivity extends Activity {

String Etage,Etname,Etaadhar_id,EtPassword,Etres,Etgen;
    EditText etAge,etName,etAadhar_id,etPassword,etres,etgen;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

         etAge= (EditText) findViewById(R.id.etAge);
         etName= (EditText) findViewById(R.id.etName);
         etAadhar_id= (EditText) findViewById(R.id.etAadhar_id);
         etPassword= (EditText) findViewById(R.id.etPassword);
         etres= (EditText) findViewById(R.id.etres);
         etgen= (EditText) findViewById(R.id.etgen);


        final Button bRegister = (Button) findViewById(R.id.bRegister);

    }


    public void register(View view)
    {
        Etage=etAge.getText().toString();
        Etname=etName.getText().toString();
        Etaadhar_id=etAadhar_id.getText().toString();
        EtPassword=etPassword.getText().toString();
        Etres=etres.getText().toString();
        Etgen=etgen.getText().toString();

        BackgroundTask backgroundTask=new BackgroundTask();
        backgroundTask.execute(Etage,Etname,Etaadhar_id,EtPassword,Etres,Etgen);
        finish();
    }












    class BackgroundTask extends AsyncTask<String,Void,String>
    {

        String add_info_url;
        @Override
        protected void onPreExecute()
        {
            add_info_url="http://lapla.net23.net/add_info_registration.php";

        }

        @Override
        protected String doInBackground(String... args)
        {
            String  Etage,Etname,Etaadhar_id,EtPassword,Etres,Etgen;
            Etage=args[0];
            Etname=args[1];
            Etaadhar_id=args[2];
            EtPassword=args[3];
            Etres=args[4];
            Etgen=args[5];

            //network operations


            try {
                URL url = new URL(add_info_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                //httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data_string = URLEncoder.encode("adhar_id", "UTF-8") + "=" + URLEncoder.encode(Etaadhar_id, "UTF-8") + "&" +
                        URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(Etname, "UTF-8")+"&"+
                        URLEncoder.encode("age", "UTF-8") + "=" + URLEncoder.encode(Etage, "UTF-8") +"&"+
                        URLEncoder.encode("residence", "UTF-8") + "=" + URLEncoder.encode(Etres, "UTF-8") +"&"+
                        URLEncoder.encode("gender", "UTF-8") + "=" + URLEncoder.encode(Etgen, "UTF-8") ;
                bufferedWriter.write(data_string);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();

                return "one row of data inserted....";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

//bieber


        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
        }

    }
}
