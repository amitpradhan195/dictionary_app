package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView lstDictionary;
    private Map<String, String> dictionary;

    //array with key and value
    public static final String words[] = {
            "अब | aba","now, from now on",
            "अबेला | abela","bound, tied up confined",
            "अबेर | aber","late",
            "अबेर भयो | aber bhayo","it is late",
            "आभास | abhas","glimpse, shadow,\n" +"reflection, vision, faint\n" +"memory, inkling",
            "अभाव | abhav","non-existence, absence,\n" +"lack, scarcity",
            "अभय | abhaya","",
            "अभिभावक | abhibhavak","guardian",
            "अभिलेख | abhilekh","inscription",
            "अभिनय | abhinaya","mimicry, imitation",
            "अभिप्रेरित | abhiprerit","motivated",
            "अभिरुचि | abhiruci","inclination, earnest desire,\n" +"liking",
            "अभियोग | abhiyog","accusation, allegation,\n" +"charge",
            "अभियुक्त | abhiyukta","accused",
            "अभ्यास | abhyas","practice",
            "अचम्म | acamma","surprise, wonder,\n" +"amazement",
            "अचम्म लग्नु | acamma lagnu","to be surprised, to be\n" +"amazed, to be astonished",
            "अचम्म पर्नु | acamma parnu","to be surprised, to be\n" +"amazed, to be astonished",
            "अचानक | acanak","suddenly, abruptly,\n" +"unexpectedly",
            "अचानो | acano","suddenly, abruptly,\n" +"unexpectedly",
            "अचार | acar","hot and sour pickle, pickles,\n" +"chutney, salsa",
            "आचरण | acaran","conduct, behaviour,\n" +"practice",
            "अचेल | acel","these days, nowadays,\n" +"recently, presently",
            "आड | aad","support, prop",
            "अदालत | adalat","law cour",
            "आदन - प्रदान | adan-pradan","giving and taking of things,\n" +"exchange, social\n" +"communication, give and\n" +"take",
            "आदरणीय | adarniya","respectable, deserving\n" +"honour",
            "आदरणीय सदस्य | adarniya sadasya","honorary member",
            "आदर्श | adarsh","ideal, value",
            "अदाउनु | adaunu","to support, to hold up, to\n" +"stop",
            "अड्डा | aada","office; court of law",
            "आदेश | adesh","order, instruction,\n" +"command",
            "आधा | adha","half",
            "अढाई बजे | adhai baje","half past two",
            "आधार | adhar","foundation, basis, support",
            "आधारात | adharat","midnight",
            "आधारभूत | adharbhut","basic, fundamental",
            "आधारित | adharit","based upon",
            "अधर्म | adharma","sinfulness, irreligiousness",
            "आधि | adhi","almost a half",
            "अधिकार | adhikar","right, authority, procession,\n" +"proprietorship",
            "अधिकारी | adhikari","officer, one having\n" +"authority, magistrate,\n" +"proprietor",
            "अधिकृत | adhikrit","authorised, vested with\n" +"authority",
            "अधिराज | adhiraj","supreme ruler, sovereign,\n" +"overlord",
            "अधिराज्य | adhirajya","sovereignty, empire,\n" +"kingdom",
            "अधिवेशन | adhiveshan","session, meeting, sitting",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstDictionary = findViewById(R.id.lstDictionary);
        dictionary = new HashMap<>();

        for(int i =0; i<words.length;i+=2){
            dictionary.put(words[i],words[i+1]);
        }

        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );

        lstDictionary.setAdapter(adapter);

        lstDictionary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String key = parent.getItemAtPosition(position).toString();

                String meaning = dictionary.get(key);
                System.out.println(meaning);

                Intent intent = new Intent(MainActivity.this, MeaningActivity.class);
                intent.putExtra("meaning",meaning);
                startActivity(intent);
            }
        });
    }
}
