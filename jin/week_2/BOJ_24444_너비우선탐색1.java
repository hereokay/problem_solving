package jin.week_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// 24444 알고리즘 수업 - 너비웃
public class BOJ_24444_너비우선탐색1 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int r = Integer.parseInt(s[2]);
        int MAX = 200000+1;

        ArrayList<Integer>[] graph = new ArrayList[MAX];

        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            String[] inp = br.readLine().split(" ");
            int u = Integer.parseInt(inp[0]);
            int v = Integer.parseInt(inp[1]);

            graph[v].add(u);
            graph[u].add(v);
        }

        for(int i=1;i<m;i++){
            Collections.sort(graph[i]);
        }

        int[] visited = new int[MAX];
        for(int i=0;i<MAX;i++){
            visited[i]=0;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(r);
        int visitCount=2;
        visited[r]=1;
        while(!q.isEmpty()){
            int cur = q.peek();
            q.remove();

            for(int i=0; i<graph[cur].size(); i++){
                int next = graph[cur].get(i);
                if (visited[next]==0){
                    q.add(next);
                    visited[next]=visitCount;
                    visitCount+=1;
                }
            }
        }

        for(int i=1;i<=n;i++){
            System.out.println(visited[i]);
        }


    }

    public static void main(String[] args) throws Exception {
        new BOJ_24444_너비우선탐색1().solution();
    }
}

