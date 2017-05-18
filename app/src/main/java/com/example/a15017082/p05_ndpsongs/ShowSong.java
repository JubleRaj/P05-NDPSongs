package com.example.a15017082.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        final ArrayList<Song> al = db.getAllSongs();
        aa = new ShowAdapter(this, R.layout.row, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ShowSong.this, ModifySong.class);
                i.putExtra("song", al.get(position).get_Id());
//                String data = al.get(position);
//                String id = data.split(",")[0].split(":")[1];
//                String content = data.split(",")[1].trim();
//
//                Song target = new Song(Integer.parseInt(id), content);
//                i.putExtra("song", target);
//                startActivityForResult(i, 9);

                startActivity(i);
            }
        });



    }
}
