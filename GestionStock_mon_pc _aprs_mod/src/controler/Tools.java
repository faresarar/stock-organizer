/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.Color;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import raven.javaswingdev.MessageDialog;
import raven.javaswingdev.MessageDialog.MessageType;
import sweet_alert.Message;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.swing.ImageIcon;

/**
 *
 * @author hicham
 */
public class Tools  {
   
private static Tools instance;   
public Tools(){}
public static Tools getInstance(){
if(instance==null){
    instance=new Tools();
}
return instance;
}    

public void ShowGoodMessage(JFrame f,String message){
   Message me2 = new Message(f, true,"/images/good128.png",message,"",new Color(41,134,10));  
  me2.showAlert();

}

public void ShowFailMessage(JFrame f,String message){
   Message me2 = new Message(f, true,"/images/stop.png",message,"",Color.red);  
  me2.showAlert();

}

public MessageType ShowConfirmMessage(String msg1,String msg2,JFrame j){
 MessageDialog obj = new MessageDialog(j);
 obj.showMessage(msg1, msg2);      
return obj.getMessageType();
}
/*public void ShowMessageDelete(JFrame f){
   Message me2 = new Message(f, true,"/images/good128.png","Bien Supprimer","",new Color(41,134,10));  
  me2.showAlert();

}*/
public void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }

public String Crypted( String plaintext) throws Exception  {
String algorithm = "AES";
        String transformation = "AES/ECB/PKCS5Padding";
        
        // Step 2: Create a key for the chosen encryption algorithm
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        SecretKey secretKey = keyGenerator.generateKey();
        System.out.println("secretKey="+secretKey);
        
        // Step 3: Initialize a cipher object with the key and encryption mode
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        // Step 4: Encrypt the data using the cipher object
      //  String plaintext = "This is a secret message";
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);
        
   System.out.println("Encrypted data: " + encryptedBase64);

return encryptedBase64;
}

public String Decrypted( String encryptedBase64) throws Exception  {

String algorithm = "AES";
        String transformation = "AES/ECB/PKCS5Padding";
         KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        SecretKey secretKey = keyGenerator.generateKey();
       
        // Step 2: Use the same key that was used during encryption
        // In this example, we assume that you have the secret key from the encryption example
       
        
        // Step 3: Initialize a cipher object with the key and decryption mode
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        
        // Step 4: Decrypt the data using the cipher object
     //   String encryptedBase64 = ...; // The encrypted data from the encryption example
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedBase64);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);
        
        System.out.println("Decrypted data: " + decryptedText);
         System.out.println("key ="+secretKey);
return decryptedText;

}

public static SecretKey generateKey() throws NoSuchAlgorithmException {
    KeyGenerator keygenerator = KeyGenerator.getInstance("AES"); 
    keygenerator.init(128);
    return keygenerator.generateKey();
}


public String PaswordToHash(String psw) throws NoSuchAlgorithmException{
MessageDigest md=   MessageDigest.getInstance("SHA");
md.update(psw.getBytes());
byte[] rbt=md.digest();
StringBuilder sb=new StringBuilder();
for(byte b:rbt)
{sb.append(String.format("%02x", b));}
return sb.toString();
}


public ImageIcon getImageIcone(){
 return    new ImageIcon("images/icone128.png"); 
}
}
