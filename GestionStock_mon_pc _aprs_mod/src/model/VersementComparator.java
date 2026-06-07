/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hicham
 */
public class VersementComparator implements java.util.Comparator<Versement> {
    @Override
    public int compare(Versement a, Versement b) {
        return a.getNum_versement() - b.getNum_versement();
    }
    public VersementComparator(){};
 }