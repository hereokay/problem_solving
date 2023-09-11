package jin.week_1;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class BOJ_1463_1로만들기 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, Integer> multiValueCheck = new HashMap<>();
        int n = Integer.parseInt(br.readLine());

        if (n==1){
            System.out.println(0);
            return ;
        }


        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n,0));
        multiValueCheck.put(n,0);
        while(!q.isEmpty()){
            Pair cur = q.remove();

            int num = cur.getX();
            int cnt = cur.getY();

            LinkedList<Integer> next = new LinkedList<>();

            if(num %3 ==0){
                next.add(num/3);
            }
            if(num %2 ==0){
                next.add(num/2);
            }
            if(num > 1){
                next.add(num-1);
            }

            for (Integer integer : next) {

                if (integer==1){
                    System.out.println(cnt+1);
                    return;
                }

                if (multiValueCheck.get(integer)==null){
                    multiValueCheck.put(integer,0);
                    q.add(new Pair(integer,cnt+1));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new BOJ_1463_1로만들기().solution();
    }
}

