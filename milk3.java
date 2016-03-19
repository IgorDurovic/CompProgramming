/*
ID: id.tesl1
LANG: JAVA
TASK: milk3
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

class milk3 {

    public static HashMap<String, Boolean> hm;
    public static PrintWriter pw;
    public static int[] max;
    public static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("milk3.in"));
        pw = new PrintWriter("milk3.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        hm = new HashMap<String, Boolean>();
        answer = new ArrayList<Integer>();
        max = new int[3];

        int A = Integer.parseInt(st.nextToken()),
                B = Integer.parseInt(st.nextToken()),
                C = Integer.parseInt(st.nextToken());

        max[0] = A;
        max[1] = B;
        max[2] = C;

        solve(0, 0, C);

        Collections.sort(answer);

        pw.print(answer.get(0));
        for(int i = 1; i < answer.size(); i++){
            pw.print(" " + answer.get(i));
        }
        pw.println();

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static void solve(int a, int b, int c){

        if(hm.containsKey(a + " " + b + " " + c)){
            return;
        }
        else{
            if(a == 0) {
                answer.add(c);
            }
            hm.put(a + " " + b + " " + c, true);
        }

        if(a != 0 && b < max[1]){
            solve(Math.max(0, a - (max[1] - b)), Math.min(max[1], a + b), c);
        }

        if(a != 0 && c < max[2]){
            solve(Math.max(0, a - (max[2] - c)), b, Math.min(max[2], a + c));
        }

        if(b != 0 && a < max[0]){
            solve(Math.min(max[0], a + b), Math.max(0, b - (max[0] - a)), c);
        }

        if(b != 0 && c < max[2]){
            solve(a, Math.max(0, b - (max[2] - c)), Math.min(max[2], b + c));
        }

        if(c != 0 && b < max[1]){
            solve(a, Math.min(max[1], c + b), Math.max(0, c - (max[1] - b)));
        }

        if(c != 0 && a < max[0]){
            solve(Math.min(max[0], a + c), b, Math.max(0, c - (max[0] - a)));
        }

    }

}
