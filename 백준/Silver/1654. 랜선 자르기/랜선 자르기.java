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

    public static int bina(int[] arr, int target, int s, int e){
        while (s <= e){

            int mid = (s+e)/2;

            if (arr[mid]==target){
                return mid;
            }
            else if (arr[mid] > target) {
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        String[] inp = br.readLine().split(" ");
        int k = Integer.parseInt(inp[0]);
        int n = Integer.parseInt(inp[1]);


        ArrayList<Integer> lanLine = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int line = Integer.parseInt(br.readLine());
            lanLine.add(line);
        }

        Collections.sort(lanLine);


        long s = 1;
        long e = Collections.max(lanLine);


        long ans = -1;
        while (s <= e){
            long mid =(s+e)/2;

            // now 에 대해 계산
            int result = 0;
            for (long lan : lanLine){
                result += (lan/mid);
            }

            // 길이가 너무 짧음
            if (result >= n){
                ans = mid;
                s = mid+1;
            }
            // 길이가 너무 김
            else{
                 e = mid-1;
            }
        }
        System.out.println(ans);
    }
}