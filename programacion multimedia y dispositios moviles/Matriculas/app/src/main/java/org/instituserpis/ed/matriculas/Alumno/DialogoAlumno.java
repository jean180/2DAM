package org.instituserpis.ed.matriculas.Alumno;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import org.instituserpis.ed.matriculas.R;

public class DialogoAlumno extends DialogFragment {
    EditText editText_nombre;
    EditText editText_apellidos;
    EditText editText_DNI;
    AlumnoForList alumno;

    public DialogoAlumno() {
    }

    public DialogoAlumno(AlumnoForList alumno) {
        this.alumno = alumno;
    }

    //Interfaz
    public interface OnSimpleDialogListener {
        void onPossitiveButtonClick(String DNI, String nombre, String apellidos);
    }

    OnSimpleDialogListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@NonNull Bundle saveInstanceState) {
        return createSimpleDialog();
    }

    //Dialogo insertar

    public AlertDialog createSimpleDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setMessage(Html.fromHtml("<b>" + "Introduca alumno" + "</b>"));
        View v = inflater.inflate(R.layout.activity_add_alumno, null);
        builder.setView(v);

        editText_DNI = (EditText) v.findViewById(R.id.et_dni);
        editText_nombre = (EditText) v.findViewById(R.id.et_nombre);
        editText_apellidos = (EditText) v.findViewById(R.id.et_apellidos);
        if (alumno != null) {
            builder.setMessage(Html.fromHtml("<b>" + "Actualiza alumno" + "</b>"));
            editText_DNI.setText(alumno.DNI);
            editText_DNI.setKeyListener(null);
            editText_nombre.setText(alumno.nombre);
            editText_apellidos.setText(alumno.apellidos);
        }

        builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                listener.onPossitiveButtonClick(editText_DNI.getText().toString(), editText_nombre.getText().toString(), editText_apellidos.getText().toString());
            }
        })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        return  builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (OnSimpleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(
                    context.toString() +" no implemento OnSetTitleListener"
            );
        }
    }
}


