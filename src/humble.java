/*
ID: id.tesl1
LANG: JAVA
TASK: humble
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/26/15.
 */
class humble {

    public static int K, N;
    public static int[] primes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("humble.in"));
        PrintWriter pw = new PrintWriter("humble.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        primes = new int[K];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            primes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(primes);

        if (K > N) {
            pw.println(primes[N]);
        } else {
            pw.println(solve());
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static Long solve() {

        ArrayList<Long> humble = new ArrayList<Long>();
        humble.add(1l);

        int[] counter = new int[K];

        while(humble.size() <= N){
            Long min = Long.MAX_VALUE;
            for(int i = 0; i < K; i++){
                min = Math.min(min, humble.get(counter[i]) * primes[i]);
            }
            humble.add(min);
            for(int i = 0; i < K; i++){
                while(humble.get(counter[i]) * primes[i] == min){
                    counter[i]++;
                }
            }
        }

        return humble.get(N);
    }

}