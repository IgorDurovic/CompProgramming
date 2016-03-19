/*
ID: id.tesl1
LANG: JAVA
TASK: ratios
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 2/15/16.
 */
public class ratios {

    public static int[] mix;
    public static int[][] options;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("ratios.in"));
        PrintWriter pw = new PrintWriter("ratios.out");
        StringTokenizer st;

        mix = new int[3];
        options = new int[3][3];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            mix[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                options[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                for(int k = 0; k < 100; k++){
                    int[] total = new int[3];
                    int[] mult = new int[]{i, j, k};
                    for(int l = 0; l < 3; l++){
                        for(int m = 0; m < 3; m++) {
                            total[m] += mult[l] * options[l][m];
                        }
                    }

                    //System.out.println(total[0] + " " + total[1] + " " + total[2]);

                    if(total[0] % mix[0] != 0
                            || total[1] % mix[1] != 0
                            || total[1] % mix[1] != 0){
                        continue;
                    }

                    int temp = -1;
                    int l;
                    for(l = 0; l < 3; l++){
                        if(total[l] == mix[l] && mix[l] == 0){
                            continue;
                        }
                        else if(total[l] % mix[l] == 0 && total[l] >= mix[l]){
                            if(temp == -1){
                                temp = total[l] / mix[l];
                            }
                            else if(temp * mix[l] != total[l]){
                                break;
                            }
                        }
                        else{
                            break;
                        }
                    }

                    if(l == 3){
                        pw.println(i + " " + j + " " + k + " " + total[0] / mix[0]);
                        pw.flush();
                        pw.close();
                        br.close();
                        System.exit(0);
                    }
                }
            }
        }

        pw.println("NONE");

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }
}
