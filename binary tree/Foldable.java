import java.util.*;
class node{
	int data;
	node left;
	node right;
	node(int d){
		data=d;
	}
}
class Foldable{
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
	boolean check(node temp1,node temp2)
	{
		if (temp1==null && temp2==null) 
			return true;
		if (temp1!=null && temp2!=null)
		return check(temp1.left,temp2.right) && check(temp1.right,temp2.left);
	return false;
	}
	public static void main(String a[]){
		Scanner s=new Scanner(System.in);
		Foldable obj=new Foldable();
		int len=s.nextInt();
		for(int i=0;i<len;i++)
		{	
	        int d=s.nextInt();
	        String str=s.next();
			char[] arr=str.toCharArray();
			obj.insert(arr,d);
		}   
		    
		System.out.print(obj.check(obj.root,obj.root));
		
	}
}