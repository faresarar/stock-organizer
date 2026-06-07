/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 *
 * @author Rais
 */
public class DateFormater {
    private static DateFormater instance;   
public DateFormater(){}
public static DateFormater getInstance(){
if(instance==null){
    instance=new DateFormater();
}
return instance;
}   
  public  String FormaterDate(Calendar selectedDate) {
  
  
 // Calendar  selectedDate =(Calendar)   jDatePicker1.getModel().getValue();
    // System.out.println("selected date="+jDatePicker1.getModel().getValue());
     //   Calendar ca = new GregorianCalendar();
String day = selectedDate.get(Calendar.DAY_OF_MONTH) + "";
String month = selectedDate.get(Calendar.MONTH) + 1 + "";
String year = selectedDate.get(Calendar.YEAR) + "";

if (day.length() == 1) {
    day = "0" + day;
}
if (month.length() == 1) {
    month = "0" + month;
}

  String date1 = year + "-" + month + "-" + day;
  return date1;
 
  }
  
  public String getcurrentTime(){
  
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
  LocalDateTime now = LocalDateTime.now();  
  return dtf.format(now);
  }
}
