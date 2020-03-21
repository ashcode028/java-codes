package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Reader {
	static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }

}
public class A1 {
	static boolean check1(int a[],int n) {
		boolean flag=false;
		for(int i=n-1;i>0;i--) {
			if(a[i]>0) {
				flag=true;
				break;
			}
		}
		return flag;
	}
	static boolean check2(int a[],int n) {
		boolean flag=true;
		for(int i=0;i<n;i++) {
			if(a[i]<=0) {
				flag=false;
				break;
			}
		}
		return flag;
	}
	static void add(int a[],int n) {

		for(int i=0;i<n;i++) {
			if(a[i]>0) {
				a[i]+=2;
				break;
			}
		}
		
	}
	static void process(int a[],int n) {
		boolean result=check1(a,n);
		while(result==true) {
			add(a,n);
			mergesort(a,0,n-1);
			boolean res=check2(a,n);
			while(res==true) {
			for(int i=0;i<n;i++) {
				a[i]-=1;
			}
			res=check2(a,n);
			}
			result=check1(a,n);
		}
		if(a[0]==0)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
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
	public static void main(String[] args) throws IOException  {
		Reader.init(System.in);
		int t=Reader.nextInt();
		for(int i=0;i<2*t;i++) {
			int n=Reader.nextInt();
			if(n==1) {
				System.out.println("YES");
			}
			else {
			int arr[]=new int[n];
			for(int j=0;j<n;j++) {
				arr[j]=Reader.nextInt();
			}
			mergesort(arr,0,n-1);
			process(arr,n);
		
			}
		}

	}

}
