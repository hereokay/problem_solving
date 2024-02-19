class Solution {
    public int solution(int[][] board) {
        
        int n =board.length;
        
        
        board[0][0]=1;
        int[][][] value = new int[4][n][n];

        bfs(0,0,0,0,board, value, n);
        bfs(0,0,2,0,board, value, n);

        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i < 4; i++) {
            if (value[i][n-1][n-1]==0){
                continue;
            }
            ans = Math.min(ans,value[i][n-1][n-1]);
        }
        return ans;
    }
    
    public static void bfs(int y,int x, int type,int cost, int[][] board, int[][][] value,int n){
        value[type][y][x]=cost;

        // 동서남북
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            // 속해있지 않으면 continue
            if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)){
                continue;
            }

            if (board[ny][nx] == 1){
                continue;
            }

            int nextCost =0;
            if (type==i){
                // 방향이 같거나 시작점인 경우
                nextCost = cost+100;
            }
            else{
                nextCost = cost+600;
            }

            if (value[i][ny][nx]==0 || nextCost <= value[i][ny][nx] ) {
                bfs(ny, nx, i, nextCost,board,value,n);
            }
        }
    }
}