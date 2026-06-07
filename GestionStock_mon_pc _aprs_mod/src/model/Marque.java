/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lenovo
 */
public class Marque {
    private int id;

    public int getId() {
        return id;
    }

    public Marque(int id, String valeur) {
        this.id = id;
        this.valeur = valeur;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String valeur;

    public Marque() {
    }

  
    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

   

    public String getValeur() {
        return valeur;
    }

  
    
}
