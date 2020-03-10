import java.util.*;
class node{
	int data;
	node left;
	node right;
	node(int d){
		data=d;
	}
}
class Mirror{
	node root;
	node insert(int[] arr,int i,node temp){
		if (i<arr.length){
			temp=new node(arr[i]);
			temp.left=insert(arr,2*i+1,temp.left);
			temp.right=insert(arr,2*i+2,temp.right);
		}
		return temp;
	}
	boolean check(node temp1,node temp2)
	{
		if (temp1==null && temp2==null)
			return true;
		if (temp1.data==temp2.data)
			return check(temp1.left,temp2.right) && check(temp1.right,temp2.left);
		return false;
	}
	public static void main(String a[]){
		Scanner s=new Scanner(System.in);
		Mirror obj=new Mirror();
		int len=s.nextInt();
		int[] arr=new int[len];
		for(int i=0;i<len;i++)
			arr[i]=s.nextInt();
		obj.root=obj.insert(arr,0,obj.root);
		System.out.print(obj.check(obj.root,obj.root));
		
	}
}