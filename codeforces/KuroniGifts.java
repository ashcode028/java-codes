package codeforces;

import java.util.*;

public class KuroniGifts {
	void print(int a[],int b[],int c[],int n) {
		for(int j=0;j<n;j++) {
			System.out.print(a[j]+" ");
		}
		System.out.println();
		for(int j=0;j<n;j++) {
			System.out.print(b[j]+" ");
		}
		
	}
	void add(int a[],int b[],int c[],int n) {
		for(int j=0;j<n;j++) {
			c[j]=a[j]+b[j];
			
		}
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<(n-i);j++) {
				int t=0;
				if(c[i]==c[j]) {
					if(a[i]!=a[j] && a[i]!=b[j]) {
					t=a[i];
					a[i]=a[j];
					a[j]=t;
					}
					else {
						t=a[i];
						a[i]=a[i+1];
						a[i+1]=t;
						
					}
				}
			}
		}
		
		print(a,b,c,n);
	}

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	KuroniGifts obj=new KuroniGifts();
	for(int i=0;i<t;i++) {
		int n=sc.nextInt();
		int [] a=new int[n];
		int[] b= new int[n];
		int [] c=new  int[n];
		int sum=0;
		for(int j=0;j<n;j++) {
			a[j]=sc.nextInt();
		}
		for(int j=0;j<n;j++) {
			b[j]=sc.nextInt();
		}
		obj.add(a,b,c,n);
	}
	
	}

}
