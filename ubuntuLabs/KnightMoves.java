package ubuntuLabs;

import java.util.Scanner;

public class KnightMoves {
	
	public static boolean move(int i,int j,int m,int n,int k) {
		if( i>8|| j>8)
			return false;
		else if (i==m && j==n)
			return true;
		else
			
		return move(i+1,j+2,m,n,k) || move(i-1,j+2,m,n,k);
		
		

	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int k=sc.nextInt();
		sc.close();
		if(move(1,1,m,n,k)==true)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
