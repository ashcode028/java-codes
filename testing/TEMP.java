package testing;

import java.util.Scanner;

public class TEMP {
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
		 int i=0;int j=0;int k=l;
		 while(i<n1 && j<n2) {
			 if(L[i]>=R[j]) {
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

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr= new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		sc.close();
		mergesort(arr,0,n-1);
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
