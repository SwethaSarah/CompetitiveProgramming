import java.util.*;
class node{
	int data;
	node left=null;
	node right=null;
	node(int d){
		data=d;
	}
}
class FirstCommonAncestor{
	node root;
	static boolean v1,v2;
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
	node findLCAUtil(node Node,int n1,int n2){
		if (Node==null)
			return null;
		node temp=null;
		if(Node.data==n1){
			v1=true;
			temp=Node;
		}
		if(Node.data==n2){
			v2=true;
			temp=Node;
		}
		node Left=findLCAUtil(Node.left,n1,n2);
		node Right=findLCAUtil(Node.right,n1,n2);
		if(temp!=null)
			return temp;
		if(Left!=null && Right!=null)
			return Node;
		return (Left!=null?Left:Right);
	}
	node findLCA(node temp,int n1,int n2){
		v1=false;
		v2=false;
		node ans=findLCAUtil(temp,n1,n2);
		if(v1&&v2)
			return ans;
		return null;
	}
	
    public static void main(String a[]){
		Scanner s=new Scanner(System.in);
		FirstCommonAncestor obj=new FirstCommonAncestor();
	    int i=s.nextInt();
		while(i!=-1)
		{
			obj.insert(i);
			i=s.nextInt();
		}
		int n1=s.nextInt();
		int n2=s.nextInt();
		node ans=obj.findLCA(obj.root,n1,n2);
		System.out.println(ans!=null?ans.data:"NULL");		
	}	
}