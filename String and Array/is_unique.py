string=input()
dic={}
for i in string:
    if i not in dic.keys():
        dic[i]=1
    else:
        dic[i]+=1
print('Unique' if max(dic.values())==1 else 'Not unique' )
