/*
ID: id.tesl1
LANG: JAVA
TASK: skidesign
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by xen0phile on 12/13/15.
 */
public class skidesign {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter pw = new PrintWriter("skidesign.out");

        int N = Integer.parseInt(br.readLine());
        int[] holder = new int[N];

        for(int i = 0; i < N; i++){
            holder[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(holder);
        int min = Integer.MAX_VALUE, temp;

        for(int i = holder[0]; i < holder[holder.length - 1]; i++){
            temp = 0;
            for(int j = 0; j < holder.length; j++){
                if(holder[j] > i + 17){
                    temp += Math.pow(holder[j] - (i + 17), 2);
                }
                else if(holder[j] < i){
                    temp += Math.pow(i - holder[j], 2);
                }
            }

            if(temp < min){
                min = temp;
            }
        }

        pw.println(min);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }
}
