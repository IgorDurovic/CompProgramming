/*
ID: id.tesl1
LANG: JAVA
TASK: pprime
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class pprime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter pw = new PrintWriter("pprime.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()),
                b = Integer.parseInt(st.nextToken());

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

}
