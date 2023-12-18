import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        while (true) {
            String[] inp = sc.nextLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            if (n==0){
                return;
            }

            PriorityQueue<Integer> list = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -(o1-o2);
                }
            });

            int zeroCount = 0;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(inp[i + 1]);
                if (num==0){
                    zeroCount ++;
                }
                else{
                    list.add(num);
                }
            }

            int weight = 1;
            int stack = 0;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int num ;
                if (list.size()==2 && zeroCount != 0){
                    zeroCount -= 1;
                    num = 0;
                }
                else{
                    num = list.poll();
                }

                ans += weight*num;
                stack += 1;

                if (stack == 2){
                    stack = 0;
                    weight *= 10;
                }
            }
            System.out.println(ans);
        }
    }
}

