import java.util.*;
class Loop_detection
{
  static node head,last;
  static class node
 { 
  int data;
  node next;
  node(int d)
 {
   data=d;
   next=null;
 }
}
 boolean find_loop()
 {
	node slow=head;
    node fast=head;
    while(fast!=null || slow!=null)
	{
		if (slow==fast)
			return true;
		slow=slow.next;
		fast=fast.next.next; 
	}
	return false;
    	
}
void insert(int d)
{
node newnode=new node(d);
if (head==null)
  head=newnode;
else
{ 
  newnode.next=head;
  head=newnode;
}
last=newnode;
}
void make_loop()
{
	 last.next=head;
}
void printlist(node n)
{
while(n.next!=null)
{
System.out.print(n.data+" ");
n=n.next;
}
System.out.print(n.data);
}
public static void main(String a[])
{
Scanner s=new Scanner(System.in);
Loop_detection list=new Loop_detection();
while(true)
{
	int d=s.nextInt();
	if(d!=-1)
      list.insert(d);
    else
		break;
}
System.out.println("linked list:");
list.printlist(head);
System.out.println("");
list.make_loop();
boolean flag=list.find_loop();
if (flag)
System.out.println("loop detected");
else
	System.out.println("no loop");
}
}