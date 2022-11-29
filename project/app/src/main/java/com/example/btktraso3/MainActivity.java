package com.example.btktraso3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Language> languages;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        adapter=new Adapter(this, R.layout.item_layout,languages);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Detail.class);
                intent.putExtra("ten",languages.get(i).getName());
                startActivity(intent);
            }
        });
    }
    private void AnhXa() {
        listView= (ListView) findViewById(R.id.lv);
        languages = new ArrayList<>();
        languages.add(new Language("Ngôn ngữ Việt Nam", R.drawable.vietnam));
        languages.add(new Language("Ngôn ngữ Anh",R.drawable.anh));
        languages.add(new Language("Ngôn ngữ Pháp",R.drawable.phap));
        languages.add(new Language("Ngôn ngữ Nga",R.drawable.nga));
        languages.add(new Language("Ngôn ngữ Trung",R.drawable.trungquoc));
        languages.add(new Language("Ngôn ngữ Ả Rập",R.drawable.arap));

    }
}