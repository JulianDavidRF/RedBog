package com.example.redbog.AVL;

import com.example.redbog.ListaE.ListaSimple;
import com.example.redbog.clases.Reporte;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<T> {
    public Node<Reporte> root;
    public String stringNum = "";

    // A utility function to get height of the tree
    public int height(Node<Reporte> N)
    {
        if (N == null)
            return 0;
        return N.height;
    }

    // A utility function to get maximum of two Reportes
    public int max(int a, int b)
    {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    public Node<Reporte> rightRotate(Node<Reporte> y)
    {
        Node<Reporte> x = y.left;
        Node<Reporte> T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    public Node<Reporte> leftRotate(Node<Reporte> x)
    {
        Node<Reporte> y = x.right;
        Node<Reporte> T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    public int getBalance(Node<Reporte> N)
    {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    public Node<Reporte> insert(Node<Reporte> node, int key, List<Reporte> reportes)
    {
        /* 1. Perform the normal BST rotation */
        if (node == null)
            return (new Node<Reporte>(key,reportes));

        if (key < node.key)
            node.left = insert(node.left, key,reportes);
        else if (key > node.key)
            node.right = insert(node.right, key,reportes);
        else // Equal keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                height(node.right));

        /* 3. Get the balance factor of this ancestor
        node to check whether this node became
        Wunbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then
        // there are 4 cases Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key)
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    /* Given a non-empty binary search tree, return the
    node with minimum key value found in that tree.
    Note that the entire tree does not need to be
    searched. */
    public Node<Reporte> minValueNode(Node<Reporte> node)
    {
        Node<Reporte> current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }

    public Node<Reporte> deleteNode(Node<Reporte> root, int key)
    {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.key)
            root.left = deleteNode(root.left, key);

            // If the key to be deleted is greater than the
            // root's key, then it lies in right subtree
        else if (key > root.key)
            root.right = deleteNode(root.right, key);

            // if key is same as root's key, then this is the node
            // to be deleted
        else
        {

            // node with only one child or no child
            if ((root.left == null) || (root.right == null))
            {
                Node<Reporte> temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else // One child case
                    root = temp; // Copy the contents of
                // the non-empty child
            }
            else
            {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node<Reporte> temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // A utility function to print preorder traversal of
    // the tree. The function also prints height of every
    // node
    public void preOrder(Node<Reporte> node)
    {
        if (node != null)
        {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }



    public void inOrder(Node<Reporte> node){
        if (node != null)
        {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }

    }



    public String preOrderFind(Node<Reporte> node,int key)
    {
        if(node !=  null) {


            if( String.valueOf(node.key).contains(String.valueOf(key))){

                //System.out.println(node.key + " "+" ->");
                stringNum = stringNum + node.key + " ";
                preOrderFind(node.left,key);
                preOrderFind(node.right,key);


            }
        }

        //System.out.println("  sali de imprimir  ");
        return stringNum;
    }
    public Node<Reporte> find(int key) {
        Node<Reporte> current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }
    public Node<Reporte> findList(int key) {
        Node<Reporte> current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

}
