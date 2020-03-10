
import java.util.*;
class node{
  int data;
  node left=null;
  node right=null;
  node(int d){
   data=d;
  }
}
class Deletion {
  node root=null;
  
  void insert(int d){
    if (this.root==null){
      this.root=new node(d);
    }
    else
    {
      node temp;
      Queue<node> q=new LinkedList<node>();
      q.add(this.root);
      while(!q.isEmpty()){
         temp=q.remove();
         if (temp==null){
            temp=new node(d);
            break;
            }
         else{
           if (temp.left!=null)
             q.add(temp.left);
           else{
             temp.left=new node(d);
             break;
           }
           if (temp.right!=null)
             q.add(temp.right);
           else{
             temp.right=new node(d);
             break;
           }
         }
      }
    }
  }
  void delete(int n){
    Queue<node> q=new LinkedList<node>();
    q.add(this.root);
    node temp=null;
    node key_node=null;
    node parent=null;
    while(!q.isEmpty()){
      temp=q.remove();
      if(temp.left!=null || temp.right!=null)
       parent=temp;
      if(temp.data==n)
        key_node=temp;
      if(temp.left!=null){
        q.add(temp.left);
      }
      if(temp.right!=null){
        q.add(temp.right);
      }
    }
    if (key_node!=null){
      key_node.data=temp.data;
      if(parent.left==temp)
       parent.left=null;
      else if(parent.right==temp)
       parent.right=null;
    }
  }
  void inorder(node temp){
    if (temp==null)
     return;
    inorder(temp.left);
    System.out.print(temp.data+" ");
    inorder(temp.right);

  }
  public static void main(String[] args) {
    Deletion obj=new Deletion();
    Scanner s=new Scanner(System.in);
    int n=s.nextInt();
    while(n!=-1){
      obj.insert(n);
      n=s.nextInt();
    }
    System.out.println("enter a value to delete");
    int del=s.nextInt();
    obj.delete(del);
    obj.inorder(obj.root);
  }
}