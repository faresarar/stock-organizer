/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.regex.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.net.Socket;

/**
 *
 * @author hicham
 */
public class DataBase_op {

JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
private static DataBase_op instance; 
String ipAdress="127.0.0.1";
String DataBase="gestion";
String port="3306";
String privelege="false";
Properties prop=new Properties();
FileInputStream ip;

public DataBase_op(){}
public static DataBase_op getInstance(){
  
if(instance==null){
    instance=new DataBase_op();
}
return instance;
}   

public  void sup_table(String table)throws Exception{

        try {
Connection conn = jdbc.Getconnection();
//Statement stmt = conn.createStatement();
String sql = "delete  from "+table+" ";
 PreparedStatement pr=conn.prepareStatement(sql);   
 pr.executeUpdate();        
            //ResultSet rs = stmt.executeQuery(sql);
  pr.close();
  conn.close();
        } catch (Exception sc) {
        
        }
   
}     




 public  void delete_users()throws Exception{

        try {
Connection conn = jdbc.Getconnection();
//Statement stmt = conn.createStatement();
String sql = "delete  from users where username <> ? ";
 PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1, "admin");
              pr.executeUpdate();
              pr.close();
        conn.close();
  conn.close();
        } catch (Exception sc) {
            sc.printStackTrace();sc.getMessage();
        }
  // System.out.println("bien executer");
}     


 public  void delete_clients()throws Exception{

        try {
Connection conn = jdbc.Getconnection();
//Statement stmt = conn.createStatement();
String sql = "delete  from client where nom_prénom_client <> ? ";
 PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1, "Passager");
              pr.executeUpdate();
              pr.close();
        conn.close();
  conn.close();
        } catch (Exception sc) {
            sc.printStackTrace();sc.getMessage();
        }
 //  System.out.println("bien executer");
}    
 
 
public  void Charger_dossier( JComboBox dossier ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
   DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
dossier.setRenderer(centr);
dossier.removeAllItems();
  Statement stmt = null;
        ResultSet resultset = null;
 try {
            Connection conn = jdbc.Getconnection();
            stmt = conn.createStatement();
            resultset = stmt.executeQuery("SHOW DATABASES;");
 
            if (stmt.execute("SHOW DATABASES;")) {
                resultset = stmt.getResultSet();
            }
                 
        while (resultset.next()) {
       if(resultset.getString("Database").equals("information_schema")||resultset.getString("Database").equals("mysql")||resultset.getString("Database").equals("performance_schema")||resultset.getString("Database").equals("phpmyadmin")||resultset.getString("Database").equals("utilisateurs")||resultset.getString("Database").equals("test")) {} else     dossier.addItem(resultset.getString("Database"));
        }
        resultset.close();
        conn.close();    
          stmt.close();
        } catch(Exception e){}
   
   } 
 
 
 
 public  boolean DossierExist( String dossier ) throws FileNotFoundException{ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
  boolean exist=false;
  Statement stmt = null;
  ResultSet resultset = null;
  getPropertyConfigFile();
   /*
   Properties prop=new Properties();
  //FileInputStream ip= new FileInputStream("src/controler/Config.properties");
   FileInputStream ip= new FileInputStream("Config.properties");
      try {
          prop.load(ip);
      } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), " Erreur ", JOptionPane.WARNING_MESSAGE, null);
          Logger.getLogger(DataBase_op.class.getName()).log(Level.SEVERE, null, ex);
      }
    ipAdress=  prop.getProperty("ip");
    port=prop.getProperty("port");
  */

  
 try {
     
       String url = "jdbc:mysql://127.0.0.1:3306/";
       url=url.replace("127.0.0.1", ipAdress);
       url=url.replace("3306", port);
         Class.forName("com.mysql.jdbc.Driver");
         Connection conn;
      //  Connection connection = DriverManager.getConnection(url,userName, password);
     // if(GetPrivelege().equals("true"))
    conn =    DriverManager.getConnection(url,"root","160588");
   // else 
   //  conn=DriverManager.getConnection(url,"root","");
    
          //  Connection conn = jdbc.Getconnection();
            stmt = conn.createStatement();
            resultset = stmt.executeQuery("SHOW DATABASES;");
 
            if (stmt.execute("SHOW DATABASES;")) {
                resultset = stmt.getResultSet();
            }
                 
        while (resultset.next()) {
         //   System.out.println("bdd="+resultset.getString("Database"));
       if(resultset.getString("Database").equals(dossier)) exist= true;
        }
        resultset.close();
        conn.close();    
         stmt.close();
        } catch(Exception e){
       // e.printStackTrace();
      
        }
   return exist;
   } 
 public void CreateBDD( String databaseName){
  
   try {
         getPropertyConfigFile();
     //   String userName = "root";
      //  String password = "";

        String url = "jdbc:mysql://127.0.0.1:3306/";
        // url=url.replace("127.0.0.1", ipAdress);
         url=url.replace("3306", port);
         System.out.println("ipAdress="+ipAdress);
             System.out.println("port="+port);
         Class.forName("com.mysql.jdbc.Driver");
         Connection connection;
      //   if(GetPrivelege().equals("true"))
     connection =    DriverManager.getConnection(url,"root","160588");
    //else 
         //    connection=DriverManager.getConnection(url,"root","");
      //  Connection connection = DriverManager.getConnection(url,userName, password);
   // Connection connection =    DriverManager.getConnection(url,"root","160588");

        String sql = "CREATE DATABASE IF NOT EXISTS " + databaseName;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
     
        statement.close();
     //   JOptionPane.showMessageDialog(null, databaseName + " Database has been created successfully", "System Message", JOptionPane.INFORMATION_MESSAGE);
   System.out.println("databaseName created:"+databaseName);
    } catch (Exception e) {
         e.printStackTrace();
         System.exit(0);
     // String exepath1 =  "c:\\xampp1\\apache_start.bat";
 //String exepath2 =  "c:\\xampp1\\mysql_start.bat";
 //String exeargs = "silent-load";

/*try {
        Runtime r = Runtime.getRuntime();
        r.exec(exepath1 + " " + exeargs);
    } catch (IOException e1) {

       
    }*/

//try {
     //   Runtime r = Runtime.getRuntime();
      //  r.exec(exepath2 + " " + exeargs);
   // } catch (IOException e2) {
//System.exit(0);
        //e.printStackTrace();
   // }
           JOptionPane.showMessageDialog(null, e.getMessage() , "erreur de creation de la BDD", JOptionPane.INFORMATION_MESSAGE);
       e.printStackTrace();
           System.exit(0);
}
  
  }
 
 public String GetIP() throws FileNotFoundException{
  Properties prop=new Properties();
  FileInputStream 
 ip= new FileInputStream("Config.properties");
  try {
          prop.load(ip);
      } catch (IOException ex) {
          Logger.getLogger(DataBase_op.class.getName()).log(Level.SEVERE, null, ex);
      }  
 return prop.getProperty("ip");
 }
 /*public String GetPrivilege() throws FileNotFoundException{
  Properties prop=new Properties();
  FileInputStream 
 ip= new FileInputStream("Config.properties");
  try {
          prop.load(ip);
      } catch (IOException ex) {
          Logger.getLogger(DataBase_op.class.getName()).log(Level.SEVERE, null, ex);
      }  
 return prop.getProperty("privelege");
 }*/
 public void SetIP(String NewIP) throws FileNotFoundException, IOException{
   try {
      File appConfig = new File("Config.properties");
      Writer inputStream = new FileWriter(appConfig);
      Properties prop=new Properties();
      prop.setProperty("ip",NewIP );
      prop.store(inputStream, "INFORMATION!!!");        
       }
       catch(Exception e){}
 }
 
 
 public String GetDataBase() throws FileNotFoundException{
 //String host="127.0.0.1";
  Properties prop=new Properties();
  FileInputStream 
 ip= new FileInputStream("Config.properties");
   try {
          prop.load(ip);
      } catch (IOException ex) {
          Logger.getLogger(DataBase_op.class.getName()).log(Level.SEVERE, null, ex);
      }
 return prop.getProperty("database");
 }
 
  public String GetPort() throws FileNotFoundException{
 //String host="127.0.0.1";
  Properties prop=new Properties();
  FileInputStream 
 ip= new FileInputStream("Config.properties");
   try {
          prop.load(ip);
      } catch (IOException ex) {
          Logger.getLogger(DataBase_op.class.getName()).log(Level.SEVERE, null, ex);
      } 
 return prop.getProperty("port");
 }
  public String GetPrivelege() throws FileNotFoundException{
 //String host="127.0.0.1";
  Properties prop=new Properties();
  FileInputStream 
 ip= new FileInputStream("Config.properties");
   try {
          prop.load(ip);
      } catch (IOException ex) {
          Logger.getLogger(DataBase_op.class.getName()).log(Level.SEVERE, null, ex);
      } 
 return prop.getProperty("privelege");
 }
  
  
 public  boolean isValidIPAddress(String ip)  
{  
//regex for digit from 0 to 255.  
String zeroTo255 = "(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])";  
// Regex for a digit from 0 to 255 and followed by a dot, repeat 4 times. this is the regex to validate an IP address.  
String regex= zeroTo255 + "\\."+ zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;  
// Compile the ReGex  
Pattern p = Pattern.compile(regex);  
//if the IP address is empty return false  
if (ip == null)   
{  
return false;  
}  
//pattern class contains matcher() method to find matching between given IP address and regular expression.  
Matcher m = p.matcher(ip);  
// Return if the IP address matched the ReGex  
return m.matches();  
}   
  
 public void RestoreDBB(String DataBase,String path){
      
     try {
         
               Thread thread = new Thread("New Thread") {
      public void run(){
         
          try {
               String[] restoreCmd;
         //  if(GetPrivelege().equals("true"))
               restoreCmd = new String[]{"mysql.exe " ,DataBase, "--user=" + "root", "--password=" + "160588"   , "-e", "source " + path};
          // else restoreCmd = new String[]{"mysql.exe " ,DataBase, "--user=" + "root", "--password=" + ""   , "-e", "source " + path};
            Process runtimProcess;
              runtimProcess = Runtime.getRuntime().exec(restoreCmd);
                int proceCom = runtimProcess.waitFor();
                      if (proceCom==0) {
                
               System.out.println("restauration réussite");               
               //JOptionPane.showMessageDialog(this, "restauration réussite", "Successfully", JOptionPane.INFORMATION_MESSAGE); 
   
            }else{
                 System.out.println("Can't Restored");              
            }
          } catch (IOException ex) {
              ex.printStackTrace();
           
          } catch (InterruptedException ex) {
             JOptionPane.showMessageDialog(null,  "erreur de restoration", ex.getMessage(), JOptionPane.INFORMATION_MESSAGE); 
          }
     
       // JOptionPane.showMessageDialog(null, " Bien Ajouter ","",JOptionPane.INFORMATION_MESSAGE,img1);
      } 
   };


   thread.start();                            
        } catch (Exception e) {
            e.printStackTrace();
      
        }
 } 
  
 public void RemouveUSES(String input,String output,String DbName){
 
        File inputFile = new File(input);
        File outputFile = new File(output);

        Scanner sc = null;
        FileWriter fw = null;

        try {       
            sc = new Scanner(inputFile);
            fw = new FileWriter(outputFile);

            while(sc.hasNextLine()) {
                String str = sc.nextLine();                 
              str = str.replaceAll("USE "+"`"+DbName+"`;", "");                 
                fw.write(str+"\n" );
            }
      
            sc.close();
            fw.close();
           System.out.println("input="+input);
           inputFile.delete();
        } catch (FileNotFoundException e2) {
           // e2.printStackTrace();
        } catch (IOException e1) {
           // e1.printStackTrace();
        } catch (Exception e) {
           // e.printStackTrace();
        }
 
 }
 
public boolean IsValid(String DbName,String chemin){
 
 boolean a=false;
        File inputFile = new File(chemin);
       

        Scanner sc = null;
       

        try {       
            sc = new Scanner(inputFile);
          

            while(sc.hasNextLine()) {
                String str = sc.nextLine();                 
              if(str.contentEquals("USE "+"`"+DbName+"`;"))      { a=true;break;  }     
              
            }
      
            sc.close();
          
         
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } 
 return a;
 }
 
    public void SetPrivillegeRoot() {
        try {
            
          getPropertyConfigFile();    
       String url = "jdbc:mysql://127.0.0.1:3306/";
        // url=url.replace("127.0.0.1", ipAdress);
         url=url.replace("3306", port);
         Class.forName("com.mysql.jdbc.Driver");
         String sql="SET PASSWORD FOR 'root'@'localhost' = PASSWORD('160588')";
       //  sql=sql.replace("localhost", ipAdress);
         Connection connection;
         System.out.println("GetPrivelege()="+GetPrivelege());
         connection =null;
      //  Connection connection = DriverManager.getConnection(url,userName, password);
 //if(GetPrivelege().equals("true")) 
  //   try{  connection =    DriverManager.getConnection(url,"root","160588");}catch(Exception e1){}
  // else 
   try{ connection =    DriverManager.getConnection(url,"root","");
        //   Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" , "root", "");
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            Throwable th = null;
            try {
                prepareStatement.executeQuery();
                
 
                if (prepareStatement != null) {
                      try {
           //  String url = "jdbc:mysql://127.0.0.1:3306/";
    //  url=url.replace("127.0.0.1", ipAdress);
         System.out.println("Ip adrese="+ipAdress);
         url=url.replace("3306", port);
            Connection connection2;
      //  Connection connection = DriverManager.getConnection(url,userName, password);
 //  if(GetPrivelege().equals("true"))
        connection2 =    DriverManager.getConnection(url,"root","160588");
  // else  connection2 =    DriverManager.getConnection(url,"root","");
            
            PreparedStatement prepareStatement2 = connection2.prepareStatement("GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY '160588' WITH GRANT OPTION;");
           //  PreparedStatement prepareStatement2 = connection2.prepareStatement("FLUSH PRIVILEGES;");
            Throwable th6 = null;
            try {
                prepareStatement2.executeQuery();
                if (prepareStatement2 != null) {
                     try{ File appConfig = new File("Config.properties");
      Writer inputStream = new FileWriter(appConfig);
      
      prop.setProperty("privelege","true" );
      prop.store(inputStream, "INFORMATION!!!"); 
  }catch(Exception e){}
                    
                    
                    if (0 != 0) {
                        try {
                            prepareStatement2.close();
                        } catch (Throwable th7) {
                            th6.addSuppressed(th7);
                        }
                    } else {
                        prepareStatement2.close();
                    }
                }
                if (connection2 != null) {
                    if (0 != 0) {
                        connection2.close();
                    } else {
                        connection2.close();
                    }
                }
            } catch (Throwable th8) {
                try {
                    throw th8;
                } catch (Throwable th9) {
                    if (prepareStatement2 != null) {
                        if (0 != 0) {
                            try {
                                prepareStatement2.close();
                            } catch (Throwable th10) {
                                th6.addSuppressed(th10);
                            }
                        } else {
                            prepareStatement2.close();
                        }
                    }
                    throw th9;
                }
            }
        } catch (Exception unused2) {
            unused2.printStackTrace();
              JOptionPane.showMessageDialog(null,  unused2.getMessage() ,"Erreur 1", JOptionPane.INFORMATION_MESSAGE);
              System.exit(0);
        }
                    
                    
                    
                    
                    
                    if (0 != 0) {
                        try {
                            prepareStatement.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        prepareStatement.close();
                    }
                }
                if (connection != null) {
                    if (0 != 0) {
                        connection.close();
                    } else {
                        connection.close();
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    if (prepareStatement != null) {
                        if (0 != 0) {
                            try {
                                prepareStatement.close();
                            } catch (Throwable th5) {
                                th.addSuppressed(th5);
                            }
                        } else {
                            prepareStatement.close();
                        }
                    }
                    throw th4;
                }
            }
        } catch (Exception unused) {
           //  JOptionPane.showMessageDialog(null,  "erreur", unused.getMessage(), JOptionPane.INFORMATION_MESSAGE);
           unused.printStackTrace();
        }
   }catch(Exception e1){}
   
   
        
     /* try{ 
          Thread.currentThread().wait(2000);}catch(Exception e){}*/
      
       /* try {
            Connection connection3 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" , "root", "");
            PreparedStatement prepareStatement3 = connection3.prepareStatement("FLUSH PRIVILEGES;");
            Throwable th11 = null;
            try {
                prepareStatement3.executeQuery();
                if (prepareStatement3 != null) {
                    if (0 != 0) {
                        try {
                            prepareStatement3.close();
                        } catch (Throwable th12) {
                            th11.addSuppressed(th12);
                        }
                    } else {
                        prepareStatement3.close();
                    }
                }
                if (connection3 != null) {
                    if (0 != 0) {
                        connection3.close();
                    } else {
                        connection3.close();
                    }
                }
            } catch (Throwable th13) {
                try {
                    throw th13;
                } catch (Throwable th14) {
                    if (prepareStatement3 != null) {
                        if (0 != 0) {
                            try {
                                prepareStatement3.close();
                            } catch (Throwable th15) {
                                th11.addSuppressed(th15);
                            }
                        } else {
                            prepareStatement3.close();
                        }
                    }
                    throw th14;
                }
            }
        } catch (Exception unused3) {
        }*/
      
        
       
    }
 public int  Verifier(String database,String path) throws InterruptedException, FileNotFoundException{
  // dop.b();
if(!DossierExist(database))try{
   
    CreateBDD(database);RestoreDBB(database,path); 

}catch(Exception e){e.getMessage();}
return 1;
}
 void getPropertyConfigFile() throws FileNotFoundException{
 // Properties prop=new Properties();
  ip= new FileInputStream("Config.properties");
  
      try {
          prop.load(ip);
         
      } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() ,"Config File not found" , JOptionPane.WARNING_MESSAGE, null);
          Logger.getLogger(DataBase_op.class.getName()).log(Level.SEVERE, null, ex);
      }
    ipAdress=  prop.getProperty("ip");
    port=prop.getProperty("port");
   privelege=prop.getProperty("privelege");
 
 
 
 }
 
 
 public boolean isServerUP(int port){
    try {    
        ipAdress=GetIP();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(DataBase_op.class.getName()).log(Level.SEVERE, null, ex);
    }
 boolean isUp=false;
 try{
 Socket socket=new Socket(ipAdress,port);
 isUp=true;
 socket.close();
 }
 catch(Exception e){}
 
 return isUp;
 }
}
