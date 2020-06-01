package submission;

import java.util.*;

public class hw1b {
   static void merge(float arr[], int l, int m, int r) 
    { 
        
        int n1 = m - l + 1; 
        int n2 = r - m; 
        float L[] = new float [n1]; 
        float R[] = new float [n2]; 
  
 
        for (int i=0; i<n1; ++i) { 
        	
        	L[i] = arr[l + i];
        }
        for (int j=0; j<n2; ++j) { 
        
        	R[j] = arr[m + 1+ j]; 
        }
    
        int i = 0, j = 0; 

        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
            	
            	arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
            
            	arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) 
        { 
        	
        	arr[k] = L[i]; 
            i++; 
            k++; 
        }
   
        while (j < n2) 
        {   
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
 

   static void mergesort(float arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2;
            mergesort(arr, l, m); 
            mergesort(arr , m+1, r);
            merge(arr, l, m, r); 
        } 
    } 
  
	
	static void check(float arr1[][],int n ,int k) {
		float ans=Integer.MAX_VALUE;
		float arr[]=new float[n];
		for(int i=0;i<n;i++) {
			int z=0;
			float sum=0;			
			float ratio=arr1[1][i]/arr1[0][i];
			 for(int j=0;j<n;j++) {
				float value=ratio*arr1[0][j];
				if(value>=arr1[1][j]) {
					arr[j]=value;
					z+=1;
				}
				else {
					arr[j]=Integer.MAX_VALUE;
				}
			 }
			 if(z>=k) {
			 mergesort(arr,0,n-1);
			 for(int j=0;j<k;j++) {
				 sum+=arr[j];
			 }
			 if(ans>=sum) {
				 ans=sum;
			 }
			 }
		}
		System.out.println((int)Math.ceil(ans));

	}
	 static void printArray(float arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i] + " "); 
	        System.out.println(); 
	    } 
	  
	 static void sum(float arr[][],int n,int k) {
		 float sum=0;
		 float d=0;
		 double price=0;
		 for(int i=0;i<k;i++) {
			 sum+=arr[1][i];
			 d+=arr[0][i]; 
		 }
		 System.out.println(sum+" "+ d);
		 for(int i=0;i<k;i++) {
			 price=Math.ceil((arr[1][i]*d)/arr[0][i]);
			 if(price>=sum) {
				 break;
			 }
		 }
		 System.out.println(price);
	 }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); 
		int n=sc.nextInt();
		int k=sc.nextInt();
		float arr1[][]=new float[2][n];
		for(int i =0;i<n;i++) {
			arr1[0][i]=sc.nextFloat();
		}
		for(int i =0;i<n;i++) {
			arr1[1][i]=sc.nextFloat();	
		}
	check(arr1,n,k);
	
	
	}

}