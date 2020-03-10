import java.util.*;
class node{
	int data;
	node left=null;
	node right=null;
	node(int d){
		data=d;
	}
}
class prev{
		static node pnode;
		prev()
		{
		pnode=null;
		}
	}
class InorderSuccessor{
	node root;
	void insert(int d){
		Queue<node> q=new LinkedList<node>();
		if (this.root==null){
			this.root=new node(d);
			return;
		}
		q.add(this.root);
		while(!q.isEmpty()){
			node temp=q.remove();
			if(temp.left==null)
			{
				temp.left=new node(d);
				break;
			}
			else
				q.add(temp.left);
			if(temp.right==null)
			{	temp.right=new node(d);
			    break;
			}
			else
				q.add(temp.right);
		}
	}
	void find(node root,node pnode,int n){
		if(root.right!=null)
			find(root.right,pnode,n);
		if (root.data==n)
		{
		 System.out.println(prev.pnode==null?"null":prev.pnode.data);
		}
		prev.pnode=root;
		if(root.left!=null)
			find(root.left,pnode,n);
		
	}
    public static void main(String a[]){
		Scanner s=new Scanner(System.in);
		InorderSuccessor obj=new InorderSuccessor();
	    int i=s.nextInt();
		while(i!=-1)
		{
			obj.insert(i);
			i=s.nextInt();
		}
		int n=s.nextInt();
		obj.find(obj.root,prev.pnode,n);
		
	}	
}