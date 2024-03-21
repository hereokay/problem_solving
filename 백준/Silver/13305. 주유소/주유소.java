
import java.util.*;

public class Main {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int n = Integer.parseInt(sc.nextLine());

        Long[] distanceArr = new Long[n-1];
        Long[] costArr = new Long[n];

        String[] inp = sc.nextLine().split(" ");
        for (int i = 0; i < n-1; i++) {
            distanceArr[i] = Long.parseLong(inp[i]);
        }

        inp = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            costArr[i] = Long.parseLong(inp[i]);
        }

        long ans = 0;
        long curMin = 2000000000;
        for (int i = 0; i < n-1; i++) {
            if (curMin > costArr[i]){
                curMin = costArr[i];
            }

            ans += distanceArr[i]*curMin;
        }

        System.out.println(ans);
    }
}


/*

1. n개 중 선택할 주사위 n/2개 선정
    -
2. 선정한 주사위로 이길 확률 계산
    -
3. 계산된 빈도중 가장 승리 빈도가 높은 것 하나 선정하여 리턴

 */