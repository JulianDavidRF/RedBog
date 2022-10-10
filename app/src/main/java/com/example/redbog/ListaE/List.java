package com.example.redbog.ListaE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.example.redbog.queue.Node;

/**
 *
 * @author ADMIN
 */
public class List<T>{

    private Node back = new Node();
    private Node front = new Node();
    private int c = -1;

    public List() {
        this.back = null;
        this.front = null;
    }

    public void add(T item) {
        if (empty()) {
            Node newP = new Node(item);
            front = newP;
            back = newP;
            c++;
        } else {
            Node newP = new Node(item);
            Node l = back;
            back = newP;
            l.setNext(back);
            back.setBack(back);
            c++;
        }
    }

    public boolean empty() {
        if (c < 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(T item) {
        if (empty()) {
            return false;
        } else {
            int s = 0;
            Node h = front;
            do {
                if (h.getData().equals(item)) {
                    s = 1;
                } else {
                    h = h.getNext();
                }
            } while (s != 1 && h != null);
            if (s == 0) {
                return false;
            } else {
                return true;
            }
        }

    }

    public T index(int item) {
        if (item == 0) {
            Node l=front;
            return (T)l.getData();
        } else {
            Node l = front;
            for (int i = 0; i < item; i++) {
                l = l.getNext();
            }
            return (T)l.getData();
        }
    }
    public int indexOf(T item) {
        if (empty()) {
            return -1;
        } else {
            Node l = front;
            int index =-1;
            for (int i = 0; i <=c+1; i++) {
                if(l.getData().equals(item)){
                    index =i;
                    break;
                }else{
                    l = l.getNext();
                }
            }
            return index;
        }
    }
    public String print(){
        String salida="[";
        Node h=front;
        while(h.getNext()!=null){
            salida=salida+h.getData();
            h=h.getNext();
        }

        salida=salida+h.getData();

        return salida+"]";
    }
    public void swap(int item, int ite){
        Node ini=front;
        Node fin=front;
        if (item == 0) {
            ini = front;
        } else {
            for (int i = 0; i < item; i++) {
                ini = ini.getNext();
            }
        }
        if (ite == 0) {
            fin = front;
        } else {
            for (int i = 0; i < ite; i++) {
                fin = fin.getNext();
            }
        }
        T dat=(T)ini.getData();
        ini.setData(fin.getData());
        fin.setData(dat);
    }
    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

}
