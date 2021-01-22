package com.expedia;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Solution {

    public Node createList(Node root){
        if(root == null){
            return null;
        }
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        List<String> ls = new ArrayList<>();
        Iterator it = ls.iterator();
        // push node's child right to left
        // push node's child left to right alternatively
        // switch bw stack untill current stack empty
        Node curr = null;
        while (!(st1.isEmpty() && st2.isEmpty())) {
            while (!st1.isEmpty()) {
                Node node = st1.pop();
                curr.next = node;
                if (node.left != null) {
                    st2.push(node.left);
                }
                if (node.right != null) {
                    st2.push(node.right);
                }
            }
            while (!st2.isEmpty()) {
                Node node = st1.pop();
                curr.next = node;
                if (node.left != null) {
                    st1.push(node.left);
                }
                if (node.right != null) {
                    st1.push(node.right);
                }

            }
        }
        return curr;
    }
}

class Node{
    Node left;
    Node right;
    Node next;
    int data;
}



