import java.util.*;

public class Main {

    static class Node {
        int height;
        int inpIndex;

        public Node(int height, int inpIndex) {
            this.height = height;
            this.inpIndex = inpIndex;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        String[] s1 = sc.nextLine().split(" ");
        ArrayList<Integer> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            people.add(Integer.parseInt(s1[i]));
        }

        PriorityQueue<Integer> distancePQ = new PriorityQueue<>();

        for (int i = 0; i < n - 1; i++) {
            int distance = people.get(i+1) - people.get(i);
            distancePQ.add(distance);
        }

        int ans = 0;
        for (int i = 0; i < n - k; i++) {
            Integer distance = distancePQ.poll();
            ans += distance;
        }

        System.out.println(ans);

        // people 은 이미 정렬되어 있음

        // 1 3 5 6 10
        //  1 2 1 4

        //  k == n
        // n-k = 1 , 둘이상 묵여야 함
        // n-k = 2 , 셋이상 묵여야함 or 둘이 상 2번


        // 1 3 5 6 10  이렇게 처음에 다 각자 조를 짜
        // 초과하는 횟수 n-k 개가 2이니까
        // 거기서 2개를 정해


        // 5 2 였음?
        // 3개를 정해야 했어

        // 7 3 이면 ? "4" 잖아
        // 1 3 5 6 10 12 19 20 50
        //  2 2 1 4  2  7  1  30


        //






    }


}
