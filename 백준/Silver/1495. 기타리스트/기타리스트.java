import java.util.*;


public class Main {
    static class Node{
        int value;
        int rank;
        int inputIdx;

        public Node(int value,int inputIdx) {
            this.value = value;
            this.inputIdx = inputIdx;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inp = sc.nextLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int s = Integer.parseInt(inp[1]);
        int m = Integer.parseInt(inp[2]);

        ArrayList<Integer> volumeList = new ArrayList<>();
        String[] s1 = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(s1[i]);
            volumeList.add(value);
        }

        List<HashSet> dp = new ArrayList();
        for (int i = 0; i < n + 1; i++) {
            dp.add(new HashSet<Integer>());
        }

        dp.get(0).add(s); // 초깃값

        for (int i = 0; i < n; i++) {
            // n 번반복 dp[i+1] 을 세팅하는 일

            HashSet<Integer> set = dp.get(i);

            int finalI = i;
            set.forEach(
                    value ->{
                        if (value + volumeList.get(finalI) <= m){
                            dp.get(finalI +1).add(value + volumeList.get(finalI));
                        }
                        if (value - volumeList.get(finalI) >= 0){
                            dp.get(finalI +1).add(value - volumeList.get(finalI));
                        }
                }
            );
        }
        HashSet<Integer> resultSet = dp.get(n);
        Iterator<Integer> iter = resultSet.iterator();

        if (resultSet.size()==0){
            System.out.println(-1);
        }
        else {
            int ans = 0;
            for (int j = 0; j < resultSet.size(); j++) {
                Integer value = iter.next();
                ans = Math.max(ans,value);
            }
            System.out.println(ans);
        }

    }

}