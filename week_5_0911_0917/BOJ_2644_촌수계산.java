package week_5_0911_0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2644_촌수계산 {
    static int MAX = 100+1;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int m = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new LinkedList();
        for (int i = 0; i < n+1; i++) {
            graph.add(new LinkedList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int v = Integer.parseInt(s1[0]);
            int u = Integer.parseInt(s1[1]);
            //graph.get(v).add(u);
            graph.get(u).add(v); //자식 -> 부모
        }
        int[] sigA = new int[MAX];
        int[] sigB = new int[MAX];

        // a로 부터 부모로 타고 올라가면서 표시
        upSearch(graph,sigA,a);

        // b로 부터 부모로 타고 올라가면서 표시
        upSearch(graph,sigB,b);

        // 2겹이 하나도 없으면 1리턴
        if(!isVaild(n,sigA,sigB)){
            System.out.println(-1);
            return;
        }

        // single 표시의 합 = 정답
        int cnt =getSumSinglePoint(n,sigA,sigB);
        System.out.println(cnt);
    }
    public static boolean isVaild(int n, int[] sigA, int[] sigB){
        for (int i = 0; i < n; i++) {
            if (sigA[i]==1 && sigB[i]==1){
                return true;
            }
        }

        return false;
    }
    public static void upSearch(List<List<Integer>> graph, int[] sig, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        sig[start]=1;
        while(!q.isEmpty()){
            Integer child = q.remove();
            if (graph.get(child).isEmpty()){
                return;
            }
            else{
                Integer parent = graph.get(child).get(0);
                q.add(parent);
                sig[parent]=1;
            }
        }
    }

    public static int getSumSinglePoint(int n, int[] sigA, int[] sigB){
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            if (sigA[i]==1 && sigB[i]==1){
                continue;
            }
            if (sigA[i]==0 && sigB[i]==0){
                continue;
            }
            ret += 1;

        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
