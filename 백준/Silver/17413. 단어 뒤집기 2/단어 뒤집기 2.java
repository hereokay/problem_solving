import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Character> stack = new Stack<>();
    static Stack<Character> tagChecker = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        char[] inputArr = input.toCharArray();

        for (int i = 0; i < inputArr.length; i++) {

            //태그
            if(isTag()){
                //바로 쓰기
                bw.write(inputArr[i]);

                //'>'인 경우 pop해서 태그아님 상태 만들기 '>'은 위에서 이미 write함
                if (inputArr[i] == '>' && isTag()) {
                    tagChecker.pop();
                }

            //아닐 때
            } else if (!isTag()) {

                //'<'만나면 tagChecker에 push하고, stack 다 뱉고, '<'쓰기
                if (inputArr[i] == '<') {
                    tagChecker.push('<');
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write('<');
                    continue;
                }
                //공백이면 stack 다 뱉고, 공백 쓰기
                if (inputArr[i] == ' ') {
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(inputArr[i]);
                }
                //공백이 아니면 스택에 (뒤집어야하니까)넣기
                if (inputArr[i] != ' ') {
                    stack.push(inputArr[i]);
                }
            }
        }
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
        bw.flush();
        bw.close();
    }
        public static boolean isTag() {
            return !tagChecker.isEmpty(); //tagChecker에 값이 남았을 때 == '<,>' 안에 있을 때
        }
}