import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        char[][] board = new char[n][m];

        int x=0;
        int y=0;

        for (int i = 0; i < n; i++) {
            String s1 = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s1.charAt(j);
                if (board[i][j]=='I'){
                    x=i;
                    y=j;
                }
            }
        }

        int ans = bfs(x, y, n, m, board);
        if (ans==0){
            System.out.println("TT");
        }
        else{
            System.out.println(ans);
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static class Pair{
        int x;
        int y;

        public Pair() {
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int bfs(int x,int y,int n,int m, char[][] board) {
        Queue<Pair> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        visited[x][y] = 1;
        q.add(new Pair(x, y));
        int cnt = 0;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!(nx >= 0 && nx < n)) {
                    continue;
                }
                if (!(ny >= 0 && ny < m)) {
                    continue;
                }

                if (visited[nx][ny] == 1) {
                    continue;
                }
                if (board[nx][ny] == 'X') {
                    continue;
                }

                q.add(new Pair(nx, ny));
                visited[nx][ny] = 1;

                if (board[nx][ny] == 'P') {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}