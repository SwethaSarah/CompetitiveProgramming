import java.util.Scanner;
class kth_last
{
  static node head;
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
 void Kthfromlast(int k)
{
  node ptr=head;
  node ahead=head;
  while(k>0)
  {
	  ahead=ahead.next;
	  k-=1;
  }
  while(ahead.next!=null)
  {
   ahead=ahead.next;
   ptr=ptr.next;
  }
  ptr.next=ptr.next.next;

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
kth_last list=new kth_last();
while(true)
{
	int d=s.nextInt();
	if(d!=-1)
      list.insert(d);
    else
		break;
}
System.out.println("linked list before removing Kth last node:");
list.printlist(head);
System.out.println("");
System.out.println("Enter k");
int k=s.nextInt();
list.Kthfromlast(k);
System.out.println("");
System.out.println("linked list after removing Kth last node");
list.printlist(head);
}
}