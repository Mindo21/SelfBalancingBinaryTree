package binarytree;

public class Node {

    public int val;    //Value
    public int ht;    //Height
    public Node left;  //Left child
    public Node right; //Right child

    public Node(int val, int ht, Node left, Node right){
        this.val = val;
        this.ht = ht;
        this.left = left;
        this.right = right;
    }

}
