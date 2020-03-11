//checks if a tree is height balanced or not
import java.util.*;
import java.lang.Math;
class node{
	int data;
	node left=null;
	node right=null;
	node(int d){
		data=d;
	}
}
class Height{
	int height=0;
}
class CheckBalanced{
	node root;
	void insert(char[] arr,int d){
		if(this.root==null)
			this.root=new node(d);
		else{
		int i=0;
		node temp=this.root;
		while(i<arr.length){
			if(arr[i]=='L'){
				if (temp.left!=null)
					temp=temp.left;
				else{
					temp.left=new node(d);
					break;
				}
			}
			else{
				if(temp.right!=null)
					temp=temp.right;
				else{
					temp.right=new node(d);
					break;
				}
			}
			i++;
		}
		}
	}
	boolean check(node temp,Height h){
		if (temp==null){
			h.height=0;
			return true;
		}
	    Height lheight=new Height(),rheight=new Height();
		boolean l=check(temp.left,lheight);
		boolean r=check(temp.right,rheight);
		int lh=lheight.height,rh=rheight.height;
		h.height=(lh>rh?lh:rh)+1;
		if(Math.abs(lh-rh)>1)
			return false;
		else
			return l&&r;
	}
	
    public static void main(String a[]){
		Scanner s=new Scanner(System.in);
		CheckBalanced obj=new CheckBalanced();
		while(true)
		{
			int i=s.nextInt();
			if(i==-1)
				break;
			else{
			String str=s.next();
			char[] arr=str.toCharArray();
			obj.insert(arr,i);
			}
		}
		Height h=new Height();
		System.out.print(obj.check(obj.root,h));
	}	
}