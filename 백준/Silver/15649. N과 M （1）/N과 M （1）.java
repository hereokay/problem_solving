import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {

        String[] inp = br.readLine().split(" ");
        N = Integer.parseInt(inp[0]);
        int M = Integer.parseInt(inp[1]);



        boolean[] visited = new boolean[N + 1];

        dfs(M,0,visited, new int[N+1]); // 현재 idx
    }

    private static void dfs(int limit, int depth, boolean[] visited, int[] value) {

        // 종료조건
        if (limit==depth){
            // value 출력
            for (int i = 0; i < limit; i++) {
                // limit 개
                System.out.print(String.valueOf(value[i+1])+" ");
            }
            System.out.println();
            return ;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]){
                // value[depth]  : 기존값
                value[depth+1]= i;
                visited[i]=true;
                dfs(limit,depth+1,visited,value);
                visited[i]=false;
            }
        }
    }

}