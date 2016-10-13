package com.example.online;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class patient extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String json_la,doc_la;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_bc1);

            doc_la = getIntent().getExtras().getString("doc");

            if (doc_la.equals("no"))
            {
                setContentView(R.layout.activity_bc);
            }




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

/////////////////////////////////////////////////////////////////////////////
        json_la = getIntent().getExtras().getString("json_born");
////////////////////////////////////////////////////////////////////////////

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //if(doc_la=="no")

    if (id == R.id.nav_personal)
    {
        try
        {
            Intent intent = new Intent(this, jason.class);


            intent.putExtra("json_born", json_la);
            startActivity(intent);
           // Toast.makeText(patient.this, "YOYYOYOYO", Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            //Toast.makeText(patient.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    else if (id == R.id.nav_history)
    {
        try
        {
            Intent intent = new Intent(this, jason_fullHistory.class);

            intent.putExtra("json_born", json_la);
            startActivity(intent);
            //Toast.makeText(patient.this, "YOYYOYOYO", Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            //Toast.makeText(patient.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    } else if (id == R.id.nav_medication)
    {


    }
    else if (id == R.id.nav_appointments)
    {
        try
        {
            Intent intent = new Intent(this, jason_appointment.class);


            intent.putExtra("json_born", json_la);
            startActivity(intent);
            //Toast.makeText(patient.this, "YOYYOYOYO", Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            //Toast.makeText(patient.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    else   if (id == R.id.nav_addappo)
                    {
                        startActivity(new Intent(this,Addinfo.class));

                    }
    else if (id == R.id.nav_addhi)
                      {
                          startActivity(new Intent(this,Addinfo_history.class));

                      }



   DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
