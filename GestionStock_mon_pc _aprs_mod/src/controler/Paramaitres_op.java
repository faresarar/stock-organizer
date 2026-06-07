/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Paramaitre;

/**
 *
 * @author pc
 */
public class Paramaitres_op {
    
    private static Paramaitres_op instance;   
public Paramaitres_op(){}
public static Paramaitres_op getInstance(){
if(instance==null){
    instance=new Paramaitres_op();
}
return instance;
}
    
     JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
    public void modifier_paramaitre(Paramaitre p){
        try {
             Connection conn = jdbc.Getconnection();
          
              String sql1 = "UPDATE Paramaitres set nom_magasin=?, adresse_p=? , num_tel_fax_fix_p=? , num_tel1_p=? , num_tel2_p=?, NRC=?, NIS=?, NIF=? ,RIB=?, activite=?,message=?,apercu_ticket=? where ID=1 ";
             // ResultSet rs1 = stmt.executeQuery(sql1);
              PreparedStatement pr=conn.prepareStatement(sql1);
              pr.setString(1, p.getNom_magasin());
              pr.setString(2, p.getAdresse_p());
              pr.setString(3, p.getNum_tel_fax_fix_p());
              pr.setString(4, p.getNum_tel1_p());
              pr.setString(5, p.getNum_tel2_p());
              pr.setString(6, p.getNRC());
              pr.setString(7, p.getNIS());
              pr.setString(8, p.getNIF());
              pr.setString(9, p.getRIB());
              pr.setString(10, p.getActivite());
              pr.setString(11, p.getMessage());
              pr.setInt(12, p.getApercu_ticket());
              pr.executeUpdate();
              pr.close(); 
              conn.close();

        } catch (Exception sc) {
           
          // sc.printStackTrace();
        }
       
    }  
    
    
    
    public Paramaitre get_Paramaitre() throws Exception {
         //
          String sql ="";
 
         Paramaitre u = null;
            Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
                sql = "select * FROM Paramaitres  where ID=1";
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
      
          
            String adresse =rs.getString("adresse_p");
            String nom_magasin =rs.getString("nom_magasin");
            String num_tel_fax_fix=rs.getString("num_tel_fax_fix_p");
            String num_tel1=rs.getString("num_tel1_p");
            String num_tel2=rs.getString("num_tel2_p");
            String NIS=rs.getString("NIS");
            String NRC=rs.getString("NRC");
            String NIF=rs.getString("NIF");
            String RIB=rs.getString("RIB");
            String activite=rs.getString("activite");
            String message=rs.getString("message");
            int apercu_ticket=rs.getInt("apercu_ticket");
         u= new Paramaitre( nom_magasin,  adresse,  num_tel_fax_fix,num_tel1,num_tel2,NRC,NIS,NIF,RIB,activite,message,apercu_ticket) ;
        }
        rs.close();
        conn.close();

       
        return u;
    }
    
    
}
