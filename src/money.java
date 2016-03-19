/*
ID: id.tesl1
LANG: JAVA
TASK: money
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/23/15.
 */
class money {

    public static int[] coins;
    public static long[][] memo;

    public static void main(String[] args) throws IOException{
        Scanner br = new Scanner(new FileReader("money.in"));
        PrintWriter pw = new PrintWriter("money.out");

        int V = br.nextInt(),
                N = br.nextInt();
        coins = new int[V];
        memo = new long[N + 1][V + 1];
        for(int i = 0; i <= N; i++){
            Arrays.fill(memo[i], -1);
        }

        for(int i = 0; i < V; i++){
            coins[i] = br.nextInt();
        }

        pw.println(solve(N, 0));

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static long solve(int n, int start){

        if(n == 0){
            return 1;
        }
        else if(n < 0){
            return 0;
        }

        if(memo[n][start] != -1){
            return memo[n][start];
        }

        long total = 0;

        for(int i = start; i < coins.length; i++){
            total += solve(n - coins[i], i);
        }

        memo[n][start] = total;
        //System.out.println(total + " " + n + " " + start);
        return total;
    }
}
