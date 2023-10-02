package week_7_0925_1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class BOJ_1074_Z {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        final int originN = n;
        int r = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);

        List<Integer> list = new ArrayList();

        while (n>0){
            int area = getArea(n,r,c);
            list.add(area);
            switch (area){
                case 1:
                    break;
                case 2:
                    c = (int) (c - pow(2,n-1));
                    break;
                case 3:
                    r = (int) (r-pow(2,n-1));
                    break;
                case 4:
                    c = (int) (c - pow(2,n-1));
                    r = (int) (r-pow(2,n-1));
                    break;
            }
            n-=1;
        }
        n = originN;
        double cnt = 0;
        for (int i = 0; i < originN; i++) {
            double v = (list.get(i) - 1) * pow(4, n - 1);
            cnt += v;
            n--;
        }

        System.out.println((int)cnt);

    }
    public static int getArea(int n, int r,int c){
        if (small(n,r) && small(n,c)){
            return 1;
        } else if (small(n,r) && !small(n,c)) {
            return 2;
        } else if (!small(n,r) & small(n,c)) {
            return 3;
        } else {
            return 4;
        }
    }

    public static boolean small(int n, int target){
        return target <= pow(2,n-1)-1;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
