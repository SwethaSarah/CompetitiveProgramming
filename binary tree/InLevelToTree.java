import java.util.*;
class node{
  int data;
  node left=null;
  node right=null;
  node(int d){
   data=d;
  }
}
class InLevelToTree {
  node root=null;
  static int index=0;
  
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
  node build_tree(int in[],int[] level,int start,int end){
    if (start>end){
      return null;
    }
    node newnode=null;
    if(start==end){
      return new node(in[start]);
    }
    int ind=0;
    boolean found=false;
    for(int i=0;i<=level.length;i++){
      for(int j=start;j<=end;j++){
        if(level[i]==in[j]){
          newnode=new node(level[i]);
          ind=j;
          found=true;
          break;
        }
      }
      if(found){
        break;
      }
    }
   newnode.left=build_tree(in,level,start,ind-1);
   newnode.right=build_tree(in,level,ind+1,end);
    return newnode;
  }
  

  void inorder(node temp){
    if (temp==null)
     return;
    inorder(temp.left);
    System.out.print(temp.data+" ");
    inorder(temp.right);

  }
  public static void main(String[] args) {
    InLevelToTree obj=new InLevelToTree();
    Scanner s=new Scanner(System.in);
    int len=s.nextInt();
    int[] in=new int[len];
    int[] level=new int[len];
    for(int i=0;i<len;i++)
      in[i]=s.nextInt();
    for(int i=0;i<len;i++)
      level[i]=s.nextInt();
    node root=obj.build_tree(in,level,0,len-1);
    obj.inorder(root);
  }
}