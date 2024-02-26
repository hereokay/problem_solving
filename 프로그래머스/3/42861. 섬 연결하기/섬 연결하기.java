import java.util.*;

class Solution {
    
    static class Node {
        int x;
        int y;
        int wei;
        
        public Node (int x,int y,int wei){
            this.x = x;
            this.y = y;
            this.wei = wei;
        }
    }
    
    static int[] parent;
    
    public static int find(int x){
        if(parent[x]==x){
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    public static boolean union(int x,int y){
        if(x > y){
            int tmp = x;
            x =y ;
            y= tmp;
        }
        
        int xRoot = find(x);
        int yRoot = find(y);
        
        if(xRoot == yRoot){
            return false;
        }
        parent[yRoot] = xRoot;
        
        return true;
    }
    public int solution(int n, int[][] costs) {
        
        parent = new int[n+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
            public int compare(Node a,Node b){
                return a.wei - b.wei;
            }
        });
        
        
        for(int[] cost : costs){
            Node node = new Node(cost[0],cost[1],cost[2]);
            pq.add(node);
        }
        
        int ans = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            
            // 사이클이 되면 잇지 않음
            if(find(cur.x) == find(cur.y)){
                continue;
            }
            
            // 잇기
            union(cur.x,cur.y);
            ans += cur.wei;
            
        }
        
        return ans;
    }
}