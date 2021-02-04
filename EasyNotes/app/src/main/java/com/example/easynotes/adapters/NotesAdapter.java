package com.example.easynotes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easynotes.R;
import com.example.easynotes.entities.Note;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder>{

    private List<Note> notes;

    public NotesAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container,parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.setNote(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    @Override
    public int getItemViewType(int position) {
         return position;
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder {

        TextView texttitle, textsubtitle, textdatetime, textdescription;

        NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            texttitle = itemView.findViewById(R.id.titleH1);
            textsubtitle = itemView.findViewById(R.id.subH1);
            textdatetime = itemView.findViewById(R.id.dateH1);
            textdescription = itemView.findViewById(R.id.descH1);
        }
        void setNote(Note note){
            texttitle.setText(note.getTitle());
            if (note.getSubtitle().trim().isEmpty()){
                textsubtitle.setVisibility(View.GONE);
            }
            else {
                textsubtitle.setText(note.getSubtitle());
            }
            textdescription.setText(note.getDescription());
            textdatetime.setText(note.getDateTime());

        }
    }
}
