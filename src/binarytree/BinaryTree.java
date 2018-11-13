package binarytree;

public class BinaryTree {

       /* Class node is defined as :
    class Node
       int val;   //Value
       int ht;       //Height
       Node left; //Left child
       Node right;    //Right child

   */

    public static Node insert(Node root, int val)
    {
        int balanceFactor = 0;
        int height = 0;
        Node temp = root;
        Node parentTemp = root;
        Node parentParent = root;
        boolean inserted = false;

        // System.out.println("Insert called");

        while (!inserted) {

            if (temp == null){
                root = newNode(val);
                inserted = true;
            }

            else if (val >= temp.val) {
                if (temp.right == null) {
                    temp.right = newNode(val);
                    inserted = true;
                    height = setHeights(root);
                } else {
                    parentParent = parentTemp;
                    parentTemp = temp;
                    temp = temp.right;
                }
            }

            else {
                if (temp.left == null) {
                    temp.left = newNode(val);
                    inserted = true;
                    height = setHeights(root);
                } else {
                    parentParent = parentTemp;
                    parentTemp = temp;
                    temp = temp.left;
                }
            }

        }

        root = iterate(root);
        setHeights(root);
        return root;
    }

    static Node iterate(Node root){

        if (root.left != null){
            root.left = iterate(root.left);
        }

        if (root.right != null){
            root.right = iterate(root.right);
        }

        setHeights(root);

        if (checkBF(root) > 1) {
            if (checkBF(root.left) >= 0){
                root = rotationLL(root, root.left);
            } else {
                root = rotationLR(root, root.left);
            }
        }

        else if (checkBF(root) < -1){
            if (checkBF(root.right) <= 0){
                root = rotationRR(root, root.right);
            } else {
                root = rotationRL(root, root.right);
            }
        }

        return root;
    }

    static Node rotationRR(Node leftNode, Node midNode){
        // System.out.println("RR:\n");
        // System.out.println("Middle: " + midNode.val);
        // System.out.println("Left: " + leftNode.val);
        Node temp = midNode.left;
        midNode.left = leftNode;
        leftNode.right = temp;
        return midNode;
    }

    static Node rotationLL(Node rightNode, Node midNode){
        // System.out.println("LL:\n");
        // System.out.println("Middle: " + midNode.val);
        // System.out.println("Right: " + rightNode.val);
        Node temp = midNode.right;
        midNode.right = rightNode;
        rightNode.left = temp;
        return midNode;
    }

    static Node rotationRL(Node x, Node z){
        Node y = z.left;

        // System.out.println("RL:\n");
        // System.out.println("Parent: " + x.val);
        // System.out.println("Right: " + z.val);
        // System.out.println("Left: " + y.val);

        z.left = y.right;
        x.right = y;
        y.right = z;

        x.right = y.left;
        y.left = x;

        return y;
    }

    static Node rotationLR(Node z, Node x){
        Node y = x.right;

        // System.out.println("LR:\n");
        // System.out.println("Parent: " + z.val);
        // System.out.println("Right: " + y.val);
        // System.out.println("Left: " + x.val);

        x.right = y.left;
        z.left = y;
        y.left = x;

        z.left = y.right;
        y.right = z;

        return y;
    }

    static int checkBF(Node root){
        if (root == null) return 0;
        if (root.left != null && root.right != null) {
            return root.left.ht - root.right.ht;
        }
        else if (root.left != null) {
            return (root.left.ht + 1);
        }
        else if (root.right != null) {
            return -(root.right.ht + 1);
        }
        else return 0;
    }

    static void printBF(Node root){

        if (root.left != null && root.right != null) {
            printBF(root.left);
            System.out.println(root.val + ": " + (checkBF(root)));
            printBF(root.right);
        }

        else if (root.left != null) {
            printBF(root.left);
            System.out.println(root.val + ": " + checkBF(root));
        }

        else if (root.right != null) {
            System.out.println(root.val + ": " + (checkBF(root)));
            printBF(root.right);
        }

        else System.out.println(root.val + ": " + checkBF(root));

    }

    static int setHeights(Node root){
        if (root.right != null && root.left != null) {
            root.ht = 1 + Math.max(setHeights(root.right), setHeights(root.left));
        }
        else if (root.right != null) {
            root.ht = 1 + setHeights(root.right);
        }
        else if (root.left != null) {
            root.ht = 1 + setHeights(root.left);
        }
        else {
            root.ht = 0;
        }
        return root.ht;
    }

    static Node newNode(int val){
        return new Node(val, 0, null, null);
    }

}
