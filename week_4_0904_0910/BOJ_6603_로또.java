package week_4_0904_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_6603_로또 {

    static int n ;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String[] split = br.readLine().split(" ");
            n = Integer.parseInt(split[0]);
            if (n == 0) {
                return;
            }

            int[] intArr = new int[n];
            for (int i = 1; i <= n; i++) {
                intArr[i - 1] = Integer.parseInt(split[i]);
                visited[i - 1] = 0;
            }

            for (int i = 0; i < n; i++) {
                Stack stack = new Stack<Integer>();
                stack.add(i);
                visited[i] = 1;

                back(intArr, i, 1, stack);
                visited[i] = 0;
                stack.pop();
            }
            System.out.println();
        }
    }

    static int[] visited = new int[15];

    public static void printStack(Stack<Integer> stack,int[] intArr){
        for (int i = 0; i < stack.size(); i++) {
            Integer idx = stack.get(i);

            System.out.print(intArr[idx] +" ");
        }
        System.out.println();
    }
    public static void back(int[] intArr, int cur, int height, Stack stack){
        if (height==6){
            printStack(stack,intArr);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]==1){
                continue;
            }
            if (cur > i ){ // i 다음이 더 작으면 continue
                continue;
            }

            visited[i]=1;
            stack.add(i);
            back(intArr,i,height+1,stack);
            stack.pop();
            visited[i]=0;
        }

    }

}
