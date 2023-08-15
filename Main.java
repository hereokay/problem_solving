import java.io.*;
import java.math.BigInteger;

public class Main {
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
        new Main().solution();
    }
}


// 1 -> 총 1개중 1개
// 2 -> 2
// 3 -> 4
// n -> 2^(n-1)
// 100 101 110 111
// 1000 1001 1010 1100 1101 1110 1111


// 10 + n-1개 자릿수


