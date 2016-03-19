import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 7/29/15.
 */
class AE2A {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int n, k;

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            pw.println((int)(solve(n, k, 1) * 100));
        }

        pw.flush();
        pw.close();
        br.close();
    }

    public static double solve(int a, int b, double p){

        if(a == 0){
            if(b == 0){
                return p;
            }
            else{
                return 0;
            }
        }

        if(b <= 0){
            return 0;
        }

        return solve(a - 1, b - 1, 1.0/6.0 * p) + solve(a - 1, b - 2, 1.0/6.0 * p) + solve(a - 1, b - 3, 1.0/6.0 * p) +
        solve(a - 1, b - 4, 1.0/6.0 * p) + solve(a - 1, b - 5, 1.0/6.0 * p) + solve(a - 1, b - 6, 1.0/6.0 * p);
    }

}
