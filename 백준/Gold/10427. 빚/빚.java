import java.util.*;


public class Main {

    static class Pair {
        Integer from;
        Integer to;

        public Pair(Integer from, Integer to) {
            this.from = from;
            this.to = to;
        }

        public Pair() {
        }
    }

    static class Three {
        Integer from;
        Integer to;
        Integer distance;

        public Three(Integer from, Integer to, Integer distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        public Three() {
        }
    }

    public static void main(String[] args) {
        final int MAX = 10001;
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            Long ret = game(sc);
            System.out.println(ret);
        }
    }

    public static Long game(Scanner sc) {
        String[] s = sc.nextLine().split(" ");
        Integer n = Integer.parseInt(s[0]);

        Long[] AList = new Long[n];
        Long[] preSum = new Long[n+1];

        preSum[0]=0L;

        for (int i = 0; i < n; i++) {
            Long num = Long.parseLong(s[i + 1]);
            AList[i]=num;


        }


        Arrays.sort(AList);

        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i]+AList[i];
        }


        Long ans = 0L;

        for (int m = 2; m <= n; m++) {
            // 2번부터
            // S[m] = ?
            Long minResult = Long.MAX_VALUE;
            for (int start = 0; start + m - 1 < n ; start++) {
                int end = start + m - 1;

                Long c = m* AList[end];
                Long b = preSum[end+1]-preSum[start];

                Long result = c - (b);

                minResult = Math.min(result,minResult);
            }
            ans += minResult;
        }
        return ans;
    }

}