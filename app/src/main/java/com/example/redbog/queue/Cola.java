package com.example.redbog.queue;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ADMIN
 */
public class Cola <T>{

    private Node cola = new Node();
    private Node cabeza = new Node();
    private int c = -1;

    public Cola() {
        this.cola = null;
        this.cabeza=null;
    }

    public void enqueue(T item) {
        if (empty()) {
            Node newP = new Node(item);
            cola = newP;
            cabeza = newP;
            c++;
        } else {
            Node newP = new Node(item);
            cola.setNext(newP);
            newP.setBack(cola);
            cola=newP;
            c++;
        }

    }

    public T dequeue() {

        T data = (T)cabeza.getData();
        cabeza= cabeza.getNext();
        c--;
        return data;
    }

    public boolean empty() {
        if (c < 0) {
            return true;
        } else {
            return false;
        }
    }
    public String Print() {
        String salida = "[";
        Node h = cabeza;

        while (h.getNext() != null) {
            salida = salida + h.getData() + ",";
            h = h.getNext();
        }

        salida = salida + h.getData();

        return salida + "]";

    }

}