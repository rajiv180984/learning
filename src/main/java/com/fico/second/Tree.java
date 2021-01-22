package com.fico.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import javax.sound.midi.Soundbank;

public class Tree {
    public static Node parentNode;

    public static void main(String aa[]) {
        BST bst = new BST();
        bst.insert(45);
        bst.insert(75);
        bst.insert(25);
        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(85);
        bst.insert(65);
       bst.insert(5);
        //bst.insert(61);
        //bst.insert(68);
        bst.insert(95);
       // bst.insert(105);
        //bst.insert(925);

        bst.inOrder(BST.root);

        int count = bst.countNode(BST.root);

        System.out.println(" Count of Node in BST :" + count);
        int level = bst.heigh(BST.root);
        System.out.println(" BST height :" + level);
        boolean isCompletBST = bst.isCompleteBinarytree(BST.root, 1, count);

        int maxPathSum = 0;
        maxPathSum = bst.maxPathSum(BST.root, maxPathSum);
        System.out.println("========= Max Path Sum ========= :" + maxPathSum);

        System.out.println(" BST is complete binary Tree " + isCompletBST);
        System.out.println(" Maximum of BST :" + bst.maxBST(BST.root));
        System.out.println(" Minimum of BST :" + bst.minBST(BST.root));
        bst.printLeaves(BST.root);
        System.out.println(" Is all leaves at same level :" + bst.checkAllLeavesAtSameLevel(BST.root, level, 1));
        System.out.println(" Print Range ");
        bst.printRange(BST.root, 45, 85);

        System.out.println("Print node at level :");
        bst.levelWisePrint(BST.root, 3, 1);
        Node LCANode = bst.lowestCommonAnccesstor(BST.root, 5, 10);
        System.out.println(" Lowest Common Ancestor :" + LCANode.data);

        Node LCANode2 = bst.findLCA(BST.root, 5, 95);
        System.out.println(" Lowest Common Ancestor :" + LCANode2.data);

        bst.topViewOfBST(BST.root);
        bst.verticalPrintBST(BST.root);

       /* BST bst2 = new BST();
        bst2.insert(45);
        bst2.insert(55);
        bst2.insert(54);
        bst2.insert(53);
        bst2.insert(52);
        bst2.insert(51);
        bst2.inOrder(BST.root);
        bst2.topViewOfBST(BST.root);
        System.out.println(" Bottom view of tree");
        bst2.bottomViewOfBST(BST.root);
        */
        ArrayList<Integer> stack = new ArrayList<>();
        stack = bst.findNodePath(BST.root, 5, stack);

        for (int c : stack) {
            System.out.print("==" + c);
        }
        System.out.println("======== Path Between two Nodes ==========");
        bst.findDistanceBWNode(BST.root, 5, 65);

        System.out.println(" Convert MaxHeap ");
        int arr[] = bst.convertBSTToMaxHeap(BST.root, new int[10], 9);
        for (int x : arr) {
            System.out.print("--" + x);
        }
        int[] path = new int[100];

        MinData minData = new MinData();
        minData.diff = 100000;
        bst.minDiffKey(BST.root, 23, minData);
        System.out.println("======= " + minData.diff + " and :" + minData.node.data);

        System.out.println("=============== Level Sum =============");
        Map<Integer, Integer> map = new HashMap<>();
        bst.levelSum(BST.root, 0, map);
        System.out.println("+==========:" + map.toString());

        System.out.println("=========== One Level Sum =========");
        int sum = bst.oneLevelSum(BST.root, 3, 0, 0);
        System.out.println(" one Level sum :" + sum);

        System.out.println("Alternative order ");
        bst.alternativeLevelOrder(BST.root, 3, 1,false);

        System.out.println("============= Print in ZigZag Fashion ============");
        bst.printZigZag(BST.root,5);

        System.out.println("===================== Left view ============== ");
        bst.leftViewUtil(BST.root);

        System.out.println("========= Kth smallest element ==========");
        bst.kthSmallest(BST.root, 3);

    }
}

class Node {
    public Node left;
    public Node right;
    public int data;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Node node = (Node) o;
        return data == node.data &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {

        return Objects.hash(left, right, data);
    }
}

class BST {
    public static Node root = null;
    public static Node parentNode = null;

    public Node createNode(int data) {
        return new Node(data);
    }

    public void insert(int data) {
        root = insertNode(root, data);
    }

    public Node insertNode(Node node, int val) {
        if (node == null) {
            node = createNode(val);
            return node;
        }
        else if (node.data <= val) {
            node.right = insertNode(node.right, val);
        }
        else if (node.data > val) {
            node.left = insertNode(node.left, val);
        }
        return node;
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println("--" + root.data);
        inOrder(root.right);
    }

    public int countNode(Node root) {
        if (root == null) {
            return 0;
        }
        int l = countNode(root.left);
        int r = countNode(root.right);
        return l + r + 1;
    }

    public int heigh(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = heigh(root.left);
        int rh = heigh(root.right);
        // max height of left subtree or Right subtree incluse root as one more level/ height
        return Math.max(lh, rh) + 1;

    }

    // Complete tree means each node have two node except one node at last level
    // at any node following formula should be apply if root index is i than left parent index =2i and right paren index would be 2i+1
    // so at any level's node index is more than count means its voileting complete binary tree constraints

    //isBSTComplete
    public boolean isCompleteBinarytree(Node node, int index, int nodeCount) {
        if (node == null) {
            return true;
        }
        if (index > nodeCount) {
            return false;
        }
        // recursively call for each node left and right sub tree
        return isCompleteBinarytree(node.left, index * 2, nodeCount) && isCompleteBinarytree(node.right, index * 2 + 1, nodeCount);
    }

    // max always right most
    public int maxBST(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null & node.right == null) {
            return node.data;
        }
        return maxBST(node.right);
    }

    // min without recursion
    public int minBST(Node node) {
        if (node == null) {
            return 0;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    // recursively check each node if left and right child is null
    public void printLeaves(Node node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.println(node.data);
        }
        printLeaves(node.left);
        printLeaves(node.right);

    }

    // check all leaves at same level: if hieght of tree and current level of leave node is not equal
    public boolean checkAllLeavesAtSameLevel(Node node, int hieght, int clevel) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            if (hieght != clevel) {
                return false;
            }
        }
        return checkAllLeavesAtSameLevel(node.left, hieght, clevel + 1) &&
                checkAllLeavesAtSameLevel(node.right, hieght, clevel + 1);
    }

    // inorder traversal print node in sorted order. Hence to print data in range
    // recusrsively traverse each node in inover way and check value according to given range
    public void printRange(Node node, int l, int h) {
        if (node == null) {
            return;
        }
        // suppose node's data is less than the lower bound than no value lies in range hence
        // that sub tree does not need to traverse means
        if (node.data < l) {
            return;
        }
        // inoder traversal
        printRange(node.left, l, h);
        // range print
        if (node.data <= h && node.data >= l) {
            System.out.print(node.data + "--");
        }
        printRange(node.right, l, h);
    }

    // when level and current level equal print no.
    // when we move from root to leave node increase current leave
    // traverse tree in preorder fashion
    public void levelWisePrint(Node node, int level, int currentLevel) {

        if (node == null) {
            return;
        }
        if (level == currentLevel) {
            System.out.print("--" + node.data);
        }
        levelWisePrint(node.left, level, currentLevel + 1);
        levelWisePrint(node.right, level, currentLevel + 1);
    }

    // Lowest common ancestor of given node
    public Node lowestCommonAnccesstor(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }
        if (node.data > n1 && node.data > n2) {
            lowestCommonAnccesstor(node.left, n1, n2);
        }
        // might lies on right subtree
        if (node.data < n1 && node.data < n2) {
            lowestCommonAnccesstor(node.right, n1, n2);
        }
        // if one node is lies in left and another lies on right that means root will be ancestor
        // current node will be root that we should return
        return node;
    }

    Node findLCA(Node node, int n1, int n2) {
        // Base case
        if (node == null) {
            return null;
        }

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.data == n1 || node.data == n2) {
            return node;
        }

        // Look for keys in left and right subtrees
        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null) {
            return node;
        }

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

    // top view of tree
    // put label on each of node, root label is 0, left child label decrease by 1 and right child label increase by 1.
    // there must be one entry in map with respect to their label as key in linked hashmap.
    // final result their must be only one value with respect to vertical tagging.
    public void topView(Node node, Map<Integer, Node> map, int hlevel) {
        if (node == null) {
            return;
        }
        // check if already exist than do'nt allow
        if (map.containsKey(hlevel)) {
            // return ;
        }
        else {
            map.put(hlevel, node);
        }
        topView(node.left, map, hlevel - 1);
        topView(node.right, map, hlevel + 1);

    }

    public void topViewOfBST(Node node) {
        if (node == null) {
            return;
        }
        Map<Integer, Node> map = new TreeMap<>();
        topView(node, map, 0);
        System.out.println("===**************==== " + map.size());
        map.forEach((integer, node1) -> System.out.print("--" + node1.data));
    }


    public void bottomViewOfBST(Node node) {
        if (node == null) {
            return;
        }
        Map<Integer, Node> map = new LinkedHashMap<>();
        bottomView(node, map, 0);
        System.out.println("===**************==== " + map.size());
        map.forEach((integer, node1) -> System.out.print("--" + node1.data));

    }

    public void bottomView(Node node, Map<Integer, Node> map, int hlabel) {
        if (node == null) {
            return;
        }
        map.put(hlabel, node);
        bottomView(node.left, map, hlabel - 1);
        bottomView(node.right, map, hlabel + 1);
    }

    // find diameter of tr
    // for each verstical label, maintain a list , So If node label is same than put into same list.
    // here lable is key of hashmap<Lable, List<Node>>
    // tracers node in preorder fashion
    public void verticalPrintBST(Node node) {
        if (node == null) {
            return;
        }
        Map<Integer, ArrayList<Node>> map = new LinkedHashMap<>();
        verticlePrint(node, map, 0);
        System.out.println(" Vertical order printing ");

        for (int key : map.keySet()) {
            map.get(key).forEach(x -> System.out.print("--" + x.data));
            System.out.println("");
        }


    }

    public void verticlePrint(Node node, Map<Integer, ArrayList<Node>> map, int hLabel) {
        if (node == null) {
            return;
        }
        verticlePrint(node.left, map, hLabel - 1);

        if (map.containsKey(hLabel)) {
            map.get(hLabel).add(node);
        }
        else {
            ArrayList<Node> list = new ArrayList<>();
            list.add(node);
            map.put(hLabel, list);
        }
        verticlePrint(node.right, map, hLabel + 1);
    }

    // banace tree, at any node check height of left and right subtree should not be more than 1.
    // recursively check for each node from root to leave

    public boolean isBalancedBST(Node node) {
        if (node == null) {
            return true;
        }
        // check left subtree height and right subttree height
        int lh = heigh(node.left);
        int rh = heigh(node.right);
        // check height diff if diff is more than 1 than false
        if (Math.abs(lh - rh) > 1) {
            return false;
        }
        // check both of sub tree itself balanced recursivley
        return isBalancedBST(node.left) && isBalancedBST(node.right);
    }

    public void diagonalPrint(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queueA = new LinkedList<Node>();
        queueA.add(node);
        while (!queueA.isEmpty()) {
            // pop untill get null in queue or right child null

            while (queueA.peek() != null) {
                if (node == null) {
                    node = queueA.poll();
                }
                System.out.println(node.data);
                if (node.left != null) {
                    queueA.add(node.left);
                }
                node = node.right;
            }
        }
    }

    public void findDistanceBWNode(Node node, int x, int y) {
        if (node == null) {
            return;
        }
        // Approach find LCA and path between them
        // Approach 2:
        // A. Condition path going via root node
        //B. Path may lie in left subtree when both of node is less than root
        // c. Path may be lien in right subtree if both node is greater or equal to root

        if (node.data > Math.max(x, y)) {
            findDistanceBWNode(node.left, x, y);
        }
        if (node.data < Math.min(x, y)) {
            findDistanceBWNode(node.right, x, y);
        }
        if (node.data < Math.max(x, y) && node.data > Math.min(x, y)) {
            System.out.print("=>" + node.data);
            findNodePath(node.left, Math.min(x, y));
            findNodePath(node.right, Math.max(x, y));
        }
    }

    public ArrayList<Integer> findNodePath(Node node, int value, ArrayList<Integer> path) {

        if (node == null) {
            return null;
        }
        // traverse in pre order fashion
        if (node.data == value) {
            path.add(value);
            return path;
        }
        // move left child
        if (node.data > value) {
            path.add(node.data);
            System.out.println("==" + node.data);
            findNodePath(node.left, value, path);
        }
        if (node.data < value) {
            path.add(node.data);
            System.out.println("==" + node.data);
            findNodePath(node.right, value, path);
        }
        return path;
    }

    public void findNodePath(Node node, int value) {

        if (node == null) {
            return;
        }
        // traverse in pre order fashion
        if (node.data == value) {
            System.out.println(node.data);

        }
        // move left child
        if (node.data > value) {
            System.out.print("==>" + node.data);
            findNodePath(node.left, value);
        }
        if (node.data < value) {
            System.out.print("==>" + node.data);
            findNodePath(node.right, value);
        }
    }

    public int[] convertBSTToMaxHeap(Node node, int arr[], int index) {
        if (node == null) {
            return null;
        }
        convertBSTToMaxHeap(node.right, arr, index);
        arr[index] = node.data;
        convertBSTToMaxHeap(node.left, arr, index);
        return arr;
    }

    /*
        public void printMain(Node node, int [] path, int arrayCounter) {
            if (node == null) {
                return;
            }

            path[arrayCounter++] = node.data;

            if (node.left == null && node.right == null) {
                printArray(path);
            }
            else {
                printMain(node.left, path, arrayCounter);
                printMain(node.right, path, arrayCounter);
            }
        }
          private void printArray(int[] path) {
            int max =100;
             if (path[max] != 0) {
                 for (int node : path) {
                     System.out.print(node + ", ");
                 }
                 System.out.print("\n");
             }
         }

         public int printhLongestPathfromRoot(Node node, Stack<Integer> st){
             if(node == null){
                 return 0;
             }
             int l = printhLongestPathfromRoot(node.left, st);
             int r = printhLongestPathfromRoot(node.right, st);
             if(l>r){
                 if(node.left!=null)
                     st.push(node.left.data);
                 return l+1;
             }else {
                 if(node.right!=null)
                     st.push(node.right.data);
                 return r+1;
             }

         }
     */
    public Node leftParentFind(Node node, int x, Node leftParent, Stack<Integer> st) {
        if (node == null) {
            return null;
        }
        if (node.data == x) {
            parentNode = leftParent;
            return leftParent;
        }
        if (node.left != null) {
            st.push(node.data);
            leftParentFind(node.left, x, leftParent, st);
        }
        leftParentFind(node.right, x, leftParent, st);
        return parentNode;
    }

    public void minDiffKey(Node node, int key, MinData minData) {
        if (node == null) {
            return;
        }
        // inorder traversal
        minDiffKey(node.left, key, minData);
        int diff = Math.abs(node.data - key);
        if (diff < minData.diff) {
            minData.diff = diff;
            minData.node = node;
        }
        minDiffKey(node.right, key, minData);
    }

    public void levelSum(Node node, int level, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        int temp = map.getOrDefault(level, 0);
        temp += node.data;
        map.put(level, temp);
        levelSum(node.left, level + 1, map);
        levelSum(node.right, level + 1, map);
    }

    public int oneLevelSum(Node node, int level, int currLevel, int sum) {
        if (node == null) {
            return 0;
        }

        if (level == currLevel) {
            sum += node.data;
            System.out.println("********* sum " + sum + " Node Data " + node.data);
        }

        sum += oneLevelSum(node.left, level, currLevel + 1, sum) + oneLevelSum(node.right, level, currLevel + 1, sum);

        return sum;
    }

    public int maxPathSum(Node node, int soFarSum) {

        if (node == null) {
            return 0;
        }
        int ls = maxPathSum(node.left, soFarSum);
        int rs = maxPathSum(node.right, soFarSum);

        if (node.left != null && node.right != null) {
            int currentSum = Math.max(ls + rs + node.data, Math.max(ls, rs));
            soFarSum = Math.max(soFarSum, currentSum);
            return root.data+Math.max(ls, rs);
        }

        if (node.left == null) {
            return rs + node.data;
        }
        else {
            return ls + node.data;
        }
    }


    public void printZigZag(Node node, int level){
        boolean leftToRight = true;
        for(int i =1; i<= level;i++){
            System.out.println(" Level :"+i);
            if(i%2==0){
                alternativeLevelOrder(node, i, 1,leftToRight);
            }else {
                alternativeLevelOrder(node, i, 1,!leftToRight);
            }

        }
    }

    public void alternativeLevelOrder(Node node, int level,int curLevel, boolean leftFlag ){
        if (node == null){
            return;
        }
        if(level == curLevel){
            System.out.print("--"+node.data);
        }
        if (leftFlag){
            alternativeLevelOrder(node.right, level, curLevel+1,leftFlag);
            alternativeLevelOrder(node.left, level,curLevel+1, leftFlag);

        }else {
          alternativeLevelOrder(node.right, level,curLevel+1, leftFlag);
          alternativeLevelOrder(node.left, level,curLevel+1, leftFlag);
        }

    }

    public  void leftViewUtil(Node node){
        Map<Integer, Integer> map = new HashMap<>();
        leftView(node,0,map);
        System.out.println(map.size()+"  Lefte view "+map.toString());
    }
    public  void leftView(Node node, int level, Map<Integer, Integer> map){

        if(node == null){
            return;
        }

        if(!map.containsKey(level)){
            map.put(level, node.data);
        }
        leftView(node.left, level+1,map);
        leftView(node.right, level+1,map);
    }

    public void kthSmallest(Node node, int k){
        if(node == null){
            return;
        }
        kthSmallest(node.left, k-1);
        k=k-1;
        if(k==0){
            System.out.println(" Kth Smallest element :"+ node.data);
            System.exit(0);
        }
        kthSmallest(node.right, k);
    }
}

class MinData {
    int diff;
    Node node;

    public MinData() {

    }
}


