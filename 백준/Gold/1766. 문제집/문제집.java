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


    public static void main(String[] args) throws IOException {

        String[] inp = br.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int m = Integer.parseInt(inp[1]);

        int[] degree = new int[n + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            inp = br.readLine().split(" ");
            int a = Integer.parseInt(inp[0]);
            int b = Integer.parseInt(inp[1]);
            // a를 b보다 먼저 풀어야함
            degree[b]++; // b를 풀기우히ㅐ
            adj.get(a).add(b); // a를 풀면 b를 풀수 있어
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (degree[i]==0){
                pq.add(i);
            }
        }

        while (!pq.isEmpty()){

            Integer cur = pq.poll();
            for (int next : adj.get(cur)){
                degree[next]--;
                if (degree[next]==0){
                    pq.add(next);
                }
            }

            System.out.print(String.valueOf(cur)+" ");
        }


    }
}