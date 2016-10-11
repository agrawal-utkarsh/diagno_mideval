package com.example.online;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
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

public class Addinfo extends Activity {
    EditText Adda,Datte;
    String  adda,datte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_info_layout);
        Adda=(EditText)findViewById(R.id.et_adda);
        Datte=(EditText)findViewById(R.id.et_datte);
    }

    public void saveInfo(View view)
    {
        adda=Adda.getText().toString();
        datte=Datte.getText().toString();
        BackgroundTask backgroundTask=new BackgroundTask();
        backgroundTask.execute(adda,datte);
        finish();
    }












    class BackgroundTask extends AsyncTask<String,Void,String>
    {

        String add_info_url;
        @Override
        protected void onPreExecute()
        {
            add_info_url="http://lapla.net23.net/add_info_appointments.php";

        }

        @Override
        protected String doInBackground(String... args)
        {
            String adda,datte;
            adda=args[0];
            datte=args[1];

            //network operations


            try {
                URL url = new URL(add_info_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                //httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data_string = URLEncoder.encode("aadhar_id", "UTF-8") + "=" + URLEncoder.encode(adda, "UTF-8") + "&" +
                                     URLEncoder.encode("next_date", "UTF-8") + "=" + URLEncoder.encode(datte, "UTF-8");
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
