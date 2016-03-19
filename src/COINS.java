import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class COINS {

    static Map<Long, Long> m = new HashMap<Long, Long>();

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        long n;

        while(scn.hasNext()){
            n = scn.nextLong();
            System.out.println(count(n));
        }

        scn.close();
        System.exit(0);
    }

    public static long count(long n){

        if(n <= 11){
            return n;
        }

        if(m.containsKey(n)){
            return m.get(n);
        }

        long c = count(n/2) + count(n/3) + count(n/4);

        m.put(n, c);

        return c;
    }

}
