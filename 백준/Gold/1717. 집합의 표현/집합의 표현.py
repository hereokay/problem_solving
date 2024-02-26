import sys
input = sys.stdin.readline

sys.setrecursionlimit(10**7)

def find(a):
    if parent[a] == a:
        return a

    p = find(parent[a])
    parent[a]=p
    return p

def union(a,b):
    a = find(a)
    b = find(b)

    if a==b:
        return

    if a< b:
        parent[b] = a
    else:
        parent[a] = b


n,m = map(int ,input().split())

parent = [i for i in range(n+1)]

for _ in range(m):
    o, a, b = map(int ,input().split())

    if o==0:
        union(a,b)
    else:
        if find(a)==find(b):
            print('YES')
        else:
            print('NO')
