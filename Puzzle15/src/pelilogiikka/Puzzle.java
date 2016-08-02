/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelilogiikka;

import pelilauta.*;

/**
 *
 * @author eamiller
 */
public class Puzzle {

    private Lauta lauta;

    public Puzzle(Lauta lauta) {
        this.lauta = lauta;
    }

    public Lauta getLauta() {
        return lauta;
    }
    
    

    public Laatta[] getLaatat() { //Kokeillaanpa jos tämä shaiba toimii
        int i = 0;
        Laatta[] laatat = new Laatta[lauta.getLaattoja()];

        for (Laatta[] laattaLista : lauta.getLauta()) {
            for (Laatta l : laattaLista) {
                if (l != null) {
                    laatat[i] = l;
                    i++;
                }
            }
        }
        return laatat;
    }

}
