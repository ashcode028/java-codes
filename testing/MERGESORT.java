package testing;

import java.util.Scanner;

public class MERGESORT {
	static void mergesort(int arr[],int l,int r) {
		 if(l<r) {
			 int mid=(l+r)/2;
			 mergesort(arr,l,mid);
			 mergesort(arr,mid+1,r);
			 merge(arr,l,mid,r);
		 }
	 }
	  static void merge(int arr[],int l,int mid,int r) {
		 int n1=(mid-l+1);
		 int n2=(r-mid);
		 int L[]=new int[n1];
		 int R[]=new int[n2];
		 for(int i=0;i<n1;i++) {
			 L[i]=arr[l+i];
		 }
		 for(int j=0;j<n2;j++) {
			 R[j]=arr[mid+1+j];
		 }
		 int i=0;int j=0;int k=0;
		 while(i<n1 && j<n2) {
			 if(L[i]<=R[j]) {
				 arr[k]=L[i];
				 i++;
			 }
			 else {
				 arr[k]=R[j];
				 j++;
			 }
			 k++;
		 }
		 while(i<n1) {
			 arr[k]=L[i];
			 i++;
			 k++;
		 }
		 while(j<n2) {
			 arr[k]=R[j];
			 j++;
			 k++;
		 }
	 }
	  static  boolean check(int arr[],int l) {
		  for(int i=0;i<l-1;i++) {
			  int x=(int)arr[i]-(int)arr[i+1];
			  if(x>2) {
				  return false;
			  }

		  }
		  return true;
		  
	  }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<t;i++) {
			
			String n=sc.nextLine();
			int l=n.length();
			int [] arr=new int[l];
			for (int j = 0; j < l; j++)
			{
			    arr[j] = n.charAt(j) - '0';
			}
			mergesort(arr,0,l-1);
			boolean result=check(arr,l);
			if(result==true) {
				System.out.println("YES");
			}
			else
				System.out.println("NO");
		
		}
		sc.close();
		
	}

}
