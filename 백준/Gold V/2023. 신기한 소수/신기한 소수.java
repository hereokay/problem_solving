import java.util.*;

public class Main {

    static class Node {
        int height;
        int inpIndex;

        public Node(int height, int inpIndex) {
            this.height = height;
            this.inpIndex = inpIndex;
        }
    }

    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        backT(n,1,2);
        backT(n,1,3);
        backT(n,1,5);
        backT(n,1,7);

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static boolean isPrime(int number){
        //TODO 소수처리
        for (int i = 2; i <= Math.pow(number, 0.5); i++) {
            if (number%i == 0){
                return false;
            }
        }
        return true;
    }
    public static void backT(int limit, int depth, int value){
        if (limit==depth){
            ans.add(value);
            return;
        }

        for (int i = 0; i < 10; i++) {
            int next = 10*value + i;
            if (isPrime(next)){
                backT(limit,depth+1,next);
            }
        }
    }

}
