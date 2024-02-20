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

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.e != o2.e){
                    return Long.compare(o1.e, o2.e);
                }

                return  Long.compare(o1.s,o2.s); // 늦게 시작하는거 부터 ?
            }
        });


        for (int i = 0; i < n; i++) {
            String[] inp = br.readLine().split(" ");
            long s = Integer.parseInt(inp[0]);
            long e = Integer.parseInt(inp[1]);

            pq.add(new Node(s,e));
        }

        long time =0;
        int ans =0;

        while (!pq.isEmpty()){
            Node next = pq.poll();

            if (time <= next.s){
                time = next.e;
                ans ++;
            }
        }
        System.out.println(ans);
    }
}