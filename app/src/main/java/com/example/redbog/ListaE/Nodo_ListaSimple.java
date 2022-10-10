package com.example.redbog.ListaE;

public class Nodo_ListaSimple<T> {
    private T data;
    private Nodo_ListaSimple next;

    public Nodo_ListaSimple(T data){
        this.data = data;
    }
    public void setData(T data){
        this.data = data;
    }
    public void setNext(Nodo_ListaSimple next){
        this.next = next;
    }

    public Nodo_ListaSimple getNext(){
        return this.next;
    }
    public T getData(){
        return this.data;
    }

}
