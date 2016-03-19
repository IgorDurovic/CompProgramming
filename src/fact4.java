/*
ID: id.tesl1
LANG: JAVA
TASK: fact4
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xen0phile on 12/28/15.
 */
class fact4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("fact4.in"));
        PrintWriter pw = new PrintWriter("fact4.out");

        int N = Integer.parseInt(br.readLine()), counter = 1;

        int fives = countFives(N);

        //System.out.println(fives);

        for(int i = 2; i <= N; i++){
            int temp = i;
            while(temp % 2 == 0 && fives > 0){
                fives--;
                temp /= 2;
            }
            while(temp % 5 == 0){
                temp /= 5;
            }
            counter *= temp;
            counter %= 10;
        }

        pw.println(counter);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static int countFives(int n){
        int counter = 0;

        for(int i = 1; i <= n; i++){
            int temp = i;
            while(temp % 5 == 0){
                temp /= 5;
                counter++;
            }
        }

        return counter;
    }

}
