import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 7/25/15.
 */
class SYNC13C {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int c1, c2;

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            c1 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());
            if(c1 % 2 == 0 || c2 % 2 == 0){
                pw.println("Suresh");
            }
            else{
                pw.println("Ramesh");
            }
        }

        pw.flush();
        pw.close();
        br.close();
    }

}
