/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.swing.JFileChooser;

import java.math.BigDecimal;
import java.math.BigInteger;



/**
 *
 * @author Rais
 */
public class Cripto_op {
JdbcClassUser jdbcuser= JdbcClassUser.getInstance();

private static Cripto_op instance;   
public Cripto_op(){}
public static Cripto_op getInstance(){
if(instance==null){
    instance=new Cripto_op();
}
return instance;
}
      Cipher ecipher;
    Cipher dcipher;
    // 8-byte Salt
    byte[] salt = {
        (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
        (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
    };
    // Iteration count
    int iterationCount = 19;
 public String getMac() throws UnknownHostException, SocketException{
 String MAC="";
  	// Obtenir l'adresse IP de la machine locale
   // InetAddress address = InetAddress.getLocalHost();
 
  //  NetworkInterface ni = NetworkInterface.getByInetAddress(address);
    byte[] mac = {12,5,72,92};//ni.getHardwareAddress();
// System.out.println("mac="+mac);
   // Afficher l'adresse Mac
    for (int i = 0; i < mac.length; i++) {
   //   System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
      MAC=MAC+mac[i];
    }
   // System.out.println("MAC="+MAC);
    
    return MAC;
  }
 

/*public String GetSerialNumber() throws Exception{
    String ref="";
   Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select SERIALNUMBER  from Serial ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String max =rs.getString("SERIALNUMBER");
         
            ref=max;
        }

return ref;
}*/
   
 public boolean ExistSerialNumber(String serial) throws Exception{
    boolean exist=false;
   Connection conn = jdbcuser.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select SERIALNUMBER  from Serial ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String sr =rs.getString("SERIALNUMBER");
         if(sr.equals(serial))
         {  exist=true;break;}
            
        }

return exist;
}
 
 public String Chifrer(String message) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
 // String ss = "Hello world, haris is here!";
      byte[] plainText = message.getBytes();
      //
      // get a DES private key
      System.out.println("\nStart generating DES key");
      KeyGenerator keyGen = KeyGenerator.getInstance("DES");
      keyGen.init(56);
      Key key = keyGen.generateKey();
      System.out.println("Finish generating DES key");
      //
      // get a DES cipher object and print the provider
      Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
      
      System.out.println("\n" + cipher.getProvider().getInfo());
      //
      // encrypt using the key and the plaintext
      System.out.println("\nStart encryption");
      cipher.init(Cipher.ENCRYPT_MODE, key);
      byte[] cipherText = cipher.doFinal(plainText);
      System.out.println("Finish encryption: ");
    //  System.out.println(new String(cipherText, "UTF8"));
      return new String(cipherText, "UTF8");
 }
 
 public String Dechifrer(String message) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException{
  KeyGenerator keyGen = KeyGenerator.getInstance("DES");
      keyGen.init(56);
      Key key = keyGen.generateKey();
       Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
   System.out.println("\nStart decryption");
      cipher.init(Cipher.DECRYPT_MODE, key);
    //  byte[] plainText = message.getBytes();
       byte[] cipherText = cipher.doFinal(message.getBytes());
      byte[] newPlainText = cipher.doFinal(cipherText);
      System.out.println("Finish decryption: ");

      System.out.println(new String(newPlainText, "UTF8"));
 return new String(newPlainText, "UTF8");
 }

 
 public String encrypt(String secretKey, String plainText)
            throws NoSuchAlgorithmException,
            InvalidKeySpecException,
            NoSuchPaddingException,
            InvalidKeyException,
            InvalidAlgorithmParameterException,
            UnsupportedEncodingException,
            IllegalBlockSizeException,
            BadPaddingException {
        //Key generation for enc and desc
        KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
        // Prepare the parameter to the ciphers
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
//Enc process
        ecipher = Cipher.getInstance(key.getAlgorithm());
        ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        String charSet = "UTF-8";
        byte[] in = plainText.getBytes(charSet);
        byte[] out = ecipher.doFinal(in);
        String encStr = new String(Base64.getEncoder().encode(out));
        return encStr;
 }
  public String decrypt(String secretKey, String encryptedText)
            throws NoSuchAlgorithmException,
            InvalidKeySpecException,
            NoSuchPaddingException,
            InvalidKeyException,
            InvalidAlgorithmParameterException,
            UnsupportedEncodingException,
            IllegalBlockSizeException,
            BadPaddingException,
            IOException {
      String plainStr;
        //Key generation for enc and desc
        KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, iterationCount);
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
        // Prepare the parameter to the ciphers
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
        //Decryption process; same key will be used for decr
        dcipher = Cipher.getInstance(key.getAlgorithm());
        dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
     try {  byte[] enc = Base64.getDecoder().decode(encryptedText);
        byte[] utf8 = dcipher.doFinal(enc);
        String charSet = "UTF-8";
        plainStr = new String(utf8, charSet);
     }catch (Exception e){plainStr="";}
        return plainStr;
    }    
  
  
  
  
  public void AddSerial(String s) throws Exception {
        
        try {
            Connection conn = jdbcuser.Getconnection();
           String sql = "INSERT INTO serial  ( serialnumber ) value (?) ";
           PreparedStatement pr=conn.prepareStatement(sql);
            
              
             pr.setString(1,s);
           pr.executeUpdate();
      
     //  System.out.println("execute update");
        conn.close();

        } catch (Exception sc) {
          sc.getMessage();
        }
       
    }  
  
  public void CreateTexFile(String s){
   try {
      File myObj = new File("D:numéro.txt");
       File myObj1 = new File("C:numéro.txt");
      myObj.createNewFile();
       myObj1.createNewFile();
  PrintWriter sortie = new PrintWriter
		(new FileWriter(myObj, true));
  PrintWriter sortie1 = new PrintWriter
		(new FileWriter(myObj1, true));
 sortie.println(s);
 sortie1.println(s);
        sortie.close();    
         sortie1.close();  
       // System.out.println("File created: " + myObj.getName());
    
    } catch (IOException e) {
    //  System.out.println("An error occurred.");
      e.printStackTrace();
    }
  
  }
  
   public  String getNumero() throws IOException {
    Runtime runtime = Runtime.getRuntime();
    String[] commands = {"wmic", "diskdrive", "get", "SerialNumber"};
    Process process = runtime.exec(commands);
    String chain = null;
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
        String serialNumber= null;
        while ((serialNumber = bufferedReader.readLine()) != null) {
            if (serialNumber.trim().length() > 0) {
                chain = serialNumber;
            }
        }
        return toAsciiString(chain.trim()).substring(0, 10);
    }
 }
   
   private  String toAsciiString(String message) {
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            int asciiCode = (int) c;
            sb.append(asciiCode);
        }
        return sb.toString();
    }
  public void SaveTxt() throws IOException{
   File  file = null;
   JFileChooser  fc = new JFileChooser(new File(".txt"));
     
         
        fc.setDialogTitle("Enregistrer...");
        
           int returnVal = fc.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();//chemin
                System.out.println(file);
             
                
            }
            
        
            
 PrintWriter sortie = new PrintWriter
		(new FileWriter(file.getPath()+".txt", true));
// sortie.println("hjgggdgfgd\n"); sortie.println("aaaaaaaaaaaaaaaaa");
        sortie.close();
  
  }
 public  String crypteru(String str) {
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            int i2 = 2;
            while (i2 < 280 && a(i2, 280) != 1) {
                i2++;
            }
            str2 = str2 + Character.toString((char) Double.valueOf(Math.pow(charAt, i2) % 319.0d).intValue());
        }
        return str2;
    }

    public  String decrypt(String str) {
        String str2 = "";
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            int i3 = 2;
            while (i3 < 280 && a(i3, 280) != 1) {
                i3++;
            }
            int i4 = 0;
            while (true) {
                if (i4 <= 9) {
                    int i5 = 1 + (i4 * 280);
                    if (i5 % i3 == 0) {
                        i = i5 / i3;
                        break;
                    }
                    i4++;
                }
            }
            str2 = str2 + Character.toString((char) BigDecimal.valueOf(charAt).toBigInteger().pow(i).mod(BigInteger.valueOf(319L)).intValue());
        }
        return str2;
    }
private  int a(int i, int i2) {
        while (i != 0) {
            int i3 = i2 % i;
            i2 = i;
            i = i3;
        }
        return i2;
    }
/*public ArrayList getList_Serial() throws Exception {
String sql = "select * FROM serial ";
ArrayList<String> List_serial= new ArrayList<>();   
Connection conn = jdbc.Getconnection();
PreparedStatement pr=conn.prepareStatement(sql);           
ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
         String sr =rs.getString("id_client");
          List_serial.add(sr);
        }
        rs.close();
        conn.close();
        return List_serial;
    }
    
*/

public int NbreSerialNumber() throws Exception{
    int nbre=0;
   Connection conn = jdbcuser.Getconnection();
            Statement stmt = conn.createStatement();
           //  String sql = "select *  from serial ";
             String sql = "select count(id)  as nb from serial  ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
             nbre =rs.getInt("nb");
       
         //   nbre=nbre+1;
        }

return nbre;
}

}
