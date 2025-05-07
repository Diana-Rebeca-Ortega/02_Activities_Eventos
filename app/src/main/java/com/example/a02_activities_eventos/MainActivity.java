package com.example.a02_activities_eventos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //PASO 1> Crear un metodo que realizara las accuones del evento clic de un boton
    public void saludo(View view){
        Log.i("MSJ dianita", "Magia magia con android");
        Toast.makeText(this, "Mfia mafia con androis", Toast.LENGTH_LONG).show();
    }

    public  void  abrirActivity (View view){
        //Codigo para llenar una activitu
        Intent intent = new Intent(this, Activity_CalSencillita.class);
        startActivity(intent);
    }
    //Paso 2: Enlazar el coponente grafico desde XML al metodo anterior en  activity main y dar clic en onClic

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}