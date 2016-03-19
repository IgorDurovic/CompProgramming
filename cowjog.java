import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 11/7/15.
 */
class cowjog {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("/home/xen0phile/Downloads/cowjog_bronze/9.in"));
        PrintWriter pw = new PrintWriter("cowjog.out");
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()), counter = 0;
        Cow[] speed = new Cow[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            speed[i] = new Cow(Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(speed);

        int cur = -1;
        for(int i = 0; i < speed.length; i++){
            if(speed[i].position > cur) {
                cur = speed[i].position;
                counter++;
            }
        }

        pw.println(counter);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static class Cow implements Comparable<Cow>{
        public int speed;
        public int position;

        Cow(int a, int b){
            speed = a;
            position = b;
        }

        @Override
        public int compareTo(Cow c){
            return this.speed - c.speed;
        }
    }

}

