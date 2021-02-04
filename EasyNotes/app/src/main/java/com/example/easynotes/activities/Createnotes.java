package com.example.easynotes.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easynotes.R;
import com.example.easynotes.database.NotesDatabase;
import com.example.easynotes.entities.Note;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.Date;
import java.util.Locale;

public class Createnotes extends AppCompatActivity {

    private EditText inputnotetile, inputnotesub,inputnotedesc;
    private TextView textdatetime;

    private String Selectedcolorfornotes;
    private View viewcolorindicator;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createnotes);

        ImageView backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        inputnotetile = findViewById(R.id.title_box);
        inputnotesub = findViewById(R.id.subtitle_box);
        inputnotedesc = findViewById(R.id.description_box);
        textdatetime = findViewById(R.id.time_holder);


        textdatetime.setText(
                new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm a", Locale.getDefault())
                        .format(new Date()));

        Button savebutton = findViewById(R.id.submit_create_button);
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });

        Selectedcolorfornotes = "#A9F3EFEF";

        Miscellaneous();

    }
    private void saveNote(){
        if(inputnotetile.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Note title can't be empty", Toast.LENGTH_SHORT).show();
            return;
        } else if (inputnotesub.getText().toString().trim().isEmpty() && inputnotedesc.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Note can't be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        final Note note = new Note();
        note.setTitle(inputnotetile.getText().toString());
        note.setSubtitle(inputnotesub.getText().toString());
        note.setDescription(inputnotedesc.getText().toString());
        note.setDateTime(textdatetime.getText().toString());

        @SuppressLint("StaticFieldLeak")
        class SaveNoteTask extends AsyncTask<Void, Void, Void>{


            @Override
            protected Void doInBackground(Void... voids) {
                NotesDatabase.getDatabase(getApplicationContext()).noteDao().insertNote(note);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();

            }
        }

        new SaveNoteTask().execute();

    }
    private void Miscellaneous(){
        @SuppressLint("WrongViewCast") final ConstraintLayout misclayout = findViewById(R.id.linearLayoutmisc);
        final BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = BottomSheetBehavior.from(misclayout);
        misclayout.findViewById(R.id.misctext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED){
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

    }

}