/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package genericos;

import Uncode.lineales.Pila;
import sun.net.www.content.text.Generic;

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class Arbol <T extends Comparable<T>> {
    
    private int contador;
    private Node1 root;
    
    
    public Arbol (){
        this.contador=0;
        this.root=null;
    }
    
    public boolean empty(){
        if (contador!=0){
            return false;
        }
        else{
            return true;
        }
    }
    
    public void preOrder(Node1 head) {
        System.out.print(head.getData()+" ");
        if (head.getLeft() != null) {
            preOrder(head.getLeft());
        }
        if (head.getRight()!= null) {
            preOrder(head.getRight());
        }

    }
    
    public void postOrder(Node1 head){
        if (head.getLeft() != null) {
            postOrder(head.getLeft());
        }
        if (head.getRight()!= null) {
            postOrder(head.getRight());
        }
        System.out.print(head.getData()+" ");
    }
    
    public void insertar(T data){
        Node1 newNode1= new Node1(data);
        Node1 padre=root;
        if (empty()){
            root=newNode1;
            contador++;
        } else {
            while (padre != null) {
            int comp=data.compareTo((T)padre.getData());
                if (comp==1 || comp==0) {
                    if (padre.getRight() == null) {
                        padre.setRight(newNode1);
                        newNode1.setRoot(padre);
                        padre = null;
                        contador++;
                    } else {
                        padre=padre.getRight();
                    }
                }else {
                    if (padre.getLeft() == null) {
                        padre.setLeft(newNode1);
                        newNode1.setRoot(padre);
                        padre = null;
                        contador++;
                    } else {
                        padre=padre.getLeft();
                    }
                }
            }
        }
     }
    
    public int heightA(){
        if (contador==0){
            return 0;
        }else{
            Node1 root = this.root;
            if (root.getLeft() != null || root.getRight() != null) {
                if (root.getRight() != null) {
                    if (root.getLeft() != null) {
                        return 1 + Integer.max(height(root.getRight()), height(root.getLeft()));
                    } else {
                        return 1 + height(root.getRight());
                    }
                } else {
                    return 1 + height(root.getLeft());
                }
            } else {
                return 1;
            }
        }
    }
    
    public int height(Node1 root){
      if (root==null){
          return 0;
      }else{
            if (root.getLeft() != null || root.getRight() != null) {
                if (root.getRight() != null) {
                    if (root.getLeft() != null) {
                        return 1 + Integer.max(height(root.getRight()), height(root.getLeft()));
                    } else {
                        return 1 + height(root.getRight());
                    }
                } else {
                    return 1 + height(root.getLeft());
                }
            } else {
                return 1;
            }
        }
    }
    
    public Node1 buscar(T data) {
        Node1 padre = root;
        if (empty()) {
            return null;
        } else {
            if (padre.getData().equals(data)) {
                return padre;
            } else {
                boolean enc = true;
                while (enc) {
                    int comp = data.compareTo((T) padre.getData());
                    if (comp == 1 || comp == 0) {
                        if (padre.getRight() != null) {
                            if (padre.getRight().getData().equals(data)) {
                                padre=padre.getRight();
                                enc=false;
                            } else {
                                padre = padre.getRight();
                            }
                        } else {
                            padre=null;
                            enc=false;
                        }
                    } else {
                        if (padre.getLeft()!= null) {
                            if (padre.getLeft().getData().equals(data)) {
                                padre= padre.getLeft();
                                enc=false;
                            } else {
                                padre = padre.getLeft();
                            }
                        } else {
                            enc=false;
                            padre= null;
                        }
                    }
                }
                return padre;
            }
        }
    }
    
    public boolean contiene(T data){
        boolean salida=false;
        Node1 padre = root;
        if (empty()) {
            return false;
        } else {
            if (padre.getData().equals(data)) {
                return true;
            } else {
                boolean enc = true;
                while (enc) {
                    int comp = data.compareTo((T) padre.getData());
                    if (comp == 1 || comp == 0) {
                        if (padre.getRight() != null) {
                            if (padre.getRight().getData().equals(data)) {
                                salida=true;
                                enc=false;
                            } else {
                                padre = padre.getRight();
                            }
                        } else {
                            salida=false;
                            enc=false;
                        }
                    } else {
                        if (padre.getLeft()!= null) {
                            if (padre.getLeft().getData().equals(data)) {
                                salida=true;
                                enc=false;
                            } else {
                                padre = padre.getLeft();
                            }
                        } else {
                            enc=false;
                            salida=false;
                        }
                    }
                }
                return salida;
            }
        }
    }
    
    public Node1 getRoot() {
        return root;
    }
    
    public Node1 ancestro(Node1 num){
        T data=(T)num.getData();
        int comp= data.compareTo((T)num.getRoot().getData());
        if (comp==-1){
            return num.getRoot();
        }else{
            return ancestro(num.getRoot());
        }
    }
    
    public Node1 decendiente(Node1 Num){
        if (Num.getLeft()==null){
            return Num;
        }else{
            return decendiente(Num.getLeft());
        }
    }
    
    public Node1 next(Node1 N){
        if (N.getRight()!=null){
            return decendiente(N.getRight());
        }else{
            return ancestro(N);
        }
    }
    
    public Node1 Maximo(){
     Node1 l=root;
     while (l.getRight()!= null){
         l=l.getRight();
    }
     return l;
    }        
    
 
 
}

