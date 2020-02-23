n=int(input())
mat=[input().split() for i in range(n)]
row=[]
col=[]
for i in range(n):
  for j in range(n):
    if mat[i][j]=='0':
     row.append(i)
     col.append(j)
for i in range(len(row)):
  mat[row[i]]=[0]*n
for j in range(len(col)):
  for i in range(n):
    mat[i][col[j]]=0
print(mat)
for i in mat:
  print(*i)
    
