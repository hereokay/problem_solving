import java.util.*;


public class Main {
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Three{
        int x;
        int y;
        int depth;

        public Three(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        String[] s = sc.nextLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);
        int d = Integer.parseInt(s[2]);
        int x = Integer.parseInt(s[3]);
        int y = Integer.parseInt(s[4]);

        // 탑 4개 위치
        Set<Pair> topList = new HashSet<>();

        Queue<Three> nearTop = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] s1 = sc.nextLine().split(" ");
            int topX = Integer.parseInt(s1[0]);
            int topY = Integer.parseInt(s1[1]);

            double distance = calcDistance(topX, topY, x, y);
            if (distance <= r){
                nearTop.add(new Three(topX,topY,0));
            }
            else{
                topList.add(new Pair(topX,topY)); // 사용되지 않은 타워
            }
        }
        double ans = 0.0;

        while(!nearTop.isEmpty()){

            Three cur = nearTop.poll();
            double divider = Math.pow(2,cur.depth);

            ans += ( d / divider);

            HashSet<Pair> removeTarget = new HashSet<>();
            // 원소 추가
            topList.forEach(
                    top -> {
                        double distance = calcDistance(top.x, top.y, cur.x, cur.y);
                        if (distance <= r){
                            nearTop.add(new Three(top.x, top.y, cur.depth+1));
                            removeTarget.add(top);
                        }
                    }
            );

            removeTarget.forEach(
                    topList::remove
            );

        }

        System.out.println(ans);
    }


    public static double calcDistance(int x1,int y1, int x2,int y2){
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

}