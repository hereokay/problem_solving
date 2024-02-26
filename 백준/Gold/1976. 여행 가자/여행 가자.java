import java.io.*;
import java.util.*;


public class Main {


    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static int[] parent;
    public static int find(int x){
        if(parent[x]==x){
            return x;
        }
        parent[x] = find(parent[x]);

        return find(parent[x]);
    }

    public static void union(int x,int y){
        if(x > y ){
            int tmp =x;
            x = y;
            y = tmp;
        }

        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot == yRoot){
            return ;
        }

        parent[yRoot] = xRoot;
    }

    public static void main(String[] args) throws IOException {

        int n =Integer.parseInt(br.readLine());
        int m =Integer.parseInt(br.readLine());

        parent = new int[n+1];
        for(int i=0;i<n;i++){
            parent[i+1]=i+1;
        }

        for(int i=0;i<n;i++){

            String[] inp = br.readLine().split(" ");

            for(int j=0;j<n;j++){
                int cmd = Integer.parseInt(inp[j]);
                if(cmd == 1){
                    // 연결됨
                    union(i+1,j+1);
                }
            }
        }

        String[] inp = br.readLine().split(" ");

        int cur = Integer.parseInt(inp[0]);

        for(String nextStr : inp){
            int next = Integer.parseInt(nextStr);

            if(find(cur) != find(next)){
                System.out.println("NO");
                return ;
            }

            cur = next;
        }

        System.out.println("YES");
    }
}