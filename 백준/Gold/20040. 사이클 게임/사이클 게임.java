import java.io.*;
import java.util.*;


public class Main {


    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static int[] parent ;
    public static int find(int x){

        if(parent[x]==x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }
    public static boolean union(int x, int y){
        if(x > y){
            int tmp =x;
            x = y;
            y = tmp;
        }

        int xRoot = find(x);
        int yRoot = find(y);
        if(xRoot == yRoot){
            return false; // 사이클
        }

        parent[yRoot] = xRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {

        String[] inp = br.readLine().split(" ");

        int n = Integer.parseInt(inp[0]);
        int m = Integer.parseInt(inp[1]);

        parent = new int[n+1];
        for(int i=0;i<n;i++){
            parent[i+1]=i+1;

        }
        // 0-index
        for(int i=0;i<m;i++){
            inp = br.readLine().split(" ");

            int a = Integer.parseInt(inp[0]);
            int b = Integer.parseInt(inp[1]);

            //false== 사이클

            if(!union(a,b)){
                // 사이클이면
                System.out.println(i+1);
                return;
            }
        }

        System.out.println("0");
    }
}