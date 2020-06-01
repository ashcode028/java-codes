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


public class hw2a {
     int v;
     int adj[][];
     public hw2a(int n){
    	 this.v=n;
    	 adj=new int[v][v];  	 
     }
      
     public void edge(int s,int t,int w) {
    	 adj[s][t]=w;
    	 adj[t][s]=w;
     }
     
     int minDistance(boolean []mst,int []key) {
    	 int d=Integer.MAX_VALUE;
    	 int vertex=-1;
    	 for(int i=0;i<v;i++) {
    		 if(mst[i]==false && d>key[i]) {
    			 d=key[i];
    			 vertex=i;
    		 }
    	 }
    	 return vertex;
     }
	public void dijkstra(int src,int arr[][],int l) {
		boolean[] check= new boolean[v];
		int [] dist=new int [v];
		int inf=Integer.MAX_VALUE;
		for(int i=0;i<v;i++) {
			dist[i]=inf;
		}
		dist[src]=0;
		for(int i=0;i<v;i++) {
			int u=minDistance(check,dist);
			check[u]=true;
			for(int V=0;V<v;V++) {
				if(adj[u][V]>0) {
					if(check[V]==false && adj[u][V]!=inf) {
						int newD=adj[u][V]+dist[u];
						if(newD < dist[V]) {
							dist[V]=newD;
						}
					}
				}
			}
		}
		printAns(dist,arr,l);
	}
	public void printAns(int []dist,int [][]arr,int l) {
        for(int j=0;j<l;j++) {
        	int a=dist[arr[j][0]];
        	int b=dist[arr[j][1]];
        	 int d=Math.min(a, b);
        	 dist[arr[j][0]]=d;
        	 dist[arr[j][1]]=d;
        }
        int f=dist[0];
		for(int j=0;j<dist.length;j++) {
			if(dist[j]>f) {
				f=dist[j];
			}
		}
		System.out.println(f);
		
	}
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int t = Reader.nextInt();
		for(int i=0;i<t;i++) {
			int n =Reader.nextInt();
			int l = Reader.nextInt();
			long k = Reader.nextLong();
			hw2a obj= new hw2a(n);
			int arr[][]=new int[n][2];
			for(int j=0;j<l;j++) {
				arr[j][0]=Reader.nextInt()-1;
				arr[j][1]=Reader.nextInt()-1;
			}
			for(long j=0;j<k;j++) {
				int a= Reader.nextInt();
				int b = Reader.nextInt();
				int c = Reader.nextInt();
				obj.edge(a-1,b-1,c);
			}
			int src=0;
		obj.dijkstra(src, arr,l);
		}
	}
     
	

}


