import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by xen0phile on 1/18/16.
 */
public class angry {

    public static int[] bales;
    public static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        PrintWriter pw = new PrintWriter("angry.out");

        int N = Integer.parseInt(br.readLine()), max = 0, index = -1;
        bales = new int[N];
        distance = new int[N - 1];

        for(int i = 0; i < N; i++){
            bales[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bales);

        for(int i = 0; i < N - 1; i++){
            distance[i] = bales[i + 1] - bales[i];
        }



        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }
}
