
import java.util.*;

public class Main {



    static int n;
    static int[][] board;
    static int[][] dp ;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.nextLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] inp = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(inp[j]);
            }
        }

        dp = new int[n][n]; // 00..

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != 0){
                    continue; // 이미 갔던 거면 pass
                }


                dp[i][j] = dfs(i,j);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }

    public static int dfs(int x,int y){

        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};

        int ret = 0;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if (nx < 0 || nx >= n || ny < 0 || ny >=n){
                continue;
            }
            if (board[nx][ny] <= board[x][y]){
                continue; // 증가하는 경우만 가능함
            }

            if (dp[nx][ny] == 0){
                dp[nx][ny] = dfs(nx,ny);
            }

            ret = Math.max(ret, dp[nx][ny]);
        }

        return ret + 1;
    }
}
