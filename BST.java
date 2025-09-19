import java.util.*;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
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
    
    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }

        if(root.data > key){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val){
        if(root.data < val){
            delete(root.right, val);
        }else if(root.data > val){
            delete(root.left, val);
        }

        if(root.data == val){
            ///No Child
            if(root.left == null && root.right == null){
                return null;
            }

            //1 Child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            //2 Children
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(k1 <= root.data && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }else if(root.data < k1){
            printInRange(root.right, k1, k2);
        }else{
            printInRange(root.left, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public static void root2Leaf(Node root, ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right==null){
            printPath(path);
        }

        root2Leaf(root.left, path);
        root2Leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }
        else if(max != null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node mirrorBST(Node root){
        if(root ==null){
            return null;
        }

        Node leftS = mirrorBST(root.left);
        Node rightS = mirrorBST(root.right);
        
        root.left = rightS;
        root.right = leftS;
        return root;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node createBST(int arr[], int st, int end){
        if(st>end){
            return null;
        }

        int mid = (st + end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }

    public static void inorderArray(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }

        inorderArray(root.left, inorder);
        inorder.add(root.data);
        inorderArray(root.right, inorder);
    }
    
    public static Node createNewBST(ArrayList<Integer> inorder, int st, int end){
        if(st>end){
            return null;
        }

        int mid = (st+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createNewBST(inorder, st, mid-1);
        root.right = createNewBST(inorder, mid+1, end);
        return root;
    }
    
    public static Node balanceBST(Node root){
        // Sorted Inorder Sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderArray(root, inorder);

        //Balance BST
        root = createNewBST(inorder, 0, inorder.size()-1);
        return root;
    }
    
    public static void main(String args[]){
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = balanceBST(root);
        preOrder(root);
    }
}