package week_6_0918_0924;

import java.io.*;
import java.util.Arrays;

public class BOJ_10816_숫자카드2 {
    static final int INIT = 20000000;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int i1 = Integer.parseInt(s[i]);
            arr[i] = i1;
        }
        int[] newArr = new int[n];
        int[] count = new int[n];
        int idx = preMake(arr, newArr, count, n);


        int m = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int question = Integer.parseInt(s1[i]);
            int search = search(newArr, count, idx, question);

            bw.write(String.valueOf(search)+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int search(int[] newArr,int[] count,int idx, int question){

        int start = 0;
        int end = idx;

        while(start <= end){
            int mid = (start+end)/2;

            if (newArr[mid] == question){
                return count[mid];
            }
            else if(newArr[mid] > question){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return 0;
    }

    public static int preMake(int[] arr,int[] newArr,int[] count, int n){
        Arrays.sort(arr);


        for (int i = 0; i < n; i++) {
            newArr[i] = INIT;
        }


        int idx = 0;
        for (int i = 0; i < n; i++) {
            int i1 = arr[i];
            if (newArr[idx] != INIT && newArr[idx] != i1) {
                idx += 1;
            }
            newArr[idx]=i1;
            count[idx]+=1;
        }
        return idx;
    }

}
