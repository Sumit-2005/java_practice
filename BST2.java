import java.util.*;

public class BST2 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void inorderArrayList(Node root, ArrayList<Integer> ar){
        if(root == null){
            return;
        }

        inorderArrayList(root.left,ar);
        ar.add(root.data);
        inorderArrayList(root.right, ar);
    }

    public static ArrayList<Integer> mergeArrayList(ArrayList<Integer> ar1, ArrayList<Integer> ar2){
        ArrayList<Integer> merge = new ArrayList<>();
        merge.addAll(ar1);
        merge.addAll(ar2);
        Collections.sort(merge);
        return merge;
    }
    
    public static Node mergeBST(Node root1, Node root2){
        ArrayList<Integer> ar1 = new ArrayList<>();
        ArrayList<Integer> ar2 = new ArrayList<>();

        inorderArrayList(root1, ar1);
        inorderArrayList(root2, ar2);
        
        ArrayList<Integer> merge = mergeArrayList(ar1, ar2);
        for(int i=0; i<merge.size(); i++){
            System.out.print(merge.get(i)+ " ");
        }
        int[] nodeArray = new int[merge.size()];
        for (int i = 0; i < merge.size(); i++) {
            nodeArray[i] = merge.get(i);
        }
        Node root = createBST(nodeArray, 0, nodeArray.length-1);
        return root;
    }

    public static Node createBST(int arr[], int left, int right){
        if(left > right){
            return null;
        }

        int mid = (left + right)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, left, mid-1);
        root.right = createBST(arr, mid+1, right);
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String args[]) {

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);
        
        Node root = mergeBST(root1, root2);
        preorder(root);
    }
}
