import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    final static int MAX = 1000+1;
    static class Pair{
        private int cur;
        private int ans;

        public Pair(int cur, int ans) {
            this.cur = cur;
            this.ans = ans;
        }

        public int getCur() {
            return cur;
        }

        public void setCur(int cur) {
            this.cur = cur;
        }

        public int getAns() {
            return ans;
        }

        public void setAns(int ans) {
            this.ans = ans;
        }
    }
    public void solution() throws IOException {

        int[] dp = new int[MAX];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);

        String[] split = br.readLine().split(" ");
        int[] arr = new int[MAX];
        for (int i = 0; i < split.length; i++) {
            arr[i]=Integer.parseInt(split[i]);
            dp[i]=1;
        }

        for (int next = 1; next < n; next++) {
            for (int cur = 0; cur < next; cur++) {
                if (arr[next]<arr[cur]){
                    if (dp[next] < dp[cur]+1){
                        dp[next] = dp[cur]+1;
                    }
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
        new Main().solution();
    }
}


/*
수열 A가 주어졌을 때, 가장 긴 감소하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 30, 10, 20, 20, 10} 인 경우에 가장 긴 감소하는 부분 수열은 A = {10, 30, 10, 20, 20, 10}  이고, 길이는 3이다.

index = 3
cur = 10, 30 ,20
cnt = 2, 1, 1

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 감소하는 부분 수열의 길이를 출력한다.

풀이
- index, cur, ans

a[index][cur] = ans

index 크기 = N의 크기
a의 크기 = linkedList
cur > next 인 a[index]에 대해 a[index+1].add((next, ans+1))

 */