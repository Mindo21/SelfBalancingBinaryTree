package main;

import binarytree.BinaryTree;
import binarytree.Node;
import userinput.Input;

public class Main {

    public static void main(String[] args){
        Node root = initializeBT();
        displayBT(root);
    }

    public static void displayBT(Node root){
        displayInOrderBT(root);
        System.out.println();
        displayPreOrderBT(root);
    }

    public static Node initializeBT(){
        Node root = null;
        Input in = new Input();
        int n = in.getInt();
        int[] values = in.getInts(n);
        in.close();
        for (int i = 0; i < n; i++) {
            root = BinaryTree.insert(root, values[i]);
        }

        return root;
    }

    public static void displayInOrderBT(Node root){
        if (root.left != null)
            displayInOrderBT(root.left);
        System.out.print(root.val + "\t");
        if (root.right != null)
            displayInOrderBT(root.right);

    }

    public static void displayPreOrderBT(Node root){
        System.out.print(root.val + "\t");
        if (root.left != null)
            displayPreOrderBT(root.left);
        if (root.right != null)
            displayPreOrderBT(root.right);
    }

}
