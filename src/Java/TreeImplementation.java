package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javax.swing.tree.TreeNode;

public class TreeImplementation {


    public TreeNode root;

    private static TreeNode center;


    public TreeImplementation(){

        root = null;
//        root.left = null;
//        root.right = null;
    }

    public class TreeNode{

        int value;
        TreeNode right;
        TreeNode left;

        public TreeNode(int data){
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode addRecursive(TreeNode root, int data) {

        if(root == null){
            root = new TreeNode(data);

        }

        if(root.value > data){
            root.left = addRecursive(root.left, data);
        }else if (root.value < data){
            root.right = addRecursive(root.right, data);
        }
        return root;
    }



    public void add(int data){

        root = addRecursive( root, data );

    }

    public boolean isEmpty(){
        return root == null;
    }

    public int getSize(){
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(TreeNode root) {

        return root == null ? 0 :   getSizeRecursive(root.left) + 1 + getSizeRecursive(root.right);
    }

    private boolean containsKey(int data){
       return TreeContainsKey(root, data);
    }

    private boolean TreeContainsKey(TreeNode root, int data) {

        if(root.value == data){
            return true;
        }

        if(root == null ){
            return false;
        }


//        if(root.value < data){
//            root.right = TreeContainsKey(root.right, data);
//        }else{
//            root.right = TreeContainsKey(root.right, data);
//        }

        return  root.value < data ? TreeContainsKey(root.right, data) : TreeContainsKey(root.left, data);
    }

    public void delete(int key){
        root = deleteRecursive(root, key);
    }

    private TreeNode deleteRecursive(TreeNode root, int key) {

        if(root == null){
            return null;
        }

        /* case 1 where no left right child only root */
        if(root.left == null && root.right == null){
            return null;
        }

        /* case 2 where Either one left right child only to root */
        if(root.right == null){
            return  root.left;
        }

        if(root.left == null){
            return root.right;
        }

        return null;

        /* Now case 3 where both left and right child are there */


   /*     int smallestValue = findSmallestValue(current.right);
        current.value = smallestValue;
        current.right = deleteRecursive(current.right, smallestValue);
        return current;
    }
        if (value < current.value) {
        current.left = deleteRecursive(current.left, value);
        return current;
    }

    current.right = deleteRecursive(current.right, value);
        return current;
}

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }*/

    }

    private void callOrders() {

        System.out.println("~~~~~~~~~~~ traverseInorder");
        traverseInorder(root);

        System.out.println("");
        System.out.println("______!!!_____traversePreorder");
        traversePreorder(root);

        System.out.println("");
        System.out.println("______!!!traversePostorder");
        traversePostorder(root);
    }

    public void traverseInorder( TreeNode current  ){



        if(current!=null){
            traverseInorder(current.left);
            System.out.print(" " +current.value);
            traverseInorder(current.right);
        }

    }


    public void traversePreorder( TreeNode current ){

        if(current!=null){
            System.out.print(" " +current.value);
            traversePreorder(current.left);
            traversePreorder(current.right);
        }

    }

    public void traversePostorder( TreeNode current ){

        if(current!=null){
            traversePostorder(current.left);
            traversePostorder(current.right);
            System.out.print(" " +current.value);
        }

    }


    public void levelOrderTraversing(){

        if(root==null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            TreeNode val = queue.remove();
            System.out.print( " " + val.value);

            if(val.left!=null){
                queue.add(val.left);
            }

            if(val.right!=null){
                queue.add(val.right);
            }
        }
        System.out.println("");
    }


    public void InorderTraversalWithoutRecurssion(){

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        stack.push(current);

        while(!stack.isEmpty()){

            while (current.left!=null){
                current = current.left;
                stack.push(current);
            }

            current = stack.pop();
            System.out.print(" " + current.value);

            while (current.right!=null){
                current = current.right;
                stack.push(current);
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {


        TreeImplementation treeImplementation  = new TreeImplementation();




        treeImplementation.add(10);
        treeImplementation.add(20);
        treeImplementation.add(30);
        treeImplementation.add(40);
        treeImplementation.add(50);
        treeImplementation.add(60);
        treeImplementation.add(70);
        treeImplementation.add(80);
        treeImplementation.add(90);
        treeImplementation.add(100);
        treeImplementation.add(120);
        treeImplementation.add(130);
        treeImplementation.add(140);
        treeImplementation.add(150);
        treeImplementation.add(160);
        treeImplementation.add(170);

        System.out.println("");
//        treeImplementation.levelOrderTraversing();

//        System.out.println("");
//        treeImplementation.InorderTraversalWithoutRecurssion();
//
//        System.out.println("");
//
//
//        System.out.println("");
//        treeImplementation.traverseInorder(center);
//
//        treeImplementation.traversePostorder(center);
//                System.out.println("");
        treeImplementation.callOrders();
    }
}
