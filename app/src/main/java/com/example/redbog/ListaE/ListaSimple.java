package com.example.redbog.ListaE;

public class ListaSimple<T> {

    private Nodo_ListaSimple head;
    public Nodo_ListaSimple tail;
    private int counter=0;
    public ListaSimple(){
        head = null;
        tail = null;
    }

    public void pushFront(T data){
        Nodo_ListaSimple miNodo = new Nodo_ListaSimple(data);
        miNodo.setNext(head);
        head = miNodo;
        if (tail == null){
            tail = head;
        }
        counter++;


    }

    public void popFront(){
        if(head==null) throw new RuntimeException("linked list is empty");
        head = head.getNext();
        if(head==null){
            tail=null;
        }
        counter--;
    }

    public void pushBack(T data){
        Nodo_ListaSimple miNodo = new Nodo_ListaSimple(data);
        miNodo.setNext(null);
        if(tail== null){
            head=tail=miNodo;
        }else{
            tail.setNext(miNodo);
            tail = miNodo;

        }
        counter++;


    }
    public int getSize(){
        /*int c= counter;
         Node p= head;
        while(p!=null){
            //System.out.println(p.getData());
            p = p.getNext();
            c++;
        }*/
        return counter;
    }
    //INCOMPLETO
    public void popBack(){
        if(head==null) throw new RuntimeException("nothing to pop");
        if(head==tail){
            head=tail=null; // se ponen a null porque solo hay un elemento y si se elimina pues mo debe quedar nada en la lista
        }
        Nodo_ListaSimple p = head;
        while(p.getNext().getNext() !=null){
            p = p.getNext();
        }
        p.setNext(null);
        tail = p;
        counter--;
    }
    public void addAfter(Nodo_ListaSimple nodo, T data){

        Nodo_ListaSimple miNodo = new Nodo_ListaSimple(data);
        miNodo.setNext(nodo.getNext());
        nodo.setNext(miNodo);
        if(tail==nodo){
            tail = miNodo;
        }
        counter++;

    }
    public Nodo_ListaSimple getAt(int indice, int size){
        if (indice < 0 || indice > size) {
            System.out.println("ERROR, No es posible realizar la búsqueda");
            return null;
        }
        Nodo_ListaSimple aux = head;

        for (int i = 0; i < indice; i++) {
            aux = aux.getNext();
        }

        return aux;

    }
    public void printLinkedList(){
        Nodo_ListaSimple p= head;
        while(p!=null){
            System.out.println(p.getData());
            p = p.getNext();
        }
    }
}
