import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE; // 최솟값찾기
        Arrays.sort(times);
        int length = times.length;
        
        long left = 0;
        long right = times[times.length-1] * (long)n;
        while(left <= right){
            
            long mid = (left+right)/2;
            long cnt = 0;
            
            for(long time : times){
                cnt += mid/time;
            }
            
            // cnt 명 참여가능
            if(cnt >= n){
                 //System.out.println(String.valueOf(mid)+" " + String.valueOf(cnt)+"이므로 증가");
                //answer = Math.min(answer, mid);
                answer = mid;
                right = mid-1;   
            }
            else{
                //System.out.println(String.valueOf(mid)+" " + String.valueOf(cnt)+"이므로 감소");
                left = mid+1;
            }
        }
        
        return answer;
    }
}