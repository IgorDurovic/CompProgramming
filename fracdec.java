/*
ID: id.tesl1
LANG: JAVA
TASK: fracdec
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/25/15.
 */
class fracdec {

    public static int[] memo;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("fracdec.in"));
        PrintWriter pw = new PrintWriter("fracdec.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()),
                D = Integer.parseInt(st.nextToken());

        memo = new int[1000001];
        Arrays.fill(memo, -1);

        String sol = solve(N, D);

        for(int i = 0; i <= sol.length()/76; i++){
            pw.println(sol.substring(i * 76, Math.min(sol.length(), (i + 1) * 76)));
        }


        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static String solve(int N, int D){

        if(N % D == 0){
            return N / D + ".0";
        }

        int sol = N / D;
        if(sol == 0){
            N *= 10;
        }
        else{
            N = (N - (N / D) * D) * 10;
        }

        StringBuilder sb = new StringBuilder(sol + ".");

        while(true){
            if(memo[N] != -1){
                sb.append(')');
                sb.insert(memo[N] - 1, '(');
                break;
            }
            sb.append(N/D);
            if(N % D == 0){
                break;
            }
            memo[N] = sb.length();
            N = (N - (N / D) * D) * 10;
        }

        return sb.toString();
    }
}
