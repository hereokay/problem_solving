import java.util.*;


/*

N = 15

15^2  = 225칸



 */
public class Main {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] inp = sc.nextLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int l = Integer.parseInt(inp[1]);
        int w = Integer.parseInt(inp[2]);

        inp = sc.nextLine().split(" ");


        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(inp[i]);
            queue.add(num);
        }

        int[] visited = new int[l];

        int sumWei = 0;
        int time = 0;
        while(!(queue.isEmpty() && sumWei == 0)){
            time ++;

            sumWei -= visited[0];

            for (int i = 0; i <= l-2; i++) {
                visited[i] = visited[i+1];
            }
            visited[l-1] = 0;

            if (!queue.isEmpty() && sumWei + queue.peek() <= w){
                visited[l-1] = queue.poll();
            }

            sumWei += visited[l-1];
        }

        System.out.println(time);
    }

}
