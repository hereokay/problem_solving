import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static class Heap{

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a==0){
                if (pq.isEmpty()){
                    System.out.println(0);
                }
                else{
                    Integer poll = pq.poll();
                    System.out.println(poll);
                }
            }
            else {
                pq.add(a);
            }
        }
    }
}