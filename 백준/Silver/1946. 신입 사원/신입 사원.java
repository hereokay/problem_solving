import java.io.*;
import java.util.*;


public class Main {

    static class Pair{
        Integer first;
        Integer second;

        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int totalCount = 0; totalCount < t; totalCount++) {
            game(sc);
        }
    }

    public static void game(Scanner sc){
        int n = sc.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.first - o2.first;
            }
        });

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pq.add(new Pair(a,b));
        }

        int secondMin = Integer.MAX_VALUE;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Pair top = pq.poll();

            if (top.second < secondMin) {
                secondMin = top.second;
                cnt += 1;
            }
        }
        System.out.println(cnt);

    }
}