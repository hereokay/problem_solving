package jin.week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_11724_연결요소의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        List<List<Integer>> graph = new LinkedList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int v = Integer.parseInt(s1[0]);
            int u = Integer.parseInt(s1[1]);

            graph.get(v).add(u);
            graph.get(u).add(v);
        }

        int[] visited = new int[n + 1];
        int ans =0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]==0){
                ans+=1;
                // BFS 실행
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i]=1;
                while(!q.isEmpty()){
                    int cur = q.remove();
                    for (int j = 0; j < graph.get(cur).size(); j++) {
                        int next = graph.get(cur).get(j);
                        if (visited[next]==0){
                            q.add(next);
                            visited[next]=1;
                        }
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
