package com.jordinymontanez.challenge.customer.common.util;
import java.util.Arrays;
public class DesviacionEstandarUtils {

        public static double calculate(Integer[] args) {

            float average= (float) Arrays.stream(args).mapToInt(i->i).average().orElse(Double.NaN);
            float media = average;
            double varianza = 0.0;
            double desviacion= 0.0;
            for(int i = 0 ; i < args.length; i++){
                double rango = Math.pow(args[i] - media, 2f);
                varianza = varianza + rango;
            }
            varianza = varianza / (float)args.length;
            desviacion = Math.sqrt(varianza);
            System.out.println("resultado: " + desviacion);
            return  desviacion;
        }


}
