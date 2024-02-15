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


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        ArrayList<String> candidateList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if ( i== j || i == k || j == k){
                        continue;
                    }

                    int value = i*100 + j*10 + k;
                    candidateList.add(String.valueOf(value));
                }
            }
        }
        // 스트라이크 볼
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            String num = s[0];
            int strike = Integer.parseInt(s[1]);
            int ball = Integer.parseInt(s[2]);

            removeCandidate(candidateList,num,strike,ball);
        }

        System.out.println(candidateList.size());
    }

    public static void removeCandidate(ArrayList<String> candidateList, String num, int strike, int ball){
        // TODO 제거

        for (int i = 0; i < candidateList.size(); i++) {
            String candidate = candidateList.get(i);

            int[] result = calResult(candidate, num);
            if (!(result[0]==strike && result[1]==ball)){
                candidateList.remove(candidate);
                i--;
            }
        }
    }

    public static int[] calResult(String one, String two){
        int[] ints = new int[2];
        
        for (int i = 0; i < 3; i++) {
            if (one.charAt(i) == two.charAt(i)){
                ints[0]++;
            }
        }

        if (one.charAt(0)==two.charAt(1) || one.charAt(0) == two.charAt(2)){
            ints[1]++;
        }
        if (one.charAt(1)==two.charAt(0) || one.charAt(1) == two.charAt(2)){
            ints[1]++;
        }
        if (one.charAt(2)==two.charAt(1) || one.charAt(2) == two.charAt(0)){
            ints[1]++;
        }

        return ints;
    }
}
