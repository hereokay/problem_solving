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

        ArrayList<Node> list = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();

            list.add(new Node(value,i));
        }


        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value-o2.value;
            }
        });

        for (int i = 0; i < n; i++) {
            Node cur = list.get(i);
            cur.rank = i;
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.inputIdx-o2.inputIdx;
            }
        });


        ArrayList<Integer> exist = new ArrayList<>();

        int ans =0;

        for (int i = 0; i < n; i++) {
            Node cur = list.get(i);

            boolean flag = false;
            for (int j = 0; j < exist.size(); j++) {
                Integer rank = exist.get(j);
                if (Math.abs(cur.rank - rank) == 1) {
                    flag = true;
                }
            }
            exist.add(cur.rank);

            if (!flag){ // flag 가 false 라는건 rank 차이가 1인 exist가 하나도 없엇다는것 => 새로운 큐생성
                ans+=1;
            }
        }

        System.out.println(ans);

    }
}