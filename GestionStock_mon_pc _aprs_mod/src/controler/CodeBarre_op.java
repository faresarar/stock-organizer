/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.CodeBarre;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

/**
 *
 * @author Rais
 */
public class CodeBarre_op {
    
    private static CodeBarre_op instance;   
public CodeBarre_op(){}
public static CodeBarre_op getInstance(){
if(instance==null){
    instance=new CodeBarre_op();
}
return instance;
}
       JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
     ImageIcon   img = new ImageIcon("Images/erreur.GIF");
  public String GenerateRandomNumber(){
      Random rand = new Random(); 
      int    number1 = 9999999;
       int    number2 = 999999;
        //generate random values from 0-999999999
      int int_random1 = rand.nextInt(number1); 
        int int_random2 = rand.nextInt(number2); 
   return int_random1+""+int_random2;
   } 
   public String GenerateRandomNumber2(){
   String s="6";
   Random rand = new Random(); 
   for(int i=0;i<12;i++)
    s=s+Math.abs(rand.nextInt()%10);       
   return s;
   } 
  
  public  void sup_ListCode(int  id_pro)throws Exception{

        try {
 Connection conn = jdbc.Getconnection();
              String sql = "delete  from codebarre where id_produit=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, id_pro);
              pr.executeUpdate();
           // ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
}  
  
  
 /* public boolean NumberExist(String code) throws Exception{
    
 boolean a=false;
       
            JdbcClass j=new JdbcClass();
            Connection conn = j.connect();
            //Statement stmt = conn.createStatement();
              String sql = "select * FROM produit where code_barre=?";
               PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,code);
             
            ResultSet rs =pr.executeQuery();
        while (rs.next()) {
            String code_barre =(rs.getString("code_barre"));
            if(code_barre.equals(code)&&(!code_barre.equals("")))
            {  
            a=true;
            }
        }
        rs.close();
        conn.close();
   return a;
   }
*/
   public boolean CodeExist(String code) throws Exception{
    
 boolean a=false;
       
            Connection conn = jdbc.Getconnection();
              String sql = "select * FROM codebarre where code=?";
               PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,code);
             
            ResultSet rs =pr.executeQuery();
        while (rs.next()) {
            String code_barre =(rs.getString("code"));
            if(code_barre.equals(code)&&(!code_barre.equals("")))
            {  
            a=true;
            
            }
        }
        rs.close();
        conn.close();
   return a;
   }
    
  
 public  void GenerateBarreCodeImage(String code){
    try {
            //Create the barcode bean
            Code128Bean bean = new Code128Bean();

            final int dpi = 120;

            //Configure the barcode generator
            bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi)); //makes the narrow bar 
                                                             //width exactly one pixel
         //   bean.setWideFactor(3);
            bean.doQuietZone(false);

            //Open output file
            
         //   InputStream input = getClass().getResourceAsStream
          // ("/images/out.jpg");
           
        
            File fichier=new File("src/images/out"+code+".jpg");
        //  if (fichier.delete()) { 
     // System.out.println("Deleted the file: " + fichier.getName());
  //  } else {
   //   System.out.println("Failed to delete the file.");
   // } 
            
           // URL url = getClass().getResource("/images/out.jpg");
           // File outputFile = new File("/images/bare.jpg");
        //   File outputFile = new File(url.getPath());
     //  if( fichier.exists())fichier.delete();
            OutputStream out = new FileOutputStream(fichier);
            
            try {
                //Set up the canvas provider for monochrome JPEG output 
                BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                        out, "image/jpeg", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

                //Generate the barcode
                bean.generateBarcode(canvas, code);

                //Signal end of generation
                canvas.finish();
            } finally {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
   
   }
 
 
 
 public  void inserer_ListCodeBarre(ArrayList<CodeBarre> list)throws Exception{
        try { 
            Connection conn = jdbc.Getconnection();
         for(int i=0;i<list.size();i++){
     
           String sql = "insert into codebarre (id_produit,code) values (?,?) ";
          //  String sql = "insert into codebarre  SET code ='"+list.get(i).getCode() +"' id_produit=LAST_INSERT_ID() ";
              PreparedStatement pr=conn.prepareStatement(sql);
            pr.setInt(1,list.get(i).getId_produit());
             pr.setString(2,list.get(i).getCode());
               
               
              pr.executeUpdate();
              pr.close();
         }
           // ResultSet rs = stmt.executeQuery(sql);
          
       
        conn.close();
        } catch (Exception sc) {
     JOptionPane.showMessageDialog(null, sc.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE,img);        
        }
   }
  public  void Modifer_ListCodeBarre(ArrayList<CodeBarre> list)throws Exception{
        try { 
           Connection conn = jdbc.Getconnection();
         for(int i=0;i<list.size();i++){
     
           String sql = "UPDATE codebarre  set code=? where id_produit='"+list.get(i).getId_produit()+"'";
          //  String sql = "insert into codebarre  SET code ='"+list.get(i).getCode() +"' id_produit=LAST_INSERT_ID() ";
              PreparedStatement pr=conn.prepareStatement(sql);
           //   pr.setInt(1,list.get(i).getId_produit());
             pr.setString(1,list.get(i).getCode());
               
               
              pr.executeUpdate();
              pr.close();
         }
           // ResultSet rs = stmt.executeQuery(sql);
          
       
        conn.close();
        } catch (Exception sc) {
     JOptionPane.showMessageDialog(null, sc.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE,img);        
        }
   }
 
 
 public  ArrayList<String> GetListCode1(int id_produit) throws Exception{
     ArrayList<String> List= new ArrayList<String>();
 
             Connection conn = jdbc.Getconnection();
              String sql = "select DISTINCT code FROM codebarre,produit where produit.id_produit=codebarre.id_produit and codebarre.id_produit= ?";
               PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1,id_produit);
             
            ResultSet rs =pr.executeQuery();
        while (rs.next()) {
            String code_barre =(rs.getString("code"));
            List.add(code_barre);
          
        }
        rs.close();
        conn.close();
   return List;
   }
 
 
 public ArrayList GetListCode(int id_produit) throws Exception{
     ArrayList<CodeBarre> List= new ArrayList<CodeBarre>();
 
             Connection conn = jdbc.Getconnection();
              String sql = "select code FROM codebarre,produit where produit.id_produit=codebarre.id_produit and codebarre.id_produit= ?";
               PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1,id_produit);
             
            ResultSet rs =pr.executeQuery();
        while (rs.next()) {
            String code_barre =(rs.getString("code"));
            List.add (new CodeBarre(code_barre,id_produit));
          
        }
        rs.close();
        conn.close();
   return List;
   }

}
