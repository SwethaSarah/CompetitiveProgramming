string1=input()
string2=input()
dic={}
stack=[]
rev_string1=string1[::-1]
if rev_string1!=string1:
     print("input string is not pallindrome")
     exit()
else:
  for i in string1:
    if i not in dic.keys():
      dic[i]=1
    else:
      dic[i]+=1
  for j in string2:
    if j not in dic.keys():
      print('Not permutation')
    else:
      dic[j]-=1
  if max(dic.values())==0 and min(dic.values())==0:
   print('permutated')
  else:
   print('not permutation')