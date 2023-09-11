package jin.week_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_11725_트리의부모찾기 {
    static final int MAX = 100000+1;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Integer>> graph = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n+1; i++) {
            graph.add(new LinkedList<Integer>());
        }

        for (int i = 0; i < n-1; i++) {
            String[] split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            graph.get(v).add(u);
            graph.get(u).add(v);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        int[] visited = new int[MAX];
        int[] parent = new int[MAX];
        visited[1]=1;
        while(!q.isEmpty()){
            int cur = q.remove();
            for(int i=0;i<graph.get(cur).size();i++){
                int next = graph.get(cur).get(i);
                if(visited[next] != 1){
                    q.add(next);
                    visited[next]=1;
                    parent[next]=cur;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            System.out.println(parent[i+1]);
        }
    }

    public static void main(String[] args) throws Exception {
        new BOJ_11725_트리의부모찾기().solution();
    }
}
