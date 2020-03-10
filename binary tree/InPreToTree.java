import java.util.*;
class node{
  char data;
  node left=null;
  node right=null;
  node(char d){
   data=d;
  }
}
class InPreToTree {
  node root=null;
  static int index=0;
  
  void insert(char d){
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
  node build_tree(char in[],char[] pre,int start,int end){
    if (start>end){
      return null;
    }
    node newnode=new node(pre[index++]);
    if(start==end){
      return newnode;
    }
    int ind=search(in,start,end,newnode.data);
   newnode.left=build_tree(in,pre,start,ind-1);
    newnode.right=build_tree(in,pre,ind+1,end);
    return newnode;

  }
  int search(char[] in,int s,int l,char d){
    int i;
    for(i=s;i<=l;i++){
      if (in[i]==d)
      return i;
    }
    return i;
  }

  void inorder(node temp){
    if (temp==null)
     return;
    inorder(temp.left);
    System.out.print(temp.data+" ");
    inorder(temp.right);

  }
  public static void main(String[] args) {
    InPreToTree obj=new InPreToTree();
    Scanner s=new Scanner(System.in);
    int len=s.nextInt();
    char[] in=new char[len];
    char[] pre=new char[len];
    for(int i=0;i<len;i++)
      in[i]=s.next().charAt(0);
    for(int i=0;i<len;i++)
      pre[i]=s.next().charAt(0);
    node root=obj.build_tree(in,pre,0,len-1);
    obj.inorder(root);
  }
}