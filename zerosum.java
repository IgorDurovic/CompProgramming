/*
ID: id.tesl1
LANG: JAVA
TASK: zerosum
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by xen0phile on 12/23/15.
 */
class zerosum {

    public static ArrayList<String> sol;
    public static PrintWriter pw;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("zerosum.in"));
        pw = new PrintWriter("zerosum.out");
        sol = new ArrayList<String>();

        int N = Integer.parseInt(br.readLine());

        solve(N, 1, 1, "1", true, '+');

        Collections.sort(sol);
        for(String s: sol){
            pw.println(s);
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static void solve(int n, int cur, int sum, String exp, boolean combine, char c){
        if(cur == n){
            //System.out.println(sum + " " + exp);
            if(sum == 0){
                sol.add(exp);
            }

            return;
        }

        if(combine) {
            switch (c) {
                case '+':
                    solve(n, cur + 1, sum - cur + (cur * 10 + cur + 1), exp + " " + (cur + 1), false, '0');
                    break;
                case '-':
                    solve(n, cur + 1, sum + cur - (cur * 10 + cur + 1), exp + " " + (cur + 1), false, '0');
                    break;
            }
        }

        solve(n, cur + 1, sum + cur + 1, exp + "+" + (cur + 1), true, '+');
        solve(n, cur + 1, sum - (cur + 1), exp + "-" + (cur + 1), true, '-');
    }

}
