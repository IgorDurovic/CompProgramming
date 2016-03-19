import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by xen0phile on 7/30/15.
 */
class BISHOPS {
    public static void main(String[] args) throws IOException{
        Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        BigInteger N;

        while(scn.hasNext()){
            N = new BigInteger(scn.nextLine());
            if(N.equals(new BigInteger("1"))){
                pw.println(1);
            }
            else {
                pw.println(N.add(N.subtract(new BigInteger("2"))).toString());
            }
        }

        pw.flush();
        pw.close();
        scn.close();
    }
}
