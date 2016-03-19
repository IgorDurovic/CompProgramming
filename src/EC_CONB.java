import java.io.*;

/**
 * Created by xen0phile on 8/4/15.
 */
class EC_CONB {
    public static void main(String[] args) throws IOException{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(rd.readLine()), n;
        String temp;

        for(int i = 0; i < T; i++){
            n = Integer.parseInt(rd.readLine());
            if(n % 2 == 0) {
                temp = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();
                pw.println(Integer.parseInt(temp, 2));
            }
            else{
                pw.println(n);
            }
        }

        pw.flush();
        pw.close();
        rd.close();
    }

}