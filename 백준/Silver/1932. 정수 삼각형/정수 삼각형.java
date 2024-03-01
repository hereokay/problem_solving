import java.util.*;


/*

7
3 8
8 1 0
2 7 4 4
4 5 2 6 5


BFS로 풀면 될듯
 */
public class Main {

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());


        int[][] board = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            String[] inp = sc.nextLine().split(" ");
            for(int j=0;j<inp.length;j++){
                board[i][j] = Integer.parseInt(inp[j]);
            }
        }
        int[][] dp = new int[n][n];

        dp[0][0] = board[0][0];

        for(int i=1;i<n;i++){
            //i = floor
            for(int j=0;j<=i;j++){

                // j==0 인경우
                // j==i 인경우
                // 그외

                if(j==0){
                    dp[i][j] = dp[i-1][j];
                }
                else if(j==i){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(
                            dp[i-1][j-1],
                            dp[i-1][j]
                    );
                }

                dp[i][j] += board[i][j]; // 가치 더해주기
            }
        }

        int ans = -1;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, dp[n-1][i]);
        }

        System.out.println(ans);
    }

}