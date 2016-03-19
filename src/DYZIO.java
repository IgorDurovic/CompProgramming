import java.io.*;

/**
 * Created by xen0phile on 7/28/15.
 */
class DYZIO {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int n;

        for(int i = 0; i < 10; i++){
            n = Integer.parseInt(br.readLine());
        }

        pw.flush();
        pw.close();
        br.close();
    }
}
