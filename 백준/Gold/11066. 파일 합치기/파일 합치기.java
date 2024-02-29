import java.util.*;

public class Main {


    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {

            int n = Integer.parseInt(sc.nextLine());

            String[] inp = sc.nextLine().split(" ");

            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(inp[i]));
            }

            int[][] dp = new int[n + 1][n + 1]; // 정답 = dp[0][n-1]

            int[] sum = new int[n+1];

            for (int i = 1; i < n+1; i++) {
                sum[i] = sum[i-1]+ arr.get(i-1);
            }

            for (int len = 2; len <= n; len++) {

                for(int start = 0;start < n;start++){
                    int end = start+len-1;
                    if(end >= n){
                        continue;
                    }
                    dp[start][end] = Integer.MAX_VALUE;

                    // stop 지점은 앞에 포함됨, stop < end
                    for(int stop = start; stop <end ; stop++){
                        dp[start][end] = Math.min(
                                dp[start][end],
                                dp[start][stop] + dp[stop+1][end] + sum[end+1] - sum[start]
                        );
                    }
                }
            }
            System.out.println(dp[0][n-1]);
        }
    }

}