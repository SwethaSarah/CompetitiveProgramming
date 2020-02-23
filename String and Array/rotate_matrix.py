n=int(input())
mat=[input().split() for i in range(n)]
for i in range(n):
  ans=[]
  for j in range(n):
    ans.append(mat[j][i])
  print(*ans)

