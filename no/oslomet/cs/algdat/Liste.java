package no.oslomet.cs.algdat;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.Iterator;

public interface Liste<T> extends no.oslomet.cs.algdat.Beholder<T> {
    public boolean leggInn(T verdi);           // Nytt element bakerst

    public void leggInn(int indeks, T verdi);  // Nytt element på plass indeks

    public boolean inneholder(T verdi);        // Er verdi i listen?

    public T hent(int indeks);                 // Hent element på plass indeks

    public int indeksTil(T verdi);             // Hvor ligger verdi?

    public T oppdater(int indeks, T verdi);    // Oppdater på plass indeks

    public boolean fjern(T verdi);             // Fjern objektet verdi

    public T fjern(int indeks);                // Fjern elementet på plass indeks

    public int antall();                       // Antallet i listen

    public boolean tom();                      // Er listen tom?

    public void nullstill();                   // Listen nullstilles (og tømmes)

    public Iterator<T> iterator();             // En iterator

    public default String melding(int indeks)  // Unntaksmelding
    {
        return "Indeks: " + indeks + ", Antall: " + antall();
    }

    public default void indeksKontroll(int indeks, boolean leggInn) {
        if (indeks < 0 ? true : (leggInn ? indeks > antall() : indeks >= antall())) {
            throw new IndexOutOfBoundsException(melding(indeks));
        }
    }

    class DobbeltLenketListe<T> implements Liste<T> {

        /**
         * Node class
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

        public Liste<T> subliste(int fra, int til){
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
            throw new NotImplementedException();
        }

        @Override
        public boolean inneholder(T verdi) {
            throw new NotImplementedException();
        }

        @Override
        public T hent(int indeks) {
            throw new NotImplementedException();
        }

        @Override
        public int indeksTil(T verdi) {
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
}  // Liste