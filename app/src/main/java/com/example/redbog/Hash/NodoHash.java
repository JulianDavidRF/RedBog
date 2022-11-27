package com.example.redbog.Hash;

import java.io.Serializable;

public class NodoHash<T,V> implements Serializable {
    private T clave;
    private V valor;

    public NodoHash(T clave, V valor){
        this.clave = clave;
        this.valor = valor;


    }

    public T getClave() {
        return clave;
    }

    public void setClave(T clave) {
        this.clave = clave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

}
