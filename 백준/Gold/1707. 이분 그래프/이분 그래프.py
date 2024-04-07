import sys
from collections import deque
input = sys.stdin.readline

t = int(input())

def bfs(v):
    q= deque()
    q.append(v)
    visited[v] = 1
    while q:
        cur = q.popleft()
        for n in graph[cur]:
            if visited[n] == 0:
                visited[n]= -visited[cur]
                q.append(n)
            elif visited[n] == visited[cur]:
                return False
    return True

for _ in range(t):
    n, m = map(int, input().split())
    graph = [[] for _ in range(n+1)]
    visited = [0]*(n+1)

    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    ans = True
    for i in range(1,n+1):
        if visited[i] == 0:
            ans = bfs(i)
            if not ans:
                break
    print("YES" if ans else "NO")