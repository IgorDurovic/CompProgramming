import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 7/28/15.
 */
class PIGBANK {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter bw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Currency[] min;

        int T = Integer.parseInt(br.readLine());
        int E, F, N, total;
        double P, W;

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            E = Integer.parseInt(st.nextToken());
            F = Integer.parseInt(st.nextToken());

            if(F - E == 0){
                bw.println("The minimum amount of money in the piggy-bank is 0.");
            }
            else {
                N = Integer.parseInt(br.readLine());
                total = 0;
                min = new Currency[N];
                for (int j = 0; j < N; j++) {
                    st = new StringTokenizer(br.readLine());
                    P = Double.parseDouble(st.nextToken());
                    W = Double.parseDouble(st.nextToken());
                    min[j] = new Currency(P, W);
                }

                Arrays.sort(min);

                int div;
                for (int j = 0; j < N; j++) {
                    div = (int)((F - E)/min[j].W);
                    total += div * min[j].P;
                    F -= div * min[j].W;
                    if(F == E){
                        bw.println("The minimum amount of money in the piggy-bank is " + total + ".");
                        break;
                    }
                }
                if(F != E){
                    bw.println("This is impossible.");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static class Currency implements Comparable<Currency>{
        public double P;
        public double W;
        public double ratio;

        Currency(double a, double b){
            P = a;
            W = b;
            ratio = a/b;
        }

        public int compareTo(Currency o){

            return (int)(this.ratio * 100000) - (int)(o.ratio * 100000);
        }

    }

}
