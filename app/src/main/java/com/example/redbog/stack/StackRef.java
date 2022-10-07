package com.example.redbog.stack;

public class StackRef<T> {
    private Node top;
    public StackRef(){
        top = null;
    }


    public void push(T item){
        Node newp = new Node(item);
        newp.setNext(top);
        top = newp;
    }



    public void showStack(){
        Node p= top;
        while(p!=null){
            System.out.println(p.getData());
            p = p.getNext();
        }
    }
    public boolean isEmpty(){
        return top == null;
    }


    public T pop(){
        //System.out.println(top.getData());
        Node<T> temp;
        if(top==null) throw new RuntimeException("Stack is empty");
        temp = top;
        top= top.getNext();
        return temp.getData();

    }
}
