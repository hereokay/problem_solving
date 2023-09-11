package jin.week_4_0904_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799_쇠막대기 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int length = s.length();
        Stack stack = new Stack<Integer>();
        int ans = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c=='('){
                stack.add(1);
            }
            else if (c==')') {
                stack.pop();
                if (s.charAt(i-1)=='('){
                    ans += stack.size();
                }
                else{
                    ans+=1;
                }
            }
        }

        System.out.println(ans);
    }
}