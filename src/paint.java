import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class paint {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("paint.in"));
        PrintWriter pw = new PrintWriter("paint.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()),
                b = Integer. parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()),
                d = Integer.parseInt(st.nextToken());

        if(a <= d && c <= a){
            pw.println(Math.max(d, b) - c);
        }
        else if(c <= b && a < c){
            pw.println(Math.max(d, b) - a);
        }
        else{
            pw.println((b - a) + (d - c));
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }
}
