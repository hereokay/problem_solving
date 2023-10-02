package week_1_0815_0820;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_2193_이친수 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger arr[] = new BigInteger[100];

        arr[0]=BigInteger.ZERO;
        arr[1]=BigInteger.ONE;
        arr[2]=BigInteger.ONE;

        for (int i=2;i<=n;i++){
            arr[i] = arr[i-1].add(arr[i-2]);
        }
//
//        for (BigInteger i : arr) {
//            System.out.println("i = " + i);
//        }
        System.out.println(arr[n]);
    }
    public static void main(String[] args) throws Exception {
        new BOJ_2193_이친수().solution();
    }
}
