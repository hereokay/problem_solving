import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int to;
        int wei;

        public Node(int to, int wei) {
            this.to = to;
            this.wei = wei;
        }
    }

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[][] plays = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] inp = sc.nextLine().split(" ");
            int num = Integer.parseInt(inp[0]);
            int strike = Integer.parseInt(inp[1]);
            int ball = Integer.parseInt(inp[2]);

            plays[i] = new int[]{num, strike, ball};
        }

        // 시작
//         // 시뮬레이션?
        ArrayList<Integer> candi = new ArrayList<Integer>();
        for(int i =1; i<= 9; i++){
            for(int j =1; j<=9; j++){
                for(int k =1; k<=9; k++){

                    if(i==j || j==k || k==i){
                        continue;
                    }

                    int num = i*100+j*10+k;
                    candi.add(num);
                }
            }
        }


        for(int[] play : plays){
            int idx = 0;
            while(true){
                if(idx == candi.size()){
                    break;
                }
                int num1 = play[0];
                int strike = play[1];
                int ball = play[2];

                int num2 = candi.get(idx);

                if(isRight(num1,num2,strike,ball)){
                    idx++;
                }
                else{
                    candi.remove(idx);
                }
            }

        }
        System.out.println(candi.size());
    }

    public static boolean isRight(int num1, int num2, int strike, int ball){
        int x1 = num1/100;
        int x2 = (num1/10)%10;
        int x3 = num1%10;

        int y1 = num2/100;
        int y2 = (num2/10)%10;
        int y3 = num2%10;

        if(x1==y1){
            strike--;
        }
        if(x2==y2){
            strike--;
        }
        if(x3==y3){
            strike--;
        }

        if(x1==y2 || x1==y3){
            ball--;
        }

        if(x2==y1 || x2 == y3){
            ball--;
        }

        if(x3==y1 || x3 == y2){
            ball--;
        }

        return strike==0 && ball ==0;
    }
}