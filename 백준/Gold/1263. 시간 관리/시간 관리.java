import java.io.*;
import java.util.*;


public class Main {

    static class Pair{
        Integer start;
        Integer end;

        public Pair(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        public Pair() {
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Pair> workList = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.end - o1.end;
            }
        });

        for (int i = 0; i < n; i++) {

            int start = sc.nextInt();
            int end = sc.nextInt();

            workList.add(new Pair(start,end));
        }
        int end = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Pair top = workList.poll();
            end = Math.min(end,top.end);

            // 일하기
            end -= top.start;
        }
        if (end<0){
            System.out.println(-1);
            return;
        }

        System.out.println(end);
    }
}