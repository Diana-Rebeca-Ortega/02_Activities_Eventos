package com.example.a02_activities_eventos;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Activity_CalBasica extends Activity implements AdapterView.OnItemSelectedListener {
    //spinners del examen
    private Spinner spinerSN_Ingresado, spinerSN_AConvertir;
    ArrayList<String> listaSistemasNumericos;
    private String primerSpiner="";

    private Button btnA, btnB, btnC, btnD, btnE, btnF;

    //importando el metodo para convertir
    ConversionesLogica cl = new ConversionesLogica();
    private EditText cajaResultado;
    private Button btn1, btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    private Button btnDividir,btnMultiplicar,btnMas,btnMenos, btnPorcentaje, btnRaiz , btnReiniciar, btnAjustes;
    private Button btn_Igual, btnCuadrado, btnUnoSobreX, btnPunto, btnBorrar, btnMasMenos;
    private Double primero, segundo;
    private Double memoria=0.0;
    private Button menMas, menMenos, menRecuperar, menLimpiar, menGuardar;
   private String operador;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal_basica);
        //spinners del examen
        spinerSN_Ingresado = findViewById(R.id.spn_uno);
        spinerSN_AConvertir = findViewById(R.id.spn_dos);

        listaSistemasNumericos = new ArrayList<>();
        listaSistemasNumericos.add("Lista Sistemas Numericos...");
        listaSistemasNumericos.add("Decimal");
        listaSistemasNumericos.add("Binario");
        listaSistemasNumericos.add("Octal");
        listaSistemasNumericos.add("Hexadecimal");

        ArrayAdapter<String> adaptadorSisNumericos = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listaSistemasNumericos);

        spinerSN_Ingresado.setAdapter(adaptadorSisNumericos);
        spinerSN_AConvertir.setAdapter(adaptadorSisNumericos);

        spinerSN_Ingresado.setOnItemSelectedListener(this);
        spinerSN_AConvertir.setOnItemSelectedListener(this);


//***********Enlazar numeros hexadecimales
        btnA = findViewById(R.id.btn_a);
        btnB = findViewById(R.id.btn_b);
        btnC = findViewById(R.id.btn_c);
        btnD = findViewById(R.id.btn_d);
        btnE = findViewById(R.id.btn_e);
        btnF = findViewById(R.id.btn_f);

        cajaResultado = findViewById(R.id.cajaResB);
        //Enlazar numeros
        btn1= findViewById(R.id.btn_1);
        btn2= findViewById(R.id.btn_2);
        btn3= findViewById(R.id.btn_3);
        btn4= findViewById(R.id.btn_4);
        btn5= findViewById(R.id.btn_5);
        btn6= findViewById(R.id.btn_6);
        btn7= findViewById(R.id.btn_7);
        btn8= findViewById(R.id.btn_8);
        btn9= findViewById(R.id.btn_9);
        btn0= findViewById(R.id.btn_0);
        //Enlazar Operadores
      btnMultiplicar= findViewById(R.id.btn_multiplicar);
      btnMas = findViewById(R.id.btn_Suma);
      btnMenos = findViewById(R.id.btn_Resta);
      btnDividir = findViewById(R.id.btn_Division);

      btnPorcentaje= findViewById(R.id.btn_Porciento);
      btnRaiz = findViewById(R.id.btn_Raiz);
      btnCuadrado = findViewById(R.id.btn_Cuadrado);
      btnUnoSobreX = findViewById(R.id.btn_Uno_Entre_X);

      btnPunto = findViewById(R.id.btn_Punto);
      btnBorrar = findViewById(R.id.btn_Borrar);
      btnMasMenos = findViewById(R.id.btn_MasMenos);
      //enlazar botones de memoria
        menMas = findViewById(R.id.menMas);
        menMenos = findViewById(R.id.menMenos);
        menLimpiar = findViewById(R.id.menC);
        menRecuperar = findViewById(R.id.menR);
        menGuardar = findViewById(R.id.menS);

    }
//***************Numeros Hexadecinales ****************************
    public void indicarNumerosHexadecimales(View v ){
        if(v.getId() == R.id.btn_a){
            cajaResultado.setText(cajaResultado.getText()+"A");
            borrarCero();
        } if(v.getId() == R.id.btn_b){
            cajaResultado.setText(cajaResultado.getText()+"B");
            borrarCero();
        } if(v.getId() == R.id.btn_c){
            cajaResultado.setText(cajaResultado.getText()+"C");
            borrarCero();
        } if(v.getId() == R.id.btn_d){
            cajaResultado.setText(cajaResultado.getText()+"D");
            borrarCero();
        } if(v.getId() == R.id.btn_e){
            cajaResultado.setText(cajaResultado.getText()+"E");
            borrarCero();
        } if(v.getId() == R.id.btn_f){
            cajaResultado.setText(cajaResultado.getText()+"F");
            borrarCero();
        }
    }

//*********************Numeros************************
    public void indicarNumero(View v ){
        if(v.getId() == R.id.btn_1){
            cajaResultado.setText(cajaResultado.getText()+"1");
            borrarCero();
        }
        if(v.getId() == R.id.btn_2){
            cajaResultado.setText(cajaResultado.getText()+"2");
            borrarCero();
        }if(v.getId() == R.id.btn_3){
            cajaResultado.setText(cajaResultado.getText()+"3");
            borrarCero();
        }if(v.getId() == R.id.btn_4){
            cajaResultado.setText(cajaResultado.getText()+"4");
            borrarCero();
        }if(v.getId() == R.id.btn_5){
            cajaResultado.setText(cajaResultado.getText()+"5");
            borrarCero();
        }if(v.getId() == R.id.btn_6){
            cajaResultado.setText(cajaResultado.getText()+"6");
            borrarCero();
        }if(v.getId() == R.id.btn_7){
            cajaResultado.setText(cajaResultado.getText()+"7");
            borrarCero();
        }if(v.getId() == R.id.btn_8){
            cajaResultado.setText(cajaResultado.getText()+"8");
            borrarCero();
        }if(v.getId() == R.id.btn_9){
            cajaResultado.setText(cajaResultado.getText()+"9");
            borrarCero();
        }if(v.getId() == R.id.btn_0){
            cajaResultado.setText(cajaResultado.getText()+"0");
            borrarCero();
        }if(v.getId() == R.id.btn_Punto){
            cajaResultado.setText(cajaResultado.getText()+".");
        }
    }//numeros
    //***********************Operadores****************************
  public void indicarOperador(View v ) {
        //operadores basicos
   if(v.getId() == R.id.btn_x){
       primero = Double.parseDouble(String.valueOf(cajaResultado.getText()));
       cajaResultado.setText("0");
       operador = "*";
   }if(v.getId() == R.id.btn_Suma){
          primero = Double.parseDouble(String.valueOf(cajaResultado.getText()));
          cajaResultado.setText("0");
          operador = "+";
   }if(v.getId() == R.id.btn_Resta){
          primero = Double.parseDouble(String.valueOf(cajaResultado.getText()));
          cajaResultado.setText("0");
          operador = "-";
   }if(v.getId() == R.id.btn_Division){
          primero = Double.parseDouble(String.valueOf(cajaResultado.getText()));
          cajaResultado.setText("0");
          operador = "/";
   }
   //Operadores nivel 2
      if(v.getId() == R.id.btn_Porciento){
          primero = Double.parseDouble(String.valueOf(cajaResultado.getText()));
          cajaResultado.setText("0");
          operador = "P";
      }if(v.getId() == R.id.btn_Raiz){
          primero = Double.parseDouble(String.valueOf(cajaResultado.getText()));
          cajaResultado.setText("0");
          operador = "R";
      }if(v.getId() == R.id.btn_Cuadrado){
          primero = Double.parseDouble(String.valueOf(cajaResultado.getText()));
          cajaResultado.setText("0");
          operador = "C";
      }if(v.getId() == R.id.btn_Uno_Entre_X){
          primero = Double.parseDouble(String.valueOf(cajaResultado.getText()));
          cajaResultado.setText("0");
          operador = "X";

      }if(v.getId() == R.id.btn_MasMenos){
          primero = Double.parseDouble(String.valueOf(cajaResultado.getText()));
          cajaResultado.setText(String.valueOf(  primero*(-1)));
          operador = "q";

      }
      if(v.getId() == R.id.menS){
          memoria = Double.parseDouble(String.valueOf(cajaResultado.getText()));
          cajaResultado.setText(String.valueOf(memoria  ));
          operador = "S";
      }
      if(v.getId() == R.id.menMas){
          memoria = memoria + Double.parseDouble(String.valueOf(cajaResultado.getText()));
          cajaResultado.setText(String.valueOf(memoria  ));
          operador = "MAS";
      }if(v.getId() == R.id.menMenos){
          memoria = memoria - Double.parseDouble(String.valueOf(cajaResultado.getText()));
          cajaResultado.setText(String.valueOf(memoria  ));
          operador = "MENOS";
      }
      if(v.getId() == R.id.menR){
        //  memoria = memoria + Double.parseDouble(String.valueOf(cajaResultado.getText()));
          cajaResultado.setText(String.valueOf(memoria  ));
          operador = "REC";
      }
      if(v.getId() == R.id.menC){
           memoria = 0.0;
          cajaResultado.setText(String.valueOf(memoria  ));
          operador = "LIM";
      }

    }//indicar operador

   //*****************Otras funciones*****************************

    public void hacerCE (View v){
        cajaResultado.setText("0");
    }
    public void hacerC (View v){
        cajaResultado.setText("0");
        primero = 0.0;
        segundo= 0.0;
    }
    public void borrar (View v){
        String cadena = String.valueOf(cajaResultado.getText());
        if(v.getId()==R.id.btn_Borrar) {
            if(cadena.length()==1 || cadena.charAt(0)=='0' ) {
                cajaResultado.setText("0");
            }else{
                cajaResultado.setText(cadena.substring(0,cadena.length()-1));
            }
        }
    }
    public void  borrarCero (){
        String cadena =String.valueOf(cajaResultado.getText());
        if(cadena.length()==2  ) {
            if(cadena.charAt(0)=='0') {
                cadena= String.valueOf(cadena.charAt(1));
                cajaResultado.setText(cadena);	}
        }
    }//borrar 0
//***********************Indicar resultado***********************

    public void ObtenerResultado (View v){
        if (v.getId() == R.id.btn_Igual) {
            segundo = Double.parseDouble(String.valueOf(cajaResultado.getText()));
            if (operador=="*"){
                cajaResultado.setText(String.valueOf(	primero*segundo));
            }if (operador=="+"){
                cajaResultado.setText(String.valueOf(	primero+segundo));
            }if (operador=="-"){
                cajaResultado.setText(String.valueOf(	primero-segundo));
            }if (operador=="/"){
                cajaResultado.setText(String.valueOf(	primero/segundo));
            }

            if (operador=="P"){
                cajaResultado.setText(String.valueOf(	primero/100));
            }if (operador=="R"){
                cajaResultado.setText(String.valueOf(	Math.sqrt(primero)));
            }if (operador=="C"){
                cajaResultado.setText(String.valueOf(	primero*primero));
            }if (operador=="X"){
                cajaResultado.setText(String.valueOf(	1/primero));
            }
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//********************spiner 1
 if(parent.getId()==R.id.spn_uno){

 if(parent.getSelectedItem().toString().equals("Decimal")){
    primerSpiner ="Decimal";
    ArrayList <String>  listaTemporal = (ArrayList<String>) listaSistemasNumericos.clone();
    listaTemporal.remove("Decimal");
    ArrayAdapter <String> nuevoAdaptador = new ArrayAdapter<>(this,
    android.R.layout.simple_list_item_1, listaTemporal);
    spinerSN_AConvertir.setAdapter(nuevoAdaptador);
 } else if(parent.getSelectedItem().toString().equals("Binario")){
     primerSpiner ="Binario";
     ArrayList <String>  listaTemporal = (ArrayList<String>) listaSistemasNumericos.clone();
     listaTemporal.remove("Binario");
     ArrayAdapter <String> nuevoAdaptador = new ArrayAdapter<>(this,
             android.R.layout.simple_list_item_1, listaTemporal);
     spinerSN_AConvertir.setAdapter(nuevoAdaptador);
 }else if(parent.getSelectedItem().toString().equals("Octal")){
     primerSpiner ="Octal";
     ArrayList <String>  listaTemporal = (ArrayList<String>) listaSistemasNumericos.clone();
     listaTemporal.remove("Octal");
     ArrayAdapter <String> nuevoAdaptador = new ArrayAdapter<>(this,
             android.R.layout.simple_list_item_1, listaTemporal);
     spinerSN_AConvertir.setAdapter(nuevoAdaptador);
 }else if(parent.getSelectedItem().toString().equals("Hexadecimal")){
     primerSpiner ="Hexadecimal";
     ArrayList <String>  listaTemporal = (ArrayList<String>) listaSistemasNumericos.clone();
     listaTemporal.remove("Hexadecimal");
     ArrayAdapter <String> nuevoAdaptador = new ArrayAdapter<>(this,
             android.R.layout.simple_list_item_1, listaTemporal);
     spinerSN_AConvertir.setAdapter(nuevoAdaptador);
 }
 }//spinner 1

        //llamar al metodo conversor de sistemas numericos
        try{

        if(primerSpiner.equals("Decimal")){
            if(parent.getSelectedItem().toString().equals("Binario")){
               // Toast.makeText(this,"DEBI", Toast.LENGTH_SHORT).show();
              String res=  cl.convertidor(String.valueOf(cajaResultado.getText()), "10","2");
              cajaResultado.setText(res);
              borrarDatosAlVolverAPresionarElSpinner();
            }if(parent.getSelectedItem().toString().equals("Octal")){
                String res=  cl.convertidor(String.valueOf(cajaResultado.getText()), "10","8");
                cajaResultado.setText(res);
                borrarDatosAlVolverAPresionarElSpinner();
            }if(parent.getSelectedItem().toString().equals("Hexadecimal")){
                String res=  cl.convertidor(String.valueOf(cajaResultado.getText()), "10","16");
                cajaResultado.setText(res);
                borrarDatosAlVolverAPresionarElSpinner();
            }
        }if(primerSpiner.equals("Binario")){
            if(parent.getSelectedItem().toString().equals("Decimal")){
                String res=  cl.convertidor(String.valueOf(cajaResultado.getText()), "2","10");
                cajaResultado.setText(res);
                borrarDatosAlVolverAPresionarElSpinner();
            }if(parent.getSelectedItem().toString().equals("Octal")){
                    String res=  cl.convertidor(String.valueOf(cajaResultado.getText()), "2","8");
                    cajaResultado.setText(res);
                    borrarDatosAlVolverAPresionarElSpinner();
            }if(parent.getSelectedItem().toString().equals("Hexadecimal")){
                    String res=  cl.convertidor(String.valueOf(cajaResultado.getText()), "2","16");
                    cajaResultado.setText(res);
                    borrarDatosAlVolverAPresionarElSpinner();
            }
        }if(primerSpiner.equals("Octal")){
                if(parent.getSelectedItem().toString().equals("Decimal")){
                    String res=  cl.convertidor(String.valueOf(cajaResultado.getText()), "8","10");
                    cajaResultado.setText(res);
                    borrarDatosAlVolverAPresionarElSpinner();
                } if(parent.getSelectedItem().toString().equals("Binario")){
                    String res=  cl.convertidor(String.valueOf(cajaResultado.getText()), "8","2");
                    cajaResultado.setText(res);
                    borrarDatosAlVolverAPresionarElSpinner();
                }if(parent.getSelectedItem().toString().equals("Hexadecimal")){
                    String res=  cl.convertidor(String.valueOf(cajaResultado.getText()), "8","16");
                    cajaResultado.setText(res);
                    borrarDatosAlVolverAPresionarElSpinner();
                }
        }if(primerSpiner.equals("Hexadecimal")){
                if(parent.getSelectedItem().toString().equals("Decimal")){
                    String res=  cl.convertidor(String.valueOf(cajaResultado.getText()), "16","10");
                    cajaResultado.setText(res);
                    borrarDatosAlVolverAPresionarElSpinner();
                } if(parent.getSelectedItem().toString().equals("Binario")){
                    String res=  cl.convertidor(String.valueOf(cajaResultado.getText()), "16","2");
                    cajaResultado.setText(res);
                    borrarDatosAlVolverAPresionarElSpinner();
                }if(parent.getSelectedItem().toString().equals("Octal")){
                    String res=  cl.convertidor(String.valueOf(cajaResultado.getText()), "16","8");
                    cajaResultado.setText(res);
                    borrarDatosAlVolverAPresionarElSpinner();
                }
            }
        }catch (Exception e){
            Toast.makeText(this,"se ha producido un error", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void borrarDatosAlVolverAPresionarElSpinner(){
        spinerSN_Ingresado.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    cajaResultado.setText("0");
                }
                return false;
            }
        });
    }

}