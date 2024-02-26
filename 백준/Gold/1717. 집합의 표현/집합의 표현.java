import java.io.*;
import java.util.*;


class Solution {

    static int[] parent ;

    public int find(int x){
        if(parent[x]==x){
            return x;
        }

        return find(parent[x]);
    }

    public void union(int x,int y){
        x = find(x);
        y = find(y);

        if(x < y)
        {
            parent[y]=x;
        }
        else{
            parent[x]=y;
        }
    }

    public int solution(int n, int[][] computers) {

        int answer = 0;
        parent = new int[n+1];


        // 1인덱스
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(computers[i][j]==1){
                    int a = i+1;
                    int b = j+1;

                    //union(a,b);
                }
            }

        }


        parent[100]=1;
        int[] root = new int[n+1];

        for(int i=1;i<=n;i++){
            root[find(i)]=1;

            System.out.print(String.valueOf(parent[i])+" ");
        }

        int ans = 0;
        for(int i=1;i<=n;i++){
            if(root[i]==1){
                ans++;
            }
        }



        return ans;
    }
}
public class Main {

    static class Node {
        int s;
        int e;

        public Node(int _s, int _e){
            this. s = _s;
            this.e = _e;
        }
    }

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static int[] parent ;
    public static int find(int x){
        if(parent[x]==x){
            return x;
        }

        parent[x] =find(parent[x]);

        return parent[x] ;
    }

    public static void union(int x, int y){
        if(x > y){
            int tmp = x;
            x = y;
            y = tmp;
        }
        // x 가 작음

        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot == yRoot){
            return ;
        }

        parent[yRoot] = xRoot;
    }

    public static void main(String[] args) throws IOException {
        String[] inp = br.readLine().split(" ");

        int n = Integer.parseInt(inp[0]);
        int m = Integer.parseInt(inp[1]);

        parent = new int[n+1]; // 1인덱싱

        for(int i=0;i<n;i++){
            parent[i+1]=i+1;
        }

        // n m
        for(int i=0;i<m;i++){
            inp = br.readLine().split(" ");
            int cmd  = Integer.parseInt(inp[0]);
            int a  = Integer.parseInt(inp[1]);
            int b  = Integer.parseInt(inp[2]);

            if(cmd==0){
                union(a,b);
            }else{

                if(find(a)==find(b)){
                    bw.write("YES\n");
                }
                else{
                    bw.write("NO\n");
                }
            }
        }

        bw.flush();

    }
}