import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int i1 = Integer.parseInt(s[i]);
            array[i]=i1;
        }
        int[] clone = array.clone();
        Arrays.sort(array);
        int ranking=0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(array[i],ranking);
            if (i != n-1){
                if (array[i] != array[i+1]){
                    ranking+=1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int value = clone[i];
            Integer rank = map.get(value);
            bw.write(String.valueOf(rank)+" ");
        }



        bw.flush();
        bw.close();
        br.close();

    }
}