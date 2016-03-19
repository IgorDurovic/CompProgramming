import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by xen0phile on 6/24/15.
 */
class FCTRL2 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        BigInteger n;
        String temp;

        for(int i = 0; i < t; i++){
            temp = scn.next();
            n = new BigInteger(temp);
            for(int j = Integer.parseInt(temp) - 1; j > 1; j--){
                temp = "" + j;
                n = n.multiply(new BigInteger(temp));
            }
            System.out.println(n);
        }

        scn.close();
        System.exit(0);
    }
}
