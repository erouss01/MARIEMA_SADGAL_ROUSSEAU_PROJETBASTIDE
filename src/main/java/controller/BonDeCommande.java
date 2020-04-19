/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.entity.Produit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rsadgal
 */
public class BonDeCommande {
       private ArrayList Bons;

    public BonDeCommande() {
        Bons = new ArrayList<String>();
    }


    public List<String> getPayload() {
        return Bons;
    }

    public void addParameter(String s) {
        Bons.add(s);
    }
}
