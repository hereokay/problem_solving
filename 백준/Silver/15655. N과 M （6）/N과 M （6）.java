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
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String[] s1 = br.readLine().split(" ");
        ArrayList<Integer> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(Integer.parseInt(s1[i]));
        }

        Collections.sort(words);

        // dfs 를 통한 백트래킹 순열
        // 기본찬 : n, m, depth
        // 중복X -> visited
        int[] arr = new int[n+1];
        boolean[] visited = new boolean[n + 1];
        dfs(n, m, 0, arr,visited, words);
        bw.flush();
    }
    private static void dfs(int n, int m, int depth, int[] arr, boolean[] visited, ArrayList<Integer> words) throws IOException {
        if (depth==m){
            // TODO
            for (int i = 1; i <= m; i++) {
                bw.write(String.valueOf(arr[i])+" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[depth] < words.get(i)){
                visited[i]=true;
                arr[depth + 1] = words.get(i);
                dfs(n,m,depth+1,arr,visited,words);
                visited[i]=false;
            }
        }
    }
}
