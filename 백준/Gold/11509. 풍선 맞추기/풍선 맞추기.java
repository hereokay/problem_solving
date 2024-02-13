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

    public static void transferNode(Stack<Node> stack,PriorityQueue<Node> pq){

        while (!stack.isEmpty()){
            Node node = stack.pop();
            pq.add(node);
        }
    }
    public static Node recentNode(PriorityQueue<Node> pq, int height, int index){

        Stack<Node> nodes = new Stack<>();


        while (!pq.isEmpty()){
            Node poll = pq.poll(); // 최상위 노드 반환

            // 조건에 부합하는지 확인
            if (poll.height == height && poll.inpIndex > index){
                // 조건에 부합할 경우
                // 스택을 정리하고 리턴
                transferNode(nodes,pq);
                return poll;
            }

            if (poll.height < height){
                // 서치를 멈춰야 할 경우
                transferNode(nodes,pq);
                pq.add(poll);
                return null;
            }

            // 서치를 계속함
            nodes.add(poll);
        }

        transferNode(nodes,pq);
        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String[] s = sc.nextLine().split(" ");
        ArrayList<Integer> balloonList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(s[i]);
            balloonList.add(num);
        }

        int ans =0;
        HashMap<Integer, Integer> arrowMap = new HashMap<>();
        for (int i = 0; i <= 1000000; i++) {
            arrowMap.put(i,0);
        }

        for (int i = 0; i < n; i++) {
            Integer height = balloonList.get(i);

            Integer numOfArrow = arrowMap.get(height);

            // 일단 화살은 추가됨
            arrowMap.put(
                    height-1,
                    arrowMap.get(height-1)+1
            );

            if (numOfArrow==0){
                ans+=1;
            }
            else{
                // 사용한 화살 빼주기
                arrowMap.put(
                        height,
                        arrowMap.get(height)-1
                );
            }
        }

        System.out.println(ans);
    }


}
