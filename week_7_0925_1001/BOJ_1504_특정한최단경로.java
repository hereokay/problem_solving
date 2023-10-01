package week_7_0925_1001;

import java.io.*;

import static java.lang.Math.min;

public class BOJ_1504_특정한최단경로 {
    static int n;
    static int v1;
    static int v2;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);

        int[][] graph = new int[n+1][n+1];
        for (int i = 0; i < e; i++) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            int c = Integer.parseInt(s1[2]);

            graph[a][b]=c;
            graph[b][a]=c;

        }

        String[] s1 = br.readLine().split(" ");
        v1 = Integer.parseInt(s1[0]);
        v2 = Integer.parseInt(s1[1]);

        int sv1 = dijk(graph,1,v1);
        int v1v2 = dijk(graph,v1,v2);
        int v2e = dijk(graph,v2,n);

        int sv2 = dijk(graph,1,v2);
        int v2v1 = v1v2;
        int v1e = dijk(graph,v1,n);

        int ans ;
        if (!isZero(sv1,v1v2,v2e) && !isZero(sv2,v2v1,v1e)){
            ans = min(
                    sv1+v1v2+v2e,sv2+v2v1+v1e
            );
        }
        else if(!isZero(sv1,v1v2,v2e)){
            ans = sv1+v1v2+v2e;
        }
        else if(!isZero(sv2,v2v1,v1e)){
            ans = sv2+v2v1+v1e;
        }
        else{
            ans = -1;
        }


        System.out.println(ans);
    }
    public static boolean isZero(
            int a,
            int b,
            int c
    ){
        if (a==-1){
            return true;
        }
        if (b==-1){
            return true;
        }
        if (c==-1){
            return true;
        }
        return false;
    }


    public static int dijk(int[][] graph, int start, int end){

        int[] visited = new int[n+1];
        int[] distance = new int[n+1];
        for (int i = 1; i <= n; i++) {
            distance[i]= Integer.MAX_VALUE;
        }
        distance[start]=0;

        while (true){
            int minNode = getMinNode(visited,distance);
            if (minNode==-1){
                break;
            }
            visited[minNode]=1;
            updateDistance(graph,distance,minNode);
        }

        if (distance[end]==Integer.MAX_VALUE){
            return -1;
        }
        return distance[end];
    }
    public static int getMinNode(int[] visited, int[] distance){
        int m = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if (visited[i]==1){
                continue;
            }
            if (m > distance[i]){
                m = distance[i];
                ans = i;
            }
        }

        return ans;
    }
    public static void updateDistance(int[][] graph, int[] distance, int node){
        for (int i = 1; i <= n ; i++) {
            if (graph[node][i]==0){
                continue;
            }

            if (distance[i] > distance[node]+graph[node][i]){
                distance[i] = distance[node]+graph[node][i];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
