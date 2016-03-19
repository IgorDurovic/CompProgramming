import java.io.*;

/**
 * Created by xen0phile on 7/28/15.
 */
class BYTESH1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int N;

        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            pw.println(solve(N));
        }

        pw.flush();
        pw.close();
        br.close();
    }

    public static int solve(int n){

        if(n < 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else if(n == 2){
            return 2;
        }
        else if(n == 3){
            return 5;
        }
        else if(n == 4){
            return 11;
        }

        return solve(n - 1) + solve(n - 2) + 2 * solve(n - 3) + 2 * solve(n - 4);
    }

}
