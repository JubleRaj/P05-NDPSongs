package com.example.a15017082.p05_ndpsongs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowSong extends AppCompatActivity {

    ListView lv;

    ShowAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_song);

        lv = (ListView) findViewById(R.id.lv);

        DBHelper db = new DBHelper(this);
        ArrayList<Song> al = db.getAllSongs();
        aa = new ShowAdapter(this, R.layout.row, al);
        lv.setAdapter(aa);




    }
}
