package week_6_0918_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

public class BOJ_2805_나무자르기 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        long[] heights = new long[n];

        long start = 1;
        long end = 0;
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            long i1 = Integer.parseInt(s1[i]);
            heights[i]= i1;
            end = max(end,i1);
        }


        long h = 0;
        while (start <= end) {
            h = (start+end)/2;

            // 자르고
            long ret = calcCut(heights, n, h);

            if (ret >= m) { // O
                start = h+1;
            }
            else{
                end = h-1;
            }
        }

        System.out.println(end);
    }


    public static long calcCut(long[] heights, long n, long h){
        long ret = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i]>h){
                ret += heights[i]-h;
            }
        }

        return ret;
    }

}
