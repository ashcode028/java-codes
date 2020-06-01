package submission;

import java.io.*;

import java.util.*;
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
    static long nextLong() throws IOException{
    	return Long.parseLong( next());
    }
}
class node{
	int value;
	long weight;
	node(){
		
	}
	node(int v,long c){
		this.value=v;
		this.weight=c;
	}
}
public class hw1d {
	static long[] bfs(ArrayList<ArrayList<node>> adj,int src,int n) {
		LinkedList<Integer> q=new LinkedList<Integer>();
		q.add(src);
		long dist[] =new long[n];
		boolean checked[]= new boolean[n];
		for(int i=0;i<n;i++) {
			dist[i]=Long.MAX_VALUE;
			checked[i]=false;
		}
		dist[src]=0;
		
		while(!q.isEmpty()) {
			int x=q.poll();
			checked[x]=true;
			int l=adj.get(x).size();
			for(int i=0;i<l;i++) {
			  node temp=adj.get(x).get(i);
			  if(!checked[temp.value]) {
				 // checked[temp.value]=true;
				  dist[temp.value]=dist[x]+temp.weight;
				  q.add(temp.value);
				  
			  }
			}
		}
		//print(dist);
		return dist;
	}
	static void print(long arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
	static void check(ArrayList<ArrayList<node>> adj,int src,int n,int supp[],int e) {
		long dist[]=bfs(adj,src,n);
		long z=Long.MAX_VALUE;
		if(dist[e]!=Long.MAX_VALUE) {
			System.out.println("escaped");
		}
		else {
		for(int i=0;i<supp.length;i++) {
			if(dist[supp[i]]!=Long.MAX_VALUE) {
				if(z>dist[supp[i]]) {
					z=dist[supp[i]];
				}
			}
		}
		if(z!=Long.MAX_VALUE) {
			System.out.println(z);
		}
		else {
			System.out.println("oo");
		}
	}
	}
	static void remove(ArrayList<ArrayList<node>> adj,int x,long arr[][]) {
		int a=(int)arr[x][0];
		int b=(int)arr[x][1];
		for(int i=0;i<adj.get(a).size();i++) {
	     node temp=adj.get(a).get(i);
	     if(temp.value==b) {
            adj.get(a).remove(i);    	     
	        }
	     }
		for(int i=0;i<adj.get(b).size();i++) {
		     node temp=adj.get(b).get(i);
		     if(temp.value==a) {
	            adj.get(b).remove(i);    	     
		        }
		     }
	}
	static void add(ArrayList<ArrayList<node>> adj,int x,long arr[][]) {
		int a=(int)arr[x][0];
		int b=(int)arr[x][1];
		long c=arr[x][2];
		adj.get(a).add(new node(b,c));
		adj.get(b).add(new node(a,c));
		
	}
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int n=Reader.nextInt();
		int s=Reader.nextInt();
		int q=Reader.nextInt();
		int e=Reader.nextInt()-1;
		ArrayList<ArrayList<node>> adj=new ArrayList<ArrayList<node>>();
        long arr[][]=new long [n-1][3];
		int supp[]=new int[s];
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<node>());
		}
		for(int i=0;i<n-1;i++) {
			int a=Reader.nextInt()-1;
			int b=Reader.nextInt()-1;
			long c=Reader.nextLong();
			adj.get(a).add(new node(b,c));
			adj.get(b).add(new node(a,c));;
			arr[i][0]=(long)a;
			arr[i][1]=(long)b;
			arr[i][2]=c;
		}
		for(int i=0;i<s;i++) {
			supp[i]=Reader.nextInt()-1;
		}
        for(int i=0;i<q;i++) {
        	int a=Reader.nextInt()-1;
        	int b=Reader.nextInt()-1;
        	if(b==e) {
        		System.out.println("escaped");
        	}
        	else {
        		remove(adj,a,arr);
        	    check(adj,b,n,supp,e);
        	    add(adj,a,arr);
        		}
        	
        }
        	
	}

}
