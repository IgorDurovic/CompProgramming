import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by xen0phile on 7/29/15.
 */
class PRIME1 {

    static boolean[] prime;
    static PrintWriter pw;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int a, b;
        int limit = 1000000000;



        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            printPrimes(a, b);

            pw.println();
        }
    }

    public static void printPrimes(int a, int b){

        getSegSieve(a, b);

        if(a % 2 == 0){
            a++;
        }
        for(int i = a; i <= b; i += 2){
            if(prime[i]) {
                pw.println(i);
            }
        }
    }

    public static void getSegSieve(int a, int b){
        prime = new boolean[b - a + 1];
        prime[2] = true;
        prime[3] = true;
        int root = (int) Math.ceil(Math.sqrt(b));

        for (int x = 1; x < root; x++)
        {
            for (int y = 1; y < root; y++)
            {
                int n = 4 * x * x + y * y;
                if (n <= b && (n % 12 == 1 || n % 12 == 5))
                    prime[n] = !prime[n];
                n = 3 * x * x + y * y;
                if (n <= b && n % 12 == 7)
                    prime[n] = !prime[n];
                n = 3 * x * x - y * y;
                if ((x > y) && (n <= b) && (n % 12 == 11))
                    prime[n] = !prime[n];
            }
        }

        for (int i = 5; i <= root; i++)
            if (prime[i])
                for (int j = i * i; j < b; j += i * i)
                    prime[j] = false;
    }

}
