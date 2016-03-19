/*
ID: id.tesl1
LANG: JAVA
TASK: crypt1
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class crypt1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter pw = new PrintWriter("crypt1.out");

        int num = Integer.parseInt(br.readLine());
        String digitInput = br.readLine();
        String[] c = digitInput.trim().split(" ");

        int[] digits = new int[c.length];
        for(int i = 0; i < c.length; i++){
            digits[i] = Integer.parseInt(c[i]);
        }

        int counter = 0;
        for(int f = 111; f < 909; f++){
            for(int s = 11; s < 90; s++){
                if(f * s < 10000 && isValid(f, s, digits)){
                    counter++;
                }
            }
        }

        pw.println(counter);

        br.close();
        pw.close();
        System.exit(0);
    }

    public static boolean isValid(int a, int b, int[] allow){

        //check the parameters for validity
        //every digit must be in the array allow[]
        String temp = a + "" + b;
        for(int i = 0; i < temp.length(); i++){
            if(!contains(allow, Integer.parseInt(temp.substring(i, i + 1)))){
                return false;
            }
        }

        //checking product for the same type of validity
        temp = "" + a*b;
        for(int i = 0; i < temp.length(); i++){
            if(!contains(allow, Integer.parseInt(temp.substring(i, i+1)))){
                return false;
            }
        }

        int partial = b%10;
        if(a*partial >= 1000)
            return false;
        temp = "" + a*partial;
        for(int i = 0; i < temp.length(); i++){
            if(!contains(allow, Integer.parseInt(temp.substring(i, i+1)))){
                return false;
            }
        }

        if(a*(b-partial)/10 >= 1000)
            return false;
        temp = "" + a*(b-partial)/10;
        for(int i = 0; i < temp.length(); i++) {
            if (!contains(allow, Integer.parseInt(temp.substring(i, i + 1)))) {
                return false;
            }
        }

        return true;
    }

    public static boolean contains(int[] ary, int num){
        for(int i = 0; i < ary.length; i++){
            if(ary[i] == num){
                return true;
            }
        }
        return false;
    }

}
