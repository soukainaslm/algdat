package no.oslomet.cs.algdat;


////////////////// class DobbeltLenketListe //////////////////////////////


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;



public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        throw new NotImplementedException();
    }

    public DobbeltLenketListe(T[] a) {
        throw new NotImplementedException();
    }

    public Liste<T> subliste(int fra, int til) {
        throw new NotImplementedException();
    }

    @Override
    public int antall() {
        throw new NotImplementedException();
    }
 
    @Override
    public boolean tom() {
        throw new NotImplementedException();
    }

    @Override
    public boolean leggInn(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "Ugyldig verdi!");
        //Negative indekser og indekser større enn null er ulovlige
        if (indeks < 0) throw new IndexOutOfBoundsException("Indeksen er ugyldig");
        else if (indeks > antall)
            throw new IndexOutOfBoundsException("Indeksen er høyere enn antall noder!");

        //listen er tom
        if (antall == 0) hode = hale = new Node<T>(verdi, null, null);

        //verdien skal legges først
        else if (indeks == 0) {
            hode = new Node<T>(verdi, null, hode);
            hode.neste.forrige = hode;

            //verdien skal legges bakerst
        } else if (indeks == antall-1) {
            hale = new Node<T>(verdi, hale, null);
            hale.forrige.neste = hale;
        }
        //legges i midten
        else {
            Node<T> denne = hode;
            for (int i = 0; i <= indeks; i++) {
                denne = denne.neste;
            }
            Node<T> nyNode = new Node<>(verdi, denne, denne.neste);
            denne.neste = nyNode;
            nyNode.neste = denne.neste;
            nyNode.forrige = denne;
            nyNode.neste.forrige = nyNode;
        }

        antall++;

        throw new NotImplementedException();
    }


    @Override
    public boolean inneholder(T verdi) {
        if (indeksTil(verdi) > -1) return true;
        else if (indeksTil(verdi) < 0)
            return false;
        throw new NotImplementedException();
    }

    @Override
    public T hent(int indeks) {
        throw new NotImplementedException();
    }

    @Override
    public int indeksTil(T verdi) {
        int index = 0;
        for (Node<T> temp = hale; temp.forrige != null; temp = temp.forrige) {
            if (temp.verdi == verdi) {
                return index;
            }
            else if (temp == hode && temp.verdi != verdi) return -1;
            index++;

        }
        throw new NotImplementedException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new NotImplementedException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T fjern(int indeks) {
        throw new NotImplementedException();
    }

    @Override
    public void nullstill() {
        //1.måten
        for (Node<T> temp = hode; temp.neste != null; temp = temp.neste){
            temp.verdi = null;
            temp.forrige = null;
            temp.neste = null;
            endringer++;
        }
        hode = hale = null;
        antall = 0;

        //2.måten
        int index = 0;
        for (Node<T> temp = hode; temp.neste != null; temp = temp.neste) {
            fjern(index);
            index ++;
        }
        throw new NotImplementedException();
    }


    @Override
    public String toString() {
        throw new NotImplementedException();
    }

    public String omvendtString() {
        throw new NotImplementedException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new NotImplementedException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new NotImplementedException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator(){
            throw new NotImplementedException();
        }

        private DobbeltLenketListeIterator(int indeks){
            throw new NotImplementedException();
        }

        @Override
        public boolean hasNext(){
            throw new NotImplementedException();
        }

        @Override
        public T next(){
            throw new NotImplementedException();
        }

        @Override
        public void remove(){
            throw new NotImplementedException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new NotImplementedException();
    }

} // class DobbeltLenketListe


