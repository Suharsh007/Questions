import java.lang.*;
import java.util.*;
import java.io.*;
class LinkedList1 { 
  
    static Node head; 
    
    static class Node { 
  
        int data; 
        Node next; 
  
        
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
    static LinkedList1 insert(LinkedList1 list, int data){
        Node new_node = new Node(data);
        new_node.next = null;
 
        if(list.head == null)
            list.head = new_node;
 
        else{
            Node last = list.head;
            while(last.next != null)
                last = last.next;
 
            last.next = new_node;
        }
        return list;
    }
  
    void printlist(Node node) 
    { 
        if (node == null) { 
            return; 
        } 
        while (node != null) { 
            System.out.print(node.data + " -> "); 
            node = node.next; 
        } 
    } 
  
    Node reverselist(Node node) 
    { 
        Node prev = null, curr = node, next; 
        while (curr != null) { 
            next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        } 
        node = prev; 
        return node; 
    } 
  
    void rearrange(Node node) 
    { 
        Node first = node;
        Node second = first.next; 
        while (second != null && second.next != null) { 
            first = first.next; 
            second = second.next.next; 
        } 
        Node node1 = node; 
        Node node2 = first.next; 
        first.next = null;
        node2 = reverselist(node2); 
  
        
        node = new Node(0);
        Node curr = node; 
        while (node1 != null || node2 != null) { 
            if (node1 != null) { 
                curr.next = node1; 
                curr = curr.next; 
                node1 = node1.next; 
            } 
            if (node2 != null) { 
                curr.next = node2; 
                curr = curr.next; 
                node2 = node2.next; 
            } 
        } 
  
        
    } 
  
    public static void main(String[] args) 
    { 
       Scanner sc1 = new Scanner(System.in);
        LinkedList1 list = new LinkedList1();
		int n =sc1.nextInt();
        for(int i=0;i<n;i++){
            int num = sc1.nextInt();
            list = insert(list, num);
        }
        list.rearrange(head); 
        list.printlist(head); 
    } 
} 