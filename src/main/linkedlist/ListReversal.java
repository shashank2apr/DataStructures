package main.linkedlist;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ListReversal {

    public static void main(String[] args) {
        reverseJavaUtilListDemo();
        System.out.println();
        reverseCustomLinkedList();
    }
    
    public static void reverseJavaUtilListDemo(){
        System.out.println("Reversing the java.util.List...");
        java.util.List<String> javaUtilList = new ArrayList<>();
        javaUtilList.add("Hello");
        javaUtilList.add("Hi");
        javaUtilList.add("Hola");
        javaUtilList.add("Namaste");
        System.out.println("printing in order of insersion");
        System.out.println(javaUtilList);
        Collections.reverse(javaUtilList);
        System.out.println("printing in reverse order");
        System.out.println(javaUtilList);
    }
    
    public static void reverseCustomLinkedList(){
        System.out.println("Reversing the custom list");
        CustomLinkedList<String> customList = new CustomLinkedList<String>();
        customList.add("0");
        customList.add("1");
        customList.add("2");
        customList.add("3");
        System.out.println("printing in order of insersion");
        customList.print();
        customList.reverse();
        System.out.println("printing in reverse order");
        customList.print();
    }

    public static class CustomLinkedList<V> implements Iterable<V> {
        private Node head;
        private Node tail;

        public void add(V data) {
            if (head == null) {
                head = new Node(data);
                tail = head;
            } else {
                Node newNode = new Node(data);
                tail.next = newNode;
                tail = newNode;
            }
        }

        public void reverse() {
            Node previous = null;
            Node current = head;
            Node next = null;

            while (current != null) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            head = previous;
        }

        private class Node {
            V data;
            Node next;

            public Node(V data) {
                this.data = data;
            }

			/* (non-Javadoc)
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString() {
				return "Node [data=" + data + ", next=" + next + "]";
			}
            
        }

        public void print() {
            for (V data : this) {
                System.out.print(data + "->");
            }
            System.out.println("null");
        }

        @Override
        public Iterator<V> iterator() {
            return new Iterator<V>() {
                Node temp = head;

                @Override
                public boolean hasNext() {
                    return temp != null;
                }

                @Override
                public V next() {
                    V data = temp.data;
                    temp = temp.next;
                    return data;
                }

				@Override
				public void remove() {
					// TODO Auto-generated method stub
					
				}
            };
        }
    }
}