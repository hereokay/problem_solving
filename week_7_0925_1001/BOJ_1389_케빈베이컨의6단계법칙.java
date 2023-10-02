package week_7_0925_1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static java.lang.Math.min;

public class BOJ_1389_케빈베이컨의6단계법칙 {
    static int n;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        List<Pair> graph[] = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i]= new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);

            graph[a].add(new Pair(b,1));
            graph[b].add(new Pair(a,1));
        }
        int mini = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 1; i <= n; i++) {
            int ret = getNumber(graph, i);
            if (mini > ret){
                mini = ret ;
                idx = i;
            } else if (mini == ret) {
                idx = min(idx,i);
            }
        }

        System.out.println(idx);
    }

    private static int getNumber(List<Pair> graph[], int node) {
        int[] visited = new int[n+1];
        int[] numbers = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            numbers[i]=Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> q = new PriorityQueue();
        q.add(new Pair(node, 0));

        while(!q.isEmpty()){
            Pair cur = q.poll();
            if (visited[cur.node]==1){
                continue;
            }
            visited[cur.node]=1;

            for (int i = 0; i < graph[cur.node].size(); i++) {
                Pair child = graph[cur.node].get(i);

                if (numbers[child.node] > numbers[cur.node]+child.weight){
                    numbers[child.node] = numbers[cur.node]+child.weight;
                    q.add(new Pair(child.node, numbers[child.node]));
                }
            }
        }

        int ret = 0;
        for (int i = 1; i <= n; i++) {
            ret += numbers[i];
        }

        return ret;
    }
    static class Pair implements Comparable<Pair>{
        int node;
        int weight;

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
