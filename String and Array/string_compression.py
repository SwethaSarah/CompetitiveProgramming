string=input()
ans=''
char=string[0]
count=1
for i in range(1,len(string)):
  if string[i]!=char:
    ans+=char+str(count)
    char=string[i]
    count=1
  else:
    count+=1
ans+=char+str(count)
print(ans)
   
   
