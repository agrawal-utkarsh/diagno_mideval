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

public class ContactAdapter2 extends ArrayAdapter
{
                                                  //yaha pe hoga logic patient !! hashing function ka jaadu

    List list=new ArrayList();                   // toh at the heart of my custom contactAdapter lies a fucking ArrayList

    public ContactAdapter2(Context context, int resource)
    {
        super(context,resource);
    }


    public void add(Contacts2 object)
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
            row=layoutInflater.inflate(R.layout.row_layout2,parent,false);
            contactHolder=new ContactHolder();

            contactHolder.tx_dated=(TextView) row.findViewById(R.id.tx_dated);
            row.setTag(contactHolder);
        }
        else
        {
            contactHolder=(ContactHolder) row.getTag();
        }

        Contacts2 contacts=(Contacts2) this.getItem(position);

        contactHolder.tx_dated.setText(contacts.getDated());
        return row;
    }

    static class ContactHolder
    {
        TextView tx_dated;

    }

}


