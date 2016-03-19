/*
ID: id.tesl1
LANG: JAVA
TASK: kimbits
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/28/15.
 */
class kimbits {

    public static long N, L, I;
    public static long[] counter;
    public static PrintWriter pw;
    public static long[][] memo;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("kimbits.in"));
        pw = new PrintWriter("kimbits.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        L = Long.parseLong(st.nextToken());
        I = Long.parseLong(st.nextToken());
        memo = new long[(int)N + 1][(int)L + 1];

        solve();

        for (int i = (int)N; i > 0; --i) {
            if (I <= memo[i-1][(int)L]) {
                pw.print('0');
            } else {
                pw.print('1');
                I -= memo[i-1][(int)L];
                --L;
            }
        }
        pw.println();

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static void solve(){
        Arrays.fill(memo[0], 1);
        for (int i = 1; i <= N; ++i) {
            memo[i][0] = 1;
            for (int j = 1; j <= L; ++j) {
                memo[i][j] = memo[i-1][j] + memo[i-1][j-1];
            }
        }
    }

}
