package week_4_0904_0910;

import Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_5567_결혼식 {
    static class Pair{
        private int a;
        private int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
    static int n;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m =  Integer.parseInt(br.readLine());

        int[][] graph = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            int v = Integer.parseInt(split[0]);
            int u = Integer.parseInt(split[1]);
            graph[v][u]=1;
            graph[u][v]=1;
        }
        bfs(1,graph);
        System.out.println(cnt);
    }
    static final int MAX = 501;
    static int[] visited = new int[MAX];
    static int cnt = 0;
    public static void bfs(int start,int[][] graph){
        visited[start]=1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start,0));
        while(!queue.isEmpty()){

            Pair cur = queue.remove();
            int x = cur.getA();
            int depth = cur.getB();

            if (depth==2){
                continue;
            }

            for (int i = 1; i < n+1; i++) {
                if (visited[i]==1){
                    continue;
                }
                if (graph[x][i]!=1){
                    continue;
                }

                visited[i]=1;
                cnt+=1;
                queue.add(new Pair(i,depth+1));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
