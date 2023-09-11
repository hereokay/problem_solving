package jin.week_5_0911_0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_4963_섬의개수 {
    static int MAX = 50+1;
    static int[][] visited = new int[MAX][MAX];

    static class Pair{
        private int h;
        private int w;

        public Pair(int h, int w) {
            this.h = h;
            this.w = w;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] split = br.readLine().split(" ");
            int w = Integer.parseInt(split[0]);
            int h = Integer.parseInt(split[1]);
            if (w==0 && h==0){
                break;
            }

            int [][] board = new int[h+1][w+1];
            for (int i = 0; i < h; i++) {
                String[] split1 = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(split1[j]);
                    visited[i][j]=0;
                }
            }
            int ans =0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visited[i][j]==1){
                        continue;
                    }
                    if (board[i][j]==0){
                        continue;
                    }
                    bfs(new Pair(i,j),h-1,w-1,board);
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

    private static void bfs(Pair pair, int maxH, int maxW, int[][] board) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(pair);
        visited[pair.getH()][pair.getW()]=1;

        int[] dH = {0,0,0,1,1,1,-1,-1,-1};
        int[] dW = {0,-1,1,0,-1,1,0,-1,1};

        while (!queue.isEmpty()){
            Pair cur = queue.remove();
            for (int i = 0; i <9 ; i++) {
                int nH = dH[i]+cur.getH();
                int nW = dW[i]+cur.getW();

                if (nH <0 || nH >maxH || nW <0 || nW>maxW){
                    continue;
                }
                if (visited[nH][nW]==1){
                    continue;
                }
                if (board[nH][nW]==0){
                    continue;
                }

                visited[nH][nW]=1;
                queue.add(new Pair(nH,nW));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
