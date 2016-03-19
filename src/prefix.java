/*
ID: id.tesl1
LANG: JAVA
TASK: prefix
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 11/1/15.
 */
class prefix {

    public static ArrayList<String> primitives;
    public static String s;
    public static boolean[] memo;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("prefix.in"));
        PrintWriter pw = new PrintWriter("prefix.out");

        primitives = new ArrayList<String>();
        String str = br.readLine();

        while(!str.equals(".")){
            StringTokenizer st = new StringTokenizer(str);
            while(st.hasMoreTokens()){
                primitives.add(st.nextToken());
            }
            str = br.readLine();
        }

        String line;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null){
            sb.append(line);
        }

        s = sb.toString();
        memo = new boolean[s.length() + 1];
        memo[0] = true;

        pw.println(solve());

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static int solve(){

        int max = 0;

        boolean b = true;

        while(b){
            b = false;
            for(int i = 0; i < memo.length; i++){
                if(memo[i]){
                    for(String str: primitives){
                        if(i + str.length() < memo.length && s.substring(i, i + str.length()).equals(str)) {
                            if(i + str.length() > max){
                                max = i + str.length();
                            }
                            memo[i + str.length()] = true;
                        }
                    }
                }
            }
        }

        return max;
    }

}
