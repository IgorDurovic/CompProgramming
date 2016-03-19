import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 2/22/16.
 */
public class cbarn2 {

    public static int N, K;
    public static int[] rooms;
    public static long[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cbarn2.in"));
        PrintWriter pw = new PrintWriter("cbarn2.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        rooms = new int[N];
        memo = new long[K + 1][N + 1];

        for (int i = 0; i < N; i++) {
            rooms[i] = Integer.parseInt(br.readLine());
        }

        long sol = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int k = 0; k <= K; k++) {
                Arrays.fill(memo[k], Integer.MAX_VALUE);
            }
            memo[0][N] = 0;
            for (int k = 1; k <= K; k++) {
                for (int j = 0; j < N; j++) {
                    long val = 0;
                    for (int a = j + 1; a <= N; a++) {
                        val += rooms[a - 1] * (a - j - 1);
                        memo[k][j] = Math.min(memo[k][j], val + memo[k - 1][a]);
                        System.out.println(memo[k][j]);
                    }
                    System.out.println(Arrays.toString(memo[k]));
                }
            }
            sol = Math.min(sol, memo[K][0]);
            rotate();
        }

        pw.println(sol);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static void rotate(){
        int first = rooms[0];
        for(int i = 0; i < N - 1; i++){
            rooms[i] = rooms[i + 1];
        }

        rooms[N - 1] = first;
    }

}
