package com.example.easynotes.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.easynotes.R;

import java.util.ArrayList;


public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, ArrayList<Book> books){
        super(context, 0 ,books);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Book book = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.notes_layout_design,parent, false);
        }

        TextView tvTitle = (TextView) convertView.findViewById(R.id.titles_out);
        TextView tvDescription = (TextView) convertView.findViewById(R.id.description_out);


        tvTitle.setText(book.title);
        tvDescription.setText(book.description);


        return convertView;
    }
}
