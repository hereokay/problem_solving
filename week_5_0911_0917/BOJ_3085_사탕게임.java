package week_5_0911_0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

public class BOJ_3085_사탕게임{
    static int n;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        char[][] board = new char[n+1][n+1];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {

                char c = s.charAt(j);
                board[i][j]=c;
            }
        }
        int ans = getCount(board);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[] di = {0, 1};
                int[] dj = {1,0};
                for (int k = 0; k < 2; k++) {
                    int ni = i + di[k];
                    int nj = j + dj[k];
                    if (ni >=n || nj >= n){
                        continue;
                    }

                    change(board,i,j, ni, nj);

//                    int count = getCount(board);
                    int count = getCountOpti(board,i,j,ni,nj);
                    ans = Math.max(count,ans);

                    change(board,i,j,ni,nj);
                }
            }
        }
        System.out.println(ans);
    }

    public static void change(char[][] board, int i1,int j1, int i2,int j2){
        char value = board[i1][j1];
        board[i1][j1]=board[i2][j2];
        board[i2][j2]=value;
    }

    public static int getCountOpti(char[][] board,int i,int j, int ni,int nj){
        int ret = 0;
        int lineValue = getLineValue(board, i, j);
        ret=max(ret,lineValue);
        int lineValue1 = getLineValue(board, ni, nj);
        ret=max(ret,lineValue1);
        return ret;
    }

    public static int getLineValue(char[][] board,int i,int j){
        char c = board[i][0];
        int ret = 0;
        int cnt = 1;
        for (int k = 1; k < n; k++) {
            if (board[i][k]==c){
                cnt+=1;
            }
            else{
                ret = max(ret,cnt);
                cnt=1;
                c=board[i][k];
            }
            ret = max(ret,cnt);
        }

        c = board[0][j];
        cnt = 1;
        for (int k = 1; k < n; k++) {
            if (board[k][j]==c){
                cnt+=1;
            }
            else{
                ret = max(ret,cnt);
                cnt=1;
                c=board[k][j];
            }
            ret = max(ret,cnt);
        }
        return ret;
    }

    public static int getCount(char[][] board){
        int ret = 0;
        for (int i = 0; i < n; i++) {
            char c = board[i][0];
            int cnt= 1;
            for (int j = 1; j < n; j++) {
                if (board[i][j]==c){
                    cnt+=1;
                }
                else{
                    ret = max(ret,cnt);
                    cnt=1;
                    c=board[i][j];
                }
            }
            ret = max(cnt,ret);
        }
        for (int j = 0; j < n; j++) {
            char c = board[0][j];
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (board[i][j]==c){
                    cnt+=1;
                }
                else{
                    ret = max(ret,cnt);
                    cnt=1;
                    c=board[i][j];
                }
            }
            ret = max(cnt,ret);
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}