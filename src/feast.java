import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/16/15.
 */
public class feast {

    public static int T, A, B;
    public static PrintWriter pw;
    public static BufferedReader br;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new FileReader("feast.in"));
        pw = new PrintWriter("feast.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        boolean[][] seen = new boolean[2][T + 1];
        seen[0][0] = true;

        if(T % A == 0 || T % B == 0){
            pw.println(T);
        }
        else{
            for(int i = 0; i < seen.length; i++){
                for(int j = 0; j < seen[i].length; j++){
                    if(!seen[i][j]){
                        continue;
                    }
                    if(j + A <= T){
                        seen[i][j + A] = true;
                    }
                    if(j + B <= T){
                        seen[i][j + B] = true;
                    }
                    if(i == 0){
                        seen[1][j/2] = true;
                    }
                }
            }

            int max;
            for(max = seen[0].length - 1; max > 0; max--){
                if(seen[0][max] || seen[1][max]){
                    break;
                }
            }

            pw.println(max);
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

}
