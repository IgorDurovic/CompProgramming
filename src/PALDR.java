import java.io.*;
import java.util.Scanner;

/**
 * Created by xen0phile on 8/1/15.
 */
class PALDR {
    public static void main(String[] args) throws IOException{
        Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int T = scn.nextInt();
        String pal;

        for(int i = 0; i < T; i++){
            pal = scn.next();
            if(pal.length() % 2 != 0){
                pw.println("NO");
            }
            else {
                int j;
                for (j = 2; j < pal.length(); j += 2) {
                    if (isPalin(pal.substring(0, j)) && makePalin(pal.substring(j))){
                        pw.println("YES");
                        break;
                    }
                }
                if(j >= pal.length()){
                    pw.println("NO");
                }
            }
        }

        pw.flush();
        pw.close();
        scn.close();
    }

    public static boolean isPalin(String s){

        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }

        return true;
    }

    public static boolean makePalin(String s){

        if(s.length() == 2 && s.charAt(0) == s.charAt(1)){
            return true;
        }

        int j;
        for (j = 2; j < s.length(); j += 2) {
            if (isPalin(s.substring(0, j)) && makePalin(s.substring(j))){
                return true;
            }
        }

        return false;
    }

}
