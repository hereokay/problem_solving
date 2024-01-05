import java.io.*;
import java.util.*;


public class Main {

    static class Pair{
        Integer wei;
        Integer price;

        public Pair(Integer wei, Integer price) {
            this.wei = wei;
            this.price = price;
        }

        public Pair() {
        }
    }

    static class Three {
        Integer day;
        Integer start;
        Integer end;

        public Three(Integer day, Integer start, Integer end) {
            this.day = day;
            this.start = start;
            this.end = end;
        }

        public Three() {
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            round(i+1,sc);
            System.out.println();
        }

    }
    public static void round(int idx, Scanner sc){

        int m = sc.nextInt();
        String next = sc.nextLine();// enter 제거
        ArrayList<Three> timeList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] res = sc.nextLine().split(" ");
            int d = Integer.parseInt(res[0]);
            int s = Integer.parseInt(res[1]);
            int e = Integer.parseInt(res[2]);

            timeList.add(new Three(d,s,e));
        }

        Collections.sort(timeList, new Comparator<Three>() {
            @Override
            public int compare(Three o1, Three o2) {
                // 날짜 오름차순
                if (!Objects.equals(o1.day, o2.day)){
                    return o1.day- o2.day;
                }
                else {
                    // 같은 날짜에서
                    // 종료시간 오름차순
                    if (o1.end != o2.end){
                        return o1.end-o2.end;
                    }
                    else {
                        // 시작시간 내림차순
                        return -(o1.start - o2.start);
                    }
                }
            }
        });

        int ans = 0;

        int nowDay=0;
        int nowTime = 0;
        for (int i = 0; i < m; i++) {
            Three game = timeList.get(i);

            if (game.day < nowDay){
                continue;
            }
            if (game.day != nowDay){
                nowTime = 0;
            }

            if (game.start < nowTime){
                continue;
            }

            nowDay = game.day;
            nowTime = game.end;
            ans++;
        }

        System.out.println("Scenario #" + String.valueOf(idx) +":");
        System.out.println(ans);
    }
}


