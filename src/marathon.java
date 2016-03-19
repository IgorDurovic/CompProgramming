import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 11/7/15.
 */
class marathon {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("/home/xen0phile/Downloads/marathon_bronze/15.in"));
        PrintWriter pw = new PrintWriter("marathon.out");

        int N = Integer.parseInt(br.readLine());
        CheckPoint[] total = new CheckPoint[N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            total[i] = new CheckPoint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int max = 0;
        int totals = 0;
        for(int i = 0; i < total.length - 2; i++){
            totals += distance(total[i], total[i + 1]);
            int temp = distance(total[i], total[i + 1]) + distance(total[i+1], total[i+2]) - distance(total[i], total[i+2]);
            if(temp > max){
                max = temp;
            }
        }

        totals += distance(total[N - 2], total[N - 1]);
        pw.println(totals - max);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static int distance(CheckPoint a, CheckPoint b){

        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    public static class CheckPoint{
        public int x;
        public int y;

        CheckPoint(int a, int b){
            x = a;
            y = b;
        }
    }

}
