/*
ID: id.tesl1
LANG: JAVA
TASK: stamps
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/27/15.
 */
class stamps {

    public static int K, N;
    public static int[] values, memo;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("stamps.in"));
        PrintWriter pw = new PrintWriter("stamps.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        values = new int[N];

        String line;
        int cur = 0;
        while((line = br.readLine()) != null){
            st = new StringTokenizer(line);
            while(st.hasMoreTokens()){
                values[cur++] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(values);
        memo = new int[values[values.length - 1] * K + 1];
        Arrays.fill(memo, 10000000);

        solve();

        int counter = 0;
        for(int i = 1; i < memo.length; i++){
            //System.out.println(sol[i]);
            if(memo[i] != 10000000){
                //System.out.println(i);
                counter++;
            }
            else{
                break;
            }

        }

        pw.println(counter);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static void solve(){
        memo[0] = 0;
        for(int i = 1; i < memo.length; i++){
            for(int j = 0; j < N; j++){
                if(i - values[j] < 0) break;
                if(memo[i - values[j]] + 1 > K) continue;
                memo[i] = Math.min(memo[i - values[j]] + 1, memo[i]);
            }
        }
    }
}
