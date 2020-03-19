package temp;

import java.util.Scanner;

public class PIPSQUIK {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0;i<T;i++) {
			int n=sc.nextInt();
			int h=sc.nextInt();
			int y1=sc.nextInt();
			int y2=sc.nextInt();
			int l=sc.nextInt();
			int c=0;
			for(int j=0;j<n;j++) {
				int t=sc.nextInt();
				int x=sc.nextInt();
				if(t==1) {
					if((h-y1)<=x) {
						c+=1;
						
					}
					else if(l>0) {
						l-=1;
						c+=1;
					}
					else { 
					break;
					
					}
					
				}
				else {
					if((y2>=x)) {
						c+=1;
						
					}
					else if(l>0) {
						l-=1;
						c+=1;
					}
					else { 
						break;
						
					}
					
				}
			}
			System.out.println(c);
		}
		sc.close();
	}

}
