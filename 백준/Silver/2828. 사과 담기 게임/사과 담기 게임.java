import com.sun.source.tree.Tree;

import javax.swing.*;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int j = sc.nextInt();

        int left = 1;
        int right = m;

        int sum = 0;
        for (int i = 0; i < j; i++) {
            int pos = sc.nextInt();
            if (left <= pos && pos <= right){
                continue;
            }

            // 안에 없을 경우
            if (pos < left){
                // 왼쪽에 위치할 경우
                sum += left-pos;
                left = pos;
                right = left+m - 1;
            }
            else{
                sum += pos-right;
                right = pos;
                left = right-m+1;
            }
        }

        System.out.println(sum);
    }
}