package com.example.a15017082.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ModifySong extends AppCompatActivity {
    TextView tvID ;
    EditText etSongTitle, etSingers, etYear;
    RadioGroup rgStars;
    Button btnUpdate, btnDelete, btnCancel;
    Song data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_song);
        tvID = (TextView)findViewById(R.id.tvID);
        etSongTitle = (EditText)findViewById(R.id.etSongTitle);
        etSingers = (EditText)findViewById(R.id.etSingers);
        etYear = (EditText)findViewById(R.id.etYear);
        rgStars = (RadioGroup)findViewById(R.id.rgStars);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnCancel = (Button)findViewById(R.id.btnCancel);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifySong.this);
                data.setId(tvID.getId());
                data.setSingers(etSingers.getText().toString());
                data.setTitle(etSongTitle.getText().toString());
                data.setYear(etYear.getText().toString());
                data.setStars(rgStars.getCheckedRadioButtonId());
                dbh.updateSong(data);
                dbh.close();
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifySong.this);
                dbh.deleteNote(data.get_Id());
                dbh.close();
                finish();
            }
        });
    }


}
