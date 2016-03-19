/*
ID: id.tesl1
LANG: JAVA
TASK: beads
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xen0phile on 12/17/15.
 */
class beads {

    public static BufferedReader br;
    public static PrintWriter pw;
    public static char[] necklace;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new FileReader("beads.in"));
        pw = new PrintWriter("beads.out");

        int N = Integer.parseInt(br.readLine()), max = 0;
        necklace = br.readLine().toCharArray();

        for(int i = 0; i < N; i++){ //trying all possible starting points
            int temp = solve(i);
            if(temp > max){
                max = temp;
            }
        }

        pw.println(max);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static int solve(int ind){

        int total = 2, left = ind;
        int right;

        if(ind == necklace.length - 1){
            right = 0;
        }
        else{
            right = ind + 1;
        }
        while(necklace[right] == 'w'){
            if(total == necklace.length){
                return total;
            }
            right++;
            if(right == necklace.length){
                right = 0;
            }
            total++;
        }
        while(necklace[left] == 'w'){
            left--;
            if(left == -1){
                left = necklace.length - 1;
            }
        }
        char r = necklace[right], l = necklace[left];
        right++;
        if(right == necklace.length){
            right = 0;
        }
        left--;
        if(left < 0){
            left = necklace.length - 1;
        }

        while(true){
            if(left < 0){
                left = necklace.length - 1;
            }
            if((necklace[left] != l && necklace[left] != 'w')){
                if(left == necklace.length - 1){
                    left = 0;
                }
                else{
                    left++;
                }
                break;
            }
            if(right == left){
                total++;
                return total;
            }
            total++;
            left--;
        }

        while(true){
            if(right == necklace.length){
                right = 0;
            }
            if((necklace[right] != r && necklace[right] != 'w') || right == left){
                break;
            }
            total++;
            right++;
        }

        return total;
    }
}
