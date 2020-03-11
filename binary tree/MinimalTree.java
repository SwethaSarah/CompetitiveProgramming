//construct a binar tree using given sorted array
import java.util.*;
class node{
	int data;
	node left=null;
	node right=null;
	node(int d){
		data=d;
	}
}
class MinimalTree{
	node root;
	node Construct(int[] arr,int start,int end){
		if(start>end)
			return null;
		int mid=(start+end)/2;
		node newnode=new node(arr[mid]);
		newnode.left=Construct(arr,start,mid-1);
		newnode.right=Construct(arr,mid+1,end);
		return newnode;
		
	}
	void printPreorder(node temp){
		if(temp==null)
			return;
		System.out.print(temp.data+" ");
		printPreorder(temp.left);
		printPreorder(temp.right);
		
	}
	public static void main(String a[]){
		Scanner s=new Scanner(System.in);
		MinimalTree obj=new MinimalTree();
		int n=s.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=s.nextInt();
		obj.root=obj.Construct(arr,0,n-1);
		obj.printPreorder(obj.root);
	}
}