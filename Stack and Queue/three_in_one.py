ONE=1
TWO=2
THREE=3

class Stack:
  def __init__(self):
    self.stack=[]
    self.sptr1=0
    self.sptr2=0
    self.sptr3=0
  
  def push(self,stackId,value):
    if (stackId==ONE and self.sptr1<10):
      self.stack.insert(self.sptr1,value)
      self.sptr1+=1   
      self.sptr2+=1 
      self.sptr3+=1        
    elif (stackId==TWO and self.sptr2-self.sptr1<10):
      self.stack.insert(self.sptr2,value) 
      self.sptr2+=1 
      self.sptr3+=1
    elif (stackId==THREE and self.sptr3-self.sptr2<10):
      self.stack.insert(self.sptr3,value)  
      self.sptr3+=1       

  def stackPop(self,stackId):
    if (stackId==ONE and self.sptr1>0):
      self.stack.pop(self.sptr1-1)
      self.sptr1-=1   
      self.sptr2-=1 
      self.sptr3-=1 
     
    elif (stackId==TWO and self.sptr2-self.sptr1>0):
      self.stack.pop(self.sptr2-1)
      self.sptr2-=1 
      self.sptr3-=1 

    elif (stackId==THREE and self.sptr3-self.sptr2>0):
      self.stack.pop(self.sptr3-1) 
      self.sptr3-=1     

  def printstack(self):
    print(self.stack)

s=Stack()
totalData=int(input())
for i in range(totalData):
  stackId,value=map(int,input().split())
  s.push(stackId,value)

print("original stack")
s.printstack()
while True:
  stackId=int(input())
  if stackId==-1:
    break
  else:
    s.stackPop(stackId)
  print("after poping stack ",stackId)
  s.printstack()