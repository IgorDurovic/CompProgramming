/*
ID: id.tesl1
LANG: JAVA
TASK: inflate
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/26/15.
 */
class inflate {

    public static int M, N;
    public static Category[] contest;
    public static int[] memo;

    public static class Category implements Comparable<Category>{
        public int points, time;

        Category(int a, int b){
            points = a;
            time = b;
        }

        public int compareTo(Category c){
            return this.time - c.time;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("inflate.in"));
        PrintWriter pw = new PrintWriter("inflate.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        contest = new Category[N];
        memo = new int[M + 1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            contest[i] = new Category(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(contest);

        pw.println(solve());

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static int solve(){

        for(int t = 1; t <= M; t++){
            for(int i = 0; i < N; i++){
                if(contest[i].time > t) break;
                memo[t] = Math.max(memo[t], memo[t - contest[i].time] + contest[i].points);
            }
        }

        return memo[M];
    }
}
