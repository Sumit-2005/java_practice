import java.util.*;

public class binaryTreeB {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int  idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorderTraversal(Node root){
            if(root == null){
                System.out.print(-1+" ");
                return;
            }
            System.out.print(root.data+" ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        public static void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+ " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelOrder(Node root){
            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!= null){
                        q.add(currNode.right);
                    }
                }   
            }
        }
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh)+1;
    }

    public static int count(Node root){
        if(root == null){
            return 0;
        }

        int lCount = count(root.left);
        int rCount = count(root.right);
        return lCount + rCount + 1;
    }

    public static int sum(Node root){
        if(root == null){
            return 0;
        }

        int lSum = sum(root.left);
        int rSum = sum(root.right);
        return lSum + rSum + root.data;
    }

    public static int diameter(Node root){
        if(root == null){
            return 0;
        }

        int leftDiam = diameter(root.left);
        int rightDiam = diameter(root.right);
        int leftH = height(root.left);
        int rightH = height(root.right);

        int selfDiam = leftH + rightH + 1;
        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }

    static class Info{
        int diam;
        int ht;

        public Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diam(Node root){
        if(root == null){
            return new Info(0,0);
        }

        Info leftInfo = diam(root.left);
        Info rightInfo = diam(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht , rightInfo.ht) + 1;
        return new Info(diam, ht);
    }

    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = BinaryTree.buildTree(nodes);
        // System.out.println(root.data);

        System.out.println(diam(root).diam);
    }
}