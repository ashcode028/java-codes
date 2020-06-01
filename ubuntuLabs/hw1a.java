package submission;


import java.util.*;

public class hw1a {
	
	private int arr[];
	private int top;
	private int capacity;
	
	hw1a(int size)
	{
      arr = new int[size];
	  capacity = size;
	  top = -1 ;
	}
	
	public void push(int k){
	if (isFull())
		{
			System.out.println("OverFlow");
			System.exit(1);
		}
		arr[++top]= k ;
	}

	public boolean isFull() {
		
		return top == capacity -1;
	}

	public int pop()
	{
		if (isEmpty())
			{
			System.out.println("UnderFlow");
            System.exit(1);
			}
	return arr[top--];
	}
    public boolean isEmpty() {
    	return top == -1;
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String x=sc.next();
		int n=x.length();
		sc.close();
		hw1a stack= new hw1a(n/2);
		for(int i =0;i<n;i++) {
			char a=x.charAt(i);
			if(a == 'L') {
				stack.push(a);
			}
			else {
				if(stack.isEmpty()) {
					if(x.charAt(i+1)=='L') {
						i+=2;
					}
				}
				else {
				stack.pop();
				}
			}
		}
		if(stack.isEmpty()) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		
		
	}

}
