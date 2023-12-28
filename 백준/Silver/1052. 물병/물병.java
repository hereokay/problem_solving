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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        //k-1번
        for (int i = 0; i < k - 1; i++) {
            // n 보다 작으면서 2의 배수인 수 중 가장 큰 수
            n -= small(n);
            if (n==0){
                System.out.println(0);
                return;
            }
        }

        // 마지막 1번
        System.out.println(big(n)-n);
    }

    // n보다 크고 2의 배수
    public static int big(int n){
        int ret = 1;

        // 무조건 크게
        while (n > ret){
            ret *=2;
            if (ret==n){
                return ret;
            }
        }

        return ret;
    }

    public static int small(int n){
        int ret = big(n);
        if (ret == n){
            return ret;
        }
        return big(n)/2;
    }
}