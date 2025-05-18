package com.example.a02_activities_eventos;

public class ConversionesLogica {
    public String convertidor (String numAConvertir, String SistemaNumericoBase,
                             String sistemaNumericoAConvertir){
        String resultado="";
if ( SistemaNumericoBase.equals("10")){
    //de decimal a binario
    if(sistemaNumericoAConvertir.equals("2")){
        resultado= Integer.toBinaryString(Integer.parseInt(numAConvertir));
    } //de decimal a octal
    if(sistemaNumericoAConvertir.equals("8")){
        resultado= Integer.toOctalString(Integer.parseInt(numAConvertir) );
    } //de decimal a hexadecimal
    if(sistemaNumericoAConvertir.equals("16")){
        resultado= Integer.toHexString(Integer.parseInt(numAConvertir) );
    }
}


        if ( SistemaNumericoBase.equals("2")){
            //de binario a decimal
            if(sistemaNumericoAConvertir.equals("10")){
                resultado= String.valueOf(  Integer.parseInt(numAConvertir, 2));
            } //de binario a octal
            if(sistemaNumericoAConvertir.equals("8")){
                resultado= String.valueOf(
                        Integer.toOctalString (Integer.parseInt(numAConvertir,2)));
            } //de binario a hexadecimal
            if(sistemaNumericoAConvertir.equals("16")){
                resultado= String.valueOf(
                        Integer.toHexString(Integer.parseInt(numAConvertir, 2)));
            }
        }


        if ( SistemaNumericoBase.equals("8")){
            //de octal a decimal
            if(sistemaNumericoAConvertir.equals("10")){
                resultado= String.valueOf(  Integer.parseInt(numAConvertir, 8));
            } //de octal a binario
            if(sistemaNumericoAConvertir.equals("2")){
                resultado= String.valueOf(
                        Integer.toBinaryString (Integer.parseInt(numAConvertir,8)));
            } //de octal a hexadecimal
            if(sistemaNumericoAConvertir.equals("16")){
                resultado= String.valueOf(
                        Integer.toHexString(Integer.parseInt(numAConvertir, 8)));
            }
        }



        if ( SistemaNumericoBase.equals("16")){
            //de hexadecimal a decimal
            if(sistemaNumericoAConvertir.equals("10")){
                resultado= String.valueOf(  Integer.parseInt(numAConvertir, 16));
            } //de hexadecimal a binario
            if(sistemaNumericoAConvertir.equals("2")){
                resultado= String.valueOf(
                        Integer.toBinaryString (Integer.parseInt(numAConvertir,16)));
            } //de hexadecimal a octal
            if(sistemaNumericoAConvertir.equals("8")){
                resultado= String.valueOf(
                        Integer.toOctalString(Integer.parseInt(numAConvertir, 16)));
            }
        }


        return resultado;
    }
}
