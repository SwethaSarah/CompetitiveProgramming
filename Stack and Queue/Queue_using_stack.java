import java.util.*;
class Queue_using_stack
{
 static class Queue
 {
   Stack<Integer> s1=new Stack<Integer>();
   Stack<Integer> s2=new Stack<Integer>();
   
   void enqueue(int d)
   {
     while(!s1.isEmpty())
	  s2.push(s1.pop());
	 s1.push(d);
     while(!s2.isEmpty())
       s1.push(s2.pop());	 
   }
   int dequeue()
   {
     if(s1.isEmpty())
	 {
      System.out.println("stack empty");
	  System.exit(0);
	 }
	 return s1.pop();
   }
 };
   public static void main(String a[])
   {
	   Queue q=new Queue();
	   Scanner s=new Scanner(System.in);
	   System.out.println("Queue using stack");
	   System.out.println("1.enqueue");
	   System.out.println("2.dequeue");
	   System.out.println("3.break");
	   while(true)
	   {
	   int ch=s.nextInt();
	   switch(ch)
	   {
		   case 1:
		    System.out.println("enter element to enqueue");
			int d=s.nextInt();
			q.enqueue(d);
			break;
		   case 2:
		    System.out.println(q.dequeue());
			break;
		   default:
		    System.exit(0);
	   }
	 }
   }
}