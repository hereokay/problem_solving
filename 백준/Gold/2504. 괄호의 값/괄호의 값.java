import java.util.*;


/*

N = 15

15^2  = 225칸



 */
public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine(); // 길이 1~30

        int n = str.length();

        Stack<Character> stack = new Stack<Character>();


        int mul = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {

            char ch = str.charAt(i);

            if (ch == '(') {
                mul *= 2;
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.empty() && stack.peek() == '(') {

                    if (i !=0 && str.charAt(i-1)=='(') {
                        ans += mul;
                    }


                    mul /= 2;
                    stack.pop();
                } else {
                    // 오류발생
                    System.out.println(0);
                    return;
                }
            } else if (ch == '[') {
                mul *= 3;
                stack.push(ch);
            } else {
                // ]일때
                if (!stack.empty() && stack.peek() == '[') {

                    if ( i != 0 && str.charAt(i-1)=='[') {
                        ans += mul;
                    }


                    mul /= 3;
                    stack.pop();
                } else {
                    // 오류발생
                    System.out.println(0);
                    return;
                }
            }
        }

        if (stack.empty()) {
            System.out.println(ans);
        }
        else{
            System.out.println(0);
        }
    }
}
