import java.util.*;
class Palindrome
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
 boolean check_palindrome()
 {
	node temp=head;
	Stack<Integer> stack=new Stack<Integer>();
	while(temp!=null)
	{
		stack.push(temp.data);
		temp=temp.next;
	}
	temp=head;
	while(temp!=null)
	{
		if (temp.data!=stack.pop())
			return false;
		temp=temp.next;
	}
	return true;
	
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
Palindrome list=new Palindrome();
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
boolean flag=list.check_palindrome();
if (flag)
System.out.println("palindrome");
else
	System.out.println("not palindrome");
}
}