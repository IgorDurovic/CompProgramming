import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/13/15.
 */
public class speeding {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter pw = new PrintWriter("speeding.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] limit = new int[100];
        int[] bessie = new int[100];
        int temp = 0;

        int N = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()),
                    B = Integer.parseInt(st.nextToken());
            Arrays.fill(limit, temp, temp + A, B);
            temp += A;
        }

        temp = 0;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()),
                    B = Integer.parseInt(st.nextToken());
            Arrays.fill(bessie, temp, temp + A, B);
            temp += A;
        }

        int max = 0;

        for(int i = 0; i < 100; i++){
            if(bessie[i] - limit[i] > max){
                max = bessie[i] - limit[i];
            }
        }

        pw.println(max);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }
}
