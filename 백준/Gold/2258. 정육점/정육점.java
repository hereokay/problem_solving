import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] info = br.readLine().split(" ");

    int N = Integer.valueOf(info[0]);
    int M = Integer.valueOf(info[1]);
    int[][] price = new int[N][2];

    for (int i = 0; i < price.length; i++) {
      info = br.readLine().split(" ");
      price[i] = new int[] { Integer.valueOf(info[0]), Integer.valueOf(info[1]) };
    }

    Arrays.sort(price, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        // 0 : 무게, 1 : 가격
        // 가격 오름차순 정렬
        // 같은 가격이라면, 무게 내림차순
        // 가격은 적으면서 무게는 큰 고기를 고르기 위함
        if (Integer.compare(o1[1], o2[1]) == 0) {
          return Integer.compare(o2[0], o1[0]);
        }

        return Integer.compare(o1[1], o2[1]);
      }
    });

    // 특정 고기까지 구입했을 때 지불해야 하는 돈
    int totalPrice = -1;
    // 특정 고기까지 구입했을 때의 총 그램 수
    int totalGram = 0;
    // 목표 무게까지 살 수 있는지 판단해주는 변수
    int answer = Integer.MAX_VALUE;
    boolean isPossible = false;

    for (int i = 0; i < N; i++) {
      // 목표 무게를 넘었더라고 가격이 더 싸면 사기 때문에
      // 모든 고기를 다 산다고 가정해야 함

      // 고기 구입
      totalGram += price[i][0];

      // 이전과 같은 가격일 경우
      if (i > 0 && price[i - 1][1] == price[i][1]) {
        // = 돈 주고 사야함
        totalPrice += price[i][1];
      } else {
        // 이전과 가격이 다르면
        // 가격은 오름차순 정렬 되어있기 때문에
        // 해당 가격 이전의 고기들(=싼 고기) 공짜로 구입 가능
        // = 총 금액 갱신
        totalPrice = price[i][1];
      }

      if (totalGram >= M) {
        // 목표 무게와 같음 = 탈출
        isPossible = true;
        // 목표 무게와 같다고 해서 탈출 아님
        // 목표 무게를 넘었더라고 가격이 더 싸면 사기 때문
        answer = Math.min(answer, totalPrice);
      }
    }

    bw.write(isPossible ? answer + "\n" : -1 + "\n");
    bw.flush();
    bw.close();
  }

}