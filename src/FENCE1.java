import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xen0phile on 7/20/15.
 */
class FENCE1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double L;

        while(true){
            L = Double.parseDouble(br.readLine());
            if(L == 0){
                break;
            }
            System.out.format("%.2f\n", L * L / Math.PI / 2.0);
        }

        br.close();
        System.exit(0);
    }
}
