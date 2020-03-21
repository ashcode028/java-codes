package practiceLabs;

import java.util.Scanner;

public class LL2 {
	static node mid;
	static node tail;
	static node head;
	
	static int c;
	
	 static class node{
		long data;
		node next;
		node prev;
		node (){
			data=0;
		}
		
		node(long d){
			data=d;
			c+=1;
		}
	}
	 
	 static void insert(long x,node head,node tail) {
		node n=new node(x);
		
		if(c==2 ) {
			head.next=n;
			n.prev=head;
			tail=n;	
			mid.next=n;
			mid=n;
		}
		else {
			n.prev=tail;
			tail.next=n;
			tail=n;
			if(c%2==0) {
				node temp =new node();
				temp=mid;
				mid=mid.next;
				mid.prev=temp;
			}
			else {
				mid.next=n;
				
			}
			
			
		}
	}
	 static void delete(node head){
		if(head!=null) {
		head.next.prev=null;
		head=head.next;
		c-=1;
		if(c%2==0) {
			mid=mid.next;
		}
		}
		else
		System.out.println("null");
	}
	 static void printm(node head){
		if(c%2==0) {
			System.out.println(mid.prev.data+" "+ mid.data);
			
		}
		else {
			System.out.println(mid.data);
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long q = sc.nextLong();
		node head=new node(1);
		tail=head;
		mid=head;
		for(int i=0;i<q;i++) {
			int qtype=sc.nextInt();
			if(qtype==1) {
				long x=sc.nextLong();
				insert(x,head,tail);
			}
			else if(qtype==2) {
				delete(head);
			}
			else {
				printm(head);
			}

	}
		sc.close();

}
}
