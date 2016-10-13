package com.example.online;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContactAdapter contactAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout); //pehle to iss activity ka layout attach kar dia ;simple hai
        listView=(ListView)findViewById(R.id.listview);  //ab list view namak widget ko pakad liya iss variable mei
                                                        //ab is widget par adapter lagate hai. vo adapter rakhta hai apne paas modified MKC

        contactAdapter=new ContactAdapter(this,R.layout.row_layout);//yaha par adapter paida kiya hai ayr usko hashing function se attach kar dia hai
        listView.setAdapter(contactAdapter);//yaha par list view k saath adapter ko attach kar dia
        json_string=getIntent().getExtras().getString("json_data");//ye apna data xD ab aa raa hai MC.  ab bas data ko adapter mei paas karna hai jo hashing function mei
                                                                   // paas kar dega aur jaadu bina kisi logic k patient !!
                                                                    // nai nai logic toh hai ContactAdapter.java mei hai

        //listview with custom adapter and custom layout
            try
            {
                jsonObject = new JSONObject(json_string);
                jsonArray=jsonObject.getJSONArray("server_response");
                int count=0;
//                String name,email,mobile;
                String adhar_id,name,age,residence,gender,profile_pic;
                while(count<jsonArray.length())
                {

                    JSONObject JO=jsonArray.getJSONObject(count);
                    adhar_id=JO.getString("adhar_id");
                    name=JO.getString("name");
                    age=JO.getString("age");
                    residence=JO.getString("residence");
                    gender=JO.getString("gender");
                    profile_pic=JO.getString("profile_pic");

                    Contacts contacts=new Contacts(adhar_id,name,age,residence,gender,profile_pic);

                    contactAdapter.add(contacts);// ye ,ye kia paas adapter mei jo ab hashing function mei paas karega logic k thru
                    count++;
                }

            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
    }
}
