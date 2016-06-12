package main.linkedlist;

import java.util.Scanner;

public class LinkedList {

	private class Node {
		private int value;
		private Node next;

		Node(int value) {
			this.value = value;
		};

		/**
		 * @return the value
		 */
		public int getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 * @return void
		 */
		public void setValue(int value) {
			this.value = value;
		}

		/**
		 * @return the next
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * @param next
		 *            the next to set
		 */
		public void setNext(Node next) {
			this.next = next;
		}

	}//End of Class Node
	
	
	Node head;

	public void addAtHead(int value) {
		Node temp = new Node(value);
		temp.setNext(head);
		head = temp;
	}

	public void addAfterNode(Node prevNode, int value) {
		if (null == prevNode)
			System.out.println("Previous Node can not be NULL !");

		Node temp = new Node(value);
		temp.setNext(prevNode.getNext());
		prevNode.setNext(temp);
	}

	public void addAtEnd(int value) {
		Node temp = head;
		if (null != temp) {
			while (null != temp.getNext()) {
				temp = temp.getNext();
			}
			temp.setNext(new Node(value));
		} else {
			head = new Node(value);
		}

	}
	public void deleteByValue(int value){
		
		Node temp=head;
		
		if(null==head)
			return;
		
		if(head.getValue()==value){
			head = head.getNext();
			return;
		}
				
		while(temp.getNext()!=null && temp.getNext().getValue()!=value)
			temp=temp.getNext();
		
		if(temp.getNext()!=null){
			temp.setNext(temp.getNext().getNext());
			return;
		}
		System.out.println("Did not find the element to delete");
	}
	public void deleteByIndex(int index){
		
		Node temp=head;
		
		if(index<0)
			return;
		
		while(temp.getNext()!=null && index-- > 1){
			temp=temp.getNext();
		}
		if(temp.getNext()!=null)
			temp.setNext(temp.getNext().getNext());
		
		System.out.println("Did not find the element to delete");
	}

	public static void main(String[] args) {
		
		//insertionTest1();
		//insertionTest2();
		deletionTest();
	}
	
	public void length(){
		Node last = head;
		int counter = 0;
		while(last!=null){
			counter++;
			last=last.getNext();
		}
		System.out.println("Total length = "+counter);
	}
	
	public int lengthByRecursion(Node node){
		//base case
		if(node==null)
			return 0;
		
		return 1+lengthByRecursion(node.getNext());
		
	}
	public boolean search(Node node,int value){
		//base case
		if(node==null)
			return false;
		//base case
		if(node.getValue()==value)
			return true;
		
		return search(node.getNext(),value);
	}
	static Node findNthNodeFromLast(Node head, int N){
		//Your code here.
		if(head == null){
		  //  return -1;
		}
		
		Node first=head;
		Node second=head;
		for(int i =0;i<N;i++){
		    second = second.next;
		    if(second == null){
		    //    return -1;
		    }
		}
		while(null!=second.next){
		    second=second.next;
		    first=first.next;
		}
		return first;
	}

	private static void deletionTest() {
		   /* Start with the empty list */
        LinkedList llist = new LinkedList();
        llist.addAtEnd(6);
        llist.addAtHead(7);
        llist.addAtHead(1);
        llist.addAtEnd(4);
        // 1->7->8->6->4->NUllist
        llist.addAfterNode(llist.head.next, 8);
 
        System.out.println("\nCreated Linked list is: ");
        llist.print();
        System.out.println(findNthNodeFromLast(llist.head,3));
       /* llist.length();
        System.out.println("SEARCH successful : "+llist.search(llist.head,7));
        System.out.println("recursion length = "+llist.lengthByRecursion(llist.head));
        llist.deleteByIndex(1);
        //llist.deleteByValue(4);
		llist.print();
		llist.length();
		System.out.println("SEARCH successful : "+llist.search(llist.head,7));
		System.out.println("recursion length = "+llist.lengthByRecursion(llist.head));*/
	}
	/**
	 * 
	 */
	private static void insertionTest1() {
		LinkedList ll = new LinkedList();
		
		ll.addAtEnd(9);		
		Scanner in=null;
		try{
			in = new Scanner(System.in);
		int value = 0;
		System.out
				.println("Enter an int and press enter for next. Enter a character to terminate: ");
		while (in.hasNextInt()) {
			value = in.nextInt();
			ll.addAtHead(value);
		}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			if(null!=in)
					in.close();
		}
		ll.addAfterNode(ll.head.getNext(), 44);
		ll.addAtEnd(99);
		ll.print();
	}
	
	private static void insertionTest2(){
		   /* Start with the empty list */
        LinkedList llist = new LinkedList();
 
        // Insert 6.  So linked list becomes 6->NUllist
        llist.addAtEnd(6);
 
        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        llist.addAtHead(7);
 
        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        llist.addAtHead(1);
 
        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        llist.addAtEnd(4);
 
        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        llist.addAfterNode(llist.head.next, 8);
 
        System.out.println("\nCreated Linked list is: ");
        llist.print();
	}


	public void print() {
		Node temp = head;
		
		while (null != temp) {
			System.out.print(temp.getValue() + "->");
			temp = temp.getNext();
		}
		System.out.println("NULL");

	}

}
