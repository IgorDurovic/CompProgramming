import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class angrycows {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        PrintWriter pw = new PrintWriter("angry.out");

        int N = Integer.parseInt(br.readLine());
        int[] bales = new int[N];

        for(int i = 0; i < N; i++){
            bales[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bales);

        int max = 0;

        for(int i = 0; i < N; i++){
            int temp = solve(bales, i);
            if(temp > max){
                max = temp;
            }
        }

        pw.println(max);

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static int solve(int[] bales, int index){
        
        int cur = 1, count = 1;

        int i = index - 1;
        while(i >= 0){
            int temp = i;
            while(temp >= 0 && bales[i + 1] - bales[temp] <= cur){
                temp--;
                count++;
            }
            if(i == temp){
                break;
            }
            cur++;
            i = temp;
        }

        cur = 1;

        i = index + 1;
        while(i < bales.length){
            int temp = i;
            while(temp < bales.length && bales[temp] - bales[i - 1] <= cur){
                temp++;
                count++;
            }
            if(i == temp){
                break;
            }
            cur++;
            i = temp;
        }

        return count;
    }

}
