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
        ansList = new ArrayList<>();

        // dfs 를 통한 백트래킹 순열
        // 기본찬 : n, m, depth
        // 중복X -> visited
        int[] arr = new int[n+1];
        boolean[] visited = new boolean[n + 1];
        dfs(n, m, 0, arr,visited, words);

        Collections.sort(ansList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int i = 1; i <= m; i++) {
                    if (o1[i] != o2[i]){
                        return o1[i]-o2[i];
                    }
                }
                return 0;
            }
        });

        int[] before = new int[1];
        for (int[] tmp : ansList){
            if (Arrays.equals(tmp,before)){
                continue;
            }
            else{
                before = tmp.clone();
            }
            for (int i = 1; i <= m; i++) {
                bw.write(String.valueOf(tmp[i])+" ");
            }
            bw.write("\n");
        }

        bw.flush();
    }

    static ArrayList<int[]> ansList;
    private static void dfs(int n, int m, int depth, int[] arr, boolean[] visited, ArrayList<Integer> words) throws IOException {
        if (depth==m){
            // TODO

            ansList.add(arr.clone());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                visited[i]=true;
                arr[depth+1] = words.get(i);
                dfs(n,m,depth+1,arr,visited,words);
                visited[i]=false;
            }

        }
    }
}
