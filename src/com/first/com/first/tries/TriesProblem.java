package com.first.com.first.tries;

import java.util.ArrayList;
import java.util.List;

public class TriesProblem {

    public static void main(String aa[]){

    }
}

// each node have reference of N nodes
class Node{
    private boolean isLeaf;
    private List<Node> nextLevel;
    private int freq;

    public Node( ) {
        this.isLeaf = false;
        this.nextLevel = new ArrayList<>(26);
        this.freq = 0;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(final boolean leaf) {
        isLeaf = leaf;
    }

    public List<Node> getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(final List<Node> nextLevel) {
        this.nextLevel = nextLevel;
    }
}

class Tries{
    public static Node root = new Node();

    public void insertWord(String word, Node root){
        Node node = null;
        for(int i =0 ; i< word.length();i++){
            char ch = word.charAt(i);

            if(root == null){
                node = new Node();
                root = node;
            }
            if(node.getNextLevel().get((int)ch-26)==null){
                 node.getNextLevel().add((int)ch-26, new Node());
            }
// moved to next level
           node = node.getNextLevel().get((int)ch-26);
        }
        // once word completed the mark terminal
        node.setLeaf(true);
    }

    public void wordBreaking(String s){
        //
        for(int i=0; i<s.length();i++){
            for(int j=0; j<s.length();j++) {
                String subStr = s.substring(i,j);
                if(isCompleteWord(subStr)){
                    //print string
                    i = i+j;
                    break;
                }
            }
        }
    }

    private boolean isCompleteWord(String subStr) {
        Node node = Tries.root;
        for(int i=0;i<subStr.length();i++){
            char ch = subStr.charAt(i);
            if(node.getNextLevel().get((int)ch-26)!=null && node.isLeaf()){
                return true;
            }
        }
        return false;
    }
}