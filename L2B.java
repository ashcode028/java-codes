package submission;

import java.util.Scanner;

public class L2B {
	public static long num(long n,long p) {
		if(n>10) {
			long r=n%10;
			long d=n/10;
			long ans=(long)Math.pow(r, p);
			System.out.println(ans);
			return ans+num(d,p);
		}
		else {
			long r=(long)Math.pow(n, p);
			System.out.println(r);
					return r;
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0;i<T;i++) {
			long n=sc.nextLong();
			int p=Long.toString(n).length();
			long result=num(n,p);
			
			if(result==n) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}

}
