import java.util.*;


public class Main {

    static class Pair{
        Integer x;
        Integer y;

        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Pair() {
        }
    }

    static class Three {
        Integer day;
        Integer start;
        Integer end;

        public Three(Integer day, Integer start, Integer end) {
            this.day = day;
            this.start = start;
            this.end = end;
        }

        public Three() {
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        ArrayList<ArrayList<Integer>> board = new ArrayList<>();

        int startX = 0;
        int startY = 0;
        int[][] values = new int[n][m];
        for (int i = 0; i < n; i++) {
            board.add(new ArrayList());
            ArrayList<Integer> list = new ArrayList<>();
            String[] s1 = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(s1[j]);
                if (num==2){
                    startX = i;
                    startY = j;
                }
                board.get(i).add(num);
            }
        }

        // bfs

        // startX, startY
        // board
        // values
        values = bfs(startX,startY,board,n,m);
        displayAns(values,n,m);
    }

    private static void displayAns(int[][] values, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(values[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] bfs(int startX, int startY, ArrayList<ArrayList<Integer>> board, int n, int m){

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(startX,startY));

        int[][] values = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                values[i][j]=  -1;
            }
        }



        values[startX][startY]=0;

        while (!queue.isEmpty()){
            Pair top = queue.poll();
            for (int i = 0; i < 4; i++) {

                int nx = top.x + dx[i];
                int ny = top.y + dy[i];

                if (nx < 0 || nx >= n){
                    continue;
                }
                if (ny <0 || ny >= m){
                    continue;
                }

                if (board.get(nx).get(ny) ==0){
                    continue;
                }

                // 모든 곳은 한번만 방문
                if (values[nx][ny] != -1){
                    continue;
                }

                // 시작했던 곳이면 리턴
                if (nx == startX && ny == startY){
                    continue;
                }

                // 이전값 + 1
                values[nx][ny] = values[top.x][top.y] +1;
                queue.add(new Pair(nx,ny));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board.get(i).get(j) == 0){
                    values[i][j]=  0;
                }
            }
        }

        values[startX][startY]=0;

        return values;
    }

}


