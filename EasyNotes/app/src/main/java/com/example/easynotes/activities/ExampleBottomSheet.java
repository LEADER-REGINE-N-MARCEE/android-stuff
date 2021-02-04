package com.example.easynotes.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.easynotes.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ExampleBottomSheet  extends BottomSheetDialogFragment {
        private Bottomsheetlistener mListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet, container,false);

        Button lowbutton = v.findViewById(R.id.lowbutton);

        lowbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.onButtonClicked("");
                dismiss();
            }
        });

        return v;
    }

    public interface Bottomsheetlistener {
            void onButtonClicked(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (Bottomsheetlistener) context;
        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement BottomSheetListener");

        }
    }
}






