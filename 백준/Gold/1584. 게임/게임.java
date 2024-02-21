import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] board ;
    static int[][] value;
    public static void main(String[] args) throws IOException {

        board = new int[501][501];
        value = new int[501][501];
        for (int i = 0; i < 501; i++) {
            for (int j = 0; j < 501; j++) {
                value[i][j]= Integer.MAX_VALUE;
            }
        }
        value[0][0]=0;
        // init 필요 0,0 제외

        // 위험지역
        int N = Integer.parseInt(br.readLine());
        setBoard(N, board, 1);

        // 금지지역
        int M = Integer.parseInt(br.readLine());
        setBoard(M,board,2);


        board[0][0]=0;

        bfs(0,0);

        if (value[500][500]==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else {
            System.out.println(value[500][500]);
        }
    }

    public static void bfs(int startX, int startY){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(startX,startY));
        while (!queue.isEmpty()){
            Node cur = queue.poll();

            int[] dy = {1,-1,0,0};
            int[] dx = {0,0,1,-1};

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;

                if (nx < 0 || nx > 500 || ny <0 || ny > 500){
                    continue;
                }

                if (board[nx][ny]==2){
                    continue;
                }


                // 현재 밸류 + 1
                int newCost = value[cur.x][cur.y] + board[nx][ny];

                if (value[nx][ny] > newCost){
                    value[nx][ny] = newCost; // 더 작은거
                    queue.add(new Node(nx,ny));
                }
            }
        }
    }

    private static void setBoard(int N, int[][] board, int fill) throws IOException {
        for (int i = 0; i < N; i++) {
            String[] inp = br.readLine().split(" ");

            int x1 = Integer.parseInt(inp[0]);
            int y1 = Integer.parseInt(inp[1]);
            int x2 = Integer.parseInt(inp[2]);
            int y2 = Integer.parseInt(inp[3]);

            // 항상 x1 y1이 작도록 변경
            if (x1 > x2 ){
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
            }
            if (y1 > y2){
                int tmp = y1;
                y1 = y2;
                y2 = tmp;
            }

            for (int x = x1; x <= x2; x++){
                for (int y = y1; y <= y2; y++){
                    board[x][y] = fill;
                }
            }
        }
    }

}