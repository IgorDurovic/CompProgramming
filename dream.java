import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 1/16/16.
 */
public class dream {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("dream.in"));
        PrintWriter pw = new PrintWriter("dream.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken());

        

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }
}
