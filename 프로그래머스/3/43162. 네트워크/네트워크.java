
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
            for(int j=i+1;j<n;j++){
                
                if(i==j){
                    continue;
                }
                
                if(computers[i][j]==1){
                    int a = i+1;
                    int b = j+1;
                    
                    union(a,b);
                }
            }
        }
        int ans = 0;
        for(int i=1;i<=n;i++){
            if(parent[i]==i){
                ans++;
            }
        }
        
        
        return ans;
    }
}