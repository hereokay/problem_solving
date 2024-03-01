import java.util.*;


public class Main {

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());



        int[] dp = new int[n+3];

        dp[1]= 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-2]%15746+dp[i-1]%15746)%15746;
        }

        System.out.print(dp[n]%15746);
    }

}