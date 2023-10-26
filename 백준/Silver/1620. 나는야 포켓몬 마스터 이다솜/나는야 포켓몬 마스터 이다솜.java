import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        HashMap<Integer, String> intToStr = new HashMap<>();
        HashMap<String, Integer> strToInt = new HashMap<>();

        // 문제 n개
        for (int i = 1; i <= n; i++) {
            String s2 = br.readLine();
            intToStr.put(i,s2);
            strToInt.put(s2,i);
        }

        // 문제 m개
        for (int i = 0; i < m; i++) {
            String s2 = br.readLine();
            if (s2.charAt(0)>= '0' && s2.charAt(0)<= '9'){
                int num = Integer.parseInt(s2);
                String s3 = intToStr.get(num);
                System.out.println(s3);
            }
            else{
                String name = s2;
                Integer integer = strToInt.get(name);
                System.out.println(integer);
            }
        }
    }
}
