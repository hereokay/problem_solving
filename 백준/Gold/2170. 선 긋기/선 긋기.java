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


    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        ArrayList<Node> arr = new ArrayList<Node>();
        for(int i=0;i<n;i++){
            String[] inp = br.readLine().split(" ");

            int x = Integer.parseInt(inp[0]);
            int y = Integer.parseInt(inp[1]);
            arr.add(new Node(x,y));
        }

        Collections.sort(arr, new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                if( a.s == b.s){
                    return a.e - b.e;
                }

                return a.s - b.s;
            }
        });

        long ans = 0;
        int line = -1000000000;
        for(Node cur : arr){

            if(cur.e >= line) {

                ans += (cur.e - Math.max(line, cur.s));
//            System.out.println(cur.e - Math.max(line,cur.s));
                line = cur.e;
            }
        }

        System.out.println(ans);
    }
}