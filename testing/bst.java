package testing;

public class bst {
	node root;
	class node{
		node l,r,p;
		int key;
		node(int data){
			key=data;
		}
	}
	node search(node x ,int key) {
		if(x.key==key || x==null) {
			return x;
		}
		if(x.key>key) {
			return search(x.l,key);
		}
		
		return search(x.r,key);
	
	}
	 void  insert(int k) {
		if(root==null) {
			root=new node(k);
		}
		else {
			node temp=root;
			if(k>temp.key) {
				while(temp.r!=null) {
					temp=temp.r;
				}
				if(temp.key<k) {
				temp.r=new node(k);
				temp.r.p=temp;
				}
				else {
				temp.l=new node(k);
				temp.l.p=temp;
				}
			}
			else {
				while(temp.l!=null) {
					temp=temp.l;
				}
			if(temp.key>k) {
			temp.l=new node(k);
			temp.l.p=temp;
			}
			else {
			temp.r=new node(k);
			temp.r.p=temp;
			}
			}
		}
		
	}
	 void delete(node s,int k) {
		 bst obj1=new bst();
		 node x=new node(1);
		 x=obj1.search(s,k);
		 
		 if(x.r==null && x.l==null) {
			 if(x.p.l==x) {
				 x.p.l=null;
				 x.p=null;
			 }
			 else {
				 x.p.r=null;
				 x.p=null;
			 }	
		 }
		 else if(x.r==null) {
			 if(x.p.l==x) {
				 x.p.l=x.l;
				 x.p=x.l;
			 }
			 else {
				 x.p.r=x.l;
				 x.p=x.l;
			 }	
			
		 }
		 else if(x.l==null) {
			 if(x.p.l==x) {
				 x.p.l=x.r;
				 x.p=x.r;
			 }
			 else {
				 x.p.r=x.r;
				 x.p=x.r;
			 }	
			 
		 }
		 else {
			 node z=new node(1);
			 z=obj1.next_larger(x);
			 x.key=z.key;
			 if(z.r==null) {
				 z.p=null;
			 }
			 else {
				 z.p.l=z.r;
				 z.r.p=z.p;
			 }
		 }
	 }
	 
	 node next_larger(node x) {
		 if(x.r!=null) {
			 node temp=x.r;
			 while(temp.l!=null) {
				 temp=temp.l;
			 }
			 return temp;
		 }
		 else {
			 if(x.p.l==x) {
				 return x.p;
			 }
			 else {
				 node temp=x.p;
				 while(temp.p.l!=temp && temp.p!=null) {
					 temp=temp.p;
				 }
				 return temp;
			 }
			 
		 }
	 }
	 void inorder(node x) {
		 if(x!=null) {
			 inorder(x.l);
			 System.out.print(x.key+" ");
			 inorder(x.r);
		 }
	 }
	public static void main(String[] args) {
		
		bst obj=new bst();
		obj.insert(50);
		obj.insert(30);
		obj.insert(20);
		obj.insert(40);
		obj.insert(70);
		obj.insert(60);
		obj.insert(80);
		obj.delete(obj.root,30 );
		obj.delete(obj.root,40);
		System.out.println(obj.root.l.key);
		obj.inorder(obj.root);
		
	}

}
