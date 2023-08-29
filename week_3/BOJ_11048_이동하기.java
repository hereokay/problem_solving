package week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.max;

public class BOJ_11048_이동하기 {
    final static int MAX = 1000+2;
    static int n;
    static int m;

    static class Pair
    {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
    public boolean check(int x,int y){
        return x <= n
                && x > 0
                && y <= m
                && y > 0;
    }
    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        int[][] board = new int[MAX][MAX];
        int[][] dp = new int[MAX][MAX];


        for (int i = 1; i <= n; i++) {
            String[] split1 = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(split1[j - 1]);
                dp[i][j]=board[i][j];
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Main.Pair(1,1));

        int[] dx = {1,0,1};
        int[] dy = {0,1,1};
        int[][] visited = new int[MAX][MAX];
        while(!q.isEmpty()){
            Main.Pair cur = q.remove();

            // move  이동, 상태변경, 가능한 것들 큐에 추가
            for (int i = 0; i < 3; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!check(nx,ny)){ // 이동불가능한 것들은 패스
                    continue;
                }

                if (dp[nx][ny] < dp[cur.x][cur.y]+board[nx][ny]
                        || visited[nx][ny]==0){
                    dp[nx][ny] = max(dp[cur.x][cur.y]+board[nx][ny],dp[nx][ny]);
                    q.add(new Main.Pair(nx,ny));
                }
            }
        }
        System.out.println(dp[n][m]);
    }
    public static void main(String[] args) throws IOException {
        new BOJ_11048_이동하기().solution();
    }
}
