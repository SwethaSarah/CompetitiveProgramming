import java.util.*;
import java.lang.Math;
class node{
	int data;
	node left;
	node right;
	node(int d){
		data=d;
	}
}
class Continuous{
	node root;
	void insert(char[] arr,int d){
		int i=0;
		if(this.root==null){
			this.root=new node(d);
			return;
		}
		node temp=this.root;
		while(i<arr.length){
			if(arr[i]=='L'){
				if(temp.left==null)
					temp.left=new node(d);
				else
					temp=temp.left;
			}
			else{
				if(arr[i]=='R'){
				if(temp.right==null)
					temp.right=new node(d);
				else
					temp=temp.right;
			}
			}
			i++;
		}
		return;
		
	}
	boolean check(node temp)
	{
		if (temp==null)
			return true;
		if(temp.right==null && temp.left==null)
			return true;
		if (temp.left==null)
			return (Math.abs(temp.data-temp.right.data)==1) && check(temp.right);
		if (temp.right==null)
			return (Math.abs(temp.data-temp.left.data)==1) && check(temp.left);
		return Math.abs(temp.data-temp.left.data)==1 && Math.abs(temp.data-temp.right.data)==1&&check(temp.right)&&check(temp.left);
	}
	public static void main(String a[]){
		Scanner s=new Scanner(System.in);
		Continuous obj=new Continuous();
		int len=s.nextInt();
		for(int i=0;i<len;i++)
		{	
	        int d=s.nextInt();
	        String str=s.next();
			char[] arr=str.toCharArray();
			obj.insert(arr,d);
		}   
		    
		System.out.print(obj.check(obj.root));
		
	}
}