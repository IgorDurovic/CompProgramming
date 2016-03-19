import java.io.*;
import java.util.Arrays;

/**
 * Created by xen0phile on 6/26/15.
 */
class AMR10G {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int K;
        int N;
        String temp[];

        int[] holder;

        for(int i = 0; i < T; i++){
            temp = br.readLine().split(" ");

            N = Integer.parseInt(temp[0]);
            K = Integer.parseInt(temp[1]);

            holder = new int[N];

            temp = br.readLine().split(" ");

            for(int j = 0; j < N; j++){
                holder[j] = Integer.parseInt(temp[j]);
            }

            Arrays.sort(holder);

            int min = holder[K - 1] - holder[0];
            for(int j = 1; j <= N - K; j++){
                if(holder[K + j - 1] - holder[j] < min){
                    min = holder[K + j - 1] - holder[j];
                }
            }

            pw.println(min);

        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

}
