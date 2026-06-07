/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.text.DecimalFormat;

/**
 *
 * @author Rais
 */
public class FormaterNumber {
 
    
 public double formaterDouble(double n ){
 double nombre;
 //DecimalFormat df = new DecimalFormat("#.##");
//String formatted = df.format(n);

//nombre=Double.parseDouble(formatted);
String h=String.format("%.02f", n);
 nombre=Double.parseDouble(h);
 return nombre;
 }   
}
