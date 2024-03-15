
import java.util.*;

public class Main {


    static class Node{
        int friend;
        int empty;
        int row;
        int col;

        public Node(int friend, int empty, int row, int col) {
            this.friend = friend;
            this.empty = empty;
            this.row = row;
            this.col = col;
        }
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        HashMap<Integer, int[]> map = new HashMap<>();

        int[][] board = new int[n+1][n+1];

        for (int i = 0; i < n*n; i++) {
            String[] inp = sc.nextLine().split(" ");

            int firstOne = Integer.parseInt(inp[0]);
            int[] secondArr = new int[4];
            for (int j = 0; j < 4; j++) {
                secondArr[j] = Integer.parseInt(inp[j+1]);
            }

            map.put(firstOne,secondArr);


            ArrayList<Node> nodeList = new ArrayList<>();
            for (int row = 1; row <= n; row++) {
                for (int col = 1; col <= n; col++) {
                    if (board[row][col] !=0 ){
                        continue;
                    }

                    // row col 에 대해 조사

                    int[] dy = {1,-1,0,0};
                    int[] dx = {0,0,1,-1};

                    int friend = 0;
                    int empty = 0;
                    for (int l = 0; l < 4; l++) {
                        int nx = dx[l] + row;
                        int ny = dy[l] + col;

                        if (nx < 1 || nx > n || ny < 1 || ny > n){
                            continue;
                        }

                        if (board[nx][ny] == 0){
                            empty++;
                            continue;
                        }

                        for (int j = 0; j < 4; j++) {
                            if (board[nx][ny] == secondArr[j]){
                                friend++;
                            }
                        }
                    }

                    nodeList.add(new Node(friend,empty,row,col));
                }
            }

            Collections.sort(nodeList, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.friend != o2.friend){
                        return -(o1.friend - o2.friend); // 큰거 우선순위
                    }

                    if (o1.empty != o2.empty){
                        return -(o1.empty - o2.empty); // 큰거 우선순위
                    }

                    if (o1.row != o2.row){
                        return o1.row - o2.row; // 작은거 운선순위
                    }

                    return o1.col - o2.col; // 작은거
                }
            });

            Node node = nodeList.get(0);
            board[node.row][node.col] = firstOne;
        }
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                int cnt = 0;
                int first = board[i][j];
                int[] key = map.get(first);

                int[] dy = {1,-1,0,0};
                int[] dx = {0,0,1,-1};


                for (int k = 0; k < 4; k++) {
                    int nx = dx[k] + i;
                    int ny = dy[k] + j;

                    if (nx < 1 || nx > n || ny < 1 || ny > n){
                        continue;
                    }

                    for (int l = 0; l < 4; l++) {
                        if (key[l] == board[nx][ny]){
                            cnt ++;
                        }
                    }
                }

                int[] plus = {0,1,10,100,1000};
                ans += plus[cnt];
            }
        }

        System.out.println(ans);
    }
}
