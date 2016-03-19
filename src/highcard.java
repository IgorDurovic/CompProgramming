import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xen0phile on 12/14/15.
 */
public class highcard {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
        PrintWriter pw = new PrintWriter("highcard.out");

        int N = Integer.parseInt(br.readLine());
        Integer[] bessie = new Integer[N];
        int[] elsie = new int[N];
        boolean[] total = new boolean[2 * N + 1];
        int cur = 0;
        int score = 0;

        for(int i = 0; i < N; i++){
            elsie[i] = Integer.parseInt(br.readLine());
            total[elsie[i]] = true;
        }

        /*for(int i = 0; i < total.length; i++){
            System.out.println(total[i]);
        }*/

        for(int i = 1; i <= 2 * N; i++){
            if(!total[i]){
                bessie[cur] = i;
                cur++;
            }
        }

        Arrays.sort(bessie, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });

        for(int i = 0; i < N; i++){
            System.out.println(bessie[i] + " " + elsie[i]);
        }

        for(int i = N/2; i < N; i++){
            int j;
            for(j = 0; j < N; j++){
                if(bessie[j] < elsie[i]){
                    break;
                }
            }

            if(j != N) {
                bessie[j] = Integer.MAX_VALUE;
                score++;
            }
        }

        for(int i = 0; i < N/2; i++){
            int j;
            for(j = N - 1; j >= 0; j--){
                if(bessie[j] > elsie[i]){
                    break;
                }
            }

            if(j != -1){
                bessie[j] = -1;
                score++;
            }
        }

        pw.println(score);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }
}
