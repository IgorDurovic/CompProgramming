/*
ID: id.tesl1
LANG: JAVA
TASK: ariprog
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

class ariprog {

    public static boolean[] holder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter pw = new PrintWriter("ariprog.out");

        int N = Integer.parseInt(br.readLine()),
                M = Integer.parseInt(br.readLine());
        int size = 0;

        holder = new boolean[M * M * 2 + 1];
        int[] bisquares = new int[(M + 1) * (M + 2)];
        boolean none = true;

        for(int i = 0; i <= M; i++){
            for(int j = 0; j <= M; j++){
                holder[i * i + j * j] = true;
                bisquares[size] = i * i + j * j;
                size++;
            }
        }

        for(int i = 1; i <= holder.length/(N-1); i++){
            for(int j = 0; j < bisquares.length; j++){
                boolean b = false;
                int temp = 0;
                for(int k = j; k < holder.length; k += i){
                    temp++;
                    if(!holder[k]){
                        break;
                    }
                    else if(temp == N){
                        b = true;
                        break;
                    }
                }

                if(b){
                    pw.println(j + " " + i);
                    none = false;
                }
            }
        }

        if(none){
            pw.println("NONE");
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

}

//5
//7
//
//1 5 9 13 17 - 1 4
//37
