/*
ID: id.tesl1
LANG: JAVA
TASK: nocows
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 11/10/15.
 */
class nocows {

    public static int[][] memo;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("nocows.in"));
        PrintWriter pw = new PrintWriter("nocows.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        memo = new int[N + 1][K + 1];
        memo[1][1] = 1;
        br.close();

        pw.println(solve(N, K));

        pw.flush();
        pw.close();
        System.exit(0);
    }

    public static int solve(int n, int k){

        for(int i = 1; i <= n; i += 2){
            for(int j = 1; j <= k; j++){
                if(memo[i][j] == 0){
                    int t = count(j);
                    if(t >= i && i >= 2 * j - 1){
                        if(i == t){
                            memo[i][j] = 1;
                        }
                        else{
                            //System.out.println(i + " " + j);
                            for(int a = i - 2; a >= 0; a -= 2){
                                int temp = memo[i - 1 - a][j - 1];
                                temp *= memo[a][j - 1];

                                int temp2 = 0;
                                for(int b = j - 2; b >= 1; b--){
                                    temp2 += memo[i - 1 - a][b];
                                    temp2 %= 9901;
                                }
                                memo[i][j] += (2 * memo[a][j - 1] * temp2) % 9901;
                                memo[i][j] += temp % 9901;
                            }
                            memo[i][j] %= 9901;
                        }
                    }
                }
            }
        }

        return memo[n][k] % 9901;
    }

    public static int count(int n){

        int total = 0;
        for(int i = n - 1; i >= 0; i--){
            total += Math.pow(2, i);
        }

        return total;
    }
}
