import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 12/13/15.
 */
class trapped {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Bale> road = new ArrayList<Bale>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            road.add(new Bale(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        Collections.sort(road);

        System.out.println(solve(road));

    }

    public static int solve(ArrayList<Bale> road){

        boolean b = true;

        while(b) {
            b = false;
            for (int i = 0; i < road.size() - 1; i++) {
                if (road.get(i + 1).p - road.get(i).p > road.get(i + 1).s) {
                    b = true;
                    road.remove(i + 1);
                } else if (road.get(i + 1).p - road.get(i).p > road.get(i).s) {
                    b = true;
                    road.remove(i);
                    i--;
                }
            }
        }

        int total = 0;

        for(int i = 0; i < road.size() - 1; i++){
            total += road.get(i + 1).p - road.get(i).p;
        }

        return total;
    }

    public static class Bale implements Comparable<Bale>{
        public int p;
        public int s;

        Bale(int a, int b){
            s = a;
            p = b;
        }

        public int compareTo(Bale b){
            return this.p - b.p;
        }
    }
}
