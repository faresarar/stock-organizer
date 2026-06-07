/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Rais
 */
public class CheckField implements MouseListener{
private static CheckField instance;   
Date date;
public CheckField(){}
public static CheckField getInstance(){
if(instance==null){
    instance=new CheckField();
}
return instance;
}
public void CheckTextField(JTextField t,int longeur){
if(t.getText().equals("")){
 //   t.setForeground(Color.red);
 t.setBorder (BorderFactory.createLineBorder (Color.red, 2));
}
else {
  t.setBorder (BorderFactory.createLineBorder (Color.gray, 1));
  if(t.getText().length()>longeur)t.setText("");
}
}
//    JOptionPane.showMessageDialog(null, " Entrer une valeur ","",JOptionPane.ERROR_MESSAGE,null);    

    
    public void CheckTextFieldLength(JTextField t,int longeur){


 // t.setBorder (BorderFactory.createLineBorder (Color.gray, 1));
  if(t.getText().length()>longeur){t.setText("");
  t.setBorder (BorderFactory.createLineBorder (Color.red, 2));
  JOptionPane.showMessageDialog(null, " Erreur ","Entrer une valeur <="+longeur,JOptionPane.ERROR_MESSAGE,null);
  }
  else  t.setBorder (BorderFactory.createLineBorder (Color.gray, 1));
}

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mouseEntered(MouseEvent me,JTextField t) {
        t.setBorder (BorderFactory.createLineBorder (Color.gray, 1));
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public void CheckDate(JXDatePicker DatePicker){
try{ date=new java.sql.Date(DatePicker.getDate().getTime());  }catch(Exception e){date=null;}  
//System.out.println("date="+date);
if(date==null){
 //   t.setForeground(Color.red);
 DatePicker.setBorder (BorderFactory.createLineBorder (Color.red, 2));
}
else {
  DatePicker.setBorder (BorderFactory.createLineBorder (Color.gray, 1));
 
}
}
}
