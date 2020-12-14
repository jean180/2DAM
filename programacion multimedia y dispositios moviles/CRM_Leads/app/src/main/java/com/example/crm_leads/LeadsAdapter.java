package com.example.crm_leads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class LeadsAdapter extends ArrayAdapter<Lead> {
    public  LeadsAdapter(Context context, List<Lead> objects) {
        super(context,0,objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //Obtener inflater
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Existe el view actual?
        if (null == convertView){
            convertView = inflater.inflate(
                    R.layout.list_item_lead,
                    parent,
                    false
            );
        }

        //Referencias UI
        ImageView avatar = (ImageView) convertView.findViewById(R.id.iv_avatar);
        TextView name = (TextView) convertView.findViewById(R.id.tv_name);
        TextView title = (TextView) convertView.findViewById(R.id.tv_title);
        TextView company = (TextView) convertView.findViewById(R.id.tv_company);

        //Lead actual
        Lead lead = getItem(position);

        //Setup
        Glide.with(getContext()).load(lead.getmImage()).into(avatar);
        name.setText(lead.getmName());
        title.setText(lead.getmTitle());
        company.setText(lead.getmCompany());

        return convertView;
    }
}
