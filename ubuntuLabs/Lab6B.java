package ubuntuLabs;

import java.io.IOException;
import java.util.Scanner;


public class Lab6B {
	int c=0;
	node rear;
	class node{
		int data;
		node prev;
		node next;
		
	}
	void push(int x) {
		node n=new node();
		n.data=x;
		if(rear==null) {
			rear=n;
		}
		else {
		n.prev=rear;
		rear.next=n;
		rear=n;
		}
		c+=1;
	}
	void pop(){
		rear=rear.prev;
		c-=1;
	}
	void search(int arr[],int n) {
		for(int i=0;i<n;i++) {
			if(rear==null) {
				push(arr[i]);
				System.out.println(1);
			}
			else {
				while(rear!=null && arr[i]>rear.data) {
					pop();
				}
				push(arr[i]);
				System.out.println(c);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt(); 
		Lab6B obj=new Lab6B();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		obj.search(arr,n);
		
	}
		

}


