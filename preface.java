/*
ID: id.tesl1
LANG: JAVA
TASK: preface
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by xen0phile on 8/17/15.
 */
class preface {

    public static int[] count = new int[7];
    public static char[] roman = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("preface.in"));
        PrintWriter pw = new PrintWriter("preface.out");

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++){
            countNumeral(i);
        }

        for(int i = 0; i < roman.length; i++){
            if(count[i] == 0){
                break;
            }
            else{
                pw.println(roman[i] + " " + count[i]);
            }
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static void countNumeral(int n){

        while(n >= 1000){
            count[6]++;
            n -= 1000;
        }

        if(n >= 900){
            count[6]++;
            count[4]++;
            n -= 900;
        }

        if(n >= 500){
            count[5]++;
            n -= 500;
        }

        if(n >= 400){
            count[5]++;
            count[4]++;
            n -= 400;
        }

        while(n >= 100){
            count[4]++;
            n -= 100;
        }

        if(n >= 90){
            count[4]++;
            count[2]++;
            n -= 90;
        }

        if(n >= 50){
            count[3]++;
            n -= 50;
        }

        if(n >= 40){
            count[3]++;
            count[2]++;
            n -= 40;
        }

        while(n >= 10){
            count[2]++;
            n -= 10;
        }

        if(n >= 9){
            count[2]++;
            count[0]++;
            n -= 9;
        }

        if(n >= 5){
            count[1]++;
            n -= 5;
        }

        if(n >= 4){
            count[1]++;
            count[0]++;
            n -= 4;
        }

        while(n >= 1){
            count[0]++;
            n -= 1;
        }
    }
}
