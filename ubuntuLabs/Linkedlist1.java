package practiceLabs;

import java.util.Scanner;


public  class Linkedlist1 {
	
		 public static Node head;
		 public static Node curr;
		
		 public static class Node{
			long data; 
			Node next;
	
		}
		public  static void insert(long x ) {
		Node n=new Node();
		n.data=x;
		n.next=curr.next;
		curr.next=n;
		
		}
	    public static void move() {
	    	curr=curr.next;
	    }
	    public static void print() {
	    	System.out.println(curr.data);
	    }
	

	public static void main(String[] args) {
		Node head=new Node();
		head.data=(long)1;
		head.next=head;
		curr=head;
		Scanner sc=new Scanner(System.in);
		long q = sc.nextLong();
		for(int i=0;i<q;i++) {
			int qtype=sc.nextInt();
			if(qtype==1) {
				long x=sc.nextLong();
				insert(x);
			}
			else if(qtype==2) {
				move();
			}
			else {
				print();
			}
					
		}
		sc.close();

	}

}
