def check_one_away(str1,str2):
 if(abs(len(str1)-len(str2))>1):
   return False
 i=j=0
 count=0
 while i<len(str1) and j<len(str2):
   if str1[i]!=str2[j]:
    count+=1
   i+=1
   j+=1
 while i<len(str1):
   count+=1
   i+=1
 while j<len(str2):
   count+=1
   j+=1
 return count<=1

string1=input()
string2=input()
if check_one_away(string1,string2):
 print('YES')
else:
 print('NO')

    