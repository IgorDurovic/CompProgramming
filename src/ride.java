/*
ID: id.tesl1
LANG: JAVA
TASK: ride
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xen0phile on 11/10/15.
 */
class ride {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("ride.in"));
        PrintWriter pw = new PrintWriter("ride.out");

        char[] comet = br.readLine().toCharArray();
        char[] group = br.readLine().toCharArray();

        if(count(comet) % 47 == count(group) % 47){
            pw.println("GO");
        }
        else{
            pw.println("STAY");
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static int count(char[] c){

        int total = 1;
        for(char t: c){
            total *= (t - 64);
        }

        return total;
    }
}
