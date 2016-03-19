import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xen0phile on 7/22/15.
 */
class CRDS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        long n;

        for(int i = 0; i < t; i++){
            n = Long.parseLong(br.readLine());
            System.out.println((3 * (n - 1) * n / 2 + 2 * n)%1000007);
        }

        br.close();
    }
}
