class Solution {
    public int solution(int[][] triangle) {
        
        int n = triangle.length;
        
        int[][] dp = new int[n][n];
        
        dp[0][0]= triangle[0][0];
        
        for(int i=1;i<n;i++){
            // i,i까지 존재
            for(int j=0;j<=i;j++){
                
                if (j==0){
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                }
                else if(j==i){
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j],dp[i-1][j-1]);
                }
            }
        }
        
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 System.out.print(String.valueOf(dp[i][j])+" ");
//             }
            
//             System.out.println();
//         }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(dp[n-1][i],ans);
        }
        return ans;
    }
}

// dp[depth][idx] = 최솟값


//0)    7
//1)    3 8
//2)    8 1 0
//3)    2 7 4 4
// ...