package week_4_0904_0910;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10819_차이를최대로 {
    static int n;
    static int M = Integer.MIN_VALUE;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] intArr = new int[n];
        for (int i = 0; i < n; i++) {
            intArr[i]=Integer.parseInt(split[i]);
            visited[i]=0;
        }
        for (int i = 0; i < n; i++) {
            visited[i]=1;
            back(i,1,0,intArr);
            visited[i]=0;
        }
        System.out.println(M);
    }
    static int[] visited = new int[10];
    public static void back(int cur, int height, int weight,int[] intArr){
        if (height==n){
            M = Math.max(M,weight);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]==1){
                continue;
            }
            visited[i]=1;
            back(i,height+1,weight+Math.abs(intArr[cur]-intArr[i]),intArr);
            visited[i]=0;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}
