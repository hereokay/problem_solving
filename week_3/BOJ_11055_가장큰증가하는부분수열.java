package week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11055_가장큰증가하는부분수열 {
    final static int MAX = 1000+1;

    public void solution() throws IOException {

        int[] arr = new int[MAX];
        int[] dp = new int[MAX];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(split[i]);
            dp[i]=arr[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <i; j++) {
                if (arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+arr[i]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans,dp[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        new BOJ_11055_가장큰증가하는부분수열().solution();
    }
}
