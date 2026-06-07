package controler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hicham
 */
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import static javax.swing.Action.ACTION_COMMAND_KEY;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
//import vue.Aucceuil4;
//import vue.Autentifier;
import vue.VenteComptoir4;

public class RaccourciBouton{
   // String key="";
  /*  public String KeyStrock(JButton j){
     ActionMap actionMap = j.getRootPane().getActionMap();
        InputMap inputMap = j.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        for (Keys direction : Keys.values()) {
            actionMap.put(direction.getText(), new KeyBinding(direction.getText()));
            inputMap.put(direction.getKeyStroke(), direction.getText());
        }

        j.getRootPane().setActionMap(actionMap);
        j.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        j.setVisible(true);   
        
        
    
    return key;}*/
 public RaccourciBouton(){
   

}
 public void Activer(JButton j){
  ActionMap actionMap = j.getRootPane().getActionMap();
        InputMap inputMap = j.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        for (Keys direction : Keys.values()) {
            actionMap.put(direction.getText(), new KeyBinding(direction.getText()));
            inputMap.put(direction.getKeyStroke(), direction.getText());
        }

        j.getRootPane().setActionMap(actionMap);
        j.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        j.setVisible(true);
 
 
 }
 /*   public void initGUI( JButton submit){
      
        AbstractAction buttonPressed = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
   //  System.out.println("Activated: " +KeyStroke.getKeyStroke("ENTER"));
                  System.out.println(e.getActionCommand());
            
         
               if(e.getActionCommand().equals("enter_pressed"))System.out.println("bbbbb");
             // else 
                //  System.out.println("ennterrr");
            }
        };

      //   submit = new JButton("Submit");
        submit.addActionListener(buttonPressed);
submit.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER,0,true), "enter_pressed");
       
        submit.getActionMap().put("enter_pressed", buttonPressed);
        
        
        
        
        submit.addActionListener(buttonPressed);
submit.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1,0), "f1_pressed");
        
        submit.getActionMap().put("f1_pressed", buttonPressed);

     
        submit.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B,0), "B_pressedv");
        submit.getActionMap().put("B_pressedv", buttonPressed);

      
        }*/
     private class KeyBinding extends AbstractAction {
        private static final long serialVersionUID = 1L;

        public KeyBinding(String text) {
            super(text);
            putValue(ACTION_COMMAND_KEY, text);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
           // if(action.equals("ENTER")) Autentifier.getObj().Valider();
            switch(action){
             //  case    "ENTER":Autentifier.getObj().Valider(); System.out.println("Key Binding: " + action);break; 
                 //    case  "F1":try{VenteComptoir4.getObj(Aucceuil4.Currentuser.getNom_prenom_utilisateur()).ValiderKey();}catch(Exception ee){}System.out.println("Key Binding: " + action); break;
                 //    case  "UP":try{VenteComptoir4.getObj(Aucceuil.Currentuser.getNom_prenom_utilisateur()).QteAdd();System.out.println("Key Binding: " + action);}catch(Exception ee){}System.out.println("Key +++: " + action); break;
                    //   case  "F2":try{VenteComptoir4.getObj(Aucceuil4.Currentuser.getNom_prenom_utilisateur()).QteAdd();System.out.println("Key Binding F2: " + action);}catch(Exception ee){}System.out.println("Key F2 +++: " + action); break;
                  //      case  "DOWN":try{VenteComptoir4.getObj(Aucceuil.Currentuser.getNom_prenom_utilisateur()).QteDown();}catch(Exception ee){}System.out.println("Key Binding: " + action); break;
                  default:break;
         //   System.out.println("Key Binding: " + action);
          
        }
    }
     }
  
    
  private enum Keys {
    //    ESCAPE ("Escape",    KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0)),
        ENTER ("ENTER",    KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0)),
            DOWN   ("DOWN",      KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,   0)),
               UP   ("UP",      KeyStroke.getKeyStroke(KeyEvent.VK_UP,   0)),
                 F2   ("F2",      KeyStroke.getKeyStroke(KeyEvent.VK_F2,   0)),
             
     //     CTRLC  ("Control-C", KeyStroke.getKeyStroke(KeyEvent.VK_C,      KeyEvent.CTRL_DOWN_MASK)),
    //      CTRLP  ("Control-P", KeyStroke.getKeyStroke(KeyEvent.VK_P,      KeyEvent.CTRL_DOWN_MASK)),
         F1     ("F1",        KeyStroke.getKeyStroke(KeyEvent.VK_F1,     0));
     //     DOWN   ("Down",      KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,   0)),
      //    LEFT   ("Left",      KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,   0)),
      //    RIGHT  ("Right",     KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,  0));

        private String text;
        private KeyStroke keyStroke;

        private Keys(String text, KeyStroke keyStroke) {
            this.text = text;
            this.keyStroke = keyStroke;
        }

        public String getText() {
            return text;
        }

        public KeyStroke getKeyStroke() {
            return keyStroke;
        }

        @Override
        public String toString() {
            return text;
        }
    }   
    

}