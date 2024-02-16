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


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        // dfs 를 통한 백트래킹 순열
        // 기본찬 : n, m, depth
        // 중복X -> visited
        int[] arr = new int[n+1];
        boolean[] visited = new boolean[n + 1];
        dfs(n, m, 0, arr, visited);

    }
    private static void dfs(int n, int m, int depth, int[] arr, boolean[] visited) {
        if (depth==m){
            // TODO
            for (int i = 1; i <= m; i++) {
                System.out.print(String.valueOf(arr[i])+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && arr[depth] < i){
                visited[i]=true;
                arr[depth+1]=i;
                dfs(n,m,depth+1,arr,visited);
                visited[i]=false;
            }
        }
    }


}
