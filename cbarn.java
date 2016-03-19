import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by xen0phile on 2/22/16.
 */
public class cbarn {

    public static int N;
    public static int[] num;
    public static ArrayList[] cows;
    public static PriorityQueue<Cow> holder = new PriorityQueue<>();

    public static class Cow implements Comparable<Cow>{
        public int steps;

        Cow(){
            steps = 0;
        }

        public int compareTo(Cow c){
            return this.steps - c.steps;
        }
    }

    public static void main(String[] args) throws IOException {

        double[] ageDistro = new double[]{0.0333, .0356, .0356, .0349,
                .0330, .0341, .0362, .0405, .0402, .0363, .0319,
                .0247, .0201, .0182, .0176, .0155, .0111, .0107};

        for(int i = 0; i < 18; i++){
            ageDistro[i] *= 2;
        }

        double[] temp = new double[18];
        temp[0] = ageDistro[0];

        double sum = temp[0];

        for(int i = 1; i < 18; i++){
            temp[i] = temp[i - 1] + ageDistro[i];
            sum += ageDistro[i];
        }

        System.out.println(sum + " " + Arrays.toString(temp));

        /*BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter pw = new PrintWriter("cbarn.out");

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        cows = new ArrayList[N];

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(br.readLine());
            cows[i] = new ArrayList<Cow>();
            for(int j = 0; j < num[i]; j++){
                cows[i].add(new Cow());
            }
        }

        solve();

        int total = 0;

        for(int i = 0; i < N; i++){
            total += Math.pow(((Cow)cows[i].get(0)).steps, 2);
        }

        pw.println(total);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);*/
    }

    public static void solve(){
        while(!holder.isEmpty()){
            if(step()){
                return;
            }
        }
    }

    public static boolean step(){
        boolean b = true;
        for(int i = 0; i < N; i++){
            int temp = i;
            if(num[temp] != 0 && num[(temp + 1) % N] == 0){
                num[temp]--;
                num[(temp + 1) % N]++;
                Cow c = (Cow)cows[temp].remove(cows[temp].size() - 1);
                c.steps++;
                cows[(temp + 1) % N].add(c);
            }
            b = b && (num[i] == 1);
        }

        return b;
    }

}
