package com.first.bst;

import javax.sound.midi.Soundbank;

import com.first.bst.BinarySearchTree;

public class BSTDemo {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(45);
        bst.insert(75);
        bst.insert(25);
        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(85);
        bst.insert(95);
        bst.insert(65);
        
        Node root = BinarySearchTree.root;
        bst.inorder(root);
        System.out.println("*******  Inoder Withour Rec ********");
        bst.inorderWithoutRec(root);
        System.out.println("*******  minimum of tree ********"+bst.min(root));
        System.out.println("*******  Max of tree ********"+bst.max(root));
        System.out.println("***** Kth Level print  *******");
        bst.levelPrint(root, 0, 2);
        int h = bst.heghtOfTree(root);
        System.out.println("***** Heiht of  tree  *******"+h);
        System.out.println("Is Valid BST "+bst.isValidBST(root));
        System.out.println(" Sum of node "+ bst.sum(root));
        System.out.println(" Tree is SUM tree :"+ bst.isSum(root));
        System.out.println(" Kth Level Sum :"+bst.levelSum(root, 0, 2));
        int noOfNode = bst.count(root);
        System.out.println("********* Count of Node "+noOfNode);
        System.out.println("===========:"+bst.isBSTComplete(root, 1, noOfNode));
        System.out.println("************** Node in Range *****************");
        bst.printRange(root, 11, 24);
        System.out.println("************** Kth smallest ***********"+bst.printKthSmallest(root, 2,0));
        
        System.out.println("******* Least Common Ancestor  ********* "+bst.LCA(root, 20, 10).data);
        System.out.println("*******Binary Tree Only  Least Common Ancestor  ********* "+bst.LCAForBinaryTree(root, 20, 10).data);
       
        System.out.println("***** Print all Leave Nodes ****** ");
        bst.printLeaves(root);
        
        System.out.println("******* All Leaves at Same Level ********"+bst.checkAllLeavesAtSameLevel(root, 0, h));

        System.out.println("*********** Diagonal Sum : ***************"+ bst.diagonalSum(root));
        
    }
}