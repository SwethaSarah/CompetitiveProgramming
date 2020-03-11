import java.util.*;
class node{
	int data;
	node left;
	node right;
	node(int d){
		data=d;
	}
}
class llnode{
	int data;
	llnode next=null;
	llnode(int d){
		data=d;
	}
}
class ListsOfDepth{
	node root;
	llnode head;
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
	void PrintListsOfDepth(){
		if(this.root==null)
			return;
		Queue<node> q=new LinkedList<node>();
		q.add(this.root);
		while(!q.isEmpty()){
			int len=q.size();
			while(len>0){
				len-=1;
				node temp=q.remove();
				llnode newnode=new llnode(temp.data);
				llnode tem=this.head;
				if(tem==null){
					this.head=newnode;
				}
				else{
				    while(tem.next!=null)
						tem=tem.next;
					tem.next=newnode;
				}
				if(temp.left!=null)
						q.add(temp.left);
				if(temp.right!=null)
						q.add(temp.right);
			}
			printlist(this.head);
			this.head=null;
		}
	}
	void printlist(llnode head){
		if(head==null)
			return;
		else{
			llnode temp=this.head;
			while(temp!=null){
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
		}
		System.out.println("");
	}
	public static void main(String a[]){
		Scanner s=new Scanner(System.in);
		ListsOfDepth obj=new ListsOfDepth();
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
		obj.PrintListsOfDepth();
	}
}
