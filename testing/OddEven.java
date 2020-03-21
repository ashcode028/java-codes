package testing;

import java.util.Scanner;

public class OddEven {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int m= sc.nextInt();
		sc.close();
		if(m%2!=0) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
		}

	}

}
