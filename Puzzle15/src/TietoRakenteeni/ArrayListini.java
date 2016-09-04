/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TietoRakenteeni;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author eamiller
 */
public class ArrayListini<T extends Object> implements List<T> {
    private T[] taulukko;
    private int tilavuus = 16;
    private int koko = 0;

    public ArrayListini() {
        this.taulukko = (T[]) new Object[tilavuus];
    }
    
    @Override
    public int size() {
        return koko;
    }

    @Override
    public boolean isEmpty() {
        return koko == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int indx = 0; indx < koko; indx++) {
            if (taulukko[indx].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private int cur = 0;

            @Override
            public boolean hasNext() {
                return cur < koko;
            }

            @Override
            public T next() {
                return taulukko[cur++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    @Override
    public Object[] toArray() {
        return this.taulukko;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(T e) {
        varmistaTilavuus();
        taulukko[koko] = e;
        koko++;
        return true;
    }
    
    private void varmistaTilavuus(){
        if(koko == tilavuus){
            tilavuus*=2;
            T[] uusiTaulukko = (T[]) new Object[tilavuus];
            int indeksi = 0;
            for(T o : taulukko){
                uusiTaulukko[indeksi] = o;
                indeksi++;
            }
            taulukko = uusiTaulukko;
        }
    }

    @Override
    public boolean remove(Object o) {
    for (int i = 0; i < koko; i++) {
            if (taulukko[i].equals(o)) {
                for (int j = i; j < koko - 1; j++) {
                    taulukko[j] = taulukko[j + 1];
                }
                koko--;
                taulukko[koko] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remove(int index) {
        T poistettu = taulukko[index];
        
        for (int i = index; i < koko - 1; i++) {
            taulukko[i] = taulukko[i + 1];
        }

        koko--;
        taulukko[koko] = null;

        return poistettu;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
