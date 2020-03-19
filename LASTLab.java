package questions;

import java.util.Scanner;

public class LASTLab {
	
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		int q=sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=0;i<q;i++) {
			int k=sc.nextInt();
			int l=0;
			int u=n-1;
			if (k<0) {
				System.out.println(0);
			}
			else {
			while(l<=u && l>=0 && u<n) {
				int mid=(l+u-1)/2;
				if(k==arr[mid]) {
					System.out.println(mid);
					break;
				}
				else if(k<arr[mid] &&k>arr[mid-1]) {
					System.out.println(mid);
					break;
				}
				else if(k>arr[mid] && k<arr[mid+1]) {
					System.out.println(mid+1);
					break;
				}
				else if (k<arr[mid] ) {
					l=mid+1;
				}
				else if(k>arr[mid]) {
					u=mid-1;
				}
				else {
					System.out.println(-1);
				}
				
			}
			}
		}
		sc.close();
	}

}
