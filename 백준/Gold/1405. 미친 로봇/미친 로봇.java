import java.util.*;


public class Main {
    static int n;
    static double[] percent = new double[4];
    static boolean[][] board = new boolean[30][30];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0,0,-1,1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        n = Integer.parseInt(s[0]);

        for (int i = 0; i < 4; i++) {
            percent[i] = Double.parseDouble(s[1+i])/100.0;
        }

        board[15][15] =!board[15][15];
        Double ans = repeat(0, 1.0,n,15,15,percent);
        System.out.println(ans);
    }

    public static Double repeat(int depth,Double cumulativeProbability, int maxDepth, int x,int y, double[] percent){


        if (cumulativeProbability==0){
            return (double) 0;
        }
        if (depth == maxDepth){
            return cumulativeProbability;
        }
        Double ret = (double) 0;
        for (int i = 0; i < 4; i++) {
            x += dx[i];
            y += dy[i];

            if (!board[x][y]){
                board[x][y] =true;
                ret += repeat(depth+1, cumulativeProbability*percent[i],maxDepth,x,y,percent);
                board[x][y] =false;
            }

            x-=dx[i];
            y-=dy[i];
        }


        return ret;
    }

}