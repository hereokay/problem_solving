import java.util.*;


public class Main {

    static class Pair{
        Integer x;
        Integer y;

        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
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
            int num = sc.nextInt();
            game(num);
        }
    }

    private static void game(int num) {
        ArrayList<Integer> fibo = new ArrayList<Integer>();
        fibo.add(1);
        fibo.add(1);
        int index = 2;

        // fibo 세팅완료
        while (true){
            int value =fibo.get(index-1) + fibo.get(index-2);
            if(value > num){
                break;
            }
            fibo.add(value);
            index++;
        }

        int size = fibo.size();

        ArrayList<Integer> ansList = new ArrayList<>();
        // 역순
        for (int i = size-1; i >=0; i--) {
            while (num >= fibo.get(i)){
                num -= fibo.get(i);
                ansList.add(fibo.get(i));
                if (num == 0){
                    break;
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(ansList);

        ansList.stream().forEach(
                a -> {
                    System.out.print(a+" ");
                }
        );
        System.out.println();
    }

}


