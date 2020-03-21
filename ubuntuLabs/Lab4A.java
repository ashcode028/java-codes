package ubuntuLabs;

import java.util.Scanner;

public class Lab4A {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		for(int i=0;i<t;i++) {
			int k=sc.nextInt();
			int time=sc.nextInt();
			int max=(time/k);
			int min=2;
			int mid=(min+max)/2;
			for(int j=min;j<=max;j++) {
				int d=(int) (k*mid*Math.log10(mid));
				if(d<time) {
					j=mid;
					min=mid;
				}
				else {
					System.out.println(j-1);
					break;
				}
				mid=(min+max)/2;
				
				
			}
			
		}
		sc.close();
	}

}
