import java.io.*;
import java.util.*;



public class Main {


    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Node {
        int x;
        int y;
        int hei ;
        public Node (int x,int y,int hei){
            this.x = x;
            this.y = y;
            this.hei = hei;
        }
    }

    public static void main(String[] args) throws IOException {

        String[] inp = br.readLine().split(" ");
        int x = Integer.parseInt(inp[0]); // 세로
        int y = Integer.parseInt(inp[1]); // 가로

        int[][] board = new int[x+1][y+1];
        boolean[][] visited = new boolean[x+1][y+1];
        int[][] cnt = new int[x+1][y+1];

        for(int i=0;i<x;i++){
            inp = br.readLine().split(" ");
            for(int j=0;j<y;j++){
                board[i][j] = Integer.parseInt(inp[j]);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
            @Override
            public int compare(Node a,Node b){
                return -(a.hei - b.hei);
            }
        });

        pq.add(new Node(0,0,board[0][0]));

        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};

        cnt[0][0] = 1;
        while(!pq.isEmpty()){

            Node cur = pq.poll();

            for(int i=0;i<4;i++){
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;

                if(nx <0 || nx >= x || ny <0 || ny >= y){
                    continue;
                }

                if(board[cur.x][cur.y] <= board[nx][ny]){
                    continue;
                }

                cnt[nx][ny] += cnt[cur.x][cur.y];

                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    pq.add(new Node(nx,ny, board[nx][ny]));
                }
            }
        }

        System.out.println(cnt[x-1][y-1]);
    }
}