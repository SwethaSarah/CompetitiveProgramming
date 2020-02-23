import java.util.*;
class sort_stack
{
 static class stack
 {
   Stack<Integer> s1=new Stack<Integer>();
   Stack<Integer> s2=new Stack<Integer>();
   
   void enqueue(int d)
   {
      s1.push(d);
   }
   void sort()
   {
	   while(!s1.isEmpty())
	   {
		   int poped=s1.pop();
		   while(!s2.isEmpty() && s2.peek()>poped)
		   {
			   s1.push(s2.pop());
		   }
		   s2.push(poped);
	   }
	   while(!s2.isEmpty())
		   s1.push(s2.pop());
   }
   void print()
   {
	   while(!s1.isEmpty())
	   {
		   System.out.println(s1.pop());
	   }
   }

 };
   public static void main(String a[])
   {
	   stack sobj=new stack();
	   Scanner s=new Scanner(System.in);
	   System.out.println("enter elements");
	   int d=s.nextInt();
	   while(d!=-1)
	   {
			sobj.enqueue(d);
			d=s.nextInt();
	   }
	   sobj.sort();
	   sobj.print();
	 }
   }
