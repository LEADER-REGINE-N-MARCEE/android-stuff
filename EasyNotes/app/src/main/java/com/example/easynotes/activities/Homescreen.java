package com.example.easynotes.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.easynotes.R;
import com.example.easynotes.adapters.NotesAdapter;
import com.example.easynotes.database.NotesDatabase;
import com.example.easynotes.entities.Note;

import java.util.ArrayList;
import java.util.List;

public class Homescreen extends AppCompatActivity {

    private TextView nickname,titleinfo,descinfo;
    private ImageButton setting, create;
    public static ArrayList<String> notes = new ArrayList<String>();
    static ArrayAdapter<String> arrayAdapter;
    public static final int REQUEST_CODE_ADD_NOTE = 1;

    private RecyclerView recyclerviewnotes;
    private List<Note> notelist;
    private NotesAdapter notesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);






        setting = findViewById(R.id.settingbutton);
        create = findViewById(R.id.createbutton);
        nickname = findViewById(R.id.textView5);

        String nickname1 = getIntent().getStringExtra("keyname");

        nickname.setText(nickname1);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homescreen.this, Settings.class);
                startActivity(intent);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(
                        new Intent(getApplicationContext(), Createnotes.class),
                        REQUEST_CODE_ADD_NOTE
                );
            }
        });
        recyclerviewnotes = findViewById(R.id.notesrecyclerview);
        recyclerviewnotes.setLayoutManager(
                new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
        );

        notelist = new ArrayList<>();
        notesAdapter = new NotesAdapter(notelist);
        recyclerviewnotes.setAdapter(notesAdapter);

        getNotes();
    }

    private void getNotes(){
        @SuppressLint("StaticFieldLeak")
        class GetNotesTask extends AsyncTask<Void, Void, List<Note>>{

            @Override
            protected List<Note> doInBackground(Void... voids) {
                return NotesDatabase.getDatabase(getApplicationContext()).noteDao().getAllNotes();
            }

            @Override
            protected void onPostExecute(List<Note> notes) {
                super.onPostExecute(notes);
                if (notelist.size() == 0) {
                    notelist.addAll(notes);
                    notesAdapter.notifyDataSetChanged();
                }
                else{
                    notelist.add(0,notes.get(0));
                    notesAdapter.notifyItemInserted(0);
                }
                recyclerviewnotes.smoothScrollToPosition(0);
            }
        }
        new GetNotesTask().execute();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_ADD_NOTE && resultCode == RESULT_OK){
            getNotes();
        }
    }
}