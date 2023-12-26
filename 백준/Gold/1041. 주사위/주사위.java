import java.io.*;
import java.util.*;


public class Main {

    static class Pair{
        Integer num;
        Integer degree;

        public Pair() {
        }

        public Pair(Integer num, Integer degree) {
            this.num = num;
            this.degree = degree;
        }
    }

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        ArrayList<Pair> numbers = new ArrayList<>();
        numbers.add(new Pair(sc.nextInt(),0));
        for (int i = 0; i < 4; i++) {
            numbers.add(new Pair(sc.nextInt(),1));
        }
        numbers.add(new Pair(sc.nextInt(),2));





        int[] fieldNum = {
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE
        };

        for (int i = 0; i < 6; i++) {
            fieldNum[0]=Math.min(fieldNum[0], numbers.get(i).num);
            for (int j = i+1; j < 6; j++) {
                if (i+j == 5){
                    continue;
                }
                fieldNum[1] = Math.min(fieldNum[1],numbers.get(i).num+numbers.get(j).num);
                for (int k = j+1; k < 6; k++) {
                    if (j+k == 5 || i+k == 5){
                        continue;
                    }
                    fieldNum[2] = Math.min(fieldNum[2],
                            numbers.get(i).num+
                            numbers.get(j).num+
                            numbers.get(k).num);
                }
            }
        }

        if (n==1){
            int maxOne=Integer.MIN_VALUE;
            int sumAll = 0;
            for (int i = 0; i < 6; i++) {
                if (numbers.get(i).num > maxOne){
                    maxOne = numbers.get(i).num;
                }
                sumAll+=numbers.get(i).num;
            }
            System.out.println(sumAll-maxOne);
            return;
        }
        long ans = 0L;

        // 1면합
        ans += fieldNum[0]*((5L *n*n)- 16L *n+12);

        // 2면합
        ans += fieldNum[1]*(8L*n-12);

        // 3면합
        ans += fieldNum[2]*(4L);

        System.out.println(ans);
    }
}