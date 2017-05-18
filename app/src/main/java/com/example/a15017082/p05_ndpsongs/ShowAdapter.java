package com.example.a15017082.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by 15056130 on 5/18/2017.
 */

public class ShowAdapter extends ArrayAdapter<Song> {
    Context context;
    ArrayList<Song> songs;
    TextView tvYear, tvTitle, tvSinger;
    int resource;
    ImageView iv1, iv2, iv3, iv4, iv5;

    public ShowAdapter(Context context, int resource, ArrayList<Song> songs) {
        super(context, resource, songs);
        this.context = context;
        this.songs = songs;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        //Match the UI components with Java variables

        tvSinger = (TextView) rowView.findViewById(R.id.tvArtist);
        tvYear = (TextView) rowView.findViewById(R.id.tvYear);
        tvTitle = (TextView) rowView.findViewById(R.id.tvTitle);
        iv1 = (ImageView) rowView.findViewById(R.id.imageView1);
        iv2 = (ImageView) rowView.findViewById(R.id.imageView2);
        iv3 = (ImageView) rowView.findViewById(R.id.imageView3);
        iv4 = (ImageView) rowView.findViewById(R.id.imageView4);
        iv5 = (ImageView) rowView.findViewById(R.id.imageView5);

        Song song = songs.get(position);

        tvTitle.setText(song.getTitle());
        tvSinger.setText(song.getSingers());
        tvYear.setText(song.getYear());

        //Check if the property for stars >= 5, if so, "light" up the stars


        if (song.getStar() >= 5) {
            iv5.setImageResource(android.R.drawable.btn_star_big_on);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (song.getStar()  == 4) {
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (song.getStar()  == 3) {
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (song.getStar()  == 2) {
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (song.getStar()  == 1) {
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }

        return rowView;
    }



}