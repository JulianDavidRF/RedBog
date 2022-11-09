package com.example.redbog.AVL;
import java.util.ArrayList;
import java.util.List;


public class Node<T>{



    int height;
    public int key;
    public List<T> reportes;



    Node<T> left, right;

    Node(int d, List<T> reportes)
    {
        this.key = d;
        this.reportes = reportes;
        this.height = 1;
    }

}
