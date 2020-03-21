package ubuntuLabs;

import java.io.IOException;
import java.util.Scanner;



public class QUEUE {
	  node front ;
	  node rear;
	  int c=0;
	class node{
		long data; 
		node next;
	}
	 void enqueue(long x ) {
		 node n=new node();
		 n.data=x;
		 if(rear==null) {
			 front=rear=n;
			 
		 }
		 else {
			 rear.next=n;
			 rear=n;
		 }
		 c+=1;
		 System.out.println(front.data);
	
		}
	 void dequeue() {
		 try {
			 node n=front;
			 front=front.next;
			 c-=1;
			 System.out.println(front.data);
		 }
		catch (Exception e) {
			front=rear=null;
			System.out.println("EMPTY");
		}
		 
	 }
	 void increase(int x,long d) {
		 
		 int k=c-x;
		 int z=0;
		 node curr=new node();
		 curr=front;
		 while(curr!=null) {
			 if(z!=k) {
			 curr=curr.next;
			 z+=1;
			 }
			 else {
				 curr.data=curr.data+d;
	
				 curr=curr.next;
			 }
		 }
		 if(front!=null)
				System.out.println(front.data);
		 else
			 System.out.println("EMPTY");
	 }
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt(); // To take integer input
			QUEUE obj=new QUEUE();
		sc.nextLine();
		
		for(int i =0;i<n;i++) {
			String x=sc.next();
			if(x.equals("enqueue") ){
				int a=sc.nextInt();
				obj.enqueue(a);
			
			}
			else if(x.equals("dequeue")) {
				obj.dequeue();
		
			}
			else {
				int a=sc.nextInt();
				int b=sc.nextInt();
				obj.increase(a, b);
			}
		}
		
		
	}

}
