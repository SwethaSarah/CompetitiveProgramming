import java.util.*;
class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } 
class Sum_Linklist 
{ 
  
    Node head;
  
     void insert(int d)
{
Node newnode=new Node(d);
if (this.head==null)
  this.head=newnode;
else
{ 
  newnode.next=this.head;
  this.head=newnode;
}
}
  
    void addTwoLists(Node first, Node second) { 
        int carry = 0, sum; 
  
        while (first != null || second != null) 
        {
            sum = carry + (first != null ? first.data : 0) 
                    + (second != null ? second.data : 0); 
            carry = (sum >= 10) ? 1 : 0; 
            sum = sum % 10; 
            this.insert(sum);
			if(first!=null)
			  first=first.next;
			if(second!=null)
			second=second.next;
        } 
  
        if (carry > 0) { 
            this.insert(carry);
        } 
    } 
    void printList() 
	{	
	   Node temp=this.head;
        while (temp != null) { 
            System.out.print(temp.data + " "); 
            temp = temp.next; 
        } 
        System.out.println(""); 
    } 
 

    public static void main(String[] args) { 
        Sum_Linklist list1 = new Sum_Linklist(); 
		Sum_Linklist list2=new Sum_Linklist();
		Sum_Linklist rs=new Sum_Linklist();
		Scanner s=new Scanner(System.in);
        while(true)
{
	int d=s.nextInt();
	if(d!=-1)
      list1.insert(d);
    else
		break;
}
       while(true)
{
	int d=s.nextInt();
	if(d!=-1)
	{
      list2.insert(d);
	}
    else
		break;
}
        list1.printList();
        list2.printList(); 
        rs.addTwoLists(list1.head,list2.head);
		System.out.print("Resultant List is "); 
        rs.printList();		
    } 
} 