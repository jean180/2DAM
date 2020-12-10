package com.example.fragmentos;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CountFragment extends Fragment {

    private Button boton;
    private EditText edit;
    private TextView text;


    public CountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_count, container, false);

        //Nuevos parametros para el view del fragmento
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        //Nueva Regla: El fragmento estara debajo del boton add_fragment
        params.addRule(RelativeLayout.BELOW, R.id.add_fragment);
        //Margenes: top 41dp
        params.setMargins(0, 41, 0, 0);
        //Setear los parametros al view
        view.setLayoutParams(params);

        boton = (Button)view.findViewById(R.id.main_button);
        edit = (EditText)view.findViewById(R.id.main_editText);
        text = (TextView) view.findViewById(R.id.main_textview);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = edit.getText().toString();
                text.setText(String.valueOf(mensaje.length()));
            }
        });

        return view;
    }
}