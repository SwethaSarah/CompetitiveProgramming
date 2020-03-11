import java.util.*;
class node{
	int data;
	node left=null;
	node right=null;
	node(int d){
		data=d;
	}
}
class Int{
		static int data;
	}
class ReplaceSum{
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
	void PrintInorder(node temp){
		if (temp==null)
			return;
		PrintInorder(temp.left);
		System.out.println(temp.data);
		PrintInorder(temp.right);
	}
	void BuildArr(node temp,Vector<Integer> arr){
		if(temp==null)
			return;
		BuildArr(temp.left,arr);
		arr.add(temp.data);
		BuildArr(temp.right,arr);
	}
	void replace(node temp){
		Vector<Integer> arr=new Vector<Integer>();
		arr.add(0);
		BuildArr(temp,arr);
		arr.add(0);
		Int i=new Int();
		i.data=1;
		replaceUtil(temp,i,arr);
	}
	void replaceUtil(node temp,Int i,Vector<Integer> arr){
	  if (temp==null)
	    return;
	  replaceUtil(temp.left,i,arr);
	  temp.data=arr.get(i.data-1)+arr.get(i.data+1);
	  i.data++;
	  replaceUtil(temp.right,i,arr);
	} 
    public static void main(String a[]){
		Scanner s=new Scanner(System.in);
		ReplaceSum obj=new ReplaceSum();
	    int i=s.nextInt();
		while(i!=-1)
		{
			obj.insert(i);
			i=s.nextInt();
		}
		obj.replace(obj.root);
		obj.PrintInorder(obj.root);
		
	}	
}