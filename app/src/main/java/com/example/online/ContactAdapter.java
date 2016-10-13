package com.example.online;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends ArrayAdapter
{
                                                  //yaha pe hoga logic patient !! hashing function ka jaadu

    List list=new ArrayList();                   // toh at the heart of my custom contactAdapter lies a fucking ArrayList

    public ContactAdapter(Context context,int resource)
    {
        super(context,resource);
    }


    public void add(Contacts object)
    {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position)
    {
        return list.get(position );
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        View row;
        row=convertView;
        ContactHolder contactHolder;
        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout,parent,false);
            contactHolder=new ContactHolder();

            contactHolder.tx_adhar=(TextView) row.findViewById(R.id.tx_adhar);
            contactHolder.tx_name=(TextView) row.findViewById(R.id.tx_name);
            contactHolder.tx_age=(TextView) row.findViewById(R.id.tx_age);
            contactHolder.tx_residence=(TextView) row.findViewById(R.id.tx_residence);
            contactHolder.tx_gender=(TextView) row.findViewById(R.id.tx_gender);
            contactHolder.tx_profile=(TextView) row.findViewById(R.id.tx_profile);
            row.setTag(contactHolder);
        }
        else
        {
            contactHolder=(ContactHolder) row.getTag();
        }

        Contacts contacts=(Contacts) this.getItem(position);

        contactHolder.tx_adhar.setText(contacts.getAdhar_id());
        contactHolder.tx_name.setText(contacts.getName());
        contactHolder.tx_age.setText(contacts.getAge());
        contactHolder.tx_residence.setText(contacts.getResidence());
        contactHolder.tx_gender.setText(contacts.getGender());
        contactHolder.tx_profile.setText(contacts.getProfile_pic());
        return row;
    }

    static class ContactHolder
    {
        TextView tx_adhar,tx_name,tx_age,tx_residence,tx_gender,tx_profile;

    }

}


