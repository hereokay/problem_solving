import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static class Num implements Comparable<Num>{
        Integer n;

        public Num(Integer n) {
            this.n = n;
        }

        @Override
        public int compareTo(Num o) {
            return -(this.n - o.n);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Num> pq = new PriorityQueue<>();


        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd==0){
                if (pq.isEmpty()){
                    System.out.println(0);
                }
                else{
                    Num top = pq.poll();
                    System.out.println(top.n);
                }
            }
            else {
                pq.add(new Num(cmd));
            }
        }
    }


}