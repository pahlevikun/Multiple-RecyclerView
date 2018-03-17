/*
 * SelectLocationAdapter Created with ♥ by Farhan Yuda Pahlevi on 12/27/17 12:57 PM
 * Copyright (c) 2017. All Rights Reserved.
 *
 * Last Modified 12/22/17 11:28 PM
 */

package com.github.pahlevikun.multipleselectrecyclerview.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.pahlevikun.multipleselectrecyclerview.R;
import com.github.pahlevikun.multipleselectrecyclerview.model.SampleModel;

import java.util.ArrayList;

/**
 * Created by farhan on 6/30/17.
 */

public class SelectAdapter extends RecyclerView.Adapter<SelectAdapter.ViewHolder> {
    public ArrayList<SampleModel> listData;
    public ArrayList<SampleModel> listSelectData;
    private Context context;

    public SelectAdapter(Context context, ArrayList<SampleModel> listData,
                         ArrayList<SampleModel> listSelectData) {
        this.listData = listData;
        this.context = context;
        this.listSelectData = listSelectData;
    }

    @Override
    public SelectAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SelectAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.textView.setText(listData.get(i).getNama());
        if(listSelectData.contains(listData.get(i))) {
            viewHolder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorBgSelect));
        }else {
            viewHolder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorBgUnSelect));
        }
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private LinearLayout linearLayout;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textViewAdapter);
            linearLayout = view.findViewById(R.id.linearLayout);
        }
    }

}

