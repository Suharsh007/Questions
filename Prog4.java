import java.lang.*;
import java.io.*;
import java.util.*;

class LinkedList
{
    static Node head;
 
    static class Node{
        int data;
        Node next;
 
        public Node(int d){
            data = d;
        }
    }
 
    static LinkedList insert(LinkedList list, int data){
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
 
    static int length(Node top){
        Node curr = top;
        if(curr.next == null)
            return 0;
 
        return 1 + length(curr.next);
    }
 
    static Node middle(Node top){
        Node curr = top;
        int len = length(top);
        int count = 0;
 
        while(curr != null){
            if(count == len/2)
                return curr;
            count++;
            curr = curr.next;
        }
        return null;
    }
 
    static void printList(Node top){
        Node temp = top;
 
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
 
    static Node mergeList(Node first, Node second){
        Node sorted = null;
 
        if(first == null)
            return second;
        if(second == null)
            return first;
 
        if(first.data <= second.data){
            sorted = first;
            sorted.next = mergeList(first.next, second);
        }
        else{
            sorted = second;
            sorted.next = mergeList(first, second.next);
        }
 
        return sorted;
    }
 
    static Node sortList(Node top){
        if(top == null || top.next == null)
            return top;
 
        Node mid = middle(top);
        Node midNext = mid.next;
 
        mid.next = null;
 
        Node firstHalf = sortList(top);
        Node secondHalf = sortList(midNext);
 
        Node sorted = mergeList(firstHalf, secondHalf);
 
        return sorted;
    }
 
	public static void main (String[] args) throws IOException
	{
		Scanner s = new Scanner(System.in);
 
		LinkedList list = new LinkedList();
 
		int n =s.nextInt();
 
		
        for(int i=0;i<n;i++){
            int num = s.nextInt();
            list = insert(list, num);
        }
        head = sortList(head);
        printList(head);
 
	}
}