package ubuntuLabs;

import java.util.Scanner;


public class MIDSEM2 {
	 public static Node head;
	 public static Node curr;
	
	 static class Node{
		long data; 
		Node next;
		
	}
  static void insert(long x ) {
	Node n=new Node();
	n.data=x;
	n.next=curr.next;
	curr.next=n;
	
	}
    static void move() {
    	curr=curr.next;
    	
    }
     static void print() {
    	System.out.println(curr.data);
    }


	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int q=sc.nextInt();
		Node head= new Node();
		head.data=sc.nextInt();
		head.next=head;
		curr=head;
		for(int i=0;i<n-1;i++) {
		insert(sc.nextInt());
		}
		for(int j=0;j<q;j++) {
			int x=sc.nextInt();
			if(x==1) {
				print();
			}
			else if(x==2) {
				move();
			}
			else {
				int d=sc.nextInt();
				insert(d);
			}
		}
		
	}

}
