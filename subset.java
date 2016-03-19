/*
ID: id.tesl1
LANG: JAVA
TASK: subset
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by xen0phile on 9/7/15.
 */
class subset {

    static int total, N;
    static int[][] holder = new int[40][390];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("subset.in"));
        PrintWriter pw = new PrintWriter("subset.out");

        N = Integer.parseInt(br.readLine());
        total = N * (N + 1) / 2;

        if(total % 2 != 0) {
            pw.println(0);
        }
        else{

            init();
            pw.println(solve(total/2 - N, N - 1));

        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);

    }

    public static void init(){
        for(int i = 0; i < holder.length; i++){
            Arrays.fill(holder[i], -1);
        }
    }

    public static int solve(int end, int n){

        if(end < 0 || n < 0) return 0;
        else if(holder[n][end] != -1) return holder[n][end];
        else if(end == 0) return holder[n][end] = 1;

        return holder[n][end] = solve(end, n - 1) + solve(end - n, n - 1);
    }

}