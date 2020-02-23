import java.util.Scanner;
class delete_middle
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
 void delete()
{
  int len=0;
  node temp=head;
  while(temp!=null)
  {
   temp=temp.next;
   len+=1;
  }
  int mid=len/2;
  node temp1=head;
  while(mid>1)
  {
	  temp1=temp1.next;
	  mid-=1;
  }
  temp1.next=temp1.next.next;


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
delete_middle list=new delete_middle();
while(true)
{
	int d=s.nextInt();
	if(d!=-1)
      list.insert(d);
    else
		break;
}
System.out.println("linked list before removing middle element:");
list.printlist(head);
System.out.println("");
list.delete();
System.out.println("");
System.out.println("linked list after removing middle element:");
list.printlist(head);
}
}