package testing;



public class avl {
	node root;
	class node{
		int key,h;
		node l,r;
		node(int data){
			key=data;
		}
	}
	void update_height(node x) {
		if(x!=null)
		x.h=Math.max(height(x.r),height(x.l))+1;
	}
	int height(node x) {
		if(x==null)
			return -1;
		else
			return x.h;
	}
	void rebalance(node x) {
		int bf=height(x.r)-height(x.l);
/*right*/if(bf>1) {
			if(height(x.r.r)-height(x.r.l)>1) {
				left_rotate(x);
			}
			else if(height(x.r.r)-height(x.r.l)<-1){
				right_rotate(x.r);
				left_rotate(x);
			}
		}
		else if(bf<-1) {
			if(height(x.l.l)-height(x.l.r)>1) {
				right_rotate(x);
			}
			else if(height(x.l.l)-height(x.l.r)<-1){
				left_rotate(x.l);
				right_rotate(x);
			}
			
		}
	}
	void left_rotate(node y) {
		node t=y.r;
		node u=t.l;
		y.r=u;
		t.l=y;
		update_height(y);
		update_height(t);
		
	}
	void right_rotate(node y) {
		node t=y.l;
		node u=t.r;
		y.l=u;
		t.r=y;
		update_height(y);
		update_height(t);
		
	}
	node insert (node root,int k) {
		if(root==null) {
			return(new node(k));
		}
		if(k<root.key)
			root.l=insert(root.l,k);
		else if(k>root.key)
			root.r=insert(root.r,k);
		else
			return root;
		update_height(root);
		rebalance(root);
		return root;
	}
	node delete(node root,int k) {
		if(root==null) {
			return root;
		}
		if(k<root.key)
			root.l=delete(root.l,k);
		else if(k>root.key)
			root.r=delete(root.r,k);
		else if(k>root.key)
			return root;
		else {
			if(root.l==null || root.r==null) {
				node temp=null;
				if(temp==root.l)
					temp=root.r;
				else
					temp=root.l;
				if(temp==null) {
					temp=root;
					root=null;
				}
				else
					root=temp;
				
			}
			else {
				node temp=minVal(root.r);
				root.key=temp.key;
				root.r=delete(root.r,temp.key);
			}
		}
		if(root==null)
			return root;
		update_height(root);
		rebalance(root);
		return root;
	}
	node minVal(node x) {
		node curr=x;
		while(curr.l!=null) {
			curr=curr.l;
		}
		return curr;
		 
	}
	 void preorder(node x) {
		 if(x!=null) {
			 System.out.print(x.key+" ");
			 preorder(x.l);
			 preorder(x.r);
		 }
	 }
	public static void main(String[] args) {
		 
        avl tree = new avl();  
  
        
        tree.root = tree.insert(tree.root, 9);  
        tree.root = tree.insert(tree.root, 5);  
        tree.root = tree.insert(tree.root, 10);  
        tree.root = tree.insert(tree.root, 0);  
        tree.root = tree.insert(tree.root, 6);  
        tree.root = tree.insert(tree.root, 11);  
        tree.root = tree.insert(tree.root, -1);  
        tree.root = tree.insert(tree.root, 2);  
        tree.root = tree.insert(tree.root, 1);  
        
        tree.preorder(tree.root);
	}

}
