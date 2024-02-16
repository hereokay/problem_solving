import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int height;
        int inpIndex;

        public Node(int height, int inpIndex) {
            this.height = height;
            this.inpIndex = inpIndex;
        }
    }

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static int[] adjList;
    static boolean[] done;
    static boolean[] visited ;
    static int ans;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int n = Integer.parseInt(br.readLine());

            adjList = new int[n+1];
            done = new boolean[n+1];
            visited = new boolean[n+1];
            ans = 0;

            String[] s = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(s[j]);
                adjList[j+1] = num;
            }

            //TODO DFS
            for (int j = 1; j <= n; j++) {
                if (!done[j]){
                    dfs(j,j);
                }
            }

            System.out.println(n-ans);
        }

    }

    private static void dfs(int v, int start) {
        if (done[v]){
            return ;
        }
        if (visited[v]){
            ans++;
            done[v]=true;

        }

        visited[v]=true;
        dfs(adjList[v],start);

        done[v]=true;
        visited[v]=false;
    }


}
