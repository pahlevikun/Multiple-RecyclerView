package com.github.pahlevikun.multipleselectrecyclerview.view.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.github.pahlevikun.multipleselectrecyclerview.R;
import com.github.pahlevikun.multipleselectrecyclerview.model.SampleModel;
import com.github.pahlevikun.multipleselectrecyclerview.view.adapter.DataAdapter.OnItemClickInterface;
import com.github.pahlevikun.multipleselectrecyclerview.view.adapter.DataAdapter.SelectAdapterItemClickListener;
import com.github.pahlevikun.multipleselectrecyclerview.view.adapter.MainAdapter.MainAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<SampleModel> sampleList = new ArrayList<>();

    private Button btSelect;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSelect = findViewById(R.id.buttonSelect);
        recyclerView = findViewById(R.id.recyclerView);

        btSelect.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DataActivity.class);
            startActivityForResult(intent, 123);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {
            if (resultCode == Activity.RESULT_OK) {
                sampleList = data.getParcelableArrayListExtra("result");
                setupRecycler();
            }
        }
    }

    private void setupRecycler() {
        adapter = new MainAdapter(this, sampleList);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
