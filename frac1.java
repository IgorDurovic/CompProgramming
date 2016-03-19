/*
ID: id.tesl1
LANG: JAVA
TASK: frac1
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

class frac1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter pw = new PrintWriter("frac1.out");

        int N = Integer.parseInt(br.readLine());
        ArrayList<Fraction> list = new ArrayList<Fraction>();

        list.add(new Fraction(0, 1));

        for(int i = 1; i <= N; i++){
            for(int j = 1; j < i; j++){
                if(gcd(i, j) == 1){
                    list.add(new Fraction(j, i));
                }
            }
        }

        list.add(new Fraction(1, 1));
        Collections.sort(list);

        for(Fraction f: list){
            pw.println(f.numerator + "/" + f.denominator);
        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);
    }

    public static int gcd(int a, int b){

        int temp;

        while(b != 0){
            temp = a;
            a = b;
            b = temp - (temp / b * b);
        }

        return a;
    }

    public static class Fraction implements Comparable<Fraction>{
        public int numerator, denominator;

        Fraction(int a, int b){
            numerator = a;
            denominator = b;
        }

        public int compareTo(Fraction f){
            return numerator * f.denominator - f.numerator * denominator;
        }
    }

}
