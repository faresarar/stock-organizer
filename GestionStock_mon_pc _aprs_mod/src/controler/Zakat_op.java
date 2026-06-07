/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author hicham
 */
public class Zakat_op {
private static Zakat_op instance;   
public Zakat_op(){}
public static Zakat_op getInstance(){
if(instance==null){
    instance=new Zakat_op();
}
return instance;
}
JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Calendar cal1 = Calendar.getInstance();
//Calendar cal2 = Calendar.getInstance();


public double Calcul_kimat_bida3a(char type_prix_vente)throws Exception{
 
double kima=0;
cal1.add(Calendar.YEAR, -1);
//System.out.println(df.format(cal1.getTime()));
Connection conn = jdbc.Getconnection();
Statement stmt = conn.createStatement();
String sql;
String prix_vente;

if(type_prix_vente=='D') {
    sql = "select prix_vente_detail,quantité from produit where date(date_achat)<= '"+df.format(cal1.getTime())+"'  ";prix_vente="prix_vente_detail";}
else if(type_prix_vente=='G'){sql = "select prix_vente_gros,quantité from produit ";prix_vente="prix_vente_gros";}
else  {sql = "select prix_special,quantité from produit ";prix_vente="prix_special";}
ResultSet rs = stmt.executeQuery(sql);
while (rs.next()) {
       double prix_v =rs.getDouble(prix_vente);
       float quantité =rs.getFloat("quantité");
       kima=kima+(prix_v*quantité);
                  }
conn.close();
rs.close();
cal1.add(Calendar.YEAR, 1);
//if(kima<prix_or*85)kima=0;
return kima; 
}

/*public long diffDate(Date d1 ,Date d2){

    long diff = d2.getTime() - d1.getTime();
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

}*/
}
