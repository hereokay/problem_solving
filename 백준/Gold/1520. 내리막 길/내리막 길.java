import java.io.*;
import java.util.*;



public class Main {


    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Node {
        int x;
        int y;
        public Node (int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    static int x;
    static int y;
    public static void main(String[] args) throws IOException {

        String[] inp = br.readLine().split(" ");
        x = Integer.parseInt(inp[0]); // 세로
        y = Integer.parseInt(inp[1]); // 가로

        int[][] board = new int[x+1][y+1];
        boolean[][] visited = new boolean[x+1][y+1];
        int[][] dp = new int[x+1][y+1];


        for(int i=0;i<x;i++){
            inp = br.readLine().split(" ");
            for(int j=0;j<y;j++){
                board[i][j] = Integer.parseInt(inp[j]);
                dp[i][j] = -1;
            }
        }

        int ans = dfs(new Node(0,0),board,dp);
        System.out.println(ans);
    }

    public static int dfs(Node cur, int[][] board, int[][] dp){

        if(cur.x == x-1 && cur.y == y-1){
            return 1;
        }

        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};

        int cnt = 0;
        for(int i=0;i<4;i++){

            int nx = dx[i]+cur.x;
            int ny = dy[i] + cur.y;

            if(nx < 0 || nx >=x || ny <0 || ny>= y){
                continue;
            }


            if(board[nx][ny] < board[cur.x][cur.y]){
                // 시작
                if(dp[nx][ny] == -1){
                    // 기존 데이터가 없으면 DFS 진행
                    dp[nx][ny] = dfs(new Node(nx, ny), board, dp);
                }
                cnt += dp[nx][ny];
            }
        }

        return cnt;
    }
}