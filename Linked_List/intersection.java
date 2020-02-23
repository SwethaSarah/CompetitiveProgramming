import java.util.*;
class node
{
	int data;
	node next;
	node(int d)
	{
		data=d;
		next=null;
	}
}
class intersection
{
	node head,tail;
	
	void push(int d)
	{
		node newnode=new node(d);
		if(head==null)
			head=newnode;
		else
		{
			newnode.next=head;
			head=newnode;
		}
		tail=newnode;
	}
	void find_intersection(node head1,node head2)
	{
		node l1ptr=head1;
		node l2ptr=head2;
		while(l1ptr!=l2ptr)
		{
			if (l1ptr.next!=null)
			 l1ptr=l1ptr.next;
		    else
				l1ptr=head1;
			if (l2ptr.next!=null)
			 l2ptr=l2ptr.next;
		    else
				l2ptr=head2;
			
		}
		System.out.println("intersection node: "+l1ptr.data);
	}
	
public static void main(String a[])
{
	Scanner s=new Scanner(System.in);
	intersection list1=new intersection();
	intersection list2=new intersection();
	System.out.println("list1 element");
	while(true)
	{
		int d=s.nextInt();
		if (d!=-1)
			list1.push(d);
		else
			break;
	}
	System.out.println("list2 element");
	while(true)
	{
		int d=s.nextInt();
		if (d!=-1)
			list2.push(d);
		else
			break;
	}
    list2.tail.next=list1.head.next;
	list1.find_intersection(list1.head,list2.head);
	
}
}