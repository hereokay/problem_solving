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
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);


        int[] words = new int[n];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            words[i] = Integer.parseInt(s1[i]);
        }

        Arrays.sort(words);

        //dfs
        //기본찬 n , m , depth, arr
        int[] arr = new int[m + 1];
        boolean[] visited = new boolean[n + 1];
        dfs(n,m,0,arr,visited,words);

        bw.flush();
    }

    private static void dfs(int n, int m, int depth, int[] arr,boolean[] visited,int[] words) throws IOException {
        if (depth==m){
            for (int i = 0; i < m; i++) {
                String text = String.valueOf(arr[i+1])+" ";
                bw.write(text);
            }
            bw.write("\n");
            return;
        }
        int before = 0;
        for (int i = 0; i < n; i++) {
            if (before != words[i]){

                visited[i]=true;
                arr[depth+1] = words[i];
                before=words[i];
                dfs(n,m,depth+1,arr,visited,words);
                visited[i]=false;
            }
        }

    }


}
