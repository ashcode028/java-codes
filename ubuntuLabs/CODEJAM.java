package ubuntuLabs;

import java.util.Scanner;
import java.util.Stack;

class CODEJAM {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<t;i++) {
			String input =sc.next();
			int c=0;
			Stack<Character> stacky = new Stack<>();
			 int j=1;
			 int l=input.length();
			     while(j<=l)
			         {
			          char ch = input.charAt(j);
			         stacky.push(ch); 
			         }
			        j=0;
			        for(j=0;j<l;j++) {
			        	char ch = input.charAt(j);
			        	if(ch=='O') {
			        		
			        	}
			        }
		     
		     System.out.println("Case #"+Integer.toString(i+1)+": "+Integer.toString(c));
		}
		sc.close();
		}
	

	}


