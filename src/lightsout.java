import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 1/18/16.
 */
public class lightsout {

    public static Point[] vertices;

    public static class Point{
        public int x, y, angle;

        Point(int a, int b){
            x = a;
            y = b;
            angle = -1;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("lightsout.in"));
        PrintWriter pw = new PrintWriter("lightsout.out");
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        vertices = new Point[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            vertices[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        //if()

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }
}
