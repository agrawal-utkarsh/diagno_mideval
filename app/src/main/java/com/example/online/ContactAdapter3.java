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

public class ContactAdapter3 extends ArrayAdapter
{
                                                  //yaha pe hoga logic patient !! hashing function ka jaadu

    List list=new ArrayList();                   // toh at the heart of my custom contactAdapter lies a fucking ArrayList

    public ContactAdapter3(Context context, int resource)
    {
        super(context,resource);
    }


    public void add(Contacts3 object)
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
            row=layoutInflater.inflate(R.layout.row_layout3,parent,false);
            contactHolder=new ContactHolder();

            contactHolder.tx_adhar=(TextView) row.findViewById(R.id.tx_adhar);
            contactHolder.tx_date=(TextView) row.findViewById(R.id.tx_date);
            contactHolder.tx_hosname=(TextView) row.findViewById(R.id.tx_hosname);
            contactHolder.tx_hosid=(TextView) row.findViewById(R.id.tx_hosid);
            contactHolder.tx_docname=(TextView) row.findViewById(R.id.tx_docname);
            contactHolder.tx_dise=(TextView) row.findViewById(R.id.tx_dise);
            contactHolder.tx_spec=(TextView) row.findViewById(R.id.tx_spec);
            contactHolder.tx_medi=(TextView) row.findViewById(R.id.tx_medi);
            row.setTag(contactHolder);
        }
        else
        {
            contactHolder=(ContactHolder) row.getTag();
        }

        Contacts3 contacts=(Contacts3) this.getItem(position);

        contactHolder.tx_adhar.setText(contacts.getAdhar_id());
        contactHolder.tx_date.setText(contacts.getDate());
        contactHolder.tx_hosname.setText(contacts.getHospital_name());
        contactHolder.tx_hosid.setText(contacts.getHospital_id());
        contactHolder.tx_docname.setText(contacts.getDoctor_name());
        contactHolder.tx_dise.setText(contacts.getDiseases());
        contactHolder.tx_spec.setText(contacts.getSpecial_remarks());
        contactHolder.tx_medi.setText(contacts.getMedication());
        return row;
    }

    static class ContactHolder
    {
        TextView tx_adhar,tx_date,tx_hosname,tx_hosid,tx_docname,tx_dise,tx_spec,tx_medi;

    }

}


