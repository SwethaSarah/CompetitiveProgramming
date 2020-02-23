import java.util.Scanner;
class Partition
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
 node partition(int x)
{
  node less=null,great=null,equal=null,lesslast=null,equallast=null,greatlast=null;
  node temp=head;
  while(temp!=null)
  {
	  if (temp.data<x)
	  {
		  if (less==null)
		  {
			  less=lesslast=temp;
		  }
		  else
		  { 
		   lesslast.next=temp;
		   lesslast=lesslast.next;
	      }
	  }
	  else if(temp.data==x)
	  {
		  if (equal==null)
		  {
			  equal=equallast=temp;
		  }
		  else
		  {equallast.next=temp;
		   equallast=equallast.next;
	      }
	  }
	  else
	  {
		  if (great==null)
		  {
			  great=greatlast=temp;
		  }
		  else
		  {
		   greatlast.next=temp;
		   greatlast=greatlast.next;
	      }
	  }
	temp=temp.next;
  }
  if(greatlast!=null)
	  greatlast.next=null;
  if (less == null)  
    {  
        if (equal == null)  
            return great;  
        equallast.next = great;  
        return equal;  
    }  
    
    if (equal == null)  
    {  
        less.next = great;  
        return less;  
    }  
    lesslast.next=equal;
    equallast.next=great;
  return less;
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
Partition list=new Partition();
while(true)
{
	int d=s.nextInt();
	if(d!=-1)
      list.insert(d);
    else
		break;
}
System.out.println("linked list before partitioning:");
list.printlist(head);
System.out.println("");
System.out.println("enter partition value");
int p=s.nextInt();
head=list.partition(p);
System.out.println("");
System.out.println("linked list after  partitioning");
list.printlist(head);
}
}