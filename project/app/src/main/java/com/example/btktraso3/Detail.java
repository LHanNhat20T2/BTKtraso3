package com.example.btktraso3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {
    EditText edtvidu;
    Button btnluu;
    TextView txtten;
    ListView listview;

    ArrayAdapter<String> adapter;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        btnluu = (Button) findViewById(R.id.btnluu);
        listview = (ListView) findViewById(R.id.lvrs);
        edtvidu = (EditText) findViewById(R.id.edtvd);
        txtten = (TextView) findViewById(R.id.textviewTen);

        Intent intent= getIntent();
        txtten.setText(intent.getStringExtra("ten"));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);
    }

    public void saveData(View view) {
        if (edtvidu.getText().toString().isEmpty()) {
            edtvidu.setError("Nhập lại");
        } else {
            list.add(edtvidu.getText().toString());
            edtvidu.setText("");
            adapter.notifyDataSetChanged();
        }
    }
}
