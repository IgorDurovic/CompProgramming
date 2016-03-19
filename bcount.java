import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/14/15.
 */
public class bcount {

    public static Counter[] count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
        PrintWriter pw = new PrintWriter("bcount.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()),
                Q = Integer.parseInt(st.nextToken());

        int cow;
        count = new Counter[N + 1];

        cow = Integer.parseInt(br.readLine());
        switch(cow) {
            case 1:
                count[1] = new Counter(1, 0, 0);
                break;
            case 2:
                count[1] = new Counter(0, 1, 0);
                break;
            case 3:
                count[1] = new Counter(0, 0 , 1);
                break;
        }

        for(int i = 2; i <= N; i++){
            cow = Integer.parseInt(br.readLine());
            switch(cow) {
                case 1:
                    count[i] = new Counter(count[i - 1].h + 1, count[i - 1].g, count[i - 1].j);
                    break;
                case 2:
                    count[i] = new Counter(count[i - 1].h, count[i - 1].g + 1, count[i - 1].j);
                    break;
                case 3:
                    count[i] = new Counter(count[i - 1].h, count[i - 1].g, count[i - 1].j + 1);
                    break;
            }

        }

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()),
                    b = Integer.parseInt(st.nextToken());
            pw.println(solve(a, b));
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static String solve(int a, int b){

        if(a == 1){
            return count[b].h + " " + count[b].g + " " + count[b].j;
        }
        return count[b].h - count[a - 1].h + " " + (count[b].g - count[a - 1].g) + " " + (count[b].j - count[a - 1].j);
    }

    public static class Counter{
        int h, g, j;

        Counter(int a, int b, int c){
            h = a;
            g = b;
            j = c;
        }
    }

}
