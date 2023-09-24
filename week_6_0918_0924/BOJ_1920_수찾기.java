package week_6_0918_0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1920_수찾기 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i]= Long.parseLong(s[i]);
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            if (search(arr,n,Long.parseLong(s1[i]))){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }

    public static boolean search(long[] arr, int n, long target){

        int start = 0;
        int end = n-1;

        while(start <= end){
            int mid = (start+end)/2;

            long l = arr[mid];
            if (l==target){
                return true;
            } else if (l > target) {
                end= mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return false;
    }

}
