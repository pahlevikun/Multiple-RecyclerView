package com.github.pahlevikun.multipleselectrecyclerview.view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;

import com.github.pahlevikun.multipleselectrecyclerview.R;
import com.github.pahlevikun.multipleselectrecyclerview.model.SampleModel;
import com.github.pahlevikun.multipleselectrecyclerview.presenter.interfaces.OnItemClickInterface;
import com.github.pahlevikun.multipleselectrecyclerview.view.adapter.SelectAdapterItemClickListener;
import com.github.pahlevikun.multipleselectrecyclerview.view.adapter.SelectAdapter;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {

    private ArrayList<SampleModel> sampleList = new ArrayList<>();
    private ArrayList<SampleModel> sampleSelectedList = new ArrayList<>();

    ActionMode mActionMode;

    private Button btSelect;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private SelectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        btSelect = findViewById(R.id.buttonSelesai);
        recyclerView = findViewById(R.id.recyclerView2);

        setupRecycler();

        btSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setupRecycler() {
        sampleList.add(new SampleModel(0, "Pilihan 1"));
        sampleList.add(new SampleModel(1, "Pilihan 2"));
        sampleList.add(new SampleModel(2, "Pilihan 3"));
        sampleList.add(new SampleModel(3, "Pilihan 4"));
        adapter = new SelectAdapter(this, sampleList, sampleSelectedList);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        recyclerView.addOnItemTouchListener(new SelectAdapterItemClickListener(this, recyclerView,
                new OnItemClickInterface() {
                    @Override
                    public void onItemClick(View view, int position) {
                        multi_select(position);
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                }));
    }

    public void multi_select(int position) {
        if (sampleSelectedList.contains(sampleList.get(position))) {
            sampleSelectedList.remove(sampleList.get(position));
        } else {
            sampleSelectedList.add(sampleList.get(position));
        }

        refreshAdapter();
    }

    public void refreshAdapter() {
        adapter.listSelectData = sampleSelectedList;
        adapter.listData = sampleList;
        adapter.notifyDataSetChanged();
    }

}
