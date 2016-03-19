/*
ID: id.tesl1
LANG: JAVA
TASK: butter
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 2/15/16.
 */
public class butter {

    public static int N, P, C;
    public static int[] pastures;
    public static int[][] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("butter.in"));
        PrintWriter pw = new PrintWriter("butter.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        pastures = new int[P + 1];
        dist = new int[P + 1][P + 1];

        for(int i = 0; i < P + 1; i++){
            Arrays.fill(dist[i], 10000);
        }

        for(int i = 0; i < N; i++){
            pastures[Integer.parseInt(br.readLine())]++;
        }

        for(int i = 0; i < P + 1; i++){
            //System.out.print(pastures[i] + " ");
        }
       // System.out.println();

        for(int i = 0; i < C; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()),
                    b = Integer.parseInt(st.nextToken()),
                    c = Integer.parseInt(st.nextToken());

            dist[a][b] = c;
            dist[b][a] = c;
        }

        fw();

        int min = Integer.MAX_VALUE;
        for(int i = 1; i < P + 1; i++){
            int counter = 0;
            for(int j = 1; j < P + 1; j++){
                if(i != j){
                    counter += pastures[j] * dist[i][j];
                }
            }
           // System.out.println(counter + " " + i);
            if(counter < min){
                //System.out.println(i + " " + min + " " + counter);
                min = counter;
            }
        }

        pw.println(min);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static void fw(){
        for(int i = 1; i < P + 1; i++){
            for(int j = 1; j < P + 1; j++){
                for(int k = 1; k < P + 1; k++){
                    if(dist[j][k] > dist[j][i] + dist[i][k]){
                        dist[j][k] = dist[j][i] + dist[i][k];
                        dist[k][j] = dist[j][k];
                    }
                }
            }
        }
    }
}
