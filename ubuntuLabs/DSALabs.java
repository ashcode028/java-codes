package ubuntuLabs;

import java.util.Scanner;


public class DSALabs {
	public static int fjourney(int a[][],int n,int i,int j,boolean flag){
		if(i<n && j<n && i>=j) {
			if(i==n-1 && j==n-1) {
				flag=true;
				return a[i][j];
			}
			else if (flag==true) return a[i][j];
			else {
							return fjourney(a,n,i+1,j,flag)+fjourney(a,n,i,j+1,flag) ;
			}
		}
		else return 0;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][]=new int[n][n];
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		sc.close();
		boolean flag =false;
		System.out.println(fjourney(arr,n,0,0,flag));
		

	}
}

