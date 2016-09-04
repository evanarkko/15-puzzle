/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelilogiikka;

import pelilauta.Koordinaatit;
import pelilauta.Lauta;
import ratkaisija.Suunta;

/**
 * Apuluokka, joka siirtelee pelaajan haluamia laattoja.
 * Ratkaisija-luokka ei käytä tämän luokan ilmentymää.
 * Ottaa koordinaatteja vastaan, ja suorittaa laattojen siirrot
 * pelilaudalla.
 * 
 * @author eamiller
 */
public class LaatanSiirtaja {
    private Lauta lauta;
    private Koordinaatit lahtoKoordinaatit=null;
    private Suunta suunta;
    private boolean siirto;

    public LaatanSiirtaja(Lauta l) {
        this.lauta = l;
        siirto = false;
    }
    
    /**
     * Ainoastaan näppäinkuuntelijalle. Ei toimi vielä enkä tiedä miksi.
     * Korjaan, jos jaksan. Jos luet tätä tekstiä, en jaksanut...
     * @param s 
     */
    public void lisaaSiirto(Suunta s){//näppäimille
        switch (s){
            case ALAS:
                lisaaLahto(new Koordinaatit(lauta.getNullSpace().x(),
                        lauta.getNullSpace().y()-1));
                break;
            case YLOS:
                lisaaLahto(new Koordinaatit(lauta.getNullSpace().x(),
                        lauta.getNullSpace().y()+1));
                break;
            case VASEN:
                lisaaLahto(new Koordinaatit(lauta.getNullSpace().x()+1,
                        lauta.getNullSpace().y()));
                break;
            case OIKEA:
                lisaaLahto(new Koordinaatit(lauta.getNullSpace().x()-1,
                        lauta.getNullSpace().y()));
                break;
        }
        suunta = s;
        siirto = true;
    }
    
    /**
     * Lisää tiedon siirrettävän laatan lähtökoordinaateista.
     * Kutsutaan hiirenkuuntelijalla.
     * @param lahto 
     */
    public void lisaaLahto(Koordinaatit lahto){
        if(lauta.getNullSpace().equals(lahto)){
            System.out.println("Et voi siirtää tyhjää tilaa"); 
        }
        this.lahtoKoordinaatit = lahto;
    }
    
    /**
     * Lisää tiedon tämänhetkisen siirron suunnasta. Tarkistaa, onko
     * kys. suunnassa tyhjä tila. Tämän jälkeen kaikki tarvittava tieto siirrosta
     * on saatu ja seuraavaksi voidaankin siirtää. (siirto-boolean trueksi)
     * @param kohde Koordinaatit, jonka avulla päätellään siirtosuunta
     */
    public void lisaaSuunta(Koordinaatit kohde){
        if(!lauta.getNullSpace().equals(kohde)){
            System.out.println("Kohdepaikka ei ole tyhjä tila");
            return;
        }
        
        if(kohde.x() == lahtoKoordinaatit.x()){ //kohde joko ylhäällä tai alhaalla
            if(kohde.y() < lahtoKoordinaatit.y()){//kohde ylhäällä
                suunta = Suunta.YLOS;
                siirto = true;
            }else if (kohde.y() > lahtoKoordinaatit.y()){
                suunta = Suunta.ALAS;
                siirto = true;
            }
        }else if(kohde.y() == lahtoKoordinaatit.y()){//kohde joko vasemmalla tai oikealla
            if(kohde.x() < lahtoKoordinaatit.x()){//kohde vasemmalla
                suunta = Suunta.VASEN;
                siirto = true;
            }else if(kohde.x() > lahtoKoordinaatit.x()){
                suunta = Suunta.OIKEA;
                siirto = true;
            }
        }
    }
    
    /**
     * Suorittaa halutun siirron ja alustaa kaikki tiedot tyhjiksi ja siirto-boolean
     * falseksi.
     */
    public void siirto(){
        lauta.siirra(lahtoKoordinaatit, suunta);
        initialize();
    }
    
    /**
     * Alustaa olion uudelleenkäytettävään tilaan.
     */
    private void initialize(){
        this.lahtoKoordinaatit = null;
        this.suunta = null;
        this.siirto = false;
    }

    public boolean isSiirto() {
        return siirto;
    }
    
    
    
    
    
    
}
