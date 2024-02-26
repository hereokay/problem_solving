import java.util.*;


class Solution {
    public int solution(int N, int number) {
        if(N==number){
            return 1;
        }
        int answer = 0;
     
        ArrayList<HashSet<Integer>> arr = new ArrayList<HashSet<Integer>>();
        
        for(int i=0;i<9;i++){
            arr.add(new HashSet<Integer>());
        }
        
        // 1개로만들 수 있는 것 === N
        arr.get(1).add(N);
        
        
        // i개로 만들 수 있는 Set 구하기
        for(int i=2;i<=8;i++){
            
            int num = 0;
            for(int p=0;p<i;p++){
                
                num *= 10;
                num += N;
            }
            arr.get(i).add(num);
            
            
            for(int j=1;j<i;j++){
                int k = i-j;
                
                for(int num1 : arr.get(j)){
                    for(int num2 : arr.get(k)){
                        
                        arr.get(i).add(num1+num2);
                        arr.get(i).add(num1-num2);
                        arr.get(i).add(num1*num2);
                        if(num2 != 0){
                            arr.get(i).add(num1/num2);
                        }
                    }
                }
            }
            
            if(arr.get(i).contains(number)){
                return i;
            }
        }
        
        
        return -1;
    }
}
