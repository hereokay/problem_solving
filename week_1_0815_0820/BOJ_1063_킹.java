package week_1_0815_0820;

import java.io.*;


public class BOJ_1063_킹 {

    class Pair{
        char[] x;
        char[] y;

        public Pair(char[] x, char[] y) {
            this.x = x;
            this.y = y;
        }

        public char[] getX() {
            return x;
        }

        public char[] getY() {
            return y;
        }
    }

    public char[] getMovePos(char[] target, int dx, int dy){
        char x = (char) (target[0] + (char) dx);
        char y = (char) (target[1] + (char) dy);

        return new char[]{x,y};
    }
    public boolean checkValid(char[] target){
        if ('A'<=target[0] && target[0] <= 'H'){
            if ('1'<=target[1] && target[1] <= '8'){
                return true;
            }
        }
        return false;
    }

    public Pair move(char[] king, char[] block, int dx, int dy){
        char[] moveKing = getMovePos(king,dx,dy);

        if (!checkValid(moveKing)){
            // 둘다 이동 X
            return new Pair(king,block);
        }

        if (moveKing[0]==block[0]
                && moveKing[1]==block[1]){
            char[] moveBlock = getMovePos(block, dx, dy);
            if(!checkValid(moveBlock)){
                // 둘다 이동 X
                return new Pair(king,block);
            }
            else{
                // 둘다이동 O
                return new Pair(moveKing,moveBlock);
            }
        }
        // 킹만 이동
        return new Pair(moveKing,block);
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] listDy = {0,0,-1,1,1,1,-1,-1}; //123..
        int[] listDx ={1,-1,0,0,1,-1,1,-1}; //abc..
        String[] listCmd = {"R","L","B","T","RT","LT","RB","LB"};

        String[] arrInp = br.readLine().split(" ");
        char[] king = arrInp[0].toCharArray();
        char[] block = arrInp[1].toCharArray();
        for (int i=0; i<Integer.parseInt(arrInp[2]);i++){
            String cmd = br.readLine();
            for (int j=0; j<listCmd.length; j++){
                if (cmd.equals(listCmd[j])){
                    int dx = listDx[j];
                    int dy = listDy[j];

                    Pair out = move(king, block, dx, dy);
                    king = out.getX();
                    block = out.getY();
                }
            }
        }
        System.out.println(king);
        System.out.println(block);
    }

    public static void main(String[] args) throws Exception {
        new BOJ_1063_킹().solution();
    }
}
