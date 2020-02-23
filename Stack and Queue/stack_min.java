import java.util.*;
class stack_min
{
 static class stack
 {
   Stack<Integer> s1=new Stack<Integer>();
   int min;
   
   void push_ele(int d)
   {
      if(s1.isEmpty())
	  {  s1.push(d);
         min=d;
      }
	  else if (d<min)
	  {
		  min=d;
		  s1.push(2*d-min);
	  }
	  else
		  s1.push(d);
   }
   void find_min()
   {
	   if(s1.isEmpty())
		   System.out.println("Stack empty");
	   else
		   System.out.println("minimum element is "+min);
   }
   void pop_ele()
   {
	   if (s1.isEmpty())
		   System.out.println("Stack empty");
	   else
	   {
	   int poped=s1.pop();
	   if (poped<min)
	   {
		   System.out.println(min);
		   min=2*min-poped;
	   }
	   else
		   System.out.println(poped);
	   }   
   }

 };
   public static void main(String a[])
   {
	   stack sobj=new stack();
	   Scanner s=new Scanner(System.in);
	   System.out.println("stack operations");
	   System.out.println("1.push");
	   System.out.println("2.pop");
	   System.out.println("3.find minimum");
	   System.out.println("4.break");
	   while(true)
	   {
	   int ch=s.nextInt();
	   switch(ch)
	   {
		   case 1:
		    System.out.println("enter element to push");
			int d=s.nextInt();
			sobj.push_ele(d);
			break;
		   case 2:
		    sobj.pop_ele();
			break;
		   case 3:
		    sobj.find_min();
			break;
		   default:
		    System.exit(0);
	   }
	 }
	 }
   }
