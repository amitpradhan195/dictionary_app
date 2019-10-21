package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MeaningActivity extends AppCompatActivity {

    private TextView tvmeaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning);

        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){
            String meaning = bundle.getString("meaning");
            tvmeaning = findViewById(R.id.meaning);
            tvmeaning.setText(meaning);
        }else{
            Toast.makeText(this,"No Meaning",Toast.LENGTH_LONG).show();
        }
    }
}
