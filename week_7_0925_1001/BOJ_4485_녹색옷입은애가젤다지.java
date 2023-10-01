package week_7_0925_1001;
import java.io.*;
import static java.lang.Math.min;

public class BOJ_4485_녹색옷입은애가젤다지 {
    static int n;

    static class Pair{
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 0;
        while (true)
        {
            idx +=1;
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int[][] board = new int[n + 1][n + 1];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(s[j]);
                }
            }
            int ans = dijk(board);
            System.out.println("Problem "+String.valueOf(idx)+": "+String.valueOf(ans));

        }
        br.close();
        bw.close();
    }

    public static int dijk(int[][] board){
        int[][] distance = new int[n+1][n+1];
        int[][] visited = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
        distance[0][0]=board[0][0];

        while (true){
            Pair node = getMinNode(visited,distance);
            if (node.getI()==-1){
                break;
            }
            visited[node.getI()][node.getJ()]=1;

            update(board,distance,node);
        }

        return distance[n-1][n-1];
    }
    public static Pair getMinNode(int[][] visited, int[][] distance){

        int i = -1;
        int j = -1;
        int m = Integer.MAX_VALUE;

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                if (visited[k][l]==1){
                    continue;
                }

                if (m > distance[k][l]){
                    m = distance[k][l];
                    i=k;
                    j=l;
                }
            }
        }

        return new Pair(i,j);
    }

    public static void update(int[][] board, int[][] distance, Pair node){
        int[] di = {0,1,0,-1};
        int[] dj = {1,0,-1,0};

        for (int k = 0; k < 4; k++) {
            int ni = di[k]+node.getI();
            int nj = dj[k]+node.getJ();

            // valid check
            if (!isValid(ni,nj)){
                continue;
            }
            //
            distance[ni][nj] = min(
                    distance[ni][nj],
                    distance[node.getI()][node.getJ()]+board[ni][nj]
            );
        }
    }
    public static boolean isValid(int a, int b){
        if (a >=0 && a<n){
            if (b >=0 && b<n){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
