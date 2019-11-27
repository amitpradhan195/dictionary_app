package com.example.dictionaryapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLDataException;

public class SqliteActivity extends AppCompatActivity {

    EditText etWord, etMeaning;
    Button btnAddWord;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        etWord = findViewById(R.id.etWord);
        etMeaning = findViewById(R.id.etMeaning);
        btnAddWord = findViewById(R.id.btnAddWord);

        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = MyHelper.InsertData(etWord.getText().toString(), etMeaning.getText().toString(), sqLiteDatabase);

                if(id>0){
                    Toast.makeText(SqliteActivity.this, "Successful" +id, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SqliteActivity.this, "Error",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
