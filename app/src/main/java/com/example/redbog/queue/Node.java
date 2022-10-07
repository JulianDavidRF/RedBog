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
public class Node <T>{

    private T data;
    private Node next;
    private Node back;

    public Node() {
        this.data = null;
    }

    public Node(T data) {
        this.data = data;
        next = null;
        back = null;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node n) {
        this.next = n;
    }

    public Node getBack() {
        return back;
    }

    public void setBack(Node back) {
        this.back = back;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}

