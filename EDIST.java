import java.io.*;

/**
 * Created by xen0phile on 7/31/15.
 */
class EDIST {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String A, B;

        for(int i = 0; i < T; i++){
            A = br.readLine();
            B = br.readLine();
            pw.println(solve(A, B));
        }

        pw.flush();
        pw.close();
        br.close();
    }

    public static int solve(String x, String y){

        return 0;
    }

    public static int min(int a, int b, int c){
        if(a <= b){
            if(c <= a){
                return c;
            }
            return a;
        }
        else{
            if(c <= b){
                return c;
            }
            return b;
        }
    }

}
