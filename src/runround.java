/*
ID: id.tesl1
LANG: JAVA
TASK: runround
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xen0phile on 9/29/15.
 */
class runround {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("runround.in"));
        PrintWriter pw = new PrintWriter("runround.out");

        int M = Integer.parseInt(br.readLine());

        while(true){
            M++;
            if(isRunRound(M + "")){
                break;
            }
        }

        pw.println(M);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static boolean isRunRound(String s){
        char[] c = s.toCharArray();
        boolean[] b = new boolean[10];
        int cur = 0;

        for(int i = 0; i < c.length; i++){
            if(b[c[cur] - 48] || c[cur] == '0'){
                return false;
            }
            b[c[cur] - 48] = true;
            cur = (cur + c[cur] - 48) % (c.length);
        }

        return cur == 0;
    }

}
