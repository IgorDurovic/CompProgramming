/*
ID: id.tesl1
LANG: JAVA
TASK: hamming
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 8/10/15.
 */
class hamming {

    public static ArrayList<Integer> sol;
    public static int N, B, D;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter pw = new PrintWriter("hamming.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int counter = 0, cur = 0;
        sol = new ArrayList<Integer>();

        while(counter < N){
            //System.out.println(counter);
            if(hamming(cur)){
                sol.add(cur);
                counter++;
            }
            cur++;
        }

        pw.print(sol.get(0));
        for(int i = 1; i < sol.size(); i++){
            if(i % 10 != 0){
                pw.print(" ");
            }
            else{
                pw.println();
            }
            pw.print(sol.get(i));
        }
        pw.println();

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static boolean hamming(int n){

        for(int i: sol){
            if(count(i ^ n) < D){
                return false;
            }
        }

        return true;
    }

    public static int count(int n){

        int counter = 0;
        while(n > 0){
            if(n % 2 == 1){
                counter++;
            }
            n >>= 1;
        }

        return counter;
    }
}