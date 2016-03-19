import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xen0phile on 7/19/15.
 */
class WILLITST {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        long n;

        while(line != null){
            n = Long.parseLong(line);
            while(n%2 == 0){
                n /= 2;
            }
            if(n < 2){
                System.out.println("TAK");
            }
            else{
                System.out.println("NIE");
            }

            line = br.readLine();
        }

        br.close();
        System.exit(0);
    }
}
