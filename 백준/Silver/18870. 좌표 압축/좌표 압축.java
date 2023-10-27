import java.io.*;
import java.util.*;

class Main {

    static class Node{
        int origin;
        int rank;
        int value;

        public Node(int origin, int value) {
            this.origin = origin;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        Node[] array = new Node[n];
        for (int i = 0; i < s.length; i++) {
            int a = Integer.parseInt(s[i]);
            array[i] = new Node(i,a);
        }

        Arrays.sort(array,rankComp);
        int ranking=0;
        for (int i = 0; i < n; i++) {
            array[i].rank=ranking;
            if (i != n-1){
                if (array[i].value != array[i+1].value){
                    ranking++;
                }
            }
        }

        Arrays.sort(array,originComp);
        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(array[i].rank));
            bw.write(" ");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static Comparator<Node> rankComp = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.value - o2.value;
        }
    };
    public static Comparator<Node> originComp = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.origin - o2.origin;
        }
    };
}