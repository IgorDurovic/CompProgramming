import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 8/3/15.
 */
class EGYPIZZA {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()), a, b, total = 1;
        int[] choice = {0, 0, 0};

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine(), "//");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            switch (a + b){
                case 3:
                    choice[0]++;
                    break;
                case 5:
                    choice[1]++;
                    break;
                case 7:
                    choice[2]++;
                    break;
            }
        }

        total += choice[2];
        choice[1] -= Math.min(choice[2], choice[1]);

        total += choice[0]/2;
        if(choice[0] % 2 != 0){
            choice[1] -= Math.min(2, choice[1]);
            total++;
        }

        total += choice[1]/4;
        if(choice[1] % 4 != 0){
            total++;
        }

        pw.println(total);

        pw.flush();
        pw.close();
        br.close();
    }
}
