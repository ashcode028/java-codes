package cODECHEF;

import java.util.*;

class March1 {

	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	int t=sc.nextInt();
	for(int i=0;i<t;i++) {
		int n=sc.nextInt();
		int m=sc.nextInt();
		int [] f=new int[n];
		int [] p= new int[n];
		for(int j=0;j<n;j++) {
			f[j]=sc.nextInt();
		}
		for(int j=0;j<n;j++) {
			p[j]=sc.nextInt();
			
		}
		int min=Integer.MAX_VALUE;

		for(int j=0;j<n;j++) {
			if(f[j]!=-1) {
			int sum=p[j];
			for(int k=0;k<n;k++) {
				if(f[j]==f[k] && j!=k) {
					sum+=p[k];
					f[k]=-1;
				}
				
			}
		
			if(min>sum) {
				min=sum;
			}
			}
		
		}
		System.out.println(min);
	}

	}

}
