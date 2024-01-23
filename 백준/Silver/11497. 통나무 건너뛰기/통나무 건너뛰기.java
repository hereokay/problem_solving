import java.util.*;



public class Main {
    static class Node{
        int value;
        int rank;
        int inputIdx;

        public Node(int value,int inputIdx) {
            this.value = value;
            this.inputIdx = inputIdx;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            System.out.println(game(sc));
        }
    }

    public static int game(Scanner sc){
        int n = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split(" ");

        ArrayList<Integer> heightList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            heightList.add(Integer.parseInt(s[i]));
        }

        Collections.sort(heightList);

        int[] leftRight = new int[2];
        leftRight[0]=heightList.get(0);
        leftRight[1]=heightList.get(0);

        int ans = Integer.MIN_VALUE;
        int direction = 0;
        for (int i = 1; i < n; i++) {

            Integer value = heightList.get(i);
            int diff = Math.abs(value-leftRight[direction]);

            leftRight[direction] = value;
            ans = Math.max(ans,diff);

            if (direction==0){
                direction=1;
            }
            else{
                direction=0;
            }
        }

        int lastDiff =leftRight[0]-leftRight[1];

        ans = Math.max(lastDiff,ans);

        return ans ;
    }

}