package com.example.radiobutton_i;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView lblMensaje = (TextView)findViewById(R.id.LblSeleccion);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.gruporb);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String TextOpcion = "";
                if (group.getCheckedRadioButtonId() == R.id.radio1){
                    TextOpcion +="OPCION 1 con ID: " + checkedId;
                }
                if (group.getCheckedRadioButtonId() == R.id.radio2){
                    TextOpcion += "OPCION 2 con ID: " + checkedId;
                }
                lblMensaje.setText(TextOpcion);
            }
        });
    }
}