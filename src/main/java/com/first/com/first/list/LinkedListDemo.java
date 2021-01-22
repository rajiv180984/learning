package com.first.com.first.list;

public class LinkedListDemo {

    public static void main(String aa[]){
        System.out.println(" =========== Linked List ============= ");
        LinkedList list = new LinkedList();
        list.insertBeg(10);
        list.insertBeg(20);
        list.insertBeg(30);
        list.insertBeg(40);
        Node last = list.lastNode(LinkedList.head);
        System.out.println("abc :"+last.val);
        list.insertLast(60, last);
        Node last1 = list.lastNode(LinkedList.head);
        System.out.println("abc :"+last1.val);
        list.insertLast(80, last1);
        list.printList();

        System.out.println("Last :"+list.getNthNodeFromLast(LinkedList.head, 3));
        System.out.println("Beg :"+list.getNthNodeFromBeg(LinkedList.head, 2));

        System.out.println(" Number of Node in List :"+ list.count(LinkedList.head));
        System.out.println("=============== reverse Print ==============");
        list.revereseListRecPrint(LinkedList.head);
       // list.sortBubbol(LinkedList.head);
        //list.printList();

        /*list.sortKNode(LinkedList.head, 3);
        list.printList();*/

        LinkedList.head = list.reverseLinkedList(LinkedList.head);
        list.printList();

        System.out.println("delete first node");
       Node node = list.deleteFirstNode();
        System.out.println(node.val);
        list.printList();
        Node node2 = list.deleteFirstNode();
        System.out.println(node2.val);
        list.printList();




    }
}

class LinkedList{
    public static Node head = null;


    public Node lastNode(Node head){
       Node ptr = head;
        while(ptr.next !=null){
            ptr = ptr.next;
        }
        return ptr;
    }
    public void insertBeg(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
        }else{
            node.next=head;
            head = node;
        }
    }

    public void insertLast(int val, Node last){
        Node node = new Node(val);
        System.out.println("abc :"+last.val);
        if(head == null){
         head = node;

        }else {
            last.next=node;

        }
    }
    public void printList(){
        Node ptr = head;
        while (ptr !=null){
            System.out.print(ptr.val+"-->");
            ptr = ptr.next;
        }

    }

    public int getNthNodeFromLast(Node head, int k){
        Node p1 = null;
        Node p2 = head;
        p1 = head;
        for(int i=0; i<k; i++){
            p1 = p1.next;
        }
        while (p1!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2.val;
    }

    public int getNthNodeFromBeg(Node head, int k){
        int l=0;
        while(head !=null){
            l++;
            if(l==k){
                return head.val;
            }
            head=head.next;

        }
        return -10000;
    }

    public void sortBubbol(Node node){
        Node newHead = null;
        if(node == null){
            return ;
        }
     int count = count(node);
        Node head = node;
        System.out.println(head.val);
        for(int i=0; i<count; i++){
            Node ptr = head;
            System.out.println(i);

            while (ptr.next!=null){
                if(ptr.val > ptr.next.val){
                    int temp = ptr.val;
                    ptr.val = ptr.next.val;
                    ptr.next.val= temp;
                }
                ptr = ptr.next;
            }
        }
    }

    // there are 4 way to reverse  linked lIst
    //1. take another node and remove node from head and insert into another pointer
    // 2. delet from last and insert into another list
    // 3. using stack
    // 4. using recursion

    public Node reverseLinkedList(Node node){
        System.out.println("this is reverse List");
       Node head2 = null;
       if (node == null){
           return null;
       }
       while (head !=null){
           Node fNode = deleteFirstNode();
           fNode.next = null;
           if (head2 ==null){
               head2 = fNode;
           }else {
               fNode.next = head2 ;
               head2 = fNode;
           }
       }

       return head2;
    }

    public Node deleteFirstNode(){
        Node fnode = null;

        if(head == null){
            return null;
        }
        fnode = head;
        if(head.next!=null){
            head = head.next;
        }else{
            head = head;
        }
        return  fnode;
    }

    public void kNodeBubbolSort(Node node, int k){
        Node newHead = null;
        if(node == null){
            return ;
        }
        int count = count(node);
        Node head = node;
        for(int i=0; i<k; i++){
            Node ptr = head;
            int j=0;
            while (ptr.next!=null && j<k-1){
                if(ptr.val > ptr.next.val){
                    int temp = ptr.val;
                    ptr.val = ptr.next.val;
                    ptr.next.val= temp;
                }
                ptr = ptr.next;
                j++;
            }
        }
    }
    public void sortKNode(Node head, int k){
       Node node = head;
        while(node!=null){

            kNodeBubbolSort(node, k);
            for(int i=0; i<k;i++){
                node=node.next;
            }
        }
    }

    public void revereseListRecPrint(Node node){

        if(node == null){
            return;
        }
        revereseListRecPrint(node.next);
        System.out.print("==>"+node.val);

    }
public int count(Node node){
        int count =0;
        if(node == null){
            return 0;
        }
        return 1+count(node.next);

}



}

class Node{
    int val;
    Node next;

    public Node(final int val) {
        this.val = val;
        this.next= null;
    }


}
