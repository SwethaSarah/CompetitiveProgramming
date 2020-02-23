import java.util.Scanner;
class remove_duplicate
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
 void remove_dups()
{
  node ptr1=null,ptr2=null;
  ptr1=head;
  while(ptr1!=null && ptr1.next!=null)
{
  ptr2=ptr1;
  while(ptr2.next!=null)
{
  if (ptr1.data==ptr2.next.data)
   ptr2.next=ptr2.next.next;
  else
   ptr2=ptr2.next;
}
ptr1=ptr1.next;
}
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
remove_duplicate list=new remove_duplicate();
while(true)
{
	int d=s.nextInt();
	if(d!=-1)
      list.insert(d);
    else
		break;
}
System.out.println("linked list before removing duplicates:");
list.printlist(head);
list.remove_dups();
System.out.println("");
System.out.println("linked list after removing duplicates:");
list.printlist(head);
}
}
    