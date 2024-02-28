import java.io.*;
import java.util.*;



public class Main {


    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Node {
        int score;
        int depth; // 연속된 횟수
    }

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        for(int i=1;i<=n;i++){
            String[] inp = br.readLine().split(" ");
            int time = Integer.parseInt(inp[0]);
            int price = Integer.parseInt(inp[1]);


            // 퇴사후 상담이 끝나는 것
            if(i+time-1 > n){
                dp[i] = Math.max(dp[i],dp[i-1]);
                continue;
            }

            dp[i+time-1] = Math.max(dp[i-1]+price,dp[i+time-1]);
            dp[i] = Math.max(dp[i],dp[i-1]);
        }

        System.out.println(dp[n]);
    }
}