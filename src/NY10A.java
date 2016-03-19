import java.io.*;
import java.util.Arrays;

/**
 * Created by xen0phile on 8/1/15.
 */
class NY10A {

    static String[] combo = {"TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT", "HHH"};
    static int[] freq = new int[8];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()), N;
        String game;

        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            game = br.readLine();
            Arrays.fill(freq, 0);

            solve(game);

            pw.print(N);
            for(int j = 0; j < freq.length; j++){
                pw.print(" " + freq[j]);
            }
            pw.println();
        }

        pw.flush();
        pw.close();
        br.close();
    }

    public static void solve(String s){
        if(s.length() < 3){
            return;
        }

        String temp = s.substring(0, 3);

        for(int i = 0; i < combo.length; i++){
            if(temp.equals(combo[i])){
                freq[i]++;
                break;
            }
        }

        solve(s.substring(1));
    }

}
