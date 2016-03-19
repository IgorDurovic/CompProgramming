import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xen0phile on 6/26/15.
 */
class ACODE {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        while(input.charAt(0) != '0') {
            long[] d = new long[input.length()+1];
            d[0] = 1;
            d[1] = 1;

            for(int i = 1; i < input.length(); i++) {
                int j = i+1;
                int c = input.charAt(i) - 48;
                int p = input.charAt(i-1) - 48;
                int n = -1;

                if(i < input.length()-1)
                    n = input.charAt(i+1) - 48;

                if(n == 0) {
                    d[j] = d[j-1];
                }
                else if(((c != 0 && p == 1) || (c < 7 && p == 2)) &&  c != 0) {
                    d[j] = d[j-1] + d[j-2];
                }
                else {
                    d[j] = d[j-1];
                }
            }

            pw.println(d[d.length-1]);

            input = br.readLine().trim();
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

}
