/*
ID: id.tesl1
LANG: JAVA
TASK: combo
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class combo {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("combo.in"));
        PrintWriter pw = new PrintWriter("combo.out");
        StringTokenizer st;

        int[] john = new int[3];
        int[] master = new int[3];

        int N = Integer.parseInt(br.readLine());
        double max = 250;
        int overlap = 1;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            john[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            master[i] = Integer.parseInt(st.nextToken());
        }

        int diff;
        for(int i = 0; i < 3; i++){
            diff =  Math.abs(john[i] - master[i]);
            if(diff < 5 && diff > N - 3){
                overlap *= ((5 - diff) + (5 - (N-diff)));
            }
            else if(diff < 5) {
                overlap *= 5 - diff;
            }
            else if(diff >= N - 4){
                overlap *= 5 - (N-diff);
            }
            else{
                overlap *= 0;
            }
        }

        if (N >= 5) {
            pw.println((int)(max - overlap));;
        }
        else{
            pw.println((int)Math.pow(N, 3));
        }

        br.close();
        pw.close();
        System.exit(0);
    }
}
