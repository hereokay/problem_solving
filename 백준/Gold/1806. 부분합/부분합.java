import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        long s;
        long e;

        public Node(long s, long e) {
            this.s = s;
            this.e = e;
        }
    }

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] inp = br.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int s = Integer.parseInt(inp[1]);

        inp = br.readLine().split(" ");
        int[] stackSum = new int[n+1];

        for (int i = 0; i < n; i++) {
            stackSum[i+1] = stackSum[i] + Integer.parseInt(inp[i]);
        }

        int left=0;
        int right =0;

        int ans = Integer.MAX_VALUE;
        while (right < n+1){
            // right 는 n+1이 되면 안돼

            int dif = stackSum[right] - stackSum[left];
            if (dif >= s){
                ans = Math.min(ans, right-left);
                left ++;
            }
            else{
                right ++;
            }
        }

        if (ans == Integer.MAX_VALUE){
            System.out.println(0);
        }
        else {
            System.out.println(ans);
        }
    }
}