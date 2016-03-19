import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xen0phile on 12/15/15.
 */
public class test {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("test.in"));
        PrintWriter pw = new PrintWriter("test.out");



        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }
}
