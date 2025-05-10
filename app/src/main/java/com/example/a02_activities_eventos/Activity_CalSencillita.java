package com.example.a02_activities_eventos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
//PASO NUM 2 A,B,C
public class Activity_CalSencillita extends Activity {

    private EditText cajaPrimerNum, cajaSegundoNum, cajaRes;
    private Button btnDividir;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal_sencilla);
        //Enlazar los objetos con java
        cajaPrimerNum = findViewById(R.id.caja_primerNumero);
        cajaSegundoNum = findViewById(R.id.caja_segundoNumero);
        cajaRes = findViewById(R.id.caja_resultado);
      // btnDividir = findViewById(R.id.)
    }


    public  void sumar (View v){
        double n1 = Double.parseDouble(cajaPrimerNum.getText().toString());
        double n2 = Double.parseDouble(cajaSegundoNum.getText().toString());

        cajaRes.setText(String.valueOf(n1+n2));
    }

    public  void realizarOperaciones (View v){
        double n1 = Double.parseDouble(cajaPrimerNum.getText().toString());
        double n2 = Double.parseDouble(cajaSegundoNum.getText().toString());

        if (v.getId() == R.id.btn_restar){
            Toast.makeText(this, "resta", Toast.LENGTH_LONG).show();
            cajaRes.setText(String.valueOf(n1-n2));
        }else   if (v.getId() == R.id.btn_multiplicar){
            Toast.makeText(this, "multiplicaion", Toast.LENGTH_LONG);
            cajaRes.setText(String.valueOf(n1*n2));
        }else   if (v.getId() == R.id.btn_dividir){
            Toast.makeText(this, " divicion", Toast.LENGTH_LONG).show();
            cajaRes.setText(String.valueOf(n1/n2));
        }
    }
}


