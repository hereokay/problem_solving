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

        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);


        ArrayList<Three> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] s1 = sc.nextLine().split(" ");

            int from = Integer.parseInt(s1[0]);
            int to = Integer.parseInt(s1[1]);
            int distance = Integer.parseInt(s1[2]);
            list.add(new Three(from, to, distance));
        }

        Collections.sort(list,
                new Comparator<Three>() {
                    @Override
                    public int compare(Three o1, Three o2) {
                        return o1.to - o2.to;
                    }
                });
        // 단순 distance 로만 오름차순 정렬

        int[] dp = new int[MAX];
        dp[0] = 0;

        int index = 0;
        for (int i = 1; i <= d; i++) {
            dp[i] = dp[i - 1] + 1;
            while (list.size() != index ) {
                if (list.get(index).to == i) {
                    Three unit = list.get(index);
                    dp[i] = Math.min(
                            dp[i],
                            unit.distance + dp[unit.from]
                    );
                    index++;
                }
                else{
                    break;
                }
            }

        }
        System.out.println(dp[d]);
    }


}