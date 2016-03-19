import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xen0phile on 7/24/15.
 */
class NGM {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if(n % 10 != 0){
            System.out.println(1);
            System.out.println(n%10);
        }
        else{
            System.out.println(2);
        }

        br.close();
    }
}
