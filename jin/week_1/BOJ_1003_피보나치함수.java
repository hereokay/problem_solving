package jin.week_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BOJ_1003_피보나치함수 {

    public class Pair{
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;

        }

        public int getY() {
            return y;
        }
        public Pair add(Pair other){
            return new Pair(x+other.getX(),y+other.getY());
        }
    }



    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            // t번 반복
            int num = Integer.parseInt(br.readLine());

            Pair[] dp = new Pair[50];
            dp[0]= new Pair(1,0);
            dp[1] = new Pair(0,1);
            for(int j=2;j<=num;j++)
            {
                dp[j]=dp[j-1].add(dp[j-2]);
            }

            System.out.println(dp[num].getX()+" "+dp[num].getY());
        }
    }

    public static void main(String[] args) throws Exception {
        new BOJ_1003_피보나치함수().solution();
    }
}
