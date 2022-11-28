/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package genericos;

/**
 *
 * @author ADMIN
 */
public class Node1<T> {
    private T data;
    private int height;
    private Node1 right;
    private Node1 left;
    private Node1 root;

    public Node1() {
        this.data = null;
    }

    public Node1(T data) {
        this.data = data;
        this.right = null;
        this.left = null;
        this.root = null;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node1 getRight() {
        return right;
    }

    public void setRight(Node1 right) {
        this.right = right;
    }

    public Node1 getLeft() {
        return left;
    }

    public void setLeft(Node1 left) {
        this.left = left;
    }

    public Node1 getRoot() {
        return root;
    }

    public void setRoot(Node1 root) {
        this.root = root;
    }
    
}
