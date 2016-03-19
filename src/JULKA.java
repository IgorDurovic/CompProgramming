import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by xen0phile on 6/24/15.
 */
class JULKA {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        BigInteger apples;
        BigInteger K;

        for(int i = 0; i < 10; i++){
            apples = new BigInteger(scn.next());
            K = new BigInteger(scn.next());

            BigInteger temp = apples.divide(new BigInteger("2"));
            if(apples.mod(new BigInteger("2")).equals(new BigInteger("0"))){
                System.out.println(temp.add(K.divide(new BigInteger("2"))));
                System.out.println(temp.subtract(K.divide(new BigInteger("2"))));
            }
            else{
                System.out.println(temp.add(K.divide(new BigInteger("2")).add(new BigInteger("1"))));
                System.out.println(temp.subtract(K.divide(new BigInteger("2"))));
            }
        }

        scn.close();
        System.exit(0);
    }
}
