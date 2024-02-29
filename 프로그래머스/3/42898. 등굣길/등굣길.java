class Solution {
    static int[][] board;
    static int[][] dp ;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        dp = new int[n+1][m+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j] = -1;
            }
        }

        dp[1][1] = 1;

        board = new int[n+1][m+1];

        for(int[] puddle : puddles){
            int py = puddle[0];
            int px = puddle[1];

            board[px][py] = 1;
        }

        int ans = dfs(1,1,n,m);


        return ans;
    }

    public int dfs(int x, int y,int n, int m){

        if( x==n && y==m){
            return 1;
        }
        int[] dy = {1,0};
        int[] dx = {0,1};

        int cnt = 0;
        for(int i=0;i<2;i++){

            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx < 1 || nx > n || ny < 1 || ny > m){
                continue;
            }

            if(board[nx][ny] == 1){
                continue;
            }

            if(dp[nx][ny] == -1){
                dp[nx][ny] = dfs(nx,ny,n,m) % 1000000007;
            }

            cnt += dp[nx][ny];
        }

        return cnt % 1000000007;
    }
}