package com.example.redbog.AVL;

public class Nodo_ListaSimple<T> {
    private T data;
    private Nodo_ListaSimple next;
    private Nodo_ListaSimple back;

    public  Nodo_ListaSimple() {
        this.data = null;
    }

    public  Nodo_ListaSimple(T data) {
        this.data = data;
        next = null;
        back = null;
    }


    public Nodo_ListaSimple getNext() {
        return next;
    }

    public void setNext(Nodo_ListaSimple n) {
        this.next = n;
    }

    public Nodo_ListaSimple getBack() {
        return back;
    }

    public void setBack(Nodo_ListaSimple back) {
        this.back = back;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
