package org.instituserpis.ed.matriculas.Asignatura;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import org.instituserpis.ed.matriculas.Asignatura.AsignaturaForList;
import org.instituserpis.ed.matriculas.R;

public class DialogoAsignatura extends DialogFragment {

    EditText editText_nombre_asignatura;
    AsignaturaForList asignatura;
    int id_st;
    int num_estudiantes;

    public DialogoAsignatura() {
    }

    public DialogoAsignatura(AsignaturaForList asignatura) {
        this.asignatura = asignatura;
    }

    //Interfaz
    public interface OnSimpleDialogListener {
        void onPossitiveButtonClick(String nombre_asignatura, int id, int num_estudiantes);
    }

    OnSimpleDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@NonNull Bundle savedInstanceState){
        return createSimpleDialog();
    }

    //Dialogo insertar

    public AlertDialog createSimpleDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setMessage(Html.fromHtml("<b>" + "Introduzca asignatura" + "</b>"));
        View v = inflater.inflate(R.layout.activity_add_asignatura, null);
        builder.setView(v);

        editText_nombre_asignatura = (EditText) v.findViewById(R.id.et_nombre_asignatura);
        if (asignatura != null) {
            builder.setMessage(Html.fromHtml("<b>" + "Actualizar asignatura" + "</b>"));
            editText_nombre_asignatura.setText(asignatura.nombre);
            id_st = asignatura.id;
            num_estudiantes = asignatura.num_estudiantes;
        }

        builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                listener.onPossitiveButtonClick(editText_nombre_asignatura.getText().toString(), id_st, num_estudiantes);

            }
        })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                    }
                });
        return builder.create();
    }

    //Comprobar implementación metodo en el contexto
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (OnSimpleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(
                    context.toString() + " no implemento OnSetTitleListener"
            );
        }
    }
}