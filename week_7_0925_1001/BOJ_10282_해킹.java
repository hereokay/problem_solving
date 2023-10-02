package week_7_0925_1001;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static java.lang.Math.max;

public class BOJ_10282_해킹 {
    static class Pair implements Comparable<Pair>
    {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int time = 0; time < t; time++) {
            take(br);

        }
    }
    static int n;
    public static void take(BufferedReader br) throws IOException {
        String[] inputs = br.readLine().split(" ");

        n = Integer.parseInt(inputs[0]);
        int d = Integer.parseInt(inputs[1]);
        int c = Integer.parseInt(inputs[2]);

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < d; i++) {
            String[] inputs2 = br.readLine().split(" ");
            int a = Integer.parseInt(inputs2[0]);
            int b = Integer.parseInt(inputs2[1]);
            int s = Integer.parseInt(inputs2[2]);

            graph.get(b).add(new Pair(a,s));
        }

        int[] ans = dijk(graph, c);
        System.out.println(String.valueOf(ans[0])+" "+String.valueOf(ans[1]));

    }
    public static int[] dijk(List<List<Pair>> graph, int c){

        int[] distance = new int[n+1];
        int[] visited = new int[n+1];

        for (int i = 1; i <= n; i++) {
            distance[i]=Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> q = new PriorityQueue<>();

        distance[c]=0;
        q.add(new Pair(c,0));

        while (!q.isEmpty()){
            Pair minNode = getMinNode(q);

            if (visited[minNode.node]==1){
                continue;
            }
            visited[minNode.node]=1;
            update(graph,distance,minNode.node,q);
        }

        int cnt = 0;
        int weight=0;

        for (int i = 1; i <= n; i++) {
            if (visited[i]==1){
                cnt+=1;
                weight = max(
                        weight,
                        distance[i]
                );
            }
        }

        return new int[] {cnt, weight};
    }

    public static Pair getMinNode(PriorityQueue<Pair> q){
        return q.poll();
    }

    public static void update(List<List<Pair>> graph, int[]distance,int node, PriorityQueue<Pair> q){
        for (int i = 0; i < graph.get(node).size(); i++) {
            Pair child = graph.get(node).get(i);

            if (distance[child.node] > distance[node]+child.weight){
                distance[child.node] = distance[node]+child.weight;
                q.add(new Pair(child.node,distance[child.node]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
