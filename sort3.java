/*
ID: id.tesl1
LANG: JAVA
TASK: sort3
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

class sort3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter pw = new PrintWriter("sort3.out");

        int N = Integer.parseInt(br.readLine().trim()), counter = 0;
        int[] holder = new int[N];
        int[] freq = new int[4];

        for(int i = 0; i < N; i++){
            holder[i] = Integer.parseInt(br.readLine().trim());
            freq[holder[i]]++;
        }

        freq[2] += freq[1];
        freq[3] += freq[2];

        for(int i = 1; i < 4; i++){
            for(int j = freq[i-1]; j < freq[i]; j++){
                if(holder[j] != i){
                    int k;
                    for(k = j + 1; k < N; k++){
                        if(k >= freq[holder[j] - 1] && k < freq[holder[j]]){
                            if(holder[k] == i) {
                                counter++;
                                holder[k] = holder[j];
                                holder[j] = i;
                                break;
                            }
                        }
                    }
                }
            }
        }

        int temp = 0;
        for(int i = 1; i < 4; i++){
            for(int j = freq[i-1]; j < freq[i]; j++){
                if(holder[j] != i){
                    temp++;
                }
            }
        }

        temp /= 3;
        counter += temp * 2;

        for(int i = 0; i < N; i++){
            System.out.println(holder[i]);
        }

        pw.println(counter);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }
}
