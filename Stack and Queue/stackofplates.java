import java.util.*;
class stackofplates
{
   Stack<Stack> set=new Stack<Stack>();
   int size;
   
   void push_ele(int d)
   {
      if(set.isEmpty())
	  { 
        Stack<Integer> s1=new Stack<Integer>();
        set.push(s1);
		s1.push(d);
      }
	  else if(set.peek().size()==size)
	  {  
          Stack<Integer> s1=new Stack<Integer>();
	      set.push(s1);
		  s1.push(d);
	  }
	  else
	  {
		  Stack<Integer> s1=set.pop();
		  s1.push(d);
		  set.push(s1);
		  
	  }
   }
   void pop_ele()
   {
	   if (set.isEmpty())
		   System.out.println("Stack empty");
	   else
	   {
		   Stack<Integer> s=set.pop();
		   System.out.println(s.pop());
		   if(!s.isEmpty())
		   {
			   set.push(s);
		   }
	   }   
   }

   public static void main(String a[])
   {
	   stackofplates sobj=new stackofplates();
	   Scanner s=new Scanner(System.in);
	   System.out.println(" Enter stack size");
	   int size=s.nextInt();
	   System.out.println("stack operations");
	   System.out.println("1.push");
	   System.out.println("2.pop");
	   System.out.println("3.break");
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
		   default:
		    System.exit(0);
	   }
	 }
	 }
   }
