package com.example.evento_directo_chechbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    Button btnHobby;
    TextView txtHobby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialUISetup();
    }

    public void initialUISetup(){
        chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);

        txtHobby = (TextView)findViewById(R.id.txtHobby);
        chkBoxCycling.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxTeaching.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxBlogging.setOnCheckedChangeListener(new myCheckBoxChangeClicker());

    }

    class myCheckBoxChangeClicker implements CheckBox.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                String prueba = "";
                if (chkBoxCycling.isChecked()){
                    prueba += "Cycling ";
                }
                if (chkBoxTeaching.isChecked()){
                    prueba += "Teaching ";
                }if (chkBoxBlogging.isChecked()) {
                    prueba += "Blogging ";
                }
                showTextNotification(prueba);

        }
    }

    public void showTextNotification(String msgToDisplay){
        txtHobby.setText(msgToDisplay);
        //Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }
}