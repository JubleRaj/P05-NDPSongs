package com.example.a15017082.p05_ndpsongs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ShowSong extends AppCompatActivity {

    ArrayList<String> al;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_song);

        ListView lv = (ListView) findViewById(R.id.lv);

        al = new ArrayList<String>();
        DBHelper db = new DBHelper(this);

        al = db.getAllSongs();

        aa = new ArrayAdapter<String>(this,
                R.layout.row, al);
        lv.setAdapter(aa);




    }
}
