
import java.util.*;

public class Main {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < T; t++) {

            int n = Integer.parseInt(sc.nextLine());


            int[][] dp = new int[n+10][4];

            dp[1][1] = 1;
            dp[1][2] = 0;
            dp[1][3] = 0;

            dp[2][1] = 1;
            dp[2][2] = 1;
            dp[2][3] = 0;

            dp[3][1] = 2;
            dp[3][2] = 0;
            dp[3][3] = 1;

            for (int i = 4; i <= n; i++) {
                dp[i][1] = dp[i-1][1]+dp[i-1][2]+dp[i-1][3];
                dp[i][2] = dp[i-2][2] + dp[i-2][3];
                dp[i][3] = dp[i-3][3];
            }

            System.out.println(dp[n][1]+dp[n][2]+dp[n][3]);
        }
    }
}


/*

1
1+1, 2
3, 2+1, 1+1+1

기존적으로 기존의 값 -> 새로운값


 */