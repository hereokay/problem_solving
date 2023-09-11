package jin.week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class BOJ_10971_외판원순회2 {

    static int MAX = 11;
    static int n;
    static int m = Integer.MAX_VALUE;
    static int[] visited = new int[MAX];

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[][] graph = new int[MAX][MAX];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
            visited[i]=0;
        }


        for (int i = 0; i < n; i++) {
            back(graph,i,0,0,i);
        }

        System.out.println(m);
    }


    public static void back(int[][] graph, int cur, int height, int weight,int start){

        if (height==n){
            m= Math.min(m,weight);
        }

        for (int i = 0; i < n; i++) {
            if (graph[cur][i] ==0){
                continue;
            }
            if (visited[i]==1){
                continue;
            }
            if (height==n-1 && i != start){
                continue;
            }

            visited[i]=1;
            back(graph,i,height+1,weight+graph[cur][i],start);
            visited[i]=0;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
