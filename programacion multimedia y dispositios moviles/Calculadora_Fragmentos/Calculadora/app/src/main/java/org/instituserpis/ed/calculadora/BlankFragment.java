package org.instituserpis.ed.calculadora;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BlankFragment extends Fragment {

    double num1, num2,result;
    String operacion;
    public BlankFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflamos el layout a cargar en este fragmento
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        //Declaramos el TextView y los botones
        final TextView tvNumero = (TextView) view.findViewById(R.id.tv_numero);
        tvNumero.setText("0");
        final Button BtnC = (Button) view.findViewById(R.id.BtnC);
        final Button BtnBorrar = (Button) view.findViewById(R.id.BtnBorrar);
        final Button BtnDividir = (Button) view.findViewById(R.id.BtnDividir);
        final Button BtnMultiplicar = (Button) view.findViewById(R.id.BtnMultiplicar);
        final Button BtnResta = (Button) view.findViewById(R.id.BtnResta);
        final Button BtnSuma = (Button) view.findViewById(R.id.BtnSuma);
        final Button BtnIgual = (Button) view.findViewById(R.id.BtnIgual);
        final Button BtnComa = (Button) view.findViewById(R.id.BtnComa);
        final Button Btn0 = (Button) view.findViewById(R.id.Btn0);
        final Button Btn1 = (Button) view.findViewById(R.id.Btn1);
        final Button Btn2 = (Button) view.findViewById(R.id.Btn2);
        final Button Btn3 = (Button) view.findViewById(R.id.Btn3);
        final Button Btn4 = (Button) view.findViewById(R.id.Btn4);
        final Button Btn5 = (Button) view.findViewById(R.id.Btn5);
        final Button Btn6 = (Button) view.findViewById(R.id.Btn6);
        final Button Btn7 = (Button) view.findViewById(R.id.Btn7);
        final Button Btn8 = (Button) view.findViewById(R.id.Btn8);
        final Button Btn9 = (Button) view.findViewById(R.id.Btn9);

        BtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvNumero.setText("0");
            }
        });

        BtnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantalla = tvNumero.getText().toString();
                tvNumero.setText(pantalla.substring(0, pantalla.length()-1));
            }
        });

        Btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantalla = tvNumero.getText().toString();
                if (!pantalla.equals("0")) {
                    pantalla = pantalla + "0";
                }
                tvNumero.setText(pantalla);
            }
        });

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantalla = tvNumero.getText().toString();
                if (!pantalla.equals("0")) {
                    pantalla = pantalla + "1";
                } else {
                    pantalla = "1";
                }
                tvNumero.setText(pantalla);
            }
        });

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantalla = tvNumero.getText().toString();
                if (!pantalla.equals("0")) {
                    pantalla = pantalla + "2";
                } else {
                    pantalla = "2";
                }
                tvNumero.setText(pantalla);
            }
        });

        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantalla = tvNumero.getText().toString();
                if (!pantalla.equals("0")) {
                    pantalla = pantalla + "3";
                } else {
                    pantalla = "3";
                }
                tvNumero.setText(pantalla);
            }
        });

        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantalla = tvNumero.getText().toString();
                if (!pantalla.equals("0")) {
                    pantalla = pantalla + "4";
                } else {
                    pantalla = "4";
                }
                tvNumero.setText(pantalla);
            }
        });

        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantalla = tvNumero.getText().toString();
                if (!pantalla.equals("0")) {
                    pantalla = pantalla + "5";
                } else {
                    pantalla = "5";
                }
                tvNumero.setText(pantalla);
            }
        });

        Btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantalla = tvNumero.getText().toString();
                if (!pantalla.equals("0")) {
                    pantalla = pantalla + "6";
                } else {
                    pantalla = "6";
                }
                tvNumero.setText(pantalla);
            }
        });

        Btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantalla = tvNumero.getText().toString();
                if (!pantalla.equals("0")) {
                    pantalla = pantalla + "7";
                } else {
                    pantalla = "7";
                }
                tvNumero.setText(pantalla);
            }
        });

        Btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantalla = tvNumero.getText().toString();
                if (!pantalla.equals("0")) {
                    pantalla = pantalla + "8";
                } else {
                    pantalla = "8";
                }
                tvNumero.setText(pantalla);
            }
        });

        Btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantalla = tvNumero.getText().toString();
                if (!pantalla.equals("0")) {
                    pantalla = pantalla + "9";
                } else {
                    pantalla = "9";
                }
                tvNumero.setText(pantalla);
            }
        });

        BtnComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantalla = tvNumero.getText().toString();
                if (!pantalla.contains(".")) {
                    pantalla = pantalla + ".";
                }
                tvNumero.setText(pantalla);
            }
        });

        BtnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Double.parseDouble(tvNumero.getText().toString());
                operacion = "suma";
                tvNumero.setText("0");
            }
        });

        BtnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Double.parseDouble(tvNumero.getText().toString());
                operacion = "resta";
                tvNumero.setText("0");
            }
        });

        BtnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Double.parseDouble(tvNumero.getText().toString());
                operacion = "multiplicacion";
                tvNumero.setText("0");
            }
        });

        BtnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Double.parseDouble(tvNumero.getText().toString());
                operacion = "division";
                tvNumero.setText("0");
            }
        });

        BtnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = Double.parseDouble(tvNumero.getText().toString());
                switch (operacion) {
                    case "suma":
                        result = num1 + num2;
                        tvNumero.setText(String.valueOf(result));
                        break;

                    case "resta":
                        result = num1 - num2;
                        tvNumero.setText(String.valueOf(result));
                        break;

                    case "multiplicacion":
                        result = num1 * num2;
                        tvNumero.setText(String.valueOf(result));
                        break;

                    case "division":
                        if (num2 != 0){
                            result = num1 / num2;
                            tvNumero.setText(String.valueOf(result));
                            break;
                        }
                }
            }
        });

        return view;
    }
}