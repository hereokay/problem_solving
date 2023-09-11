package jin.week_4_0904_0910;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10819_차이를최대로 {
    static int n;
    static int M = Integer.MIN_VALUE;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] intArr = new int[n];
        for (int i = 0; i < n; i++) {
            intArr[i]=Integer.parseInt(split[i]);
            visited[i]=0;
        }
        for (int i = 0; i < n; i++) {
            visited[i]=1;
            back(i,1,0,intArr);
            visited[i]=0;
        }
        System.out.println(M);
    }
    static int[] visited = new int[10];
    public static void back(int cur, int height, int weight,int[] intArr){
        if (height==n){
            M = Math.max(M,weight);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]==1){
                continue;
            }
            visited[i]=1;
            back(i,height+1,weight+Math.abs(intArr[cur]-intArr[i]),intArr);
            visited[i]=0;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}


/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

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


 */