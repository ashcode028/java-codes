package ubuntuLabs;

import java.util.Scanner;

public class Lab3 {
	public static int fibo(int n) {
		if(n==1)
			return 0;
		else if(n==2)
			return 1;
		else if(n==3)
			return 1;		
		else
			return fibo(n-1)+fibo(n-2)+fibo(n-3);
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
	
		System.out.println(fibo(n));
	}

}
