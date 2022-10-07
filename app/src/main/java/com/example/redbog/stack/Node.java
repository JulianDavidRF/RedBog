package com.example.redbog.stack;

public class Node<T> {

    private T data;
    Node next = null;



    public Node(T data){

        this.data = data;
    }


    public T getData(){
        return this.data;

    }
    public void setNext(Node next){

        this.next = next;
    }

    public Node getNext(){
        return this.next;
    }
}
