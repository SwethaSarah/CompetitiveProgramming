import java.util.*;
class Node
{
	String data;
	Node next;
	int arrivaltime;
	Node(String value,int time)
	{
		data=value;
		arrivaltime=time;
	}
}
class animalshelter
{
	Node head;
	
void enqueue(String value,int time)
{
  Node newnode=new Node(value,time);
  Node temp=this.head;
  if(this.head==null)
  {
    this.head=newnode;
  }
  else
  {
    while(temp.next!=null)
  {
  temp=temp.next;
  }
  temp.next=newnode;
  }
}

void deQueue()
{
	if(head!=null)
	{
     String ans=this.head.data;
     this.head=this.head.next;
     System.out.println(ans);
	}
	else
		System.out.println("No animal found");
}

void dequeueAny(animalshelter dog,animalshelter cat)
{
   if(dog.head!=null && cat.head!=null)
   {
	String ans="";
	if(dog.head.arrivaltime<cat.head.arrivaltime)
	{
     ans=dog.head.data;
     dog.head=dog.head.next;
	}
    else
    {
	 ans=cat.head.data;
     cat.head=cat.head.next;
	}
	System.out.println(ans);
   }
   else if(dog.head!=null)
   {
	   dog.deQueue();
   }
   else
	   cat.deQueue();
}

public static void main(String[] arg)
{
Scanner sc=new Scanner(System.in);
int tc=sc.nextInt();
animalshelter cat=new animalshelter();
animalshelter dog=new animalshelter();
animalshelter any=new animalshelter();
int time=0;
for(int i=0;i<tc;i++)
{
 System.out.println("Enter animal");
 String animal=sc.next();
 System.out.println("Enter action");
 String action=sc.next();
 if(animal.equals("cat") && action.equals("enqueue"))
 {
  System.out.println("Enter animal name");
  String animalname=sc.next();
  cat.enqueue(animalname,time);
  time++;
 }
 else if(animal.equals("dog") && action.equals("enqueue"))
 {
  System.out.println("Enter animal name");
  String animalname=sc.next();
  dog.enqueue(animalname,time);
  time++;
 }
 else if(animal.equals("cat")&& action.equals("dequeue"))
 {
	cat.deQueue();
 }
 else if(animal.equals("dog") && action.equals("dequeue"))
 {
	dog.deQueue();
 }
 else if(animal.equals("any") && action.equals("dequeue"))
 {
	any.dequeueAny(cat,dog);
 }
}
}
}