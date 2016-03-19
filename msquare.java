/*
ID: id.tesl1
LANG: JAVA
TASK: msquare
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by xen0phile on 2/15/16.
 */
public class msquare {

    public static HashMap<String, Integer> memo = new HashMap<String, Integer>();
    public static String target;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("msquare.in"));
        PrintWriter pw = new PrintWriter("msquare.out");

        target = br.readLine().replaceAll("\\s", "");

        String sol = solve("12345678");

        pw.println(sol.length());
        pw.println(sol);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static String solve(String config){

        ArrayList<String> conf = new ArrayList<String>();
        ArrayList<String> move = new ArrayList<String>();
        HashSet<String> hs = new HashSet<String>();
        conf.add(config);
        move.add("");

        while(!conf.isEmpty()){
            String curConf = conf.remove(0);
            String curMove = move.remove(0);

            //System.out.println(curConf + " " + curMove);

            hs.add(curConf);

            if(curConf.equals(target)){
                return curMove;
            }
            else{
                String A = A(curConf),
                        B = B(curConf),
                        C = C(curConf);

                if(!hs.contains(A)){
                    hs.add(A);
                    conf.add(A);
                    move.add(curMove + "A");
                }
                if(!hs.contains(B)){
                    hs.add(B);
                    conf.add(B);
                    move.add(curMove + "B");
                }
                if(!hs.contains(C)){
                    hs.add(C);
                    conf.add(C);
                    move.add(curMove + "C");
                }
            }
        }

        return "none";
    }

    public static String A(String s){
        StringBuilder sb1 = new StringBuilder(s.substring(0, s.length()/2));
        StringBuilder sb2 = new StringBuilder(s.substring(s.length()/2, s.length()));

        return sb2.reverse().toString() + sb1.reverse().toString();
    }

    public static String B(String s){
        StringBuilder sb = new StringBuilder("");
        sb.append(s.charAt(3));
        sb.append(s.substring(0, 3));
        sb.append(s.substring(5, 8));
        sb.append(s.charAt(4));

        return sb.toString();
    }

    public static String C(String s){
        StringBuilder sb = new StringBuilder("");
        sb.append(s.charAt(0));
        sb.append(s.charAt(6));
        sb.append(s.charAt(1));
        sb.append(s.substring(3, 5));
        sb.append(s.charAt(2));
        sb.append(s.charAt(5));
        sb.append(s.charAt(7));

        return sb.toString();
    }
}
