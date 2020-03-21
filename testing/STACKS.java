package testing;
import java.util.Scanner;
import java.util.Stack;

public class STACKS{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<t;i++) {
			String input =sc.next();
			int c=0;
			Stack<Character> stacky = new Stack<>();
		     for (int j= 0; j < input.length(); j++) {
		    	 char z=input.charAt(j);
		    	 int d=0;
		        if (!stacky.isEmpty()) {
		            if(z=='I') {
		                stacky.push(z);
		                d=j;
		          }
		            else if(z=='O') {
		            	if(stacky.pop()=='I') {
		            	    if((j-d)%2!=0){
		            		c-=1;}
		            	    else {
		            	    	c+=1;
		            	    }
		            	}
		            }
		        } 
		        else {
		            stacky.push(z);
		        } 
		     }
		     System.out.println("Case #"+Integer.toString(i+1)+": "+Integer.toString(c));
		}
		sc.close();

	}

}
