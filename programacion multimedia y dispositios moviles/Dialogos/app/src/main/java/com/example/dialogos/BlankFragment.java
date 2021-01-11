package com.example.dialogos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BlankFragment extends DialogFragment {

    public interface OnSetTitleListener{
        void onPossitiveButtonClick();
        void onNegativeButtonClick();
    }

    OnSetTitleListener listener;

    public BlankFragment(){
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        return createSingleListDialog();
    }

    public AlertDialog createSingleListDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setTitle("¿Lanzar misiles?")
                .setPositiveButton("SI",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                .setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try {
            listener = (OnSetTitleListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(
                    getContext().toString() + "adadasdas"
            );
        }
    }


}