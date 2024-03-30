
import java.util.*;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        int n = Integer.parseInt(sc.nextLine());


        int[] calender = new int[1001];

        for (int i = 0; i < n; i++) {
            String[] inp = sc.nextLine().split(" ");
            int s = Integer.parseInt(inp[0]);
            int e = Integer.parseInt(inp[1]);


            for (int j = s; j <= e; j++) {
                calender[j]++;
            }
        }

        int ans = 0;
        int width = 0;
        int height = 0;
        for (int i = 1; i <= 1000; i++) {
            if (calender[i]==0){
                ans += width * height;

                width=0;
                height=0;
                continue;
            }

            height = Math.max(height,calender[i]);
            width++;
        }
        // 마무리 잘하기

        ans += width*height;

        System.out.println(ans);
    }
}


/*

1
1+1, 2
3, 2+1, 1+1+1

기존적으로 기존의 값 -> 새로운값


 */