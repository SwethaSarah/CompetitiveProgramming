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
class CheckForBST{
	node root;
	static node prev=null;
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
	boolean check(node temp){
       if(temp!=null){
		   if(!check(temp.left))
			   return false;
		   if(prev!=null && temp.data<=prev.data)
			   return false;
		   prev=temp;
		   return check(temp.right);
	   }
	   return true;
	}
	
    public static void main(String a[]){
		Scanner s=new Scanner(System.in);
		CheckForBST obj=new CheckForBST();
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
		System.out.print(obj.check(obj.root));
	}	
}