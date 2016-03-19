import java.io.*;
import java.util.Scanner;

/**
 * Created by xen0phile on 7/31/15.
 */
class DIGNUM {

    static String[] digits = {" _ \n| |\n|_|", "   \n  |\n  |", " _ \n _|\n|_ ", " _ \n _|\n _|", "   \n|_|\n  |",
            " _ \n|_ \n _|", " _ \n|_ \n|_|", " _ \n  |\n  |", " _ \n|_|\n|_|", " _ \n|_|\n  |"};

    public static void main(String[] args) throws IOException{
        Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        String temp;

        char[] line1, line2, line3;

        while(scn.hasNext()){
            line1 = scn.nextLine().toCharArray();
            line2 = scn.nextLine().toCharArray();
            line3 = scn.nextLine().toCharArray();

            for(int i = 0; i < line1.length; i += 3){
                sb = new StringBuilder("");
                sb.append(line1[i] + "" + line1[i + 1] + "" + line1[i + 2]);
                sb.append("\n");
                sb.append(line2[i] + "" + line2[i + 1] + "" + line2[i + 2]);
                sb.append("\n");
                sb.append(line3[i] + "" + line3[i + 1] + "" + line3[i + 2]);

                temp = sb.toString();
                for(int j = 0; j < digits.length; j++){
                    if(temp.equals(digits[j])){
                        pw.print(j);
                    }
                }
            }

            pw.println();
        }

        pw.flush();
        pw.close();
        scn.close();
    }
}
