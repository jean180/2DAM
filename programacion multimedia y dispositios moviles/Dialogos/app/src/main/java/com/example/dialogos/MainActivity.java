package com.example.dialogos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements BlankFragment.OnSetTitleListener{
    TextView resultado;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button)findViewById(R.id.boton);
        resultado = (TextView)findViewById(R.id.resultado);
        boton.setOnClickListener(new BlankFragment().show(getSupportFragmentManager(), "BlankFragment"));

    }

    @Override
    public void onPossitiveButtonClick() {
        resultado.setText("Has lanzado los misiles");
    }

    @Override
    public void onNegativeButtonClick() {
        resultado.setText("Lanzamiento cancelado");
    }
}