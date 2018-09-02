package com.first.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    public static Node root = null;
    public static int sum = 0;

    public Node createNode(int data) {
        Node node = new Node(data, null, null);
        return node;
    }

    public void insert(int data) {
        root = insertUtil(root, data);
    }

    public Node insertUtil(Node node, int data) {
        if (node == null) {
            node = createNode(data);
            return node;
        }
        if (node.data > data) {
            node.left = insertUtil(node.left, data);
        }
        else if (node.data <= data) {
            node.right = insertUtil(node.right, data);
        }
        return node;
    }

    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }

    public void inorderWithoutRec(Node node) {
        // if Left is not null keep on insert into stack.
        // if left is null than pop the node and process it and each pop node treated as root of sub tree
        if (node == null) {
            return;
        }
        Node cur = node;
        Stack<Node> st = new Stack<Node>();
        boolean flag = false;
        while (!flag) {

            if (cur != null) {
                st.push(cur);
                cur = cur.left;

            }
            else {
                cur = st.pop();
                System.out.println(cur.data);
                cur = cur.right;

            }
            if (st.isEmpty() && cur == null) {
                flag = true;
            }
        }
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        inorder(node.left);
        inorder(node.right);
    }

    public int min(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public int max(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    public void levelPrint(Node node, int curLevel, int lev) {
        if (node == null) {

            return;
        }
        if (curLevel == lev) {
            System.out.print(node.data + "  ");
        }
        levelPrint(node.left, curLevel + 1, lev);
        levelPrint(node.right, curLevel + 1, lev);
    }

    public int heghtOfTree(Node node) {
        if (node == null) {
            return 0;
        }
        int l = heghtOfTree(node.left);
        int r = heghtOfTree(node.right);
        return max(l, r) + 1;
    }

    public int max(int a, int b) {
        if (a > b) {
            return a;
        }
        else {
            return b;
        }
    }

    public void printLevelWise(Node node, int height) {
        for (int i = 0; i < height; i++) {
            this.levelPrint(root, 0, i);
        }
    }

    public boolean isValidBST(Node node) {
        if (node == null) {
            return true;
        }
        if (node.left != null && node.data < max(node.left)) {
            return false;
        }
        if (node.right != null && node.data > min(node.right)) {
            return false;
        }
        if (isValidBST(node.left) || isValidBST(node.right)) {
            return false;
        }

        return true;
    }

    public boolean isSum(Node node) {
        // no node
        if (node == null) {
            return true;
        }
        // only one node
        if (node.left == null && node.right == null) {
            return true;
        }
        int l = sum(node.left);
        int r = sum(node.right);
        if (node.data == l + r && isSum(node.left) && isSum(node.right)) {
            return true;
        }
        return false;
    }

    public int sum(Node node) {
        if (node == null) {
            return 0;
        }
        return node.data + sum(node.left) + sum(node.right);
    }

    public int levelSum(Node node, int cl, int al) {
        if (node == null || cl > al) {
            return 0;
        }
        if (cl == al) {
            sum += node.data;
        }
        levelSum(node.left, cl + 1, 2);
        levelSum(node.right, cl + 1, 2);
        return sum;
    }

    public int count(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.left) + count(node.right);

    }

    public boolean isBSTComplete(Node node, int index, int nodeCount) {
        if (node == null) {
            return true;
        }
        if (index > nodeCount) {
            return false;
        }
        return isBSTComplete(node.left, 2 * index, nodeCount) && isBSTComplete(node.right, 2 * index + 1, nodeCount);

    }

    // apply in-order approach and print data if it lying in range
    public void printRange(Node node, int low, int high) {
        if (node == null) {
            return;
        }
        if (node.data < low) {
            return;
        }
        //if(node.data>low){
        printRange(node.left, low, high);
        //}
        // if node value is greater or equal of low or Greater or equal to high
        if (node.data <= high && node.data >= low) {
            System.out.print(node.data + "--");
        }
        //if(node.data<high){
        printRange(node.right, low, high);
        //}
    }

    public int printKthSmallest(Node node, int k, int i) {
        if (root == null || k == 0) {
            return 0;
        }
        if (node.left != null) {
            printKthSmallest(node.left, k, i);
        }
        i++;
        if (k == i) {
            return node.data;
        }
        if (node.right != null) {
            printKthSmallest(node.right, k, i);
        }

        // inorder approach kth smallest mean kth element in accending sortest element.
        // pass kth element and when when we roll out / wrap-up than decrease k once it become 0 than print those number
        return 0;
    }

    public int diagonalSum(Node node) {
        Queue<Node> Q = new LinkedList<Node>();
        Q.add(node);
        Node cur = null;
        int sum = 0;
        while (!Q.isEmpty()) {
            sum = 0;
            cur = Q.poll();
            while (cur != null) {
                sum += cur.data;
                if (cur.left != null) {
                    Q.add(cur.left);
                }
                cur = cur.right;
            }
            System.out.println("Diagonal Sum : "+sum);
        }
        return sum;

    }

    public Node LCA(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }
        // both node at left sub tree

        if (node.data < n1 && node.data < n2) {
            return LCA(node.right, n1, n2);
        }
        // lies right subtree
        if (node.data > n1 && node.data > n2) {
            return LCA(node.left, n1, n2);
        }
        // else root will be common ancestor
        return node;
    }

    // for binary tree there is no comparsion
    public Node LCAForBinaryTree(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }
        if (node.data == n1 || node.data == n2) {
            return node;
        }
        Node lc_left = LCAForBinaryTree(node.left, n1, n2);
        Node lc_ri = LCAForBinaryTree(node.right, n1, n2);
        if (lc_left != null && lc_ri != null) {
            return node;
        }
        else {
            return lc_left != null ? lc_left : lc_ri;
        }
    }

    public void printLeaves(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.println(root.data + "--");
        }
        printLeaves(root.left);
        printLeaves(root.right);
    }

    public boolean checkAllLeavesAtSameLevel(Node root, int cl, int d) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            System.out.println(root.data + "--");
            if (cl != d) {
                return false;
            }
        }
        return (checkAllLeavesAtSameLevel(root.left, cl + 1, d) &&
                checkAllLeavesAtSameLevel(root.right, cl + 1, d));

    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node() {

    }

    public Node(int data, Node left, Node right) {
        super();
        this.data = data;
        this.left = left;
        this.right = right;
    }
}