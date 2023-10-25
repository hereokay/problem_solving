import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int pos = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='-'){
                pos=i;
                break;
            }
        }
        int a = numberSum(s,0, pos-1);
        int b = numberSum(s,pos+1,s.length()-1);
        if (pos == -1){
            System.out.println(b);
        }
        else{
            System.out.println(a-b);
        }

    }
    public static int numberSum(String s,int start, int end){
        int left =start;
        int length = 0;
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            if (i==end){
                length+=1;
            }
            // 숫자가 아니면
            if (!('0' <= s.charAt(i) && s.charAt(i) <= '9') || i==end){
                String substring = s.substring(left, left + length);
                if (substring==""){
                    continue;
                }
                cnt += Integer.parseInt(substring);

                left=i+1;
                length=0;
            }
            else{
                // 숫자면
                length+=1;
            }
        }

        return cnt;
    }
}
